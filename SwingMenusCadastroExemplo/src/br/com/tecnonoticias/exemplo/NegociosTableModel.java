package br.com.tecnonoticias.exemplo;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class NegociosTableModel extends AbstractTableModel {

	private final List<Negocio> lista;

	// ctrl + 3 constructor
	public NegociosTableModel(List<Negocio> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@SuppressWarnings("unused")
	@Override
	public Object getValueAt(int linha, int coluna) {
		Negocio negocio = lista.get(linha);
		switch (coluna) {
		case 0:
		    Locale brasil = new Locale("pt", "BR");
		    NumberFormat formatadorMoeda = 
		    NumberFormat.getCurrencyInstance(brasil);
		case 1:
			return negocio.getQuantidade();
		case 2:
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return sdf.format(negocio.getData().getTime());
		}
		return "";
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Preço";
		case 1:
			return "Quantidade";
		case 2:
			return "Data";
		}
		return "";
	}
}