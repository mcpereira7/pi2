/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Controllers;

import Exceptions.DataSourceException;
import Exceptions.VendaException;
import Model.Venda;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 *
 * @author aayan
 */
public class ServicoVenda {

    public static void AdicionarProdutoNaVenda(String codVenda,
            String codProduto, String quantidade) {

        //Metodo para procurar o produto no estoque
        //Produto novo = Mock.MockListaDeProduto.getProdutoByCod(codProduto);
        //Metodo para ditar a quantidade em venda
        //produto.setQuantidadeVenda(quantidade);
        //List<Produto> listaNova = venda.getListaProdutos();
        //Adicionando o produto na lista da venda
        //listaNova.add(produto);
        //Retornando a lista
        //venda.setListaProdutos(listaNova);

    }

    public static List<Venda> ConsultaVendaByCodVenda(int codVenda)
            throws VendaException, DataSourceException {
        try {
            //Metodo que encontra a venda no banco com o codVenda
            return Mock.MockListaDeVenda.getVenda(codVenda);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados.", e);
        }
    }
    
    public static List<Venda> ConsultaVendaByVendedor(String vendedor)
            throws VendaException, DataSourceException {
        try {
            //Metodo que encontra a venda no banco com o codVenda
            return Mock.MockListaDeVenda.getVenda(vendedor);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados.", e);
        }
    }
    
    public static List<Venda> ConsultaVendaByData(Calendar de, Calendar ate)
            throws VendaException, DataSourceException {
        try {
            //Metodo que encontra a venda no banco com o codVenda
            return Mock.MockListaDeVenda.getVenda(de, ate);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados.", e);
        }
    }
    
//    public static String ObterNomeClienteByCod(String codCliente)
    
    public static int geraCodVenda() {
        Random rnd = new Random();
        int parteUM = rnd.nextInt(100) + 1;
        int parteDOIS = rnd.nextInt(98) + 151;

        int fim = parteUM + parteDOIS;

        return fim;
    }
}
