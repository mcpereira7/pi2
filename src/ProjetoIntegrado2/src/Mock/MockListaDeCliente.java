/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Mock;

import Model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author aayan
 */
public class MockListaDeCliente {
    
    private static ArrayList<Cliente> listaDeCliente;

    //Construtor
    public MockListaDeCliente() {
        
    }

    //Metodos
    public static Cliente getCliente() {
        //Cliente consultado = consultarClienteLALALA();
        Cliente lala = new Cliente();
        return lala;
    }
    
    public static void setCliente(Cliente cadastrado) {
        listaDeCliente.add(cadastrado);
    }
    
}