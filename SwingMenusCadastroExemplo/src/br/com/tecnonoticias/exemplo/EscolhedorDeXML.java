package br.com.tecnonoticias.exemplo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.birosoft.liquid.LiquidLookAndFeel;

public class EscolhedorDeXML {

	public List<Negocio> escolhe() {

		try {
			JFileChooser chooser = new JFileChooser("/home/edgar/Downloads");
			int retorno = chooser.showOpenDialog(null);
			if (retorno == JFileChooser.APPROVE_OPTION) {
				FileReader reader = new FileReader(chooser.getSelectedFile());
				return new LeitorXML().carrega(reader);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
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

	public static void main(String[] args) {
		lookandfeel();
		new EscolhedorDeXML().escolhe();
	}
}
