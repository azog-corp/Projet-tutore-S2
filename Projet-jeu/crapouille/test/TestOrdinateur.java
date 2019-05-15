/**
 * TestOrdinateur.java
 * Azcop 2019, droit d'auteur
 */
package crapouille.test;

import crapouille.Ordinateur;
import crapouille.Pion;
import game.Partie;

/**
 * Fonction permettant de test le 
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
	if ( pionChercher == pion1) {
	    System.out.println("Test Réussie");
	}
	/* Test si un crapaud et une grenouille sont sur une ligne*/
	System.out.println("Test n°2 : ");
	pionChercher = Ordinateur.recherchePion(plateauPionTest2);
	if ( pionChercher == pion3) {
	    System.out.println("Test Réussie");
	}
	/* Test s'il y a deux crapaud sur une ligne */
	System.out.println("Test n°3 : ");
	pionChercher = Ordinateur.recherchePion(plateauPionTest3);
	if ( pionChercher == pion5) {
	    System.out.println("Test Réussie");
	}
	/* Test si le pion Crapaud est bloqué par une grenouille */
	System.out.println("Test n°4 : ");
	pionChercher = Ordinateur.recherchePion(plateauPionTest4);
	if ( pionChercher == null) {
	    System.out.println("Test Réussie");
	}
	/* Test si le crapaud est au bout du tableau */
	System.out.println("Test n°5 : ");
	pionChercher = Ordinateur.recherchePion(plateauPionTest5);
	if ( pionChercher == null) {
	    System.out.println("Test Réussie");
	}
    }
    
    /**
     * Test si l'ordinateur avance bien un pion
     * 
     */
    public static void testMoveOrdi () {
	System.out.println(pion1);
	Ordinateur.moveOrdi();
	System.out.println(pion1);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	pion1.setBloque(plateauPionTest1);
	pion2.setBloque(plateauPionTest1);
	pion3.setBloque(plateauPionTest1);
	pion4.setBloque(plateauPionTest1);
	pion5.setBloque(plateauPionTest1);
	pion6.setBloque(plateauPionTest1);
	pion7.setBloque(plateauPionTest1);
	pion8.setBloque(plateauPionTest1);
	pion9.setBloque(plateauPionTest5);
	testRecherchePion();
    }

}
