package br.com.tecnonoticias.cienciaDaComputacao3Semestre.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.tecnonoticias.cienciaDaComputacao3Semestre.dao.UsuarioDao;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JTextField usuarios;
	private JPasswordField senha;
	private JButton login, limpa;
	private JLabel user, pass;
	final TelaLogin abilita = new TelaLogin();
	
	public Login() {
		super("Login Cervejaria Alvorada");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		setSize(250, 170);
		setLocation(300, 200);

		user = new JLabel("Usuário: ");
		add(user);

		usuarios = new JTextField(15);
		add(usuarios);

		pass = new JLabel("Senha:   ");
		add(pass);

		senha = new JPasswordField(15);
		add(senha);

		login = new JButton("Entrar");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {

				if (evento.getSource() == login) {
			     UsuarioDao dao = new UsuarioDao();
			     boolean verdade = dao.acessarSistema(usuarios.getText(), senha.getText());
					if (verdade) {
						
						abilita.cliente.setEnabled(true);
						abilita.fornecedor.setEnabled(true);
						abilita.usuario.setEnabled(true);
						abilita.cCliente.setEnabled(true);
						abilita.cFornecedor.setEnabled(true);
						
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto! tente novamente!");
					}
				}
			}
		});
		add(login);

		limpa = new JButton("Limpar");
		limpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if (evento.getSource() == limpa) {
					usuarios.setText("");
					senha.setText("");
				}
			}
		});
		add(limpa);
	}

	public static void main(String[] args) {

		new Login();
	}
}