package br.com.tecnonoticias.player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.jar.JarException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Tocador {

	public static void tocar() throws JavaLayerException {
		FileInputStream in;
		try {
			// Inicializa o FileInputStream com o endereço do arquivo para tocar
			in = new FileInputStream("/home/edgar/Downloads/DragonBallKai/04 - Oh Yeah!!!! - ED3.mp3");

			// Cria uma instancia da classe player passando para ele o
			// InpuStream do arquivo
			Player p = new Player(in);

			// executa o som
			p.play();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws JavaLayerException, JarException {
		tocar();

	}
}