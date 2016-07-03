package br.com.tecnonoticias.no;

import javax.swing.JOptionPane;

public class No {

	private static int continuar = 0;
	public String pergunta ;
	public String animal ;
	public String animalP;
	public No noDireito = null;
	public No noEsquerdo = null;

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public void setNoDireito(No noDireito) {
		this.noDireito = noDireito;
	}

	public void setNoEsquerdo(No noEsquerdo) {
		this.noEsquerdo = noEsquerdo;
	}

	public void iniciar() {
		
		if (noDireito != null) {
			int questao = JOptionPane.showConfirmDialog(null, "O animal que você pensou " + pergunta,"Por acaso...", 0);
			if (questao == 0) {
				noDireito.iniciar();
			} else {
				noEsquerdo.iniciar();
			}

		} else {
			boolean acerteiOAnimal = Animal();
			if (acerteiOAnimal) {
				AcertarOAnimal();
			} else {
				criarUmNovoJogo();
			}
		}
	}

	public boolean Animal() {
		int animalSugerido = JOptionPane.showConfirmDialog(null, "O animal que você pensou é " + animal,"Sei o animal", 0);
		return (animalSugerido == 0);
	}

	public void AcertarOAnimal() {
		JOptionPane.showMessageDialog(null, "Acertei novamente");
		
	}

	public void criarUmNovoJogo() {
		String animalPensou = JOptionPane.showInputDialog(null, "Qual animal que você pensou?", "Desisto",0);
		String dicaDoJogador = JOptionPane.showInputDialog(null,"O(a) " + animalPensou + " ..................... e o(a) " + animal + " não.",
				"Qual a diferença entre os animais?", 0);
	
		No novoNoDireito = new No();
		novoNoDireito.setAnimal(animalPensou);

		No novoNoEsquerdo = new No();
		novoNoEsquerdo.setAnimal(dicaDoJogador);

		pergunta = dicaDoJogador;

		noDireito = new No();
		noEsquerdo = new No();

		noDireito = novoNoDireito;
		noEsquerdo = novoNoEsquerdo;
	}

	public static void main(String[] args) {
		
		No noDireito = new No();
		noDireito.setAnimal("Tubarão");

		No noEsquerdo = new No();
		noEsquerdo.setAnimal("Macaco ");

		No no = new No();
		no.setNoDireito(noDireito);
		no.setNoEsquerdo(noEsquerdo);
		no.setPergunta(" vive na água? ");
		
		while (continuar == 0) {
			JOptionPane.showMessageDialog(null, "Pense em um animal");
			
			no.iniciar();

			continuar = JOptionPane.showConfirmDialog(null, "Deseja continuar jogando?", "Continuar?", 0);
		}

	}

}
