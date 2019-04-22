package crapouille.game;

import crapouille.Action;
import crapouille.Pion;
import crapouille.Plateau;

/**
 * @author Maël
 *
 */
public class Partie {
	
	private static Plateau plateau;
	private static Pion[] grenouille;
	private static Pion[] crapaud;
	private static Action action;

	public static void setCrapaud(int nbCrapaud) {
		crapaud = new Pion[nbCrapaud];
		for (int i = 0; i < crapaud.length; i++) {
			crapaud[i] = new Pion(i, i, true); 
			// TODO : changer les coordonées
		}
	}
	
	public static void setGrenouille(int nbGrenouille) {
		grenouille = new Pion[nbGrenouille];
		for (int i = 0; i < grenouille.length; i++) {
			grenouille[i] = new Pion(i, i, false);
			// TODO : changer les coordonées
		}
	}
	
	public static void setPlateau(int ligne, int colonne) {
		plateau = new Plateau(ligne, colonne);
	}

	public static void main(String[] args) {
		int abscisse = 5, // Nombre de colonne
		ordonnee = 5, // Nombre de ligne
		nbCrapaud = 10, // Nombre de crapaud
		nbGrenouille = 10, // Nombre de grenouille
		ordinateur = 0; // Difficulte de l'ordinateur (0 signifie une partie contre un joueur)
		setPlateau(abscisse, ordonnee);
		setGrenouille(nbGrenouille);
		setCrapaud(nbCrapaud);
		System.out.println("Tout c'est bien passer");
	}
}