package faculdade;

public class Elevador extends Equipamento implements Movel {

	@Override
	public String direcao() {
		return "Pra cima e Pra baixo";
	}

}
