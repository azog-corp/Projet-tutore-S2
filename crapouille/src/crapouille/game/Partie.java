package crapouille.game;

import crapouille.Pion;
import crapouille.Plateau;

/**
 * @author Maël
 *
 */
public class Partie {
	
	private Plateau[][] plateau;
	private Pion[] pion;
	private int ordinateur;
	
	public Partie(int abscisse, int ordonnee, int nbPion, int ordinateur) {
		this.plateau = new Plateau[abscisse][ordonnee];
		this.pion = new Pion[nbPion];
		this.ordinateur = ordinateur;
	}

	public static void main(String[] args) {
		int abscisse = 0, // Nombre de colonne
		ordonnee = 0, // Nombre de ligne
		nbPion = 10, // Nombre de batracien
		ordinateur = 0; // Difficulte de l'ordinateur (0 signifie une partie contre un joueur)
		Partie partie = new Partie(abscisse, ordonnee, nbPion, ordinateur);
	}
}