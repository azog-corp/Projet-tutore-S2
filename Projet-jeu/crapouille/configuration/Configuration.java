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
	
	
	public Configuration(Pion[][] configPlateau) {
		this.configPlateau = configPlateau;
	}

	public Pion[][] getConfigPlateau() {
		return configPlateau;
	}


	public void setConfigPlateau(Pion[][] configPlateau) {
		this.configPlateau = configPlateau;
	}
	
	

}
