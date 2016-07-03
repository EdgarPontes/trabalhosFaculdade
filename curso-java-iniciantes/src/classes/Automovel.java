package classes;

public abstract class Automovel {

	private String cor;
	private String potencia;
	private String direcao;
	
	public abstract String tipoDoCarro();

	public abstract String getDirecao();
	
	public String getCor() {
		return "branco";
	}
	
	String getPotencia() {
		return "500cv";
	}
	

}
