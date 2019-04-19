package crapouille;

import crapouille.Pion;

public class Ordinateur {
	
	private int intelligence;
	private Pion choixPion;

	public Ordinateur(int intelligence) {
		this.intelligence = intelligence;
	}
	
	public Pion getChoixPion() {
		switch (intelligence) {
		case 0 : // TODO : mode facile
			break;
		case 1 : // TODO : niveau intermédiaire
			break;
		case 2 : // TODO : niveau dificile
		}
		return choixPion;
	}

}
