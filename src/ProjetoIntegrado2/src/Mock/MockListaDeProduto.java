/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Mock;

import Model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aayan
 */
public class MockListaDeProduto {

    private static int totalProdutos = 0;

    public static List<Produto> listaProdutos = new ArrayList<Produto>();

    public static void adicionar(Produto p) throws Exception {
        p.setId(totalProdutos++);
        listaProdutos.add(p);
    }

    public static List<Produto> listar() throws Exception {
        return listaProdutos;
    }

    // Consulta produto
    public static List<Produto> ListarProduto(Integer codigo, String nome, String tipo, String fornecedor) throws Exception {
        List<Produto> listaDeProduto = new ArrayList<>();
        
        if (codigo != 0 || nome != null || tipo != null || fornecedor != null) {
            for (Produto produto : listaDeProduto) {
                if (produto.getCodProduto() == codigo || produto.getNome().equalsIgnoreCase(nome) || produto.getTipo().equalsIgnoreCase(tipo) || produto.getFornecedor().equalsIgnoreCase(fornecedor)) {
                    listaDeProduto.add(produto);
                }
            }
        }

        return listaDeProduto;
    }

}
