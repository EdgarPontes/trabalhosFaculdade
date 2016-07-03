package br.com.tecnonoticias.estruturadedados.Chat;

import java.io.Serializable;
import java.util.Date;

public class Arquivo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private byte[] conteudo;
	private transient long tamanhoKB;
	private String diretorioDestino;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

	public long getTamanhoKB() {
		return tamanhoKB;
	}

	public void setTamanhoKB(long tamanhoKB) {
		this.tamanhoKB = tamanhoKB;
	}

	public String getDiretorioDestino() {
		return diretorioDestino;
	}

	public void setDiretorioDestino(String diretorioDestino) {
		this.diretorioDestino = diretorioDestino;
	}
}