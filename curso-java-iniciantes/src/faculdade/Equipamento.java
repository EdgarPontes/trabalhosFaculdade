package faculdade;

public abstract class Equipamento implements Eletronico{

	public String ligar() {
		return "Esta ligado";
	}

	public String desligar() {
		return "Esta Desligado";
	}
}
