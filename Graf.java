package Oving7_Uvektede_grafer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @author Bjørn Kristian Punsvik
 */
public class Graf {
	int N, K;
	Node[] node;

	public void ny_ugraf(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		node = new Node[N];
		for (int i = 0; i < N; ++i) {
			node[i] = new Node();
		}
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int fra = Integer.parseInt(st.nextToken());
			int til = Integer.parseInt(st.nextToken());
			Kant k = new Kant(node[til], node[fra].kant1);
			node[fra].kant1 = k;
		}
	}

	public void initforgj(Node s) {
		for (int i = N; i-- > 0; ) {
			node[i].d = new Forgj();
		}
		((Forgj) s.d).dist = 0;
	}

	public void bfs(Node s) {
		initforgj(s);
		Queue queue = new Queue(N - 1);
		queue.leggIKø(s);
		while (!queue.tom()) {
			Node n = (Node) queue.nesteIKø();
			for (Kant k = n.kant1; k != null; k = k.neste) {
				Forgj f = (Forgj) k.til.d;
				if (f.dist == f.uendelig) {
					f.dist = ((Forgj) n.d).dist + 1;
					f.forgj = n;
					queue.leggIKø(k.til);
				}
			}
		}
	}

	public void printBFS() {
		Node n;
		for (int i = 0; i < node.length; i++) {
			n = node[i];
			Forgj fj= (Forgj)n.d;
			int f = Arrays.asList(node).indexOf(fj.forgj);
			String ut;
			if (f < 0) {
				ut=" ";
			} else {
				ut=""+f;
			}
			System.out.println(i + "          "
					+ut + "         "
					+ fj.dist);
		}
	}

	public Node df_topo(Node n, Node l) {
		Topo_lst nd = (Topo_lst) n.d;
		if (nd.funnet) return l;
		nd.funnet = true;
		for (Kant k = n.kant1; k != null; k = k.neste) {
			l = df_topo(k.til, l);
		}
		nd.neste = l;
		return n;
	}

	public Node topologisort() {
		Node l = null;
		for (int i = N; i-- > 0; ) {
			node[i].d = new Topo_lst();
		}
		for (int i = N; i-- > 0; ) {
			l = df_topo(node[i], l);
		}
		return l;
	}
}