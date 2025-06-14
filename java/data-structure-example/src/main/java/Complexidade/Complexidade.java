package Complexidade;

public class Complexidade {

	public int isIn(int chave, int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (chave == a[i])
				return i;
		}
		return -1;

	}

	public int isInBinario(int chave, int[] a) {
		int baixo = 0, meio, alto = a.length - 1;
		while (baixo <= alto) {
			meio = (baixo + alto) / 2;
			if (chave == a[meio])
				return meio;
			else if (chave < a[meio])
				alto = meio - 1;
			else
				baixo = meio + 1;
		}
		return -1;
	}

	public int[] ordena(int[] a) {
		int aux;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					aux = a[i];
					a[i] = a[j];
					a[j] = aux;
				}
			}
		}
		return a;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
