package br.com.tecnonoticias.jogo;

import javax.swing.JOptionPane;

public class Confirma extends Confirma2{

	Confirma3 queanimal = new Confirma3();
	
	public void vivenaagua() {
		
//		no.animal = "Tubarão";

		int retorno = JOptionPane.showConfirmDialog(null, "O animal que você pensou é um "+ noEsquerdo.animal +
				"?", "Jogo do Animais",JOptionPane.YES_NO_OPTION);
		
		if (retorno == JOptionPane.YES_OPTION) {
			
			AcertarOAnimal();
//			JOptionPane.showMessageDialog(null, "Acertei de novo!", "Jogo dos Animais", JOptionPane.OK_OPTION);
			
		} else {
			
			queanimal.queanimal();
		}
	}
}