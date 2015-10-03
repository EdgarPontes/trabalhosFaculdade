package br.com.tecnonoticias.estruturadedados;

public class Notas {
	double nota1b;
	double nota2b;
	double media;
	
	public Notas(double nota1, double nota2){
		this.nota1b = nota1;
		this.nota2b = nota2;
		this.media = (nota1+nota2) / 2;
	}

	public double getNota1b() {
		return nota1b;
	}

	public void setNota1b(double nota1b) {
		this.nota1b = nota1b;
	}

	public double getNota2b() {
		return nota2b;
	}

	public void setNota2b(double nota2b) {
		this.nota2b = nota2b;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}
}