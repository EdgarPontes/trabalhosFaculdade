package br.com.tecnonoticias.estruturadedados.Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ServidorChat {
	List<PrintWriter> escritores = new ArrayList<PrintWriter>();
//	private Socket socket;

	public ServidorChat() {
		Scanner leitor;
		ServerSocket server;
		Object[] coneccao = new Object[10];
		try {
			server = new ServerSocket(5000);
			while (true) {	
				Socket socket = server.accept();
				coneccao[0] = socket.getRemoteSocketAddress();
				System.out.println(coneccao[0]);
				new Thread(new EscutaCliente(socket)).start();
				PrintWriter p = new PrintWriter(socket.getOutputStream());
				escritores.add(p);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private void encaminhaParaTodos(String texto){
		for (PrintWriter w : escritores) {
			try {	
				w.println(texto);
				w.flush();
			} catch (Exception e) {
				
			}
		}
	}
	
	private class EscutaCliente implements Runnable {
		Scanner leitor;
		public EscutaCliente(Socket socket) {			
			try {
				leitor = new Scanner(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
		}
	}

		public void run() {
			try {
				String texto;
				while ((texto = leitor.nextLine()) != null) {
					  encaminhaParaTodos(texto);				  
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		Locale.setDefault(new Locale("pt", "BR"));
		new ServidorChat();
	}
}