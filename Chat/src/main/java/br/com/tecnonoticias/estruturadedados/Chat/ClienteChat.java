package br.com.tecnonoticias.estruturadedados.Chat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClienteChat extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField textoParaEnviar;
	Socket socket;
	PrintWriter escritor;
	String nome;
	JTextArea textoREcebido;
	Scanner leitor;
	JButton botao;

	private class EscutaServidor implements Runnable {

		public void run() {
			try {
				String texto;
				while ((texto = leitor.nextLine()) != null) {
					textoREcebido.append(texto + "\n");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	public ClienteChat(String nome) {
		super(nome);

		this.nome = nome;

		Font fonte = new Font("Serif", Font.PLAIN, 20);

		textoParaEnviar = new JTextField();
		textoParaEnviar.setFont(fonte);

		JButton botao = new JButton("Enviar");
		botao.setFont(fonte);
		botao.addActionListener((ActionListener) new EnviarListener());  

		Container envio = new JPanel();
		envio.setLayout(new BorderLayout());
		envio.add(BorderLayout.CENTER, textoParaEnviar);
		envio.add(BorderLayout.EAST, botao);

		textoREcebido = new JTextArea();
		textoREcebido.setFont(fonte);
		JScrollPane scroll = new JScrollPane(textoREcebido);
		
		Colar: textoREcebido.setLineWrap(true);
		getContentPane().add(BorderLayout.CENTER, scroll);
		getContentPane().add(BorderLayout.SOUTH, envio);
		configurarRede();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
	}

	private class EnviarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			escritor.println(nome + " : " + textoParaEnviar.getText());
			escritor.flush();
			textoParaEnviar.setText(" ");
			textoParaEnviar.requestFocus();
//			System.out.println(socket.getRemoteSocketAddress());
		}

	}

	private void configurarRede() {
		try {
			socket = new Socket("192.168.0.102", 5000);
			escritor = new PrintWriter(socket.getOutputStream());
			leitor = new Scanner(socket.getInputStream());
			new Thread(new EscutaServidor()).start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Locale.setDefault(new Locale("pt", "BR"));
		new ClienteChat("Edgar");
//		new ClienteChat("Nicolas");

	}

}
