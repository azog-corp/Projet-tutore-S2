package crapouille.game;

import java.util.Scanner;

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
	Scanner entree = new Scanner(System.in);

	public static void setCrapaud(int nbCrapaud) {
		int x = 0; // Variable temporaire
		int y = 0;
		crapaud = new Pion[nbCrapaud];
		for (int i = 0; i < crapaud.length; i++) {
			crapaud[i] = new Pion(x, y, true);
			x = x < 5 ? x++ : 0;
			y = x == 4 ? y++ : 0;
			plateau.setCase(grenouille[i]);
			// TODO : changer les coordonées
		}
	}
	
	public static void setGrenouille(int nbGrenouille) {
		int x = 0; // Variable temporaire
		int y = 0;
		grenouille = new Pion[nbGrenouille];
		for (int i = 0; i < grenouille.length; i++) {
			grenouille[i] = new Pion(0, 0, false);
			plateau.setCase(grenouille[i]);
			x = x < 5 ? x++ : 0;
			y = x == 4 ? y++ : 0;
			// TODO : changer les coordonées
		}
	}
	
	public static void setPlateau(int ligne, int colonne) {
		plateau = new Plateau(ligne, colonne);
	}

	public static void main(String[] args) {
		int abscisse = 5, // Nombre de colonne
		ordonnee = 5, // Nombre de ligne
		nbPion = 10, // Nombre de batraciens
		ordinateur = 0; // Difficulte de l'ordinateur (0 signifie une partie contre un joueur)
		setPlateau(abscisse, ordonnee);
		setGrenouille(nbPion);
		setCrapaud(nbPion);
		plateau.toString();
		System.out.println("Tout c'est bien passer");
	}
}