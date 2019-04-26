package crapouille;

import java.util.ArrayList;

import crapouille.Pion;
import crapouille.Plateau;

public class Ordinateur {

	public static ArrayList<Pion> pionLibre(Pion[] crapaud) {
		ArrayList<Pion> pion = new ArrayList<Pion>(0);
		for (int x = 0 ; x < crapaud.length ; x++) {
			if (!crapaud[x].isBloque()) {
				pion.add(crapaud[x]);
			}
		}
		return pion;
	}

	public static Pion choixOrdi(Pion[][] plateau, Pion[] crapaud, int ordinateur) {
		ArrayList<Pion> pionLibre = pionLibre(crapaud);
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
	
	public static Pion ordiLvl1(ArrayList<Pion> pionLibre) {
		return pionLibre.get((int) (0 + (Math.random() * (pionLibre.size()))));
	}
	
	public static Pion ordiLvl2(ArrayList<Pion> pionLibre, Pion[][] plateau) {
		return null;
	}
	
	public static Pion ordiLvl3(ArrayList<Pion> pionLibre, Pion[][] plateau) {
		return null;
	}
}
