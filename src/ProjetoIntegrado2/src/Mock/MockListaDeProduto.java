/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Mock;

import Model.Produto;
import Telas.CadastroProduto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aayan
 */
public class MockListaDeProduto {

    public static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();


    public static ArrayList<Produto> lista;

    public static ArrayList<Produto> getLista() {
        return lista;
    }

}
