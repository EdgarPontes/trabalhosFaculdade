package br.com.tecnonoticias.cienciaDaComputacao3Semestre.modelo;

import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class modeloTableMode extends AbstractTableModel {

	private List<PessoaFisica> lista;
	private List<String[]> linhas;

	// ctrl + 3 constructor
	public modeloTableMode(List<PessoaFisica> lista) {
		super();
		this.lista = lista;
	}

	public int getRowCount() {
		return lista.size();
	}

	public int getColumnCount() {
		return 8;
	}
	
//	public Class getColumnClass(int col) {
//		return getValueAt(0, col).getClass();
//	}

	public Object getValueAt(int linha, int coluna) {
		PessoaFisica pessoa = lista.get(linha);
		switch (coluna) {
		case 0:
			return pessoa.getPessoaId();
		case 1:
			return pessoa.getNome();
		case 2:
			return pessoa.getCpf();
		case 3:
			return pessoa.getRg();
		case 4:
			return pessoa.getSexo();
		case 5:
			return pessoa.getEndereco();
		case 6:
			return pessoa.getCidade();
		case 7:
			return pessoa.getEstado();
		case 8:
			return pessoa.getDataNascimento();
		}
		return "";
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Id";
		case 1:
			return "Nome";
		case 2:
			return "Cpf";
		case 3:
			return "Rg";
		case 4:
			return "Sexo";
		case 5:
			return "Endereço";
		case 6:
			return "Cidade";
		case 7:
			return "Estado";
		case 8:
			return "Data Nascimento";
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
	
	public void setValueAt(List<PessoaFisica> aValue, int row, int column) {
		lista = aValue;
	}

	public PessoaFisica get(int row) {
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
