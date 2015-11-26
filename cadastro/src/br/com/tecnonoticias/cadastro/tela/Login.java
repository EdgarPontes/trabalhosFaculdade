package br.com.tecnonoticias.cadastro.tela;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JTextField usuario;
	private JPasswordField senha;
	private JButton login, limpa;
	private JLabel user, pass;
	
	public Login(){
		super("Login em Java");
		setLayout(new FlowLayout());
				
		user = new JLabel("Usuário: ");
		add(user);
		
		usuario = new JTextField(15);
		add(usuario);
		
		pass = new JLabel("Senha:   ");
		add(pass);
		
		senha = new JPasswordField(15);
		add(senha);
		
		login = new JButton("Entrar");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento){
				if(evento.getSource() == login)
					if(usuario.getText().equals("Java") && senha.getText().equals("progressivo"))
						JOptionPane.showMessageDialog(null, "Parabéns, você entrou na Matrix!");
					else
						JOptionPane.showMessageDialog(null, "Senha errada! Estude Java!");
				
			}
		 }
		);
		add(login);
		
		limpa = new JButton("Limpar");
		limpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento){
				if(evento.getSource() == limpa){
					usuario.setText("");
					senha.setText("");
				}
			}
		 }
		);
		add(limpa);
	}
	

	public static void main(String[] args) {

		Login texfield = new Login();
		  
		  texfield.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  texfield.setSize(310,110);
		  texfield.setVisible(true);
		  texfield.setSize(200, 160);
		  texfield.setLocation(800, 400);
	}
}