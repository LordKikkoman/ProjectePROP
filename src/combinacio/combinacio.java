package combinacio;

public class combinacio {
	private int [] combinacio;

	// CONSTRUCTOR
	public combinacio(int tamany) {
		combinacio = new int [tamany];
	}
	
	// GETTERS AND SETTERS
	
	// Retorna una combinacio
	public int[] getCombinacio() {
		return combinacio;
	}

	// Modifica el contingut d'una combinacio
	public void setCombinacio(int [] combinacio){
		this.combinacio = combinacio;
	}

}
