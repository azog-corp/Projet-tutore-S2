package crapouille;

public class OutilAction {

	private static Pion choixPion(int abscisse, int ordonnee) {
		return null;
	}
	
	private static void bougerPion(Pion batracien, int abscisse, int ordonnee) {
		Plateau.movePion(batracien, abscisse, ordonnee);
	}

	public static void doAction() {
		bougerPion(choixPion(0, 0), 0, 0);
	}
	
}
