package br.com.tecnonoticias.exemplo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class Estudos extends JFrame {

	public Estudos() {
		super("Exemplo de uma tabela simples");

		// colunas da tabela
		final String[] colunas = { "Cidade", "Estado", "Habitantes" };

		// conteúdo da tabela
		final Object[][] conteudo = { { "Goiânia", "GO", "43.023.432" }, { "São Paulo", "SP", "5.343.234" },
				{ "Rio de Janeiro", "RJ", "6.434.212" }, { "Jussara", "GO", "87.454" },
				{ "Barra do Garças", "MT", "64.344" } };

		TableModel dataModel = new AbstractTableModel() {
			public int getColumnCount() {
				return colunas.length;
			}

			public int getRowCount() {
				return conteudo.length;
			}

			public Object getValueAt(int row, int col) {
				return conteudo[row][col];
			}

			public String getColumnName(int column) {
				return colunas[column];
			}

			public Class getColumnClass(int col) {
				return getValueAt(0, col).getClass();
			}

			public void setValueAt(Object aValue, int row, int column) {
				conteudo[row][column] = aValue;
			}
		};

		// constrói a tabela
		JTable tabela = new JTable(dataModel);

		ListSelectionModel listMod = tabela.getSelectionModel();
		listMod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMod.addListSelectionListener(new Selecao(tabela));

		tabela.setPreferredScrollableViewportSize(new Dimension(350, 150));

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JScrollPane scrollPane = new JScrollPane(tabela);
		c.add(scrollPane);

		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String args[]) {
		Estudos app = new Estudos();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Selecao implements ListSelectionListener {
	private JTable tabela;

	public Selecao(JTable tb) {
		this.tabela = tb;
	}

	public void valueChanged(ListSelectionEvent e) {
		int maxRows;
		int[] selRows;
		Object value;

		if (!e.getValueIsAdjusting()) {
			selRows = tabela.getSelectedRows();

			if (selRows.length > 0) {
				for (int i = 0; i < 3; i++) {
					TableModel tm = tabela.getModel();
					value = tm.getValueAt(selRows[0], i);
					System.out.println("Selecao : " + value);
				}
				System.out.println();
			}
		}
	}
}
