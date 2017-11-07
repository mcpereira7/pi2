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

/**
 *
 * @author alexandre.vfsilva
 */ 

//Serviço de Clientes
public class ServicoCliente {
    public static void cadastrarCliente (Cliente cliente)
            throws ClienteException, DataSourceException{
        
        //Validador para verificar os dados inseridos no MockListDeCliente
        ValidadorCliente.validacao(cliente);
        
        try{
            // Realizada a inserção de dados no 'MOCk'
            MockListaDeCliente.inserir(cliente);
        }catch (Exception e){
            
            //mostra no console qualquer erro que ocorra no 'MOCK'
            
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados",e);
        }
    }
    
}
