package tauler;
import java.util.Random;

public class algoritme {
	
	
	public combinacio resoldre(tauler t) {
		int max = 0;
		int linia_max = 0;
		for (int i = 0; i <= t.getUltima(); ++i) {
			int aux = 0;
			int cont = 0;
			for (int j = 0; j <= t.getLine_size(); ++j) {
				if (t.get_solucio_linia(i).get_elementx(j) == 2) {
					aux += 2;
					++cont;
				}
				else if (t.get_solucio_linia(i).get_elementx(j) == 1) {
					++aux;
					++cont;
				}
			}
			if ((aux+cont) > max) {
				max = aux + cont;
				linia_max = i;
			}
		}
		combinacio resultat = t.getlinia(linia_max);
		Random r = new Random();
		resultat.set_elementx(r.nextInt(t.getLine_size()), r.nextInt(6));
		return resultat;
	}
}
