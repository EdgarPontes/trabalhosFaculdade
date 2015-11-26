package br.com.tecnonoticias.jogo;

import javax.swing.JOptionPane;

public class No {

	public String pergunta ;
	public String animal ;
	public String animalP;
	public No noDireito = null;
	public No noEsquerdo = null;
	private int ret = 1;

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}	
	
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

	public boolean Animal() {
		int animalSugerido = JOptionPane.showConfirmDialog(null, "O animal que você pensou é " + animal,"Sei o animal", 0);
		return (animalSugerido == 0);
	}

	public void AcertarOAnimal() {
		JOptionPane.showMessageDialog(null, "Acertei novamente");
		
	}

	public void criarUmNovoJogo() {
	
		No novoNoDireito = new No();
		novoNoDireito.setAnimal(this.animalP);

		No novoNoEsquerdo = new No();
		novoNoEsquerdo.setAnimal(this.animal);
		
		pergunta = animal;

		noDireito = new No();
		noEsquerdo = new No();

		noDireito = novoNoDireito;
		noEsquerdo = novoNoEsquerdo;

	}

	public String run() {
		// TODO Auto-generated method stub
		return null;
	}

}
