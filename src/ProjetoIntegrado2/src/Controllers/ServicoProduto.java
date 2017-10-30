/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Controllers;

import Model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aayan
 */
public class ServicoProduto {

//    public static ArrayList<Produto> ListarProduto(String filtro) {
    public static ArrayList<Produto> ListarProduto(Produto produto) {
        ArrayList<Produto> listaDeProduto = new ArrayList<>();

        for (int i = 0; i < listaDeProduto.size(); i++) {
            if (listaDeProduto.get(i) == null) {
                listaDeProduto.add(produto);
            }
        }

        return listaDeProduto;
    }

    public Produto consultaProduto(List<Produto> produto) {
            for(int i = 0; i<produto.size(); i++){
                
            }
        return null;
    }

}
