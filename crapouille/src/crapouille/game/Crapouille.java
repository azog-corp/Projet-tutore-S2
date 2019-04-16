package crapouille.game;

import crapouille.OutilAction;
import crapouille.Crapaud;
import crapouille.Grenouille;
import crapouille.Plateau;

public class Crapouille {
	
	private static Plateau plateau;
	
	private static Grenouille[] crapaud;
	
	private static Crapaud[] grenouille;
	
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public void setCrapaud(Grenouille[] crapaud) {
		this.crapaud = crapaud;
	}

	public void setrenouille(Crapaud[] grenouille) {
		this.grenouille = grenouille;
	}

	private static boolean victoire() {
		return true;
	}
	
	public static void main(String[] args) {
		OutilAction.doAction();
	}

}
