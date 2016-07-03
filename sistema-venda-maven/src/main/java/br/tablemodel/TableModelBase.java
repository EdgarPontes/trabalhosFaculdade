package br.tablemodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Altieres de Matos
 * @param <T>
 */
@SuppressWarnings("serial")
public abstract class TableModelBase<T extends Serializable> extends AbstractTableModel {

    protected List<T> lista;

    public void setLista(Collection<T> lista) {
        this.lista = new ArrayList<>(lista);
    }
    
    public T getValue(int index) {
        return lista.get(index);
    }
    
    @Override
    public int getRowCount() {
        if (lista == null) {
            return 0;
        }
        return lista.size();
    }

    @Override
    public abstract int getColumnCount();
    
    @Override
    public abstract String getColumnName(int column);

    @Override
    public abstract Object getValueAt(int rowIndex, int columnIndex);
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

}