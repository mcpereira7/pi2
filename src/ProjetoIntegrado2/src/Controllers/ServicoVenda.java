/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Controllers;

import DAO.VendaDAO;
import Exceptions.ClienteException;
import Exceptions.DataSourceException;
import Exceptions.VendaException;
import Model.*;
import static Telas.Vendas.isParsable;
import java.awt.Component;
import java.awt.HeadlessException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aayan
 */
public class ServicoVenda {

    public static List<Cliente> ConsultaClienteByNomeOuCodigo(String campoDaConsulta,
            List<ItensVenda> listaItensVenda, List<Cliente> listaDeClientes, Component tela)
            throws VendaException {

        try {
            //Verifica se o usuario 
            if (!campoDaConsulta.isEmpty()) {
                //Verifica se algum cliente já foi incluído à venda
                if (!listaItensVenda.isEmpty() || !listaDeClientes.isEmpty()) {
                    JOptionPane.showMessageDialog(tela, "Já existe um cliente na venda.");
                    return null;
                } else {
                    //Verifica se é um código
                    if (isParsable(campoDaConsulta)) {

                        listaDeClientes = ServicoCliente.procuraCliente(Integer.parseInt(campoDaConsulta), campoDaConsulta);

                        if (listaDeClientes.size() > 1) {
                            JOptionPane.showMessageDialog(tela, "Mais de um cliente enconttrado com o mesmo nome.");
                            return listaDeClientes;
                            //clienteVenda = ServicoCliente.obterCliente(jTextFieldCodCliente.getText());
                        } else {
                            return listaDeClientes;
                        }

                    } else {
                        listaDeClientes = ServicoCliente.procuraCliente(-1, campoDaConsulta);
                        return listaDeClientes;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(tela, "Digite um nome ou código valido.");
                return null;
            }
        } catch (ClienteException | DataSourceException | HeadlessException | NumberFormatException e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }

    public static void ConcluirVenda(Venda entrada) throws VendaException {
        try {
            ServicoProduto.AtualizaEstoque(entrada.getListaItensVenda());
            //DAO.VendaDAO.insertItensVenda(entrada.getListaItensVenda(), entrada);
            DAO.VendaDAO.inserir(entrada);
        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }

//    public static Venda ConsultaVendaByCodVenda(int codVenda)
//            throws VendaException, DataSourceException {
//        try {
//            //Metodo que encontra a venda no banco com o codVenda
//            return DAO.VendaDAO.getVendaByCod(codVenda);
//        } catch (Exception e) {
//            throw new VendaException("Erro na fonte de dados.", e.getCause());
//        }
//    }
    public static List<Venda> ConsultaVendaByData(Date de, Date ate)
            throws VendaException, DataSourceException {
        try {
            //Metodo que encontra a venda no banco com o codVenda
            return DAO.VendaDAO.getVendaByDates(de, ate);
        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }

    public static List<Venda> ConsultaVendaRelatorio(Date de, Date ate, String campoOrdenacao, boolean ASC)
            throws VendaException, DataSourceException {
        try {
            
            

//Metodo que encontra a venda no banco com o codVenda
            return DAO.VendaDAO.getVendaRelatorio(de, ate, campoOrdenacao, ASC);
        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }

    public static int geraCodVenda()
            throws VendaException, DataSourceException {
        try {

            int codigo = VendaDAO.countVendas();
            codigo++;

            while (codigo == VendaDAO.countVendas()) {
                codigo++;
            }

            return codigo;

        } catch (Exception e) {
            throw new VendaException("Erro na fonte de dados.", e.getCause());
        }
    }
}
