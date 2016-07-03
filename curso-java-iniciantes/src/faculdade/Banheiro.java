package faculdade;

public class Banheiro extends Sala {

	String vaso;
	String pia;
	String espelho;
	
	@Override
	Integer quantidadeJanelas() {
		return 0;
	}

	@Override
	Integer quantidadePortas() {
		return 2;
	}

	@Override
	Integer quantidadeLampadas() {
		return 2;
	}
	
	
	
}
