package crapouille;

import java.util.ArrayList;

import crapouille.Crapaud;
import crapouille.Grenouille;
import crapouille.Pion;

public class Plateau {

	private int abscisse,
	ordonnee;
	private Pion[][] plateau;

	public Plateau(int abscisse, int ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.plateau = new Pion[abscisse][ordonnee];
	}

	public void setCase(ArrayList<Crapaud> crapaud, ArrayList<Grenouille> grenouille) {
		
	}
}