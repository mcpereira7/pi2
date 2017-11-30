/*
 * Alexandre Vinicius Ferreida da Silva & Leandro Alves
 * @author alexandre.vfsilva
 * Turma A
 */
package Controllers;

import Exceptions.ClienteException;
import Exceptions.DataSourceException;
import Mock.MockListaDeCliente;
import Model.Cliente;
import Model.ValidadorCliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexandre.vfsilva
 */
//Serviço de Clientes
public class ServicoCliente {

    public static void cadastrarCliente(Cliente cliente)
            throws ClienteException, DataSourceException {

        //Validador para verificar os dados inseridos no MockListDeCliente
        ValidadorCliente.validacao(cliente);

        try {
            // Realizada a inserção de dados no 'MOCk'
            MockListaDeCliente.inserir(cliente);
        } catch (Exception e) {

            //mostra no console qualquer erro que ocorra no 'MOCK'
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    // Atualizar o Cliente no 'MOCK'
    public static void atualizaCliente(Cliente cliente)
            throws ClienteException, DataSourceException {

        // Utiliza o validador para checar o cliente
        ValidadorCliente.validacao(cliente);

        try {
            //Utiliza a Atualização no 'MOCK'
            MockListaDeCliente.atualizar(cliente);
            return;
        } catch (Exception e) {

            //Mostra no console qualquer erro que ocorra no 'MOCK'
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    // Realiza a pesquisa do Cliente por um nome no 'Mock'
    public static List<Cliente> procuraCliente(String nome)
            throws ClienteException, DataSourceException {
        try {
            // Verifica se foi ou não informado um dado para pesquisa.
            // Se informado um dado, realiza a listagem simples do mock.
            // Se não informado um dado, realiza uma pesquisa com o dado.
            if (nome == null && "".equals(nome)) {
                return MockListaDeCliente.listar();
            } else {
                return MockListaDeCliente.procurar(null, nome);
            }
        } catch (Exception e) {
            //mostra no console qualquer erro que ocorra no 'MOCK'
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Obtem um cliente com ID informado do MOCK
    public static Cliente obterCliente(Integer codigo)
            throws ClienteException, DataSourceException {
        try {
            // Retorn o Cliente obtido
            return MockListaDeCliente.obter(codigo);
        } catch (Exception e) {
            //mostra no console qualquer erro que ocorra no 'MOCK'
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de da dados", e);
        }
    }

    public static Cliente obterCliente(String codigo)
            throws DataSourceException {
        try {
            int numCod = Integer.parseInt(codigo);
            return MockListaDeCliente.obter(numCod);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de da dados", e);
        }
    }

    //by Andre
    public static Cliente obterClienteByNome(String nome)
            throws DataSourceException {
        try {
            return MockListaDeCliente.obterByNome(nome);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de da dados", e);
        }
    }

    public static void excluiCliente(Integer codigo)
            throws ClienteException, DataSourceException {
        try {
            MockListaDeCliente.excluir(codigo);
        } catch (Exception e) {

            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

}
