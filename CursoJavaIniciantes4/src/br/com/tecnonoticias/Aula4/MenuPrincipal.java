package br.com.tecnonoticias.Aula4;

import javax.swing.JDialog;

public class MenuPrincipal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3687979529547834728L;

	public static void main(String[] args) {
		try {
			MenuPrincipal dialog = new MenuPrincipal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MenuPrincipal() {
	}
}
