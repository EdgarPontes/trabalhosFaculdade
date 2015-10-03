package faculdade;

public class Computador extends Equipamento {

	@Override
	public String ligar() {
		super.desligar();
		String botao = "Apertar botao";
		String carregando = "Esperar carregar sistema";
		return "Esta ligado";
	}

}
