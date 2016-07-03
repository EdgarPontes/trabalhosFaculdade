package br.com.tecnonoticias.estruturadedados.vinteUm;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.birosoft.liquid.LiquidLookAndFeel;

@SuppressWarnings("serial")
public class ChamaTela extends JFrame {

	public static void main(String[] args) {
		lookandfeel();
		new ChamaTela().montaTela();

	}

	private Object jogadores;
	private JFrame janela;
	private JPanel painelPrincipal;
	@SuppressWarnings("rawtypes")
	private JComboBox combo;
	private JButton botao;

	public void montaTela() {
		preparaJanela();
		preparaPainelPrincipal();
		preparaComboBox();
		preparaBotaoPlay();
		preparaTitulo();
		// preparaBotaoCarregar();
		// preparaBotaoSair();
		mostraJanela();
	}

	private void preparaJanela() {
		janela = new JFrame("Black Jack");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void preparaPainelPrincipal() {
		painelPrincipal = new JPanel();
		janela.add(painelPrincipal);
	}

	private void mostraJanela() {
		janela.pack();
		janela.setSize(350, 140);
		janela.setLocation(500, 200);
		janela.setVisible(true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void preparaComboBox() {
		combo = new JComboBox();
		combo.addItem(2);
		combo.addItem(3);
		combo.addItem(4);
		combo.addItem(5);
		combo.addItem(6);
		combo.addItem(7);
		combo.addItem(8);
		painelPrincipal.add(combo);
	}

	private void preparaBotaoPlay() {
		botao = new JButton("Play");
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jogadores = combo.getSelectedItem();
				JOptionPane.showMessageDialog(null, "Jogador: " + jogadores);
			}
		});
		painelPrincipal.add(botao);
	}

	public void preparaTitulo() {

		JLabel titulo = new JLabel("Quantos vão participar?", SwingConstants.CENTER);
		titulo.setFont(new Font("Verdana", Font.BOLD, 25));
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