package tauler;
import java.util.Scanner;

public class driver {

	public static void main(String[] args){
		
		System.out.print("escriu el numero de linies:");
		int files = 0;
		Scanner S = new Scanner(System.in);
		files = S.nextInt();
		System.out.print("escriu el numero d'elements:");
		int numero_elements = 0;
		numero_elements = S.nextInt();
		tauler t = new tauler(files, numero_elements);
		System.out.println("Apreta 0 per sortir.");
		System.out.println("Apreta 1 per obtenir el nombre de linies del tauler.");
		System.out.println("Apreta 2 per obtenir el nombre de d'elements de la linia.");
		System.out.println("Apreta 3 per obtenir els elements de una linia.");
		System.out.println("Apreta 4 per cambiar els elements de una linia.");
		System.out.println("Apreta 5 per visualitzar el tauler.");
		System.out.println("Apreta 6 per escriure la linia per endevinar.");
		System.out.println("Apreta 7 per obtenir la linia per endevinar.");
		System.out.println("Apreta 8 per visualitzar la solucio.");
		int n = 0;
		n = S.nextInt();
		while(n != 0){
			switch(n){
				case 0:
				{
					break;
				}
				case 1:
				{
					 System.out.println("files: "+t.getLine_number());
					 break;
				}
				case 2:
				{
					System.out.println("elements: "+t.getLine_size());
					break;
				}
				case 3:
				{
					System.out.print("Introdueix numero de linia:");
					int l = S.nextInt();
					if (l < 0 || l >= t.getLine_number()) System.out.println("El numero que has introduit no es valid");
					else {
						int v[] = t.getlinia(l);
						for (int i = 0; i != t.getLine_size(); ++i){
							System.out.println(i+": "+v[i]);
						}
					}
					break;
				}
				case 4:
				{
					System.out.print("Introdueix numero de linia:");
					int l = S.nextInt();
					int[] v = new int[t.getLine_size()];
					if (l < 0 || l >= t.getLine_number()) System.out.println("El numero que has introduit no es valid");
					else {
						System.out.print("Introdueix els '"+t.getLine_size()+"' colors:");
						for (int i = 0; i != t.getLine_size(); ++i) v[i] = S.nextInt();
						t.setlinia(v, l);
						System.out.println("La linia ha sigut modificada");
					}
					break;
				}
				case 5:
				{
					t.escriu_tauler();
					break;
				}
				case 6:
				{
					System.out.print("Introdueix els '"+t.getLine_size()+"' colors:");
					int[] v = new int[t.getLine_size()];
					for (int i = 0; i != t.getLine_size(); ++i) v[i] = S.nextInt();
					t.setInitial_line(v);
					break;
				}
				case 7:{
					int[] v = new int[t.getLine_size()];
					v = t.getInitial_line();
					for (int i = 0; i != t.getLine_size(); ++i) System.out.print(v[i]);
					break;
				}
				case 8:
				{
					t.escriu_solucio();
					break;
				}
			}
			n = S.nextInt();
		}
		S.close();
	}
}
