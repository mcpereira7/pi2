/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Controllers;

import DAO.ProdutoDAO;
import Exceptions.productException;
import Exceptions.DataSourceException;
import Model.Produto;
import java.util.ArrayList;
import java.util.List;
import Mock.MockListaDeProduto;

/**
 *
 * @author aayan
 */
public class ServicoProduto {

    public static void cadastroProduto(Produto produto) throws productException, DataSourceException {
        //validação do quarto:
        ProdutoDAO.validaProduto(produto);

        try {
            ProdutoDAO.inserir(produto);
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

    public static List<Produto> consultaProduto(int codigo, String nome, String tipo, String fornecedor) throws Exception {
//        List<Produto> produto=MockListaDeProduto.procurar(codigo, nome, tipo, fornecedor);
List<Produto> produto=ProdutoDAO.procurarProduto(codigo, nome, tipo, fornecedor);
        for (int i = 0; i < produto.size(); i++) {
                if(!produto.isEmpty()){
                    return produto;
                }
        }
        return null;
    }

    public static Produto getProdutoByCodProduto(String codProduto) throws productException {
        try {
            int codProdutoNumero = Integer.parseInt(codProduto);
            Produto resultado = null;

            List<Produto> lista = MockListaDeProduto.listar();
            for (Produto produto : lista) {
                if (produto.getCodProduto() == codProdutoNumero) {
                    resultado = produto;
                }
            }
            return resultado;

        } catch (Exception e) {
            throw new productException("Erro: ");
        }
    }

    public static void AtualizaEstoque(List<Produto> lista)
            throws productException {
        try {
            List<Produto> old = MockListaDeProduto.listar();

            for (Produto produto : lista) {
                for (Produto produtoOld : old) {
                    if (produto.getCodProduto() == produtoOld.getCodProduto()) {
                        int quant = produtoOld.getQuantidadeEstoque();
                        quant -= produto.getQuantidadeVenda();
                        produtoOld.setQuantidadeEstoque(quant);
                    }
                }
            }
            MockListaDeProduto.RefreshLista(old);

        } catch (Exception e) {
        }

    }
}
