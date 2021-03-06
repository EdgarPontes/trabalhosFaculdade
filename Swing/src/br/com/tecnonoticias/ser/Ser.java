package br.com.tecnonoticias.ser;

import java.awt.Component;
import java.util.Random;

public class Ser {

	public String nome;
	public int linha;
	public int coluna;
	public int vida;
	public static int distancia;
	int x; // AQUI É A COORDENADA X
	int y; // AQUI É A COORDENADA Y
	boolean vai;
	boolean volta;

	public Ser(String nome) {

		this.nome = nome;
		linha = randomAparecer(800);
		coluna = randomAparecer(600);
		vida = 100;
		distancia = 10;
	}

	public int moverX(int ser, int telaC, int telaF) {
		if (ser < telaC) {
			vai = true;
			volta = false;
		}
		if (vai == true) {
			x += 10;
		}

		if (ser > telaF) {
			vai = false;
			volta = true;
		}
		if (volta == true) {
			x -= 10;
		}
		return x;
	}

	public int moverY(int ser, int telaC, int telaF) {
		if (ser < telaC) {
			vai = true;
			volta = false;
		}
		if (vai == true) {
			y += 10;
		}
		if (ser > telaF) {
			vai = false;
			volta = true;
		}
		if (volta == true) {
			y -= 10;
		}
		return y;
	}

	public boolean bateu(Component a, Component b) {
		int aX = a.getX();
		int aY = a.getY();
		int ladoDireitoA = aX + a.getWidth();
		int ladoEsquerdoA = aX;
		int ladoBaixoA = aY + a.getHeight();
		int ladoCimaA = aY;

		int bX = b.getX();
		int bY = b.getY();
		int ladoDireitoB = bX + b.getWidth();
		int ladoEsquerdoB = bX;
		int ladoBaixoB = bY + b.getHeight();
		int ladoCimaB = bY;

		boolean bateu = false;

		boolean cDireita = false;
		boolean cCima = false;
		boolean cBaixo = false;
		boolean cEsquerda = false;

		if (ladoDireitoA >= ladoEsquerdoB) {
			cDireita = true;
		}
		if (ladoCimaA <= ladoBaixoB) {
			cCima = true;
		}
		if (ladoBaixoA >= ladoCimaB) {
			cBaixo = true;
		}
		if (ladoEsquerdoA <= ladoDireitoB) {
			cEsquerda = true;
		}

		if (cDireita && cEsquerda && cBaixo && cCima) {
			bateu = true;
		}

		return bateu;
	}

	public Integer randomAparecer(Integer limite) {
		try {
			Thread.sleep(80);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Random random = new Random();
		Integer numero = random.nextInt(limite);

		return numero * 2 + (numero / 3) * 2;
	}

	public Integer random(Integer limite) {
		Random random = new Random();
		Integer numero = random.nextInt(limite);
		return numero * (numero + numero) / 2;
	}

	public int morrer(int a, int vida2) {
		return vida = vida2 - a;
	}

	public int viver(int a, int vida2) {
		int total = vida2 + a;
		if (total < 100) {
			return total;
		} else {
			return vida2;
		}
	}
}