package br.tablemodel;

import br.aula.modelo.Cliente;

@SuppressWarnings({ "serial", "unchecked" })
public class TableModelCliente extends TableModelBase<Cliente>{

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int column) {
		String[] colunas = {"Codigo", "Nome", "Rg", "Cpf"};
		return colunas[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Cliente obj = lista.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return obj.getId();
		case 1: 
			return obj.getNome();
		case 2:
			return obj.getRg();
		case 3:
			return obj.getCpf();
		
		}
		return obj;
	}

}
