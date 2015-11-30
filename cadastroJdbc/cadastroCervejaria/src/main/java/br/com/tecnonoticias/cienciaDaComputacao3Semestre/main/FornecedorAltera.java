package br.com.tecnonoticias.cienciaDaComputacao3Semestre.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.tecnonoticias.cienciaDaComputacao3Semestre.dao.FornecedorDao;
import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.PessoaJuridica;

@SuppressWarnings("serial")
public class FornecedorAltera extends JFrame {
	/**
	 * Cria tela de alteração de fornecedor.
	 */
	JLabel lb_RazaoSocial, lb_Codigo, lb_NomeFantazia, lb_Endereço, lb_Cnpj, lb_Cidade, lb_Estado;

	JTextField tf_RazaoSocial, tf_Codigo, tf_NomeFantazia, tf_Endereço, tf_Cnpj, tf_Cidade, tf_Estado;

	JButton bt_salvar, bt_consultar, bt_fechar;

	private JPanel contentPane;
	private static boolean fechar = true;

	public FornecedorAltera() {

		setTitle("Alterar fornecedor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(270, 200, 475, 350);// Mude aqui a para o tamanho desejado
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);// Absolute Layout

		lb_RazaoSocial = new JLabel("Razão Social");
		lb_Codigo = new JLabel("Código");
		lb_NomeFantazia = new JLabel("Nome Fantazia");
		lb_Endereço = new JLabel("Endereço");
		lb_Cnpj = new JLabel("Cnpj");
		lb_Cidade = new JLabel("Cidade");
		lb_Estado = new JLabel("Estado");

		tf_RazaoSocial = new JTextField("");
		tf_Codigo = new JTextField("");
		tf_NomeFantazia = new JTextField("");
		tf_Endereço = new JTextField("");
		tf_Cnpj = new JTextField("");
		tf_Cidade = new JTextField("");
		tf_Estado = new JTextField("");

		bt_salvar = new JButton("Salvar");
		bt_consultar = new JButton("Consultar");
		bt_fechar = new JButton("Fechar");

		tf_Codigo.setBounds(20, 30, 100, 20);
		lb_Codigo.setBounds(20, 10, 80, 20);
		tf_RazaoSocial.setBounds(20, 70, 335, 20);
		lb_RazaoSocial.setBounds(20, 50, 150, 20);
		tf_Cnpj.setBounds(230, 120, 120, 20);
		lb_Cnpj.setBounds(230, 100, 150, 20);
		tf_NomeFantazia.setBounds(20, 120, 200, 20);
		lb_NomeFantazia.setBounds(20, 100, 150, 20);
		tf_Endereço.setBounds(20, 170, 335, 20);
		lb_Endereço.setBounds(20, 150, 150, 20);
		tf_Cidade.setBounds(20, 220, 150, 20);
		lb_Cidade.setBounds(20, 200, 80, 20);
		tf_Estado.setBounds(220, 220, 150, 20);
		lb_Estado.setBounds(220, 200, 80, 20);
		bt_salvar.setBounds(20, 270, 100, 25);
		bt_consultar.setBounds(130, 270, 105, 25);
		bt_fechar.setBounds(350, 270, 100, 25);

		bt_salvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				salvar();
			}

			private void salvar() {
				PessoaJuridica contato = new PessoaJuridica();
				if (tf_RazaoSocial.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campos obrigatorios não preenchidos.");
				} else {
					contato.setRazaoSocial(tf_RazaoSocial.getText());
					contato.setNomeFantasia(tf_NomeFantazia.getText());
					contato.setCnpj(tf_Cnpj.getText());
					contato.setEndereco(tf_Endereço.getText());
					contato.setCidade(tf_Cidade.getText());
					contato.setEstado(tf_Estado.getText());
					contato.setFornecedorId(Integer.parseInt(tf_Codigo.getText()));
					// grave nessa conexão!!!
					FornecedorDao dao = new FornecedorDao();

					// método elegante
					dao.altera(contato);

					JOptionPane.showMessageDialog(null, "Fornecedor salvo com sucesso!");
				}
			}
		});
		
		bt_fechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FornecedorAltera.this.dispose();
			}
		});

		getContentPane().add(tf_RazaoSocial);
		getContentPane().add(tf_Codigo);
		getContentPane().add(tf_NomeFantazia);
		getContentPane().add(tf_Endereço);
		getContentPane().add(tf_Cnpj);
		getContentPane().add(tf_Cidade);
		getContentPane().add(tf_Estado);

		getContentPane().add(lb_RazaoSocial);
		getContentPane().add(lb_Codigo);
		getContentPane().add(lb_NomeFantazia);
		getContentPane().add(lb_Endereço);
		getContentPane().add(lb_Cnpj);
		getContentPane().add(lb_Cidade);
		getContentPane().add(lb_Estado);

		getContentPane().add(bt_salvar);
		getContentPane().add(bt_fechar);
		// getContentPane().add(bt_consultar);

	}

	public static void main(String[] args) {
		new FornecedorAltera().setVisible(fechar);
	}
}