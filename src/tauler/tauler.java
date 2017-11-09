package tauler;

public class tauler { // tauler de linies del MM
	private int line_number; // nombre de linies del MM
	private int line_size; // nombre d'elements per linia
	private int ultima; //ultima linia modificada
	private combinacio comb_ini;
	private combinacio[] tauler; // solucio del MM
	private combinacio[] solucio;
	
	//-----COLORS-----
	// 0-> BUIT
	// 1-> NEGRE bé però en pos incorrecte
	// 2-> BLANC ok

	// CONSTRUCTOR
	
	public tauler(int line_number, int line_size){
		ultima = 0;
		this.line_number = line_number;
		this.line_size = line_size;
		tauler = new combinacio[line_number];
		comb_ini = new combinacio(line_size);
		solucio = new combinacio[line_number];
		for(int i = 0; i < tauler.length; ++i){
			tauler[i] = new combinacio(line_number);
			solucio[i] = new combinacio(line_number);
		}
	}
	// SETTER I GETTERS
	
	// retorna el numero de la ultima linia modificada
	public int getUltima() {
		return ultima;
	}
	
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
	public combinacio get_solucio_linia(int line){
		return solucio[line];
	}
	
	// retorna la combinacio la linia "line"
	public combinacio getlinia(int line){
		return tauler[line];
	}

	// retorna el vector de combinacions
	public combinacio[] getTauler(){
		return tauler;
	}

	// modifica la matriu tauler
	public void setTauler(combinacio[] tauler){
		this.tauler = tauler;
	}

	// retorna la combinacio inicial
	public combinacio get_comb_ini(){
		return comb_ini;
	}

	// modifica la combinacio inicial
	public void setInitial_line(combinacio comb_ini){
		this.comb_ini = comb_ini;
	}
	
	// retorna la matriu solucio
	public combinacio[] getSolucio() {
		return solucio;
	}

	// modifica la matriu solucio
	public void setSolucio(combinacio[] solucio) {
		this.solucio = solucio;
	}
	
	// OTHERS
	
	// escriu el tauler per pantalla
	public void escriu_tauler(){
		for(int i = line_number-1; i >= 0; --i){
			tauler[i].escriu_combinacio();
		}
	}
	
	// escriu la solucio per pantalla
	public void escriu_solucio(){
		for(int i = line_number-1; i >= 0; --i){
			solucio[i].escriu_combinacio();
		}
	}
	
	
	//afegeix una combinacio a la ultima linia no modificada
	public void set_ultima_linia(combinacio c){
		if(ultima >= line_number){
			//ja tenim el mastermind ple per tant no podem posar + linies
			System.out.println("ERROR: El mastermind ja esta omplert.");
		}
		else{
			tauler[ultima] = c;
			// Emplenem la solucio
			actualitzar(c);	
			++ultima;
		}
		
	}
		// donada una nova linia comparar-la amb la combinacio inicial i
		//emplenar la combinacio solucio corresponent
       private void actualitzar(combinacio c){
    	   int blancs = 0;
    	   int negres = 0;
    	   //el vector s'utilitza per que si veiem que una bola està bé
    	   //no la conti 2 cops si una és del mateix color en mala pos
    	   int[] comprovant = new int[line_size];
    	   for(int i = 0; i < line_size; ++i){
    		   if(c.get_elementx(i)== comb_ini.get_elementx(i)){
    			   ++blancs;
    			   comprovant[i] = 1;
    		   }
    		   else{
    			   int j = 0;
   					boolean trobat = false;
   					while(j < line_size && !trobat){
   						if(c.get_elementx(i) == comb_ini.get_elementx(j)&& comprovant[j] ==0 ){
   						++negres;
   						trobat = true;
   					}
   					++j;
   				}
    		   }
    	   }
    	   solucio[ultima].omplir(blancs, negres);  
       }
}