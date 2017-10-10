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
			File file = new File("src/Oving7_Uvektede_grafer/grafer/L7g1.txt");
			reader = new BufferedReader(new FileReader(file));

			Graf g = new Graf();
			g.ny_ugraf(reader);

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

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