package br.com.tecnonoticias.jogo;

import javax.swing.JOptionPane;

public class Confirma4 extends No{

	public void naoemacaco(){

        this.animalP = JOptionPane.showInputDialog("Qual Animal você pensou?:");  
        this.animal = JOptionPane.showInputDialog("Um(a)" + this.animalP +"____ mas um(a) "+ this.noEsquerdo+" não."); 
        
        this.criarUmNovoJogo();
//        JOptionPane.showMessageDialog(null, "Então o/a  " + no.animalP + " " +no.pergunta+ " mas um(a) Macaco não.");
//
//        No novoNoDireito = new No();
//    	novoNoDireito.setAnimal(no.animalP);
//    	No novoNoEsquerdo = new No();
//    	novoNoEsquerdo.setAnimal(no.animal);
//    	no.pergunta = detalhes;
//    	no.noDireito = new No();
//    	no.noEsquerdo = new No();
//    	no.noDireito = novoNoDireito;
//    	no.noEsquerdo = novoNoEsquerdo;
    	
    	this.setRet(JOptionPane.showConfirmDialog(null, "Deseja continuar jogando?", "Continuar?", 0));
    }
}