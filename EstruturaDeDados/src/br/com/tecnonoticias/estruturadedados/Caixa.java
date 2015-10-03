package br.com.tecnonoticias.estruturadedados;

public class Caixa {

	private boolean tempo;
	private Object preferencial;
	private final String normal;

	Caixa() {
		this.tempo = false;
		this.preferencial = "Preferencial";
		this.normal = "Normal";
	}

	public Object[] chamaFila(Object[] filaOrigem, int numero) {
		
		Object[] filaMuda = new Object[filaOrigem.length];
		if (numero < filaOrigem.length) {
			for(int i =0; i<filaOrigem.length; i++){
			filaOrigem[numero] = null;
			filaMuda[i] = filaOrigem[i];
			}
		} else {
			System.out.println("Não existe mais senhas!!! ");
		}
		return filaMuda;
	}

	public Object getPreferencial() {
		return preferencial;
	}

	public String getNormal() {
		return normal;
	}

	public Object geraSenha(int senha) {

		if (senha == 1) {
			return getPreferencial();
		} else {
			return getNormal();
		}
	}

	public boolean isTempo() {
		return tempo;
	}

	public void setTempo(boolean intervalo) {
		this.tempo = intervalo;
	}

	public void preferencia() {

	}

	public boolean intervalo(int quantidade) {
		if (quantidade % 10 == 0) {
			return true;
		} else {
			return false;
		}
	}
}