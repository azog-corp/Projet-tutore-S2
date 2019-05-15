/**
 * 
 */
package crapouille.configuration;

import crapouille.Pion;

/**
 * @author Azog
 *
 */
public class Configuration {

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
