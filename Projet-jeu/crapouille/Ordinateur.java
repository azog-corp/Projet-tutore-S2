/**
 * Ordinateur.java
 * Azcop 2019, droit d'auteur
 */
package crapouille;

import crapouille.Pion;
import crapouille.game.Partie;


/**
 * Class onjet de l'ordinateur permettant de gérer toute ces manipulations
 * @author Arzcop
 */
public class Ordinateur {

    /**
     * Fonction recherchant le premier pion dans un tableau
     * qui n'est pas bloqué
     * @param plateauJeu, le plateau du jeu contenant les pions
     * @return pion, pion est le premier pion qui peut être avancer
     * @return null si aucun pion n'as était trouvé
     */
    public static Pion recherchePion(Pion[][] plateauJeu) { 
	/* Pion qui va être cherché */
	Pion pionTrouver; 
	/* Boucle parcourant le tableau sur chaque ligne */
	for ( int ligne = 0; ligne < plateauJeu.length; ligne++ ){
	    /* boucle parcourant les colonnes sur une ligne */
	    for ( int colonne1 = 0; colonne1 < plateauJeu[ligne].length; colonne1++) {
		/* Vérification si le pion crapaud n'est pas bloqué  */
		if (plateauJeu[ligne][colonne1] != null 
			&& plateauJeu[ligne][colonne1].isCrapaud()
			&& !plateauJeu[ligne][colonne1].isBloque() ) {
		    pionTrouver = plateauJeu[ligne][colonne1];
		    return pionTrouver ;
		}
	    }
	}
	return null;

    }
    /**
     * L'ordinateur simple va bouger le pion trouvé
     * @param plateauJeu, le plateau du jeu contenant les pions
     * @return 
     */
    public static void ordinateurMove (Pion[][] plateauJeu) {
	/* Variable permettant de stocker le pion à bouger */
	Pion pionBouger;
	/* fonction recherchant un pion à bouger */
	pionBouger = recherchePion( plateauJeu );
	/* vérifie si le pionBouger n'est pas égale à null */
	if (pionBouger != null) {
	    movePion(pionBouger, plateauJeu);
	}
    }

    /**
     * Choix du niveau de l'ordianteur
     * @param niveauOrdi, niveauOrdi représente le niv de l'ordinateur choisis allant de 1 à 3
     * @param plateauJeu, le plateau du jeu contenant les pions
     */
    public static void ChoixOrdinateur(int niveauOrdi,Pion[][] plateauJeu ) {
	if (niveauOrdi == 1){
	    ordinateurMove(plateauJeu);
	}
	if (niveauOrdi == 2) {
	    /* Mettre la ou les fonction de L'ordinateur Moyenne */
	} 
	if (niveauOrdi == 3) {
	    /* Mettre la ou les fonction de L'ordinateur difficil */
	} 


    }
}
