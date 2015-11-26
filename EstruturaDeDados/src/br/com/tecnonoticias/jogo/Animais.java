package br.com.tecnonoticias.jogo;

import javax.swing.JOptionPane;

public class Animais {

	public static void main(String[] args) {
		Confirma playAnimal = new Confirma();

		// Animais playAnimal = new Animais();

		No noDireito = new No();
		noDireito.setAnimal("Macaco");

		No noEsquerdo = new No();
		noEsquerdo.setAnimal("Tubarão ");

		No no = new No();
		no.setNoDireito(noDireito);
		no.setNoEsquerdo(noEsquerdo);
		no.setPergunta(" vive na água? ");

		while (playAnimal.getRet() == 1) {

			JOptionPane.showMessageDialog(null, "Pense em um animal", "Jogo dos Animais", JOptionPane.OK_OPTION);
			int ret = JOptionPane.showConfirmDialog(null, "O animal que você pensou " + playAnimal.pergunta + "?",
					"Jogo do Animais", JOptionPane.YES_NO_OPTION);

			if (ret == JOptionPane.YES_OPTION) {
				playAnimal.vivenaagua();
			} else {
				playAnimal.eummacaco();
			}
		}
	}
}