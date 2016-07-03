package br.com.tecnonoticias.estruturadedados.blackjack;

public class Pilha {

	public Object[] pilha;
	public int posicaoPilha;

	public Pilha() {
		this.posicaoPilha = -1;
		// indica que esta nula, vazia, pois posição um indica que contém
		// informação
		this.pilha = new Object[52];
		// criando uma pilha com 52 posições
	}

	public boolean pilhaVazia() {
		// isEmpty
		if (this.posicaoPilha == -1) {
			return true;
		}
		return false;
	}

	public int tamanho() {
		// is
		if (this.pilhaVazia()) {
			return 0;
		}
		return this.posicaoPilha + 1;
	}

	public Object exibeUltimoValor() {
		// top
		if (this.pilhaVazia()) {
			return null;
		}
		return this.pilha[this.posicaoPilha];
	}

	public Object desempilhar() {
		// pop
		if (pilhaVazia()) {
			return null;
		}
		return this.pilha[this.posicaoPilha--];
	}

	public void empilhar(Object valor) {
		// push
		if (this.posicaoPilha < this.pilha.length - 1) {
			this.pilha[++posicaoPilha] = valor;
		}
	}

	public static void main(String args[]) {
		Pilha p = new Pilha();
		p.empilhar("Portuguesa ");
		p.empilhar("Frango com catupiry ");
		p.empilhar("Calabresa ");
		p.empilhar("Quatro queijos ");
		p.empilhar(10);
		while (p.pilhaVazia() == false) {
			System.out.println(p.desempilhar());
		}
	}
}
	// Leia mais em: Pilhas: Fundamentos e implementação da estrutura em Java
	// http://www.devmedia.com.br/pilhas-fundamentos-e-implementacao-da-estrutura-em-java/28241#ixzz3pFQmhqs1
