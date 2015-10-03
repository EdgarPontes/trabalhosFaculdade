package br.com.tecnonoticias.estruturadedados;

import java.util.Scanner;

public class CadastroDeAlunos {
	private static final int ARRAYNOTA1B = 0;

	private static final int ARRAYNOTA2B = 0;

	static Scanner teclado = new Scanner(System.in);

	static Aluno[] Formulario = new Aluno[3];
	// static int opcao;
	static int adicionar;

	public static void adicionar() {
		System.out.println("Quantos alunos quer adicionar? ");
		adicionar = teclado.nextInt();
		for (int x = 0; x < adicionar; x++) {
			System.out.println("Digite o nome: ");
			String nome = teclado.next();
			System.out.println("Digite o cpf: ");
			String cpf = teclado.next();
			System.out.println("Digite o turma: ");
			String turma = teclado.next();
			Aluno criar = new Aluno(nome, cpf, turma);
			Formulario[x] = criar;
		}
		menu();
	}

	public static int buscar() {
		@SuppressWarnings("unused")
		int posicao;
	System.out.println("Digite o nome do aluno que quer alterar: ");
		String nomeA = teclado.next();
		for (int x = 0; x < Formulario.length; x++) {
			if (Formulario[x] != null) {
				if (nomeA.equals(Formulario[x].getNome())) {
					posicao = x;
				}
			}
		}
		return adicionar;
	}

	public static void alterar() {
		menuDecisao();
		menu();
	}

	public static void excluir() {
		int posicao = buscar();
		for (int x = posicao; x < Formulario.length - 1; x++) {
			Formulario[x] = Formulario[x + 1];
			Formulario[x + 1] = null;
		}
		menu();
	}

	public static void imprimir() {
		for (int x = 0; x < Formulario.length; x++) {
			if (Formulario[x] != null && Formulario[x].arrayNota[x] != null) {
				System.out.println("None: " + Formulario[x].getNome() + " Cpf: " + Formulario[x].getCpf() + " Turma: "
						+ Formulario[x].getTurma() + Formulario[x].arrayNota[ARRAYNOTA1B].getNota1b());
			}
		}
		menu();
	}

	public static void menuDecisao() {
		System.out.println("O que deseja alterar? \n 1-Cpf \n 2-Turma \n 3-Notas ");
		int opcao = teclado.nextInt();
		switch (opcao) {
		case 1:
			int posicaoCpf = buscar();
			System.out.println("Digite o cpf: ");
			String cpf = teclado.next();
			Formulario[posicaoCpf].setCpf(cpf);
		case 2:
			int posicaoTurma = buscar();
			System.out.println("Digite o turma: ");
			String turma = teclado.next();
			Formulario[posicaoTurma].setTurma(turma);
		case 3:
//			int nota1b = buscar();
//			System.out.println("Digite a nota do 1º bimestre:");
//			double nota1 = teclado.nextDouble();
//			Formulario[nota1b].arrayNota[ARRAYNOTA1B].setNota1b(nota1);
//			Formulario[nota1b].arrayNota[ARRAYNOTA2B].setNota1b(0);
		}
	}

	public static void menu() {
		System.out.println("Digite a opção desejada: " + "\n1-Adicionar " + "\n2-Alterar " + "\n3-Excluir "
				+ "\n4-Imprimir " + "\n5-Sair");
		int opcao = teclado.nextInt();
		switch (opcao) {

		case 1:
			adicionar();
		case 2:
			alterar();
		case 3:
			excluir();
		case 4:
			imprimir();
		case 5:
			System.exit(0);
		default:
			System.out.println("Opção Invalida!!!");
		}
	}

	public static void main(String[] args) {
		menu();
	}
}