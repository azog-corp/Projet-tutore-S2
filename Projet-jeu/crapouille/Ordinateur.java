/*
 * Ordinateur.java
 * Azog-corp 2019, droit d'auteur
 */
package crapouille;

import java.util.ArrayList;

import crapouille.Pion;

/**
 * Class de l'objet ordinateur(IA)
 * @author Azog-corp
 */
public class Ordinateur {

	private static Pion G, // Est un pion grenouille
	C, // Est un pion crapaud
	O; // Est le pion vérifié par l'IA
	private static Pion[][] casPossibles = {
			// Cas où l'IA peut bloquer une ou plusieurs grenouilles
			{G, G, null, O},
			{G, null, C, O},
			{G, C, null, O},
			{G, null, G, O},
			// Cas où l'IA peut géner l'adversaire ou agir
			// sans risque
			{null, null, G, O},
			{G, null, null, O},
			{C, null, null, O},
	};

	public static Pion choixOrdi(Pion[][] plateau, Pion[] crapaud, int ordinateur) {
		ArrayList<Integer> pionLibre = new ArrayList<Integer>();
		ArrayList<Pion[]> casActuel = new ArrayList<>();
		Pion[] cas = {null, null, null, O};
		int ligne,
		colonne;
		for (int x = 0 ; x < crapaud.length ; x++) {
			if (!crapaud[x].isBloque()) {
				pionLibre.add(x);
				ligne = crapaud[x].getLigne();
				colonne = crapaud[x].getColonne();
				if (crapaud[x].getColonne() > 2) {
					cas[2] = plateau[ligne][colonne-1] == null ? null : plateau[ligne][colonne-1].isCrapaud() ? G : C;
					cas[1] = plateau[ligne][colonne-2] == null ? null : plateau[ligne][colonne-2].isCrapaud() ? G : C;
					cas[0] = plateau[ligne][colonne-3] == null ? null : plateau[ligne][colonne-3].isCrapaud() ? G : C;
				} else if (crapaud[x].getColonne() > 1) {
					cas[2] = plateau[ligne][colonne-1] == null ? null : plateau[ligne][colonne-1].isCrapaud() ? G : C;
					cas[1] = plateau[ligne][colonne-1] == null ? null : plateau[ligne][colonne-2].isCrapaud() ? G : C;
				} else if (crapaud[x].getColonne() > 1) {
					cas[2] = plateau[ligne][colonne-1] == null ? null : plateau[ligne][colonne-1].isCrapaud() ? G : C;
				}
				casActuel.add(cas);
			}
		}

		int indice = -1;
		switch (ordinateur) {
		case 3 :
			indice = ordiLvl3(pionLibre, casActuel, plateau);
			if (indice == -1) {
				break;
			}
		case 2 :
			indice = ordiLvl2(pionLibre, casActuel, plateau);
			if (indice == -1) {
				break;
			}
		case 1 :
			indice = ordiLvl1(pionLibre);
			if (indice == -1) {
				break;
			}
		default :
			throw new RuntimeException("Erreur de l'IA");
		}
		return crapaud[indice];
	}

	public static int ordiLvl1(ArrayList<Integer> pionLibre) {
		return pionLibre.get((int) (1 + (Math.random() * (pionLibre.size()))));
	}

	public static int ordiLvl2(ArrayList<Integer> pionLibre, ArrayList<Pion[]> casActuel, Pion[][] plateau) {
		for (int x = 0 ; x < pionLibre.size() ; x++) {
			if (casActuel.get(x) == casPossibles[0] || 
					casActuel.get(x) == casPossibles[1] || 
					casActuel.get(x) == casPossibles[2] || 
					casActuel.get(x) == casPossibles[3]) {
				return x;
			}
		}
		return -1;
	}

	public static int ordiLvl3(ArrayList<Integer> pionLibre, ArrayList<Pion[]> casActuel, Pion[][] plateau) {
		for (int x = 0 ; x < pionLibre.size() ; x++) {
			if (casActuel.get(x) == casPossibles[4] || 
					casActuel.get(x) == casPossibles[5] || 
					casActuel.get(x) == casPossibles[6]) {
				return x;
			}
		}
		return -1;
	}
}
