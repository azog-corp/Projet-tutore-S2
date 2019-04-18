package crapouille.game;

import crapouille.Plateau;

public class Partie {
	
	private static Plateau[][] plateau = new Plateau[1][1];
	
	public void setPlateau(Plateau[][] plateau) {
		this.plateau = plateau;
	}

	private static boolean victoire() {
		return true;
	}
	
	public static void main(String[] args) {
		
	}

}
