package crapouille;

import crapouille.Pion;

public class Ordinateur {
	
	private int intelligence;
	private Pion[][] pion;
	private Pion choixPion;

	public Ordinateur(int intelligence, Pion[][] pion) {
		this.intelligence = intelligence;
		this.pion = pion;
	}
	
	public Pion getChoixPion() {
		return choixPion;
	}

}
