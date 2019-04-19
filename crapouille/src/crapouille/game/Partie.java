package crapouille.game;

import crapouille.Ordinateur;
import crapouille.Pion;
import crapouille.Plateau;

/**
 * @author Maël
 *
 */
public class Partie {
	
	private Plateau[][] plateau;
	private Pion[] pion;
	private Ordinateur ordinateur;
	
	public Partie(int abscisse, int ordonnee, int nbPion, int ordinateur) {
		this.plateau = new Plateau[abscisse][ordonnee];
		this.pion = new Pion[nbPion];
		this.ordinateur = new Ordinateur(ordinateur);
	}
	
	public void setPion(Pion[] pion) {
		for (int colonne = 0 ; colonne < 2 ; colonne++) {
			for (int ligne = 0 ; ligne < 10 ; ligne++) {
				this.pion[colonne+ligne] = new Pion(ligne, colonne, true);
			}
		}
		for (int colonne = 9 ; colonne > 7 ; colonne--) {
			for (int ligne = 9 ; ligne > 0 ; ligne--) {
				this.pion[colonne+ligne] = new Pion(ligne, colonne, false);
			}
		}
	}

	public static void main(String[] args) {
		int abscisse = 5, // Nombre de colonne
		ordonnee = 5, // Nombre de ligne
		nbPion = 20, // Nombre de batracien
		ordinateur = 0; // Difficulte de l'ordinateur (0 signifie une partie contre un joueur)
		Partie partie = new Partie(abscisse, ordonnee, nbPion, ordinateur);
		partie.setPion(partie.getPion());
		System.out.println("Tout c'est bien passer");
	}
}