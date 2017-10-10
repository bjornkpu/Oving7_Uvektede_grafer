package Oving7_Uvektede_grafer;

/**
 * @author Bjørn Kristian Punsvik
 */
public class Forgj {
	int dist;
	Node forgj;
	static int uendelig = 1000000000;
	public int finn_dist() {return dist;}
	public Node finn_forgj() {return forgj;}
	public Forgj(){
		dist = uendelig;
	}
}
