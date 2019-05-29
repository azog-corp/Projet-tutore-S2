/**
 * 
 */
package crapouille.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import crapouille.Partie;
import crapouille.Pion;
import crapouille.Plateau;
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
	
	/**
	 * ArrayList contenant toutes les configurations créé
	 * ainsi que la configuration par défaut.
	 * Cette variable est enregistré lorsque le joueur
	 * quitte l'application
	 */
	public static ArrayList<Configuration> listConfiguration = new ArrayList<Configuration>();
	
	/**
	 * Chemin du fichier bin dans lequel est enregistré
	 * la ArryList listConfiguration
	 */
	private final static String CHEMIN_FICHIER = "crapouille/configuration/listConfiguration.bin";
	
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
	
	/**
	 * Récupère la ArrayList contenant toutes les configurations
	 * qui ont été crées et celle par défaut
	 */
	@SuppressWarnings("unchecked")
	public static void initConfig() {
		try(ObjectInputStream fichier = new ObjectInputStream(new FileInputStream(CHEMIN_FICHIER))) {           
			// lecture de l'objet contenu dans le fichier
			listConfiguration = (ArrayList<Configuration>) fichier.readObject();
			Partie.currentPlateau = new Plateau (listConfiguration.get(0).getConfigPlateau());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sauvegarde en mémoire la ArrayList contenant toutes les configurations
	 */
	public static void saveConfig() {
		try(ObjectOutputStream fichier = new ObjectOutputStream(new FileOutputStream(CHEMIN_FICHIER))) {
			fichier.writeObject(listConfiguration);
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
}
