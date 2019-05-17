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
	/* v�rifie si le pionBouger n'est pas �gale � null */
	if (pionBouger != null) {
	    movePion(pionBouger, plateauJeu);
	}
    }

    /**
     * Fonction permettant d'avancer un pion et aussi v�rifiant si le pion n'est 
     * pas bloqu� 
     * @param pion, Le pion qu'on veut bouger
     * @param  plateauJeu, le plateau du jeu contenant les pions
     */
    public static void movePion(Pion pion,Pion[][] plateauJeu) {
	/* Mets la valeur null dans l'ancienne case o� ce situ� le pion */
	plateauJeu[pion.getLigne()][pion.getColonne()] = null;
	/* v�rifie si le pion peut avanc�, si oui il l'avance le pion */
	pion.setColonne(plateauJeu);
	/* Mets le dans la nouvelle case o� doit ce situ� le pion */
	plateauJeu[pion.getLigne()][pion.getColonne()] = pion;
	/* Boucle parcourant la ligne ou ce situe le pion */
	for (int x = 0 ; x < pion.getLigne() ; x++) {
	    /* v�rifie sur le tableau si les case poss�de un pion dessus */
	    if (plateauJeu[pion.getLigne()][x] != null) {
		plateauJeu[pion.getLigne()][x].setBloque(plateauJeu);
	    }
	}
    }

    /**
     * Choix du niveau de l'ordianteur
     * @param niveauOrdi, niveauOrdi repr�sente le niv de l'ordinateur choisis allant de 1 � 3
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