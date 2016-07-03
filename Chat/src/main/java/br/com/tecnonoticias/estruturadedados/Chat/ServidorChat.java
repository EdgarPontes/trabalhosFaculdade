package br.com.tecnonoticias.estruturadedados.Chat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServidorChat {
	List<PrintWriter> escritores = new ArrayList<PrintWriter>();
//	private Socket socket;
	File arquivoRecebe = null;

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
				aguardandoClient(arquivoRecebe, socket);
				
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
	public void aguardandoClient(File arquivo, Socket sock) {
		// Checa se a transferencia foi completada com sucesso
		OutputStream socketOut = null;
		ServerSocket servsock = null;
		FileInputStream fileIn = null;

		try {

			// Criando tamanho de leitura
			byte[] cbuffer = new byte[1024];
			int bytesRead;

			// Criando arquivo que sera transferido pelo servidor
			File file = arquivo;
			fileIn = new FileInputStream(file);
			System.out.println("Lendo arquivo...");

			// Criando canal de transferencia
			socketOut = sock.getOutputStream();

			// Lendo arquivo criado e enviado para o canal de transferencia
			System.out.println("Enviando Arquivo...");
			while ((bytesRead = fileIn.read(cbuffer)) != -1) {
				socketOut.write(cbuffer, 0, bytesRead);
				socketOut.flush();
			}

			System.out.println("Arquivo Enviado!");
		} catch (Exception e) {
			// Mostra erro no console
			e.printStackTrace();
		} finally {
			if (socketOut != null) {
				try {
					socketOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (servsock != null) {
				try {
					servsock.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fileIn != null) {
				try {
					fileIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new ServidorChat();
	}
}