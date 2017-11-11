/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Controllers;

import Exceptions.productException;
import Exceptions.DataSourceException;
import Model.Produto;
import java.util.ArrayList;
import java.util.List;
import Mock.MockValidarProduto;
import Mock.MockListaDeProduto;

/**
 *
 * @author aayan
 */
public class ServicoProduto {

    public static void cadastroProduto(Produto produto) throws productException, DataSourceException {
        //validação do quarto:
        MockValidarProduto.validacao(produto);

        try {
            MockListaDeProduto.adicionar(produto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro: ", e);
        }
    }

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
        for (int i = 0; i < produto.size(); i++) {

        }
        return null;
    }

//    public Produto getProdutoByCodProduto(String codProduto) throws Exception {
//        List<Produto> lista = MockListaDeProduto.listar();
//        
//    }
}
