package tauler;

public class tauler {
	private int [][] tauler; // tauler de linies del MM
	private int line_number; // nombre de linies del MM
	private int line_size; // nombre d'elements per linia
	private int [] initial_line; //combinació a endivinar
	private int [][] solucio; // solucio del MM

	// CONSTRUCTOR
	
	public tauler(int line_number, int line_size){
		this.line_number = line_number;
		this.line_size = line_size;
		tauler = new int [line_number][line_size];
		initial_line = new int [line_size];
		solucio = new int [line_number][line_size];
	}

	// SETTER I GETTERS
	
	// retorna el nombre de linies del MM
	public int getLine_number(){
		return line_number;
	}

	// modifica el nombre de linies del MM
	public void setLine_number(int line_number){
		this.line_number = line_number;
	}

	// retorna el nombre d'elements per linia
	public int getLine_size(){
		return line_size;
	}

	// modifica el nombre d'elements per linia
	public void setLine_size(int line_size){
		this.line_size = line_size;
	}
	
	// retorn al solució de la linia "line"
	public int [] get_solucio_linia(int line){
		return solucio[line];
	}
	
	// retorna un vector amb la combinació de la linia "line"
	public int [] getlinia(int line){
		return tauler[line];
	}

	// retorna la matriu tauler
	public int [][] getTauler(){
		return tauler;
	}

	// modifica la matriu tauler
	public void setTauler(int [][] tauler){
		this.tauler = tauler;
	}

	// retorna la combinacio inicial
	public int [] getInitial_line(){
		return initial_line;
	}

	// modifica la combinacio inicial
	public void setInitial_line(int [] initial_line){
		this.initial_line = initial_line;
	}
	
	// retorna la matriu solucio
	public int[][] getSolucio() {
		return solucio;
	}

	// modifica la matriu solucio
	public void setSolucio(int[][] solucio) {
		this.solucio = solucio;
	}
	
	// OTHERS
	
	// escriu el tauler per pantalla
	public void escriu_tauler(){
		for(int i = 0; i < line_number; ++i){
			for(int j = 0; j < line_size; ++j) System.out.print(tauler[i][j]);
				System.out.println();
		}
	}
	
	// escriu la solucio per pantalla
	public void escriu_solucio(){
		for(int i = 0; i < line_number; ++i){
			for(int j = 0; j < line_size; ++j) System.out.print(solucio[i][j]);
				System.out.println();
		}
	}
	
	// modifica el valor d'una linia
	// "linia" es el nombre de la linia que es vol modificar
	public void setlinia(int [] vec_linia, int linia){
			tauler[linia] = vec_linia;
			int iguals = 0;
			int diferent_pos = 0;
			for(int i = 0; i < vec_linia.length; ++i){
				if (vec_linia[i] == initial_line[i]) ++iguals;
				else{
					int j = 0;
					boolean trobat = false;
					while(j < vec_linia.length && !trobat){
						if(initial_line[i] == vec_linia[j]){
							++diferent_pos;
							trobat = true;
						}
						++j;
					}
				}	
			}
			int i = 0;
			while(i < vec_linia.length){
				if(iguals > 0){
					// està bé
					solucio[linia][i] = 2;
					--iguals;
				}
				else if (diferent_pos > 0){
					//diferent solució
					solucio[linia][i] = 1;
					--diferent_pos;
				}
				// està mal
				else solucio[linia][i] = 0;
				++i;
			}
		}
}