package crapouille.test;

import crapouille.Outils;

public class TestOutils {

	
	/** Fonction test de recupType
	 * Test uniquement la bonne recuperation
	 * Car les differents des cas d'erreurs sont toujours geres
	 * Avant l'appel de cette fonction
	 */
	private void testRecupType() {
		final char[] aTesterChar = {'C', 'G'};
		final boolean[] recupTypeAttendu = {true, false};
		int nbTestOk = 0;
		
		for(int i = 0; i < aTesterChar.length; i++) {
			if (Outils.recupType(aTesterChar[i]) == recupTypeAttendu[i]) {
				nbTestOk++;
			}
		}
		System.out.println(nbTestOk + " sur " + aTesterChar.length + " tests");
	}
	public static void main(String[] args) {
		
	}
}
