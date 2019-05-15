/**
 * Ordinateur.java
 * Azcop 2019, droit d'auteur
 */
package crapouille;
 
import crapouille.Pion;

/**
 * Class onjet de l'ordinateur permettant de g�rer toute ces manipulations
 * @author Arzcop
 */
public class Ordinateur {

    /**
     * Fonction recherchant le premier pion dans un tableau
     * qui n'est pas bloqu�
     * @param plateau, le plateau du jeu contenant les pions
     * @return pion, pion est le premier pion qui peut �tre avancer
     * @return null si aucun pion n'as �tait trouv�
     */
    public static Pion recherchePion(Pion[][] plateauJeu) { 
	/* Pion qui va �tre cherch� */
	Pion pionTrouver; 
	/* Boucle parcourant le tableau sur chaque ligne */
	for ( int ligne = 0; ligne < plateauJeu.length; ligne++ ){
	    /* boucle parcourant les colonnes sur une ligne */
	    for ( int colonne1 = 0; colonne1 < plateauJeu[ligne].length; colonne1++) {
                /* V�rification si le pion crapaud n'est pas bloqu�  */
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
//    /**
//     * L'ordinateur va bouger le pion trouv�
//     * @param plateau
//     */
//    public static void OrdinateurMove (Pion[][] plateauJeu) {
//	/* Variable permettant de stocker le pion � bouger */
//	Pion pionBouger;
//	/* fonction recherchant un pion � bouger */
//	pionBouger = recherchePion( plateauJeu );
//	if (pionBouger != null) {
//	    movePion(pionBouger);
//	}
//    }
}