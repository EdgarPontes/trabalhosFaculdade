package br.com.tecnonoticias.lookandfeald;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LookAndFeel extends JFrame {
	private UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
//	private JLabel lbLabel01 = new JLabel("Nome :");
//	private JLabel lbLabel02 = new JLabel("E-mail :");
//	private JTextField jtTexto01 = new JTextField(10);
//	private JTextField jtTexto02 = new JTextField(10);
//	private JButton jbOk = new JButton("Enviar");
//	private JButton jbLim = new JButton("Limpar");
	private JRadioButton[] escolha = new JRadioButton[looks.length];
	private ButtonGroup grupo = new ButtonGroup();

	public static void main(String[] args) {
		LookAndFeel lfd = new LookAndFeel();
		lfd.show();
	}

	public LookAndFeel() {
		super("Teste");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
//		c.add(lbLabel01);
//		c.add(jtTexto01);
//		c.add(lbLabel02);
//		c.add(jtTexto02);
//		c.add(jbOk);
//		c.add(jbLim);

		ItemSelecionado iselect = new ItemSelecionado();
		for (int i = 0; i < looks.length; i++) {
			escolha[i] = new JRadioButton(looks[i].getName());
			escolha[i].addItemListener(iselect);
			grupo.add(escolha[i]);
			c.add(escolha[i]);
		}
		escolha[2].setSelected(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 200);
	}

	public void atualiza(int i) {
		try {
			UIManager.setLookAndFeel(looks[i].getClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class ItemSelecionado implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			for (int i = 0; i < escolha.length; i++) {
				if (escolha[i].isSelected())
					atualiza(i);
			}
		}
	}
}