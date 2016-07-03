package br.com.tecnonoticias.estruturadedados;

public class Aluno {
	String nome;
	String cpf;
	String turma;
	static Notas[] arrayNota = new Notas[3];
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Aluno(String nome, String cpf, String turma) {
		this.nome = nome;
		this.cpf = cpf;
		this.turma = turma;
	}
	 
	public boolean equals(Object o){
		o.equals(this.nome);
		return true;
	}
}