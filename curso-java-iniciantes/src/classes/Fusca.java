package classes;

public class Fusca extends Automovel{

	static Integer quantidadeCavalos;
	public Automovel automovel;
	
	@Override
	public String getDirecao() {
		return "direção manual";
	}
	
	public String getPotencia(Integer 
			quantidadeCavalos) {
		this.quantidadeCavalos = quantidadeCavalos;
		
		return quantidadeCavalos + " cavalos";
	}
	
	@Override
	String getPotencia() {
		return "2 potraquinho";
	}
	
	public static void main(String... args){
		Fusca auto = new Fusca();
		System.out.println(auto.getCor());
		System.out.println(auto.getPotencia());
		System.out.println(auto.getPotencia(200));
		System.out.println(quantidadeCavalos);
		System.out.println(auto.getDirecao());
		
	}

	@Override
	public String tipoDoCarro() {
		return "é um fusca";
	}

}
