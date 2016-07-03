package curso;

public class Fusca extends Automovel {
	
	public String eUmFusca;
	
	public static void main(String... args){
		Fusca fusca = new Fusca();
		fusca.getAutomovel();
	}

	
 public void getAutomovel(){
	 
	 Automovel carro = new Automovel();
	 carro.potencia = "500cv";
	 carro.roda = "17";
	 
	 System.out.println(carro.getCor());
	 System.out.println(carro.getPotencia());
	 System.out.println(carro.getRoda());
	 
 }
}
