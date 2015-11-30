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
import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.Usuario;

public class CadastroUsuario extends JFrame {

	private JTextField usuarios;
	private JPasswordField senha;
	private JButton login, limpa;
	private JLabel user, pass;

	public CadastroUsuario() {

		super("Cadastro Login Cervejaria Alvorada");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 110);
		setLocation(250, 200);

		user = new JLabel("Usuário: ");
		add(user);

		usuarios = new JTextField(15);
		add(usuarios);

		pass = new JLabel("Senha:   ");
		add(pass);

		senha = new JPasswordField(15);
		add(senha);

		login = new JButton("Salvar");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {

				if (evento.getSource() == login) {
					if (login.getText() == "" || senha.getText()=="") {
					JOptionPane.showMessageDialog(null, "Campos obrigatorios não preenchidos");
				} else {
						UsuarioDao dao = new UsuarioDao();
						// pronto para gravar
						Usuario usuario = new Usuario();

						usuario.setUsuario(usuarios.getText());
						usuario.setSenha(senha.getText());
						// contato.setPessoaId(3L);

						// grave nessa conexão!!!
						dao.adiciona(usuario);
						JOptionPane.showMessageDialog(null, "Usuario cadastrado!");
					}
					int resposta;
					resposta = JOptionPane.showConfirmDialog(null, "Cadastrar novo", "Mensagem do programa",
							JOptionPane.YES_NO_OPTION);
					if (resposta == 0)
						System.exit(0);
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
		new CadastroUsuario();
		// UsuarioDao dao = new UsuarioDao();
		//
		// // pronto para gravar
		// Usuario usuario = new Usuario();
		//
		// usuario.setUsuario("cervejaria");
		// usuario.setSenha("alvorada");
		// // contato.setPessoaId(3L);
		//
		// // grave nessa conexão!!!
		// dao.adiciona(usuario);
		//
		// System.out.println("Cadastrado com sucesso!");

	}

}
