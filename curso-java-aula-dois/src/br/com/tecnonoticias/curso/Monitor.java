package br.com.tecnonoticias.curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Monitor {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {

			Condicoes condicoes = new Condicoes();
			List<Numero> numeros = new ArrayList<>();
			System.out.println("Digite um numero: ");
			Scanner scanner = new Scanner(System.in);
			String valorDigitado = scanner.next();
			char[] charArray = valorDigitado.toCharArray();

			for (char c : charArray) {
				Numero n = condicoes.getNumero(String.valueOf(c));
				numeros.add(n);
				limparTela();
			}
			for (Numero nm : numeros) {
				nm.print();
			}
		}
	}

	private static void limparTela() {
		for (int a = 0; a < 10; a++) {
			System.out.println("");
		}
	}
}