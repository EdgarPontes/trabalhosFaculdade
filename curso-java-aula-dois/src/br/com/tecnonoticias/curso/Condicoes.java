package br.com.tecnonoticias.curso;

public class Condicoes {

	public Numero getNumero(String valor) {

		if (valor.equals("1")) {
			return new NumeroUm();
		} else if (valor.equals("2")) {
			return new NumeroDois();
		} else if (valor.equals("3")) {
			return new NumeroTres();
		} else if (valor.equals("4")) {
			return new NumeroQuatro();
		} else if (valor.equals("5")) {
			return new NumeroCinco();
		} else if (valor.equals("6")) {
			return new NumeroSeis();
		} else if (valor.equals("7")) {
			return new NumeroSete();
		} else if (valor.equals("8")) {
			return new NumeroOito();
		} else if (valor.equals("9")) {
			return new NumeroNove();
		} else {
			return new NumeroZero();
		}
	}
}