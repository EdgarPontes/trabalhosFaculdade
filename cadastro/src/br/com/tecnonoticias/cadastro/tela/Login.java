package br.com.tecnonoticias.cadastro.tela;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JFrame {

	JButton cancelar = new JButton("Cancelar");
	JButton ok = new JButton("ok");
	JTextField login = new JTextField();
	JPasswordField senha = new JPasswordField();

	public Login() {

		super("Login");

		Container c = getContentPane();

		c.setLayout(new GridLayout(3, 2));
		c.add(new JLabel("Login:"));
		c.add(login);
		c.add(new JLabel("Senha"));
		c.add(senha);
		c.add(ok);// add o botão ok no conteiner
		c.add(cancelar);// add o botão cancelar no conteiner

		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new Login();
	}
}