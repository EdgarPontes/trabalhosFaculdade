package br.com.tecnonoticias.cienciaDaComputacao3Semestre.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.tecnonoticias.cienciaDaComputacao3Semestre.dao.PessoaDao;
import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.PessoaFisica;

@SuppressWarnings("serial")
public class AlteraCliente extends JFrame {

	JLabel lb_Nome, lb_Codigo, lb_Nascimento, lb_Endereco, lb_Cpf, lb_Rg, lb_Sexo, lb_Cidade, lb_Estado;

	JTextField tf_Nome, tf_Codigo, tf_Nascimento, tf_Endereco, tf_Cpf, tf_Rg, tf_Sexo, tf_Cidade, tf_Estado;

	JButton bt_salvar, bt_consultar, bt_fechar, bt_Limpa;

	private JPanel contentPane;

	public AlteraCliente() {

		setTitle("Alterar clientes");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(270, 200, 475, 350);// Mude aqui a para o tamanho desejado
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);// Absolute Layout

		lb_Nome = new JLabel("Nome");
		lb_Codigo = new JLabel("Código");
		lb_Nascimento = new JLabel("Nascimento");
		lb_Endereco = new JLabel("Endereço");
		lb_Cpf = new JLabel("Cpf");
		lb_Rg = new JLabel("Rg");
		lb_Sexo = new JLabel("Sexo");
		lb_Cidade = new JLabel("Cidade");
		lb_Estado = new JLabel("Estado");

		tf_Nome = new JTextField("");
		tf_Codigo = new JTextField("");
		tf_Nascimento = new JTextField("");
		tf_Endereco = new JTextField("");
		tf_Cpf = new JTextField("");
		tf_Rg = new JTextField("");
		tf_Sexo = new JTextField("");
		tf_Cidade = new JTextField("");
		tf_Estado = new JTextField("");

		bt_salvar = new JButton("Salvar");
		bt_consultar = new JButton("Consultar");
		bt_fechar = new JButton("Fechar");
		bt_Limpa = new JButton("Limpar");

		tf_Codigo.setBounds(20, 30, 100, 20);
		lb_Codigo.setBounds(20, 10, 80, 20);
		tf_Nome.setBounds(20, 70, 320, 20);
		lb_Nome.setBounds(20, 50, 150, 20);
		tf_Cpf.setBounds(160, 170, 100, 20);
		lb_Cpf.setBounds(160, 150, 100, 20);
		tf_Nascimento.setBounds(270, 170, 100, 20);
		lb_Nascimento.setBounds(270, 150, 100, 20);
		tf_Endereco.setBounds(20, 120, 320, 20);
		lb_Endereco.setBounds(20, 100, 150, 20);
		tf_Rg.setBounds(20, 170, 130, 20);
		lb_Rg.setBounds(20, 150, 250, 20);
		tf_Sexo.setBounds(350, 70, 20, 20);
		lb_Sexo.setBounds(350, 50, 80, 20);
		tf_Cidade.setBounds(20, 220, 150, 20);
		lb_Cidade.setBounds(20, 200, 80, 20);
		tf_Estado.setBounds(220, 220, 150, 20);
		lb_Estado.setBounds(220, 200, 80, 20);
		bt_salvar.setBounds(20, 270, 100, 25);
		bt_consultar.setBounds(130, 270, 105, 25);
		bt_fechar.setBounds(350, 270, 100, 25);
		bt_Limpa.setBounds(180, 270, 100, 25);

		getContentPane().add(tf_Nome);
		getContentPane().add(tf_Codigo);
		getContentPane().add(tf_Nascimento);
		getContentPane().add(tf_Endereco);
		getContentPane().add(tf_Cpf);
		getContentPane().add(tf_Rg);
		getContentPane().add(tf_Sexo);
		getContentPane().add(tf_Cidade);
		getContentPane().add(tf_Estado);

		getContentPane().add(lb_Nome);
		getContentPane().add(lb_Codigo);
		getContentPane().add(lb_Nascimento);
		getContentPane().add(lb_Endereco);
		getContentPane().add(lb_Cpf);
		getContentPane().add(lb_Rg);
		getContentPane().add(lb_Sexo);
		getContentPane().add(lb_Cidade);
		getContentPane().add(lb_Estado);

		getContentPane().add(bt_salvar);
		getContentPane().add(bt_fechar);
		getContentPane().add(bt_Limpa);
		
		bt_salvar.addActionListener(new ActionListener() {

//			int valor = Integer.parseInt(tf_Codigo.getText().trim());
//			long idl = Long.valueOf(valor);
			public void actionPerformed(ActionEvent e) {
				salvar();
			}

			private void salvar() {
				PessoaFisica contato = new PessoaFisica();
				if (tf_Nome.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campos obrigatorios não preenchidos.");
				} else {
					
					contato.setNome(tf_Nome.getText());
					contato.setCpf(tf_Cpf.getText());
					contato.setRg(tf_Rg.getText());
					contato.setEndereco(tf_Endereco.getText());
					contato.setCidade(tf_Cidade.getText());
					contato.setEstado(tf_Estado.getText());
					contato.setSexo(tf_Sexo.getText());
//					contato.setDataNascimento(Calendar.getInstance());
					contato.setPessoaId(Integer.parseInt(tf_Codigo.getText()));

					// grave nessa conexão!!!
					PessoaDao dao = new PessoaDao();

					// método elegante
					dao.altera(contato);

					System.out.println("Gravado!");
				}
			}
		});

		bt_Limpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento){
				if(evento.getSource() == bt_Limpa){
					tf_Nome.setText("");
					tf_Codigo.setText("");
					tf_Nascimento.setText("");
					tf_Endereco.setText("");
					tf_Cpf.setText("");
					tf_Rg.setText("");
					tf_Sexo.setText("");
					tf_Cidade.setText("");
					tf_Estado.setText("");
				}
			}
		 }
		);
//		add(bt_Limpa);
		
		bt_fechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlteraCliente.this.dispose();
			}
		});
	}

	public static void main(String[] args) {
		new AlteraCliente().setVisible(true);
		// PessoaDao dao = new PessoaDao();
		//
		// // pronto para gravar
		// PessoaFisica contato = new PessoaFisica();
		//
		// contato.setNome("Amanda");
		// contato.setCpf("029.022.099-98");
		// contato.setRg("7.777.777-7");
		// contato.setSexo("F");
		// contato.setEndereco("R. Nove, 47");
		// contato.setCidade("Sarandi");
		// contato.setEstado("Parana");
		// contato.setDataNascimento(Calendar.getInstance());
		// contato.setPessoaId(3L);
		//
		// // grave nessa conexão!!!
		// dao.altera(contato);
		//
		// System.out.println("Alterado!");
	}
}