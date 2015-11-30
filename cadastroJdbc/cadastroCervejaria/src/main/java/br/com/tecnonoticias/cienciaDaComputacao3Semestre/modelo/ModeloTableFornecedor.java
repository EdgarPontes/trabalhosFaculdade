package br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo;

import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModeloTableFornecedor extends AbstractTableModel {



		private List<PessoaJuridica> lista;
		private List<String[]> linhas;

		// ctrl + 3 constructor
		public ModeloTableFornecedor(List<PessoaJuridica> lista) {
			super();
			this.lista = lista;
		}

		public int getRowCount() {
			return lista.size();
		}

		public int getColumnCount() {
			return 8;
		}
		
//		public Class getColumnClass(int col) {
//			return getValueAt(0, col).getClass();
//		}

		public Object getValueAt(int linha, int coluna) {
			PessoaJuridica pessoa = lista.get(linha);
			switch (coluna) {
			case 0:
				return pessoa.getFornecedorId();
			case 1:
				return pessoa.getRazaoSocial();
			case 2:
				return pessoa.getNomeFantasia();
			case 3:
				return pessoa.getCnpj();
			case 4:
				return pessoa.getEndereco();
			case 5:
				return pessoa.getCidade();
			case 6:
				return pessoa.getEstado();
			case 7:
			
			}
			return "";
		}

		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return "Id";
			case 1:
				return "Razão Social";
			case 2:
				return "Nome Fantazia";
			case 3:
				return "Cnpj";
			case 4:
				return "Endereço";
			case 5:
				return "Cidade";
			case 6:
				return "Estado";
			}
			return "";
		}

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			if (columnIndex == 0) {  
			      return false;  
			    }  
			// Indicamos se a célula da rowIndex e da columnIndex é editável. 
			return false;
		}
		
		public void setValueAt(List<PessoaJuridica> aValue, int row, int column) {
			lista = aValue;
		}

		public PessoaJuridica get(int row) {
			return lista.get(row);
		}
		public List<String[]> getLinhas() {  
	        return linhas;  
	    }  
		public void addRow(String[] dadosLinhas) {  
	        getLinhas().add(dadosLinhas);  
	        int linha = getLinhas().size()-1;  
	        fireTableRowsInserted(linha, linha);  
	        return;  
	    }  
	}