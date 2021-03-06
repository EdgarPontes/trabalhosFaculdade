package br.com.tecnonoticias.estruturadedados;

import java.util.Scanner;

public class CaixaAtendimento {

	static Caixa caixap = new Caixa();
	static Caixa caixa2 = new Caixa();
	static int somaP = 0;
	static int somaN = 0;
	static int chamaSenhaP=0;
	static int chamaSenhaN=0;

	private static Object[] senhaP = new Object[10];
	private static Object[] senhaN = new Object[10];

	@SuppressWarnings({ "resource" })
	public static void menu() {

		Scanner teclado = new Scanner(System.in);
		System.out.println(
				"Digite \n1 para retirar senha \n2 para chamar o caixa preferencial "
				+ "\n3 para chamar caixa normal \n4 para imprimir as senhas \n5 para sair ");
		roda();
		
		int opcao = teclado.nextInt();
		switch (opcao) {

		case 1:
			System.out.println("Digite \n1 para senha Preferencial \n2 para Normal ");
			roda();
			
			int numero = teclado.nextInt();
			if(numero==1){
				senhaP[somaP] = caixap.geraSenha(numero);
				somaP++;
			}else{
				senhaN[somaN] = caixa2.geraSenha(numero);
				somaN++;
			}
			menu();

		case 2:
			senhaP = caixap.chamaFila(senhaP, chamaSenhaP++);
			System.out.println();
			menu();

		case 3 :
			senhaN = caixa2.chamaFila(senhaN, chamaSenhaN++);
			System.out.println();
			menu();
		case 4:

			for (int i = 0; i < senhaP.length; i++) {
				if(senhaP[i]!=null){
				System.out.println("Senha "+ i + " caixa"+" " +senhaP[i].toString());					
				}
			}
			System.out.println();
			
			for (int i = 0; i < senhaN.length; i++) {
				if(senhaN[i]!=null){
				System.out.println("Senha "+ i + " caixa"+ " " +senhaN[i].toString());
				}
			}
			System.out.println();
			menu();

		case 5:
			System.exit(0);

		default:
			System.out.println("Opcção invalida!!! ");
		}
	}
	/*
	 * Metodo para dar um espaço entre as telas!
	 */
	public static void roda(){
		for(int i = 0; i < 15; i++){
			System.out.println("");
		}
	}

	public static void main(String[] args) {

		menu();

	}
}