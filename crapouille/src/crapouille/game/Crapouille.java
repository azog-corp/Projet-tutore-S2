package crapouille.game;

import crapouille.OutilAction;
import crapouille.Crapaud;
import crapouille.Grenouille;
import crapouille.Plateau;

public class Crapouille {
	
	private static Plateau[][] plateau = new Plateau[1][1];
	
	private static Grenouille[] grenouille;
	
	private static Crapaud[] crapaud;
	
	public void setPlateau(Plateau[][] plateau) {
		this.plateau = plateau;
	}

	public void setCrapaud(Grenouille[] crapaud) {
		this.grenouille = grenouille;
	}

	public void setrenouille(Crapaud[] grenouille) {
		this.crapaud = crapaud;
	}

	private static boolean victoire() {
		return true;
	}
	
	public static void main(String[] args) {
		OutilAction.doAction();
	}

}
