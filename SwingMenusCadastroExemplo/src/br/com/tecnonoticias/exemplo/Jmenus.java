package br.com.tecnonoticias.exemplo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import com.birosoft.liquid.LiquidLookAndFeel;

@SuppressWarnings("serial")
public class Jmenus extends JFrame {

	private JMenuBar BarraMenu = null;
	private JMenu menuArquivo = null;
	private JMenuItem menuSair = null;

	public Jmenus() {
		super();
		initialize();
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

	/**
	 * Metodo de criacao da tela
	 */
	private void initialize() {

		this.setTitle("Aplicação com menu");
		this.setJMenuBar(getBarraMenu());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setVisible(true);
	}

	/**
	 * Metodo de criacao da barra de menu
	 */
	private JMenuBar getBarraMenu() {
		if (BarraMenu == null) {
			BarraMenu = new JMenuBar();
			BarraMenu.add(getMnuArquivo());
		}
		return BarraMenu;
	}

	/**
	 * Metodo de criacao do subMenu
	 */
	private JMenu getMnuArquivo() {
		if (menuArquivo == null) {
			menuArquivo = new JMenu();
			menuArquivo.setText("Arquivo");
			menuArquivo.add(getMnuSair());
		}

		return menuArquivo;
	}

	/**
	 * Metodo de criacao do item do subMenu
	 */
	private JMenuItem getMnuSair() {
		if (menuSair == null) {
			menuSair = new JMenuItem();
			menuSair.setText("Sair");
		}
		// ActionListener
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction(e);
			}
		});
		
		return menuSair;
	}

	protected void buttonAction(ActionEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {

		lookandfeel();
		new Jmenus();
	}

}