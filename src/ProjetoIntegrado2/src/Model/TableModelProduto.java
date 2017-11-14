package Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marcelo Pereira <marcelo.pereira@rerum.com.br>
 */
public class TableModelProduto extends AbstractTableModel {

    private List<Produto> linhas;
    private String[] colunas = new String[]{
        "Codigo", "Nome", "Fornecedor", "Data Entrada", "Estoque"
    };
    
    // Constantes referente ao indice das colunas
    private static final int codigo=0;
    private static final int nome=1;
    private static final int fornecedor=2;
    private static final int dtEntrada=3;
    private static final int estoque=4;

    // Construtores
    public TableModelProduto() {
        linhas = new ArrayList<>();
    }

    public TableModelProduto(List<Produto> listaProdutos) {
        linhas = new ArrayList<Produto>(listaProdutos);
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
