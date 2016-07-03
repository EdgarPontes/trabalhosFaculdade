package classes;

public class Ferrari extends Automovel {

	
	private Ferrari(){
	}
	
	public static Ferrari getInstance(){
		return new Ferrari();
	}
	
	@Override
	public String getDirecao() {
		return null;
	}

	@Override
	public String tipoDoCarro() {
		return "é uma ferrari";
	}

}
