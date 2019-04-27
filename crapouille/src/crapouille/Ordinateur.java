package crapouille;

import java.util.ArrayList;

import crapouille.Pion;
import crapouille.Plateau;

public class Ordinateur {
	
	Pion G; // Est un pion grenouille
	Pion C; // Est un pion crapaud
	Pion O; // Est le pion vérifié par l'IA
	Pion[][] casPossibles = {
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

	public static ArrayList<int[]> pionLibre(Pion[] crapaud) {
		ArrayList<int[]> pion = new ArrayList<int[]>(0);
		for (int x = 0 ; x < crapaud.length ; x++) {
			if (!crapaud[x].isBloque()) {
				pion.add(x);
			}
		}
		return pion;
	}

	public static Pion choixOrdi(Pion[][] plateau, Pion[] crapaud, int ordinateur) {
		ArrayList<int[]> pionLibre = pionLibre(crapaud);
		Pion pion = null;
		switch (ordinateur) {
		case 1 :
			pion = ordiLvl1(pionLibre);
			break;
		case 2 :
			pion = ordiLvl2(pionLibre, plateau);
			break;
		case 3 :
			pion = ordiLvl3(pionLibre, plateau);
			break;
		default :
			throw new RuntimeException("Erreur de l'IA");
		}
		return pion;
	}
	
	public static int[] ordiLvl1(ArrayList<int[]> pionLibre) {
		return pionLibre.get((int) (0 + (Math.random() * (pionLibre.size()))));
	}
	
	public static Pion ordiLvl2(ArrayList<int[]> pionLibre, Pion[][] plateau) {
		return null;
	}
	
	public static Pion ordiLvl3(ArrayList<int[]> pionLibre, Pion[][] plateau) {
		return null;
	}
}
