package br.com.tecnonoticias.exemplo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Clientes extends JFrame {
	JLabel lb_Nome, lb_Codigo, lb_Nascimento, lb_Endereço, lb_Cpf, lb_Rg, lb_Sexo, lb_Cidade, lb_Estado;

	JTextField tf_Nome, tf_Codigo, tf_Nascimento, tf_Endereço, tf_Cpf, tf_Rg, tf_Sexo, tf_Cidade, tf_Estado;

	JButton bt_salvar, bt_fechar;

	private JPanel contentPane;

	private Clientes() {

		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 200, 475, 350);// Mude aqui a para o tamanho desejado
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);// Absolute Layout

		lb_Nome = new JLabel("Nome");
		lb_Codigo = new JLabel("Código");
		lb_Nascimento = new JLabel("Nascimento");
		lb_Endereço = new JLabel("Endereço");
		lb_Cpf = new JLabel("Cpf");
		lb_Rg = new JLabel("Rg");
		lb_Sexo = new JLabel("Sexo");
		lb_Cidade = new JLabel("Cidade");
		lb_Estado = new JLabel("Estado");

		tf_Nome = new JTextField("");
		tf_Codigo = new JTextField("");
		tf_Nascimento = new JTextField("");
		tf_Endereço = new JTextField("");
		tf_Cpf = new JTextField("");
		tf_Rg = new JTextField("");
		tf_Sexo = new JTextField("");
		tf_Cidade = new JTextField("");
		tf_Estado = new JTextField("");

		bt_salvar = new JButton("Salvar");
		bt_fechar = new JButton("Fechar");

		tf_Codigo.setBounds(20, 30, 100, 20);
		lb_Codigo.setBounds(20, 10, 80, 20);
		tf_Nome.setBounds(20, 70, 320, 20);
		lb_Nome.setBounds(20, 50, 150, 20);
		tf_Cpf.setBounds(160, 170, 100, 20);
		lb_Cpf.setBounds(160, 150, 100, 20);
		tf_Nascimento.setBounds(270, 170, 100, 20);
		lb_Nascimento.setBounds(270, 150, 100, 20);
		tf_Endereço.setBounds(20, 120, 320, 20);
		lb_Endereço.setBounds(20, 100, 150, 20);
		tf_Rg.setBounds(20, 170, 130, 20);
		lb_Rg.setBounds(20, 150, 250, 20);
		tf_Sexo.setBounds(350, 70, 20, 20);
		lb_Sexo.setBounds(350, 50, 80, 20);
		tf_Cidade.setBounds(20, 220, 150, 20);
		lb_Cidade.setBounds(20, 200, 80, 20);
		tf_Estado.setBounds(220, 220, 150, 20);
		lb_Estado.setBounds(220, 200, 80, 20);
		bt_salvar.setBounds(20, 270, 150, 25);
		bt_fechar.setBounds(200, 270, 150, 25);

		getContentPane().add(tf_Nome);
		getContentPane().add(tf_Codigo);
		getContentPane().add(tf_Nascimento);
		getContentPane().add(tf_Endereço);
		getContentPane().add(tf_Cpf);
		getContentPane().add(tf_Rg);
		getContentPane().add(tf_Sexo);
		getContentPane().add(tf_Cidade);
		getContentPane().add(tf_Estado);

		getContentPane().add(lb_Nome);
		getContentPane().add(lb_Codigo);
		getContentPane().add(lb_Nascimento);
		getContentPane().add(lb_Endereço);
		getContentPane().add(lb_Cpf);
		getContentPane().add(lb_Rg);
		getContentPane().add(lb_Sexo);
		getContentPane().add(lb_Cidade);
		getContentPane().add(lb_Estado);
		getContentPane().add(bt_salvar);
		getContentPane().add(bt_fechar);

	}

	public static void main(String[] args) {  
        new Clientes().setVisible(true);  
  }
}