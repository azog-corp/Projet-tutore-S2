/**
 * TestOrdinateur.java
 * Azcop 2019, droit d'auteur
 */
package crapouille.test;

import crapouille.Ordinateur;
import crapouille.Pion;

/**
 * Fonction permettant de test la class ordi
 * @author yanis
 */
class TestOrdinateur {

    /* Déclaration de tous les pions */
    static Pion pion1 = new Pion(0,3,true);

    static Pion pion2 = new Pion(1,0,false);

    static Pion pion3 = new Pion(1,3,true);

    static Pion pion4 = new Pion(2,0,false);

    static Pion pion5 = new Pion(2,2,true);

    static Pion pion6 = new Pion(2,3, true);

    static Pion pion7 = new Pion(3,0,false);

    static Pion pion8 = new Pion(3,1,true);

    static Pion pion9 = new Pion(3,0,true);

    /* Creation pion resultat */
    static Pion pion1Res = new Pion(0,2,true);

    static Pion pion3Res = new Pion(1,2,true);

    static Pion pion5Res = new Pion(2,1,true);

    static Pion pion8Res = new Pion(3,1,true);

    static Pion pion9Res = new Pion(3,0,true);

    /* Déclaration des tableau des pions pour les Test */

    static Pion[][] plateauPionTest1 = {
	    {null,null,null,pion1},
	    {pion2,null,null,pion3},
	    {pion4,null,pion5,pion6},
	    {pion7,pion8,null,null}
    };

    static Pion[][] plateauPionTest2 = {
	    {null,null,null,null},
	    {pion2,null,null,pion3},
	    {pion4,null,pion5,pion6},
	    {pion7,pion8,null,null}
    };

    static Pion[][] plateauPionTest3 = {
	    {null,null,null,null},
	    {null,null,null,null},
	    {pion4,null,pion5,pion6},
	    {pion7,pion8,null,null}
    };

    static Pion[][] plateauPionTest4 = {
	    {null,null,null,null},
	    {null,null,null,null},
	    {null,null,null,null},
	    {pion7,pion8,null,null}
    };

    static Pion[][] plateauPionTest5 = {
	    {null,null,null,null},
	    {null,null,null,null},
	    {null,null,null,null},
	    {pion9,null,null,null}
    };


    /**
     * Fonction test sur la fonction recherchePion
     * dans la classe Ordinateur
     */
    public static void testRecherchePion() {
	Pion pionChercher;
	/* Test si un Crapaud est seul sur une ligne */
	System.out.println("Test n°1 : ");
	pionChercher = Ordinateur.recherchePion(plateauPionTest1);
	/*vérifie si le pion chercher et identique au pion1*/
	if ( pionChercher == pion1) {
	    System.out.println("Test Réussie");
	}
	/* Test si un crapaud et une grenouille sont sur une ligne*/
	System.out.println("Test n°2 : ");
	pionChercher = Ordinateur.recherchePion(plateauPionTest2);
	/*vérifie si le pion chercher et identique au pion3*/
	if ( pionChercher == pion3) {
	    System.out.println("Test Réussie");
	}
	/* Test s'il y a deux crapaud sur une ligne */
	System.out.println("Test n°3 : ");
	pionChercher = Ordinateur.recherchePion(plateauPionTest3);
	/*vérifie si le pion chercher et identique au pion5*/
	if ( pionChercher == pion5) {
	    System.out.println("Test Réussie");
	}
	/* Test si le pion Crapaud est bloqué par une grenouille */
	System.out.println("Test n°4 : ");
	pionChercher = Ordinateur.recherchePion(plateauPionTest4);
	/*vérifie si le pion chercher renvoie null*/
	if ( pionChercher == null) {
	    System.out.println("Test Réussie");
	}
	/* Test si le crapaud est au bout du tableau */
	System.out.println("Test n°5 : ");
	pionChercher = Ordinateur.recherchePion(plateauPionTest5);
	/*vérifie si le pion chercher renvoie null*/
	if ( pionChercher == null) {
	    System.out.println("Test Réussie");
	}
    }

    /**
     * Test si l'ordinateur avance bien un pion
     * 
     */
    public static void testMoveOrdi () {
	System.out.println("Test n°1 :");
	Ordinateur.ordinateurMove(plateauPionTest1);
	/*vérifie si le pion chercher ce situe sur la même collone que le pion résultat*/
	if (pion1.getColonne() == pion1Res.getColonne()) {
	    System.out.println("Test Réussie");
	}

	System.out.println("Test n°2 :");
	Ordinateur.ordinateurMove(plateauPionTest2);
	/*vérifie si le pion chercher ce situe sur la même collone que le pion résultat*/
	if (pion3.getColonne() == pion3Res.getColonne()) {
	    System.out.println("Test Réussie");
	}

	System.out.println("Test n°3 :");
	Ordinateur.ordinateurMove(plateauPionTest3);
	/*vérifie si le pion chercher ce situe sur la même collone que le pion résultat*/
	if (pion5.getColonne() == pion5Res.getColonne() ) {
	    System.out.println("Test Réussie");
	}

	System.out.println("Test n°4 :");
	Ordinateur.ordinateurMove(plateauPionTest4);
	/*vérifie si le pion chercher ce situe sur la même collone que le pion résultat*/
	if (pion8.getColonne() == pion8Res.getColonne()) {
	    System.out.println("Test Réussie");
	}

	System.out.println("Test n°5 :");
	Ordinateur.ordinateurMove(plateauPionTest5);
	/*vérifie si le pion chercher ce situe sur la même collone que le pion résultat*/
	if (pion9.getColonne() == pion9Res.getColonne()) {
	    System.out.println("Test Réussie");
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	/* vérifie si tous les pion sont bloqué */
	pion1.setBloque(plateauPionTest1);
	pion2.setBloque(plateauPionTest1);
	pion3.setBloque(plateauPionTest1);
	pion4.setBloque(plateauPionTest1);
	pion5.setBloque(plateauPionTest1);
	pion6.setBloque(plateauPionTest1);
	pion7.setBloque(plateauPionTest1);
	pion8.setBloque(plateauPionTest1);
	pion9.setBloque(plateauPionTest5);
	/* fonction qui test la fonction rechercher */
	testRecherchePion();
	System.out.println("--------- Test moveOrdi ----------");
	/* fonction qui test la fonction moveOrdi */
	testMoveOrdi();

    }

}
