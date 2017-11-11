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

    private static List<Produto> listaProdutos = new ArrayList<Produto>();

    public static void adicionar(Produto p) throws Exception {
        p.setId(totalProdutos++);
        listaProdutos.add(p);
    }

    public static List<Produto> listar() throws Exception {
        return listaProdutos;
    }

    public static void RefreshLista(List<Produto> lista) {
        listaProdutos.clear();
        listaProdutos.addAll(lista);
    }
}
