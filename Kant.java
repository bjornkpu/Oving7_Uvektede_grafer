package Oving7_Uvektede_grafer;
/**
 * @author Bjørn Kristian Punsvik
 */
public class Kant {
	Kant neste;
	Node til;

	public Kant(Node n, Kant nst){
		til = n;
		neste = nst;
	}
}
