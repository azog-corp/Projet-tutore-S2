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

	/**
	 * Fonction test de EstValide
	 * Test uniquement la bonne recuperation
	 * Car les differents des cas d'erreurs sont toujours geres
	 * Avant l'appel de cette fonction
	 */
	private static void testEstValide () {
		final String[] aTesterString = {"C","G","A","R","Z","AA","1"};
		final boolean[] recupAttendu = {true,true,false,false,false,false,false};
		int nbTestOk = 0;

		for(int i = 0; i < aTesterString.length; i++) {
			/* Vérifie si le String est valide et compare avec le tableau résultat */
			if (Outils.typeValide(aTesterString[i]) == recupAttendu[i] ) {
				nbTestOk++;
			}
		}

		System.out.println("il y a " + nbTestOk + " test réussie sur 7");
	}

	/**
	 * Fonction test de verificationLettre
	 * Test uniquement la bonne recuperation
	 * Car les differents des cas d'erreurs sont toujours geres
	 * Avant l'appel de cette fonction
	 */
	private static void testVerificationLettre () {
		final String[] aTesterString = {"1234","e234","EArT6","ERTEZ"};
		final boolean[] recupAttendu = {true,false,false,false};
		int nbTestOk = 0;

		for(int i = 0; i < aTesterString.length; i++) {
			/* Vérifie si le String est valide et compare avec le tableau résultat */
			if (Outils.verificationLettre(aTesterString[i]) == recupAttendu[i] ) {
				nbTestOk++;
			}
		}

		System.out.println("il y a " + nbTestOk + " test réussie sur 4");
	}

	/**
	 * Fonction test de verificationLettre
	 * Test uniquement la bonne recuperation
	 * Car les differents des cas d'erreurs sont toujours geres
	 * Avant l'appel de cette fonction
	 */
	private static void testLigneEstValide () {
		final int[] aTesterLigne = {0,-1,5,10,31,40,3,20};
		final boolean[] recupAttendu = {true,false,true,true,false,false,true,true};
		int nbTestOk = 0;

		for(int i = 0; i < aTesterLigne.length; i++) {
			/* Vérifie si la ligne est valide et compare avec le tableau résultat */
			if (Outils.ligneEstValide(aTesterLigne[i]) == recupAttendu[i] ) {
				nbTestOk++;
				System.out.println(i);
			}
		}

		System.out.println("il y a " + nbTestOk + " test réussie sur 8");
	}

	
	public static void main(String[] args) {
		testEstValide();
		testVerificationLettre();
		testLigneEstValide();

	}
}
