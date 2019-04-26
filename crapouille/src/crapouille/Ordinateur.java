package crapouille;

import java.util.ArrayList;

import crapouille.Pion;
import crapouille.Plateau;

public class Ordinateur {
	
	/**
	 * Contient une copie du plateau
	 */
	public static Pion[][] tempPlateau;
	
	/**
	 * Contient une copie des crapauds
	 */
	public static ArrayList<Pion> tempCrapaud;
	
	public static ArrayList<Pion> choixPion = new ArrayList<Pion>(0);
	
	public static void initChoixPion(Pion[] crapaud) {
		for (int x = 0 ; x < crapaud.length ; x++) {
			if (!crapaud[x].isBloque()) {
				choixPion.add(crapaud[x]);
			}
		}
		tempCrapaud = choixPion;
	}
	
	public static Pion terminator(Pion [][] plateau, Pion[] crapaud, int ordinateur) {
		tempPlateau = plateau;
		initChoixPion(crapaud);
		if (ordinateur == 1) {
			return choixPion.get((int) (0 + (Math.random() * (choixPion.size()))));
		}
		return null;
	}
	

}
