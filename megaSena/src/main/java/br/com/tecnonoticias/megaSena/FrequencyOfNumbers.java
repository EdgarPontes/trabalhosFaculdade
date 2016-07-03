package br.com.tecnonoticias.megaSena;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FrequencyOfNumbers {

	public int[] leitura(int x) {
		String[] arquivo = null;
		int[] resultado = new int[x];
		int a = 0;
		int i = 0;
		Path path = Paths.get("/media/edgar/45D33C19493C7BD8/resultadosMega.txt");
		Charset utf8 = StandardCharsets.UTF_8;

		try (BufferedReader leitura = Files.newBufferedReader(path, utf8)) {
			String line = null;
			
			while ((line = leitura.readLine()) != null) {
				arquivo = line.split(" ");

				while (i < arquivo.length) {
					resultado[a] = Integer.parseInt(arquivo[i]);
					i++;
					a++;
				}
				i = 0;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public int[] frequencyOfNumbersSearch(int[] vetor){
		
		int[] vetor60 = new int[60];
		
		for (int i = 0; i < vetor.length; i++) {
			vetor60[vetor[i]-1] ++;
		}
		
		return vetor60;
	}

	public static void main(String[] args) throws IOException {

		int[] arquivo = new FrequencyOfNumbers().leitura(120);
		
		int[] vetor = new FrequencyOfNumbers().frequencyOfNumbersSearch(arquivo);
		
		int i = 0;
		for (int number : vetor) {
			i++;
			System.out.println("O número " + i + " saiu " +  number);
		}
	}

}
