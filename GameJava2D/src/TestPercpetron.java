import java.io.*;

public class TestPercpetron {

	int matriz[] = { 1, 0, 0, 1 };
	int matriz2[] = { 0, 0, 1, 1 };
	int pesos[] = { 2, 3 };
	int count = 0;
	int dif;

	public TestPercpetron() {

		int k = 0, l = 1, count = 0;

		// Faz a soma ponderada dos pesos

		for (int i = 0; i < 2; i++) {

			int result = matriz[k] * pesos[0] + matriz[l] * pesos[1];

			System.out.println("Resultado de " + k + " por " + 0 + " e de " + l + " por " + 1 + " = " + result);

			// testa se o resultado da soma ponderada é igual ao resultado
			// esperado

			if (result < 1) {

				dif = result - 1;
				pesos[0] = pesos[0] + (dif);
				pesos[1] = pesos[1] + (dif);

			} else {
				System.out.println("\n");

				System.out.println("Resultado de " + k + " por " + 0 + " e de " + l + " por " + 1
						+ " está classificado corretamente!");

				System.out.println("\n");

			}

			/*
			 * /////////////////////////////////////////////////////////////////
			 * ////////////
			 */

			// como não descobri um meio melhor, separei as entradas em duas
			// matrizes diferentes para comparar as saídas

			int result2 = matriz2[k] * pesos[0] + matriz[l] * pesos[1];

			if (result2 > 0) {

				dif = result - 1;
				pesos[0] = pesos[0] - (dif);
				pesos[1] = pesos[1] - (dif);

			} else {

				System.out.println("\n");

				System.out.println("Resultado de " + k + " por " + 0 + " e de " + l + " por " + 1
						+ " está classificado corretamente!");

				System.out.println("\n");

			}

			k = k + 2;
			l = l + 2;
			count = count + 1;

		}
	}
}