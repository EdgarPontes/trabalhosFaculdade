package br.com.tecnonoticias.heranca;

public class AnimalTeste {

	public static void main(String[] args) {
		
		Cachorro toto = new Cachorro();
		
		toto.comida = "Carne";
//		toto.dormir();
		
		Galinha carijo = new Galinha();
//		carijo.dormir();
//		System.out.println("A galinha comeu "+carijo.comida);
		System.out.println(toto instanceof Cachorro);
	}

}
