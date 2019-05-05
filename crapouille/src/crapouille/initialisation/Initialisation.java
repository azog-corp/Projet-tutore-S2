/**
 * 
 */
package crapouille.initialisation;

import java.util.Scanner;

/**
 * @author Azog
 *
 */
public class Initialisation {
	
	/**
	 * Ajout de l'entrée courante
	 */
	private static Scanner entree = new Scanner(System.in);

	private int ligne,
	colonne,
	nbPion;
	private int[][] coGrenouille,
	coCrapaud;

	public Initialisation() {
		boolean ok = true;
		
		do {
			System.out.print("Entrez le nombre de lignes du plateau : ");
		    ok = entree.hasNextInt();
		    
		    if (!ok) {
		    	System.err.println("Erreur !\nEntrer un nombre de colonnes positifs et non nul :\nEx : 6 ou 10"
				           + "\nAttention le plateau est limité à 20 colonnes");
		    } else {
		    	ligne = entree.nextInt();
				if(ligne <= 0 || ligne > 20) {
					System.err.println("Erreur !\nEntrer nombre de lignes positifs et non nul :\nEx : 6 ou 10"
							           + "\nAttention le plateau est limité à 20 lignes");
					ok = false;
				}
	        }
	        entree.nextLine();
		} while (!ok);
		
		do {
			System.out.print("Entrez le nombre de colonnes du plateau : ");
		    ok = entree.hasNextInt();
		    
		    if (!ok) {
		    	System.err.println("Erreur !\nEntrer un nombre de colonnes positifs et non nul :\nEx : 6 ou 10"
				           + "\nAttention le plateau est limité à 20 colonnes");	
		    } else {
		    	colonne = entree.nextInt();
				if(colonne <= 0 || colonne > 20) {
					System.err.println("Erreur !\nEntrer un nombre de colonnes positifs et non nul :\nEx : 6 ou 10"
							           + "\nAttention, le plateau est limité à 20 colonnes");
					ok = false;
				}
	        }
	        entree.nextLine();
		} while (!ok);

		do {
			System.out.print("Entrez le nombre de pions présents sur le plateau : ");
		    ok = entree.hasNextInt();
		    
		    if (!ok) {
		    	System.err.println("Erreur !\nEntrer un nombre de pions positifs pair et non nul :\nEx : 6 ou 10 ");	
		    } else {
		    	nbPion = entree.nextInt();
				if(nbPion <= 0 || nbPion >= ligne * colonne || nbPion % 2 == 1) {
					System.err.println("Erreur !\nEntrer un un nombre de pions positifs pair et non nul :\nEx : 6 ou 10"
							           + "\nAttention, le nombre de pions doit être inférieur à la dimension du plateau"
							           + " (soit nombres de pions < lignes * colonnes)\n");
					ok = false;
				}
	        }
	        entree.nextLine();
		} while (!ok);
		
		System.out.printf("\nLe plateau sera composé :\n" 
					     + "- %d" + " lignes\n"
					     + "- %d" + " colonnes\n"
					     + "- %d" + " pions\n", ligne, colonne, nbPion);		
	}
	
	public Initialisation(int ligne, int colonne, int nbPion, int[][] coGrenouille, int[][] coCrapaud) {
		this.ligne = ligne;
		this.colonne = colonne;
		this.nbPion = nbPion;
		this.coGrenouille = coGrenouille;      
		this.coCrapaud = coCrapaud;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	public int getNbPion() {
		return nbPion;
	}

	public void setNbPion(int nbPion) {
		this.nbPion = nbPion;
	}
	public int[][] getCoGrenouille() {
		return coGrenouille;
	}

	public void setCoGrenouille(int[][] coGrenouille) {
		this.coGrenouille = coGrenouille;
	}

	public int[][] getCoCrapaud() {
		return coCrapaud;
	}

	public void setCoCrapaud(int[][] coCrapaud) {
		this.coCrapaud = coCrapaud;
	}
}
