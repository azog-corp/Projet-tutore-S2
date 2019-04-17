package crapouille;

public class Grenouille extends Pion {

	private int abscisse,
	ordonnee;
	private boolean bloque = false;

	public Grenouille(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}

	public boolean isBloque() {
		return bloque;
	}

	public void setBloque(boolean bloque) {
		this.bloque = bloque;
	}
}