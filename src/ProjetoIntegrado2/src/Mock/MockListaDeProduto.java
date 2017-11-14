/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Mock;

import Model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aayan
 */
public class MockListaDeProduto {

    private static int totalProdutos = 0;

    public static List<Produto> listaProdutos = new ArrayList<Produto>();

    public static void adicionar(Produto p) throws Exception {
        listaProdutos.add(p);
        p.setId(totalProdutos++);
    }

    public static List<Produto> listar() throws Exception {
        return listaProdutos;
    }

    // Consulta produto
    public static List<Produto> ListarProduto(Integer codigo, String nome, String tipo, String fornecedor) throws Exception {
        
        // Criando array que recebe o tipo de Objeto Produto
        ArrayList<Produto> resultadoBusca = new ArrayList<Produto>();
        
       for(Produto p:listaProdutos){
           if(codigo!=null){
               resultadoBusca.add(p);
           }
           else if(nome!=null && p.getNome().equalsIgnoreCase(nome)){
               resultadoBusca.add(p);
           }
       }
        return resultadoBusca;
        
    }

}
