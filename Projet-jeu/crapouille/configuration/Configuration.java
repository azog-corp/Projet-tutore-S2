/**
 * 
 */
package crapouille.configuration;

import java.io.Serializable;

import crapouille.Pion;

/**
 * @author Azog
 *
 */
public class Configuration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3678759492095676152L;
	private Pion[][] configPlateau;
	private String nom;
	
	
	public Configuration(Pion[][] configPlateau, String nom) {
		this.configPlateau = configPlateau;
		this.nom = nom;
	}

	public Pion[][] getConfigPlateau() {
		return configPlateau;
	}


	public void setConfigPlateau(Pion[][] configPlateau) {
		this.configPlateau = configPlateau;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
