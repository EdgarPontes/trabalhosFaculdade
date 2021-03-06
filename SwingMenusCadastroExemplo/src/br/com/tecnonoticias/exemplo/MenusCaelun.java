package br.com.tecnonoticias.exemplo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

import com.birosoft.liquid.LiquidLookAndFeel;

public class MenusCaelun {

	private JFrame janela;
	private JPanel painelPrincipal;
	private JTable tabela;

	public static void main(String[] args) {
		Locale.setDefault(new Locale("pt", "BR"));
		lookandfeel();
		new MenusCaelun().montaTela();

	}

	private void montaTela() {
		preparaJanela();
		preparaPainelPrincipal();
		preparaTitulo();
		preparaTabela();
		preparaBotaoCarregar();
		preparaBotaoSair();
		mostraJanea();
	}

	private void preparaTitulo() {
		JLabel titulo = new JLabel("Lista de Negócios", SwingConstants.CENTER);
		titulo.setFont(new Font("Verdana", Font.BOLD, 25));
		painelPrincipal.add(titulo);
	}

	private void preparaTabela() {
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

	private void preparaJanela() {
		janela = new JFrame("Cadrastro");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void preparaPainelPrincipal() {
		
		painelPrincipal = new JPanel();
		janela.add(painelPrincipal);

	}

	private void preparaBotaoCarregar() {
		JButton botaoCarregar = new JButton("Carregar XML");
		botaoCarregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Negocio> lista = new EscolhedorDeXML().escolhe();
				NegociosTableModel ntm = new NegociosTableModel(lista);
				tabela.setModel(ntm);
			}
		});
		painelPrincipal.add(botaoCarregar);
	}

	private void preparaBotaoSair() {
		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// KeyListener para o Frame
		botaoSair.addKeyListener(new KeyListener() {
			// Quando soltar a tecla
			public void keyReleased(KeyEvent e) {
				// Se a tecla pressionada for igual a F2
				if (e.getKeyCode() == KeyEvent.VK_F2)
					System.exit(0);
			}

			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
			}
		});
		painelPrincipal.add(botaoSair);
	}

	private void mostraJanea() {
		janela.pack();
		janela.setSize(540, 540);
		janela.setVisible(true);

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