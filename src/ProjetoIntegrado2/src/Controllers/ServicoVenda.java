/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Controllers;

import Exceptions.DataSourceException;
import Exceptions.VendaException;
import Model.*;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 *
 * @author aayan
 */
public class ServicoVenda {

    public static void ConcluirVenda(Venda entrada) throws VendaException {
        try {
            ServicoProduto.AtualizaEstoque(entrada.getListaProdutos());
            DAO.VendaDAO.inserir(entrada);
        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }

    public static Venda ConsultaVendaByCodVenda(int codVenda)
            throws VendaException, DataSourceException {
        try {
            //Metodo que encontra a venda no banco com o codVenda
            return DAO.VendaDAO.getVendaByCod(codVenda);
        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }

    public static List<Venda> ConsultaVendaByData(Calendar de, Calendar ate)
            throws VendaException, DataSourceException {
        try {
            //Metodo que encontra a venda no banco com o codVenda
            return DAO.VendaDAO.getVendaByDates(de, ate);
        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
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
