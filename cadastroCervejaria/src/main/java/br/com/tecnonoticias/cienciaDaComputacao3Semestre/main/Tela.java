package br.com.tecnonoticias.cienciaDaComputacao3Semestre.main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.birosoft.liquid.LiquidLookAndFeel;

public class Tela {

	private JFrame janela;
	private JPanel painelPrincipal;

	public static void main(String[] args) {
		/**
		 * Setar o local padráo do aplicativo.
		 */
		Locale.setDefault(new Locale("pt", "BR"));
		/**
		 * Construtor do look and feel para o sistema.
		 */
		lookandfeel();
		/**
		 * Iniciador da tela.
		 */
		new Tela().montaTela();

	}
	/**
	 * Metodo para montagem da tela.
	 */
	private void montaTela() {
		preparaJanela();
		preparaPainelPrincipal();
		preparaTitulo();
		preparaCadastroCliente();
		preparaAlteraCliente();
		preparaConsultaCliente();
		preparaExcluiCliente();
//		preparaBotaoCarregar();
		preparaBotaoSair();
		mostraJanea();
	}
	
	/**
	 * Metodo para preparo da tela.
	 */
	private void preparaJanela() {
		janela = new JFrame("Cadrastro");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setBounds(270, 200, 475, 350);
		
	}
	/**
	 * Metodo para painel principal da tela, onde será colocado todos os componentes.
	 */
	private void preparaPainelPrincipal() {
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		janela.add(painelPrincipal);
		painelPrincipal.setLayout(null);
	}
	/**
	 * Metodo para colocar titulo da tela.
	 */
	private void preparaTitulo() {
		JLabel titulo = new JLabel("Cervejaria Alvorada", SwingConstants.CENTER);
		titulo.setFont(new Font("Verdana", Font.BOLD, 25));
		titulo.setBounds(120, 25, 300, 50);
		painelPrincipal.add(titulo);
	}
	/**
	 * Metodo para chamar cadastro de clientes.
	 */
	private void preparaCadastroCliente() {
		JButton botaoCadastroInclui = new JButton("Cadastro Clientes");
		botaoCadastroInclui.setBounds(20, 80, 200, 50);
		botaoCadastroInclui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Clientes().setVisible(true);
			}
		});
		painelPrincipal.add(botaoCadastroInclui);
	}
	/**
	 * Metodo para chamar alteração de clientes.
	 */
	private void preparaAlteraCliente() {
		JButton botaoCadastroAltera = new JButton("Alterar Clientes");
		botaoCadastroAltera.setBounds(20, 150, 200, 50);
		botaoCadastroAltera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new Clientes().setVisible(true);
				JOptionPane.showMessageDialog(null, "Tela em construção!");
			}
		});
		painelPrincipal.add(botaoCadastroAltera);
	}
	/**
	 * Metodo para chamar consulta de clientes.
	 */
	private void preparaConsultaCliente() {
		JButton botaoCadastroConsulta = new JButton("Consulta Clientes");
		botaoCadastroConsulta.setBounds(20, 220, 200, 50);
		botaoCadastroConsulta.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				new JdbcTesteBusca().montaTela();
			}
		});
		painelPrincipal.add(botaoCadastroConsulta);
	}
	/**
	 * Metodo para chamar exclusão de clientes.
	 */
	private void preparaExcluiCliente() {
		JButton botaoCadastroExclui = new JButton("Exclui Clientes");
		botaoCadastroExclui.setBounds(20, 290, 200, 50);
		botaoCadastroExclui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new Clientes().setVisible(true);
				JOptionPane.showMessageDialog(null, "Tela em construção!");
			}
		});
		painelPrincipal.add(botaoCadastroExclui);
	}
	/**
	 * Metodo para botao sair da tela.
	 */
	private void preparaBotaoSair() {
		JButton botaoSair = new JButton("Sair");
		botaoSair.setBounds(20, 400, 200, 50);
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		painelPrincipal.add(botaoSair);
	}
	/**
	 * Metodo para chamar o contrutor da tela.
	 */
	private void mostraJanea() {
		janela.pack();
		janela.setSize(540, 540);
		janela.setVisible(true);

	}
	/**
	 * Metodo para chamar o lookandfell, tem que ser antes do contrutor da tela.
	 */
	public static void lookandfeel() {
		try {
			/**
			 * "com.birosoft.liquid.LiquidLookAndFeel" tema mac
			 * "com.jtattoo.plaf.aero.AeroLookAndFeel" tema aero
			 * "com.jtattoo.plaf.hifi.HiFiLookAndFeel" black
			 * "com.jtattoo.plaf.acryl.AcrylLookAndFeel" tema acryl
			 * "com.jtattoo.plaf.mcwin.McWinLookAndFeel" tema mcWin
			 * "com.jtattoo.plaf.smart.SmartLookAndFeel" tema smart
			 */
			UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
			LiquidLookAndFeel.setLiquidDecorations(true, "mac");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

}
