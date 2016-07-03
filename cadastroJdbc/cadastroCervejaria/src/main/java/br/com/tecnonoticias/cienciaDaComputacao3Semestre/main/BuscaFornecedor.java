package br.com.tecnonoticias.cienciaDaComputacao3Semestre.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import com.birosoft.liquid.LiquidLookAndFeel;

import br.com.tecnonoticias.cienciaDaComputacao3Semestre.dao.FornecedorDao;
import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.ModeloTableFornecedor;
import br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo.PessoaJuridica;

@SuppressWarnings("serial")
public class BuscaFornecedor extends JFrame {


	public BuscaFornecedor() {
		montaTela();
		ListSelectionModel listMod = tabela.getSelectionModel();
		listMod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMod.addListSelectionListener(new Selecao(tabela));
	}

	private static JRadioButton botaoAlterar, botaoExcluir;
	private static JFrame janela;
	private static JPanel painelPrincipal;
	private static JTable tabela;

	public static void main(String[] args) {
		Locale.setDefault(new Locale("pt", "BR"));
		// lookandfeel();
		new BuscaFornecedor();

	}

	public static void montaTela() {
		preparaJanela();
		preparaPainelPrincipal();
		mostraJanea();
		preparaTabela();
		preparaBotaoCarregar();
		preparaBotaoRadioButton();
		preparaBotaoSair();
	}

	private static void preparaJanela() {
		janela = new JFrame("Consulta Fornecedor");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setLocation(400, 100);
		janela.setLayout(null);

	}

	private static void preparaPainelPrincipal() {
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelPrincipal.setBounds(10, 10, 500, 450);
		janela.add(painelPrincipal);
	}

	private static void mostraJanea() {
		janela.pack();
		janela.setSize(530, 490);
		janela.setResizable(false);
		janela.setVisible(true);

	}

	private static void preparaTabela() {
		tabela = new JTable();
		tabela.setBorder(new LineBorder(Color.red));
		tabela.setGridColor(Color.blue);
		tabela.setShowGrid(true);
		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().setBorder(null);
		scroll.setSize(500, 200); // Mudar tamanho da JTable.

		scroll.getViewport().add(tabela);
		painelPrincipal.add(scroll);
	}

	private static void preparaBotaoCarregar() {

		JButton botaoCarregar = new JButton("Consultar");
		botaoCarregar.setBounds(40, 410, 110, 30);
		botaoCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FornecedorDao dao = new FornecedorDao();
				List<PessoaJuridica> fornecedor = dao.busca();
				ModeloTableFornecedor ntm = new ModeloTableFornecedor(fornecedor);
				tabela.setModel(ntm);
				tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
				tabela.getColumnModel().getColumn(1).setPreferredWidth(260);
				tabela.getColumnModel().getColumn(2).setPreferredWidth(260);
				tabela.getColumnModel().getColumn(3).setPreferredWidth(260);
				tabela.getColumnModel().getColumn(4).setPreferredWidth(120);
				tabela.getColumnModel().getColumn(5).setPreferredWidth(260);
				tabela.getColumnModel().getColumn(6).setPreferredWidth(200);
				// tabela.getColumnModel().getColumn(7).setPreferredWidth(200);
			};

		});

		painelPrincipal.add(botaoCarregar);
	}

	public static void preparaBotaoRadioButton() {
		
		botaoAlterar = new JRadioButton("Alterar");
		botaoAlterar.setBounds(185, 405, 110, 30);
		botaoExcluir = new JRadioButton("Excluir");
		botaoExcluir.setBounds(185, 430, 110, 30);
		
		painelPrincipal.add(botaoExcluir);
		painelPrincipal.add(botaoAlterar);
	}

	public static void preparaBotaoSair() {
		JButton botaoSair = new JButton("Sair");
		botaoSair.setBounds(355, 410, 110, 30);
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela.dispose();
			}
		});

		painelPrincipal.add(botaoSair);
	}

	class Selecao implements ListSelectionListener {

		private JTable tabela;

		public Selecao(JTable tb) {
			this.tabela = tb;
		}

		public void valueChanged(ListSelectionEvent e) {

			if (botaoAlterar.isSelected()) {
				int[] selRows;
				FornecedorAltera altera = new FornecedorAltera();

				if (!e.getValueIsAdjusting()) {
					selRows = tabela.getSelectedRows();

					if (selRows.length > 0) {
						TableModel tm = tabela.getModel();
						altera.tf_Codigo.setText(tm.getValueAt(selRows[0], 0).toString());
						altera.tf_RazaoSocial.setText(tm.getValueAt(selRows[0], 1).toString());
						altera.tf_NomeFantazia.setText(tm.getValueAt(selRows[0], 2).toString());
						altera.tf_Cnpj.setText(tm.getValueAt(selRows[0], 3).toString());
						altera.tf_Endereço.setText(tm.getValueAt(selRows[0], 4).toString());
						altera.tf_Cidade.setText(tm.getValueAt(selRows[0], 5).toString());
						altera.tf_Estado.setText(tm.getValueAt(selRows[0], 6).toString());
						altera.setVisible(true);

						System.out.println();
					}
				}
			}
			if (botaoExcluir.isSelected()) {
				int[] selRows;
				DeletaFornecedor excluir = new DeletaFornecedor();

				if (!e.getValueIsAdjusting()) {
					selRows = tabela.getSelectedRows();

					if (selRows.length > 0) {
						TableModel tm = tabela.getModel();
						excluir.tf_Codigo.setText(tm.getValueAt(selRows[0], 0).toString());
						excluir.tf_RazaoSocial.setText(tm.getValueAt(selRows[0], 1).toString());
						excluir.tf_NomeFantazia.setText(tm.getValueAt(selRows[0], 2).toString());
						excluir.tf_Cnpj.setText(tm.getValueAt(selRows[0], 3).toString());
						excluir.tf_Endereço.setText(tm.getValueAt(selRows[0], 4).toString());
						excluir.tf_Cidade.setText(tm.getValueAt(selRows[0], 5).toString());
						excluir.tf_Estado.setText(tm.getValueAt(selRows[0], 6).toString());
						excluir.setVisible(true);

						System.out.println();
					}
				}
			}
		}

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