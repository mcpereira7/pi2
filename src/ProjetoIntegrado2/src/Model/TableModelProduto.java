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
        "Codigo", "Nome", "Fornecedor", "DataEntrada", "Estoque"
    };

    // Constantes referente ao indice das colunas
    private static final int CODIGO = 0;
    private static final int NOME = 1;
    private static final int FORNECEDOR = 2;
    private static final int DATAENTRADA = 3;
    private static final int ESTOQUE = 4;

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
        Produto produto = linhas.get(rowIndex);

        switch (columnIndex) {
            case NOME:
            case CODIGO:
            case FORNECEDOR:
            case DATAENTRADA:
            case ESTOQUE:
                return produto.getCodProduto();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

}
