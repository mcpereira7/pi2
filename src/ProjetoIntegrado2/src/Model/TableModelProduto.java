package Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Marcelo Pereira <marcelo.pereira@rerum.com.br>
 */
public class TableModelProduto extends AbstractTableModel{

    private List<Produto> proLinhas;
    private String [] nomeColunas = new String[]{
        "Codigo", "Nome","Fornecedor","Data Entrada", "Estoque"
    };
    
    // Construtores
    public TableModelProduto(){
        proLinhas = new ArrayList<Produto>();
    }
    
    public TableModelProduto(List<Produto> listaProdutos){
        proLinhas = new ArrayList<Produto>(listaProdutos);
    }
    
        
    
    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
