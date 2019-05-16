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
     * @param plateauJeu, le plateau du jeu contenant les pions
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
    /**
     * L'ordinateur simple va bouger le pion trouv�
     * @param plateauJeu, le plateau du jeu contenant les pions
     * @return 
     */
    public static void ordinateurMove (Pion[][] plateauJeu) {
	/* Variable permettant de stocker le pion � bouger */
	Pion pionBouger;
	/* fonction recherchant un pion � bouger */
	pionBouger = recherchePion( plateauJeu );
	if (pionBouger != null) {
	    movePion(pionBouger, plateauJeu);
	}
	//return plateauJeu;
    }
    
    /**
	 * Fonction permettant d'avancer un pion et aussi v�rifiant si le pion n'est 
	 * pas bloqu� 
	 * @param pion, Le pion qu'on veut bouger
	 * @param  plateauJeu, le plateau du jeu contenant les pions
	 */
	public static void movePion(Pion pion,Pion[][] plateauJeu) {
		plateauJeu[pion.getLigne()][pion.getColonne()] = null;
		pion.setColonne(plateauJeu);
		plateauJeu[pion.getLigne()][pion.getColonne()] = pion;
		for (int x = 0 ; x < pion.getLigne() ; x++) {
			if (plateauJeu[pion.getLigne()][x] != null) {
				plateauJeu[pion.getLigne()][x].setBloque(plateauJeu);
			}
		}
		//return plateauJeu;
	}
    
    /**
     * Choix du niveau de l'ordianteur
     * @param ordiFacile, ordiFacile est initialis� � true : 
     * il indique que l'ordi est de difficult� est en facile
     * @param plateauJeu, le plateau du jeu contenant les pions
     */
     public static void ChoixOrdinateur(boolean ordiFacile,Pion[][] plateauJeu ) {
	 if (ordiFacile) {
	     ordinateurMove(plateauJeu);
	 } else {
	     /* Mettre la ou les fonction de L'ordinateur Difficile */
	 }
     }
}