package br.com.tecnonoticias.estruturadedados.vinteUm;

import java.net.MalformedURLException;
import java.util.Scanner;

public class PilhaComandos {

	private static final int JOGADOR8 = 7;
	private static final int JOGADOR7 = 6;
	private static final int JOGADOR6 = 5;
	private static final int JOGADOR5 = 4;
	private static final int JOGADOR4 = 3;
	private static final int JOGADOR3 = 2;
	private static final int JOGADOR2 = 1;
	private static final int JOGADOR1 = 0;
	
	public Object[] pilha;
	public Object[] players = {"","","","","","","","",};

	public int posicaoPilha;
	public static int troca;

	private static String jogadorN;
	private static int resultJogador1;
	private static int resultJogador2;
	private static int resultJogador3;
	private static int resultJogador4;
	private static int resultJogador8;
	private static int resultJogador7;
	private static int resultJogador6;
	private static int resultJogador5;

	public PilhaComandos() {
		this.posicaoPilha = -1;
		// indica que esta nula, vazia, pois posição um indica que contém
		// informação
		this.pilha = new Object[52];
		// this.baralho = new Object[52];
		// criando uma pilha com 52 posições
	}

	public Object[] getPlayers() {
		return players;
	}

	public void embaralhar() {
		Baralho cartas = new Baralho();
		while (pilhaCheia()) {
			troca = (int) (Math.random() * 52);
			if (cartas.getBaralho()[troca] != null) {
				empilhar(cartas.getBaralho()[troca]);
				cartas.getBaralho()[troca] = null;
				System.out.println(troca);
			}
		}
	}

	public boolean pilhaCheia() {
		if (this.posicaoPilha >= 51) {
			return false;
		} else {
			return true;
		}
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

	public int ganhador(int Jogador1, int jogador2, int jogador3, int jogador4, int jogador5, int jogador6, int jogador7, int jogador8){
		
		return 0;
	}
	public void empilhar(Object valor) {
		// push
		if (this.posicaoPilha < this.pilha.length - 1) {
			this.pilha[++posicaoPilha] = valor;
		}
	}

	@SuppressWarnings({ "resource" })
	public static void main(String args[]) throws MalformedURLException {
		Scanner teclado = new Scanner(System.in);

		PilhaComandos p = new PilhaComandos();
		p.embaralhar();
		
		Baralho jogo = new Baralho();
		System.out.println("Quantos jogadores vão participar? no maximo de 8");
		int jogadores = teclado.nextInt();

		for (int f = 0; f <= jogadores-1; f++) {
			Scanner t = new Scanner(System.in);
			System.out.println("Digite o nome do jogador " +f);
			p.players[f] = t.next();
		}
//		for (int j = 0; j < jogadores; j++) {
//			for (int i = 0; i < jogo.getBaralho().length; i++) {
//				Scanner t = new Scanner(System.in);
//				System.out.println("Qual jogador e vc?");
//				jogadorN = t.next();
//				if (p.getPlayers()[JOGADOR1].equals(jogadorN)) {
//					System.out.println(p.getPlayers()[JOGADOR1] +" quer reitar uma carta? 'S' ou 'N' ");
//					String retirarJogador1 = teclado.next();
//					if (retirarJogador1.equals("S")) {
//						String a = (String) p.desempilhar();
//						resultJogador1 += jogo.valor(a);
//						new Icones().montaTela(a,resultJogador1);
//					} 
//				}
//				if (p.getPlayers()[JOGADOR2].equals(jogadorN)) {
//					System.out.println(p.getPlayers()[JOGADOR2]+" quer reitar uma carta? 'S' ou 'N' ");
//					String retirarJogador2 = teclado.next();
//					if (retirarJogador2.equals("S")) {
//						String a = (String) p.desempilhar();
//						resultJogador2 += jogo.valor(a);
//						new Icones().montaTela(a,resultJogador2);
//					} 
//				}
//				if (p.getPlayers()[JOGADOR3].equals(jogadorN)) {
//					System.out.println(p.getPlayers()[JOGADOR3]+" quer reitar uma carta? 'S' ou 'N' ");
//					String retirarJogador3 = teclado.next();
//					if (retirarJogador3.equals("S")) {
//						String a = (String) p.desempilhar();
//						resultJogador3 += jogo.valor(a);
//						new Icones().montaTela(a,resultJogador3);
//					}
//				}
//				if (p.getPlayers()[JOGADOR4].equals(jogadorN)) {
//					System.out.println(p.getPlayers()[JOGADOR4]+" quer reitar uma carta? 'S' ou 'N' ");
//					String retirarJogador4 = teclado.next();
//					if (retirarJogador4.equals("S")) {
//						String a = (String) p.desempilhar();
//						resultJogador4 += jogo.valor(a);
//						new Icones().montaTela(a,resultJogador4);
//					}
//				}
//				if (p.getPlayers()[JOGADOR5].equals(jogadorN)) {
//					System.out.println(p.getPlayers()[JOGADOR5]+" quer reitar uma carta? 'S' ou 'N' ");
//					String retirarJogador5 = teclado.next();
//					if (retirarJogador5.equals("S")) {
//						String a = (String) p.desempilhar();
//						resultJogador5 += jogo.valor(a);
//						new Icones().montaTela(a,resultJogador5);
//					}
//				}
//				if (p.getPlayers()[JOGADOR6].equals(jogadorN)) {
//					System.out.println(p.getPlayers()[JOGADOR6]+" quer reitar uma carta? 'S' ou 'N' ");
//					String retirarJogador6 = teclado.next();
//					if (retirarJogador6.equals("S")) {
//						String a = (String) p.desempilhar();
//						resultJogador6 += jogo.valor(a);
//						new Icones().montaTela(a,resultJogador6);
//					}
//				}
//				if (p.getPlayers()[JOGADOR7].equals(jogadorN)) {
//					System.out.println(p.getPlayers()[JOGADOR7]+" quer reitar uma carta? 'S' ou 'N' ");
//					String retirarJogador7 = teclado.next();
//					if (retirarJogador7.equals("S")) {
//						String a = (String) p.desempilhar();
//						resultJogador7 += jogo.valor(a);
//						new Icones().montaTela(a,resultJogador7);
//					}
//				}
//				if (p.getPlayers()[JOGADOR8].equals(jogadorN)) {
//					System.out.println(p.getPlayers()[JOGADOR8]+" quer reitar uma carta? 'S' ou 'N' ");
//					String retirarJogador8 = teclado.next();
//					if (retirarJogador8.equals("S")) {
//						String a = (String) p.desempilhar();
//						resultJogador8 += jogo.valor(a);
//						new Icones().montaTela(a,resultJogador8);
//					}
//				}
//			}
		}
	}
//}