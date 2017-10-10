package Oving7_Uvektede_grafer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Bjørn Kristian Punsvik
 */
public class Main {
	public static void main(String[] args) {
		BufferedReader reader = null;

		try {
			File file = new File("src/Oving7_Uvektede_grafer/grafer/L7g5");
			reader = new BufferedReader(new FileReader(file));

			Graf g = new Graf();
			g.ny_ugraf(reader);
			//Utfører bredde-Først-Søk og skriver denne ut
			int StartNode = 5;

//			System.out.println("Node    "+"Forgj    "+"Dist");
//			g.bfs(g.node[StartNode]);
//			g.printBFS();

			g.printTopo();
			//Utfører topologisk sorteringog skriver denne ut




		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}