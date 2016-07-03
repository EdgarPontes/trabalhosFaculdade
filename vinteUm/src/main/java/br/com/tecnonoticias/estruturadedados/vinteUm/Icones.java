package br.com.tecnonoticias.estruturadedados.vinteUm;

import java.awt.Font;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.birosoft.liquid.LiquidLookAndFeel;

public class Icones extends Baralho {

	public static void main(String[] args) {
		try {
			new Icones().montaTela("JC",10);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private JFrame janela;
	private JPanel painelPrincipal;
	private JButton botao;

	public void montaTela(String carta, int valorCarta) throws MalformedURLException {
		preparaJanela();
		preparaPainelPrincipal(carta);
		preparaTitulo(valorCarta);
		// preparaBotaoCarregar();
		// preparaBotaoSair();
		mostraJanela();
	}

	private void preparaJanela() {
		janela = new JFrame("Black Jack");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void preparaPainelPrincipal(String b) throws MalformedURLException {
		painelPrincipal = new JPanel();
		Baralho icone = new Baralho();
		painelPrincipal.add(new JLabel(getImagem(nome(b))));
		janela.add(painelPrincipal);
	}

	private void mostraJanela() {
		janela.pack();
		janela.setSize(180, 340);
		janela.setLocation(500, 200);
		janela.setVisible(true);
	}

	public void preparaTitulo(int a) {

		JLabel titulo = new JLabel("Você tirou: " + a, SwingConstants.CENTER);
		titulo.setFont(new Font("Verdana", Font.BOLD, 20));
		painelPrincipal.add(titulo);
	}

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
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
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
