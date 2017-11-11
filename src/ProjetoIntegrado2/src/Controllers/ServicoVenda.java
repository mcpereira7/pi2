/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Controllers;

import Exceptions.DataSourceException;
import Exceptions.VendaException;
import Mock.MockListaDeVenda;
import Model.*;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aayan
 */
public class ServicoVenda {

    public static void ConcluirVenda(Venda entrada) throws VendaException {
        try {
            ServicoProduto.AtualizaEstoque(entrada.getListaProdutos());
            MockListaDeVenda.inserirVenda(entrada);
        } catch (Exception e) {
            e.printStackTrace();
            throw new VendaException("Erro na fonte de dados.", e);
        }
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
