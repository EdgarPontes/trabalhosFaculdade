package br.com.tecnonoticias.comunica;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	private static String pergunta;
	
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		System.out.println("Cliente:");
		pergunta = t.next();
		Socket s = null;
		PrintStream ps = null;
		try {
			String x = pergunta;
			s = new Socket("127.0.0.1", 7000);
			ps = new PrintStream(s.getOutputStream());
			ps.println(x);
			s.close();
		} catch (IOException e) {
			System.out.println("erro");
		}

	}
}