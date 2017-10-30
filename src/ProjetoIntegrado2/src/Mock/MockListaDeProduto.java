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
    
    private static ArrayList<Produto> lista;

    public static ArrayList<Produto> getLista() {
        return lista;
    }

    public static void setListaProduto(Produto produto) {
        lista.add(produto);
    }
    
    
}
