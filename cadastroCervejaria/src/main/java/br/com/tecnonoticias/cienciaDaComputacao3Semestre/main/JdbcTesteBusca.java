package br.com.tecnonoticias.cienciaDaComputacao3Semestre.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

import com.birosoft.liquid.LiquidLookAndFeel;

import br.com.tecnonoticias.cienciaDaComputacao3Semestre.dao.PessoaDao;
import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.PessoaFisica;
import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.modeloTableMode;

public class JdbcTesteBusca {
	
	private static JFrame janela;
	private static JPanel painelPrincipal;
	private static JTable tabela;
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Locale.setDefault(new Locale("pt", "BR"));
		lookandfeel();
		new JdbcTesteBusca().montaTela();

	}
	public static void montaTela() {
		preparaJanela();
		preparaPainelPrincipal();
//		preparaTitulo();
		preparaTabela();
		preparaBotaoCarregar();
//		preparaBotaoSair();
		mostraJanea();
	}

	private static void preparaTabela() {
		tabela = new JTable();
		tabela.setBorder(new LineBorder(Color.black));
		tabela.setGridColor(Color.black);
		tabela.setShowGrid(true);
		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().setBorder(null);
		scroll.setSize(450, 450);
		scroll.getViewport().add(tabela);
		painelPrincipal.add(scroll);
	}
	private static void preparaJanela() {
		janela = new JFrame("Consulta");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private static void preparaPainelPrincipal() {
		painelPrincipal = new JPanel();
		janela.add(painelPrincipal);
	}
	private static void mostraJanea() {
		janela.pack();
		janela.setSize(640, 500);
		janela.setVisible(true);

	}
	private static void preparaBotaoCarregar() {
		JButton botaoCarregar = new JButton("Consultar");
		botaoCarregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PessoaDao dao = new PessoaDao();
				List<PessoaFisica> pessoas = dao.busca();
				modeloTableMode ntm = new modeloTableMode(pessoas);
				tabela.setModel(ntm);
				};
		});
		painelPrincipal.add(botaoCarregar);
	}
	
//	public static void preparaBotaoSair() {
//		JButton botaoSair = new JButton("Sair");
//		botaoSair.setBounds(20, 400, 200, 50);
//		botaoSair.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JdbcTesteBusca.this.
//			}
//		});
//
//		painelPrincipal.add(botaoSair);
//	}
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
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
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