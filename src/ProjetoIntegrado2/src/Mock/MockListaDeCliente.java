package Mock;

import Model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 * Alexandre Vinicius Ferreira da Silva & Leandro Alves alexandre.vfsilva
 */
public class MockListaDeCliente {

    private static int numClientes = 0;
    private static List<Cliente> listaClientes = new ArrayList<Cliente>();
    
    //Não precisa de um construtor
    // Inserir Cadastro do Cliente 
    public static void inserir(Cliente cliente) throws Exception {
        cliente.setId(numClientes++);
        listaClientes.add(cliente);
    }

    //Atualiza o Cadastro do Cliente.
    public static void atualizar(Cliente procuraCliente) throws Exception {

        if (procuraCliente != null && !listaClientes.isEmpty()) {
            for (Cliente listaCliente : listaClientes) {
                if (listaCliente != null && listaCliente.getId() == procuraCliente.getId()) {

                    listaCliente.setCodCliente(procuraCliente.getCodCliente());
                    listaCliente.setDataCadastro(procuraCliente.getDataCadastro());
                    listaCliente.setNome(procuraCliente.getNome());
                    listaCliente.setSexo(procuraCliente.getSexo());
                    listaCliente.setCpf(procuraCliente.getCpf());
                    listaCliente.setRg(procuraCliente.getRg());
                    listaCliente.setDataNasc(procuraCliente.getDataNasc());
                    listaCliente.setTelefone(procuraCliente.getTelefone());
                    listaCliente.setCelular(procuraCliente.getCelular());
                    listaCliente.setEmail(procuraCliente.getEmail());
                    listaCliente.setCep(procuraCliente.getCep());
                    listaCliente.setCidade(procuraCliente.getCidade());
                    listaCliente.setUf(procuraCliente.getUf());
                    listaCliente.setEndereco(procuraCliente.getEndereco());
                    listaCliente.setEndNumero(procuraCliente.getEndNumero());
                    listaCliente.setComplemento(procuraCliente.getComplemento());
                    listaCliente.setBairro(procuraCliente.getBairro());
                    listaCliente.setObs(procuraCliente.getObs());
                    break;
                }
            }
        }
    }

    //Exclui o Cadastro de um Cliente.
    public static void excluir(Integer id) throws Exception {
        if (id != null && !listaClientes.isEmpty()) {
            for (int i = 0; i < listaClientes.size(); i++) {
                Cliente clienteLinha = listaClientes.get(i);
                if (clienteLinha != null && clienteLinha.getId() == id) {
                    listaClientes.remove(i);
                    break;
                }
            }
        }
    }

    //Listar Todos os Clientes.
    public static List<Cliente> listar() throws Exception {
        return listaClientes;
    }

    //Procura um Cliente por Código ou Nome.
    public static List<Cliente> procurar(Integer codigo, String nome) throws Exception {
        List<Cliente> resultados = new ArrayList<Cliente>();

        if ((codigo != null || nome != null) && !listaClientes.isEmpty()) {
            for (Cliente cliente : listaClientes) {
                if (codigo != null && nome != null) {
                    if (cliente.getCodCliente() == codigo && cliente.getNome().toUpperCase().contains(nome.toUpperCase())) {
                        resultados.add(cliente);
                    }
                } else if (codigo != null) {
                    if (cliente.getCodCliente() == codigo) {
                        resultados.add(cliente);
                    }
                } else if (cliente.getNome().toUpperCase().contains(nome.toUpperCase())) {
                    resultados.add(cliente);
                }
            }
        }
        return resultados;
    }

//Retorna um cliente da lista.
    public static Cliente obter(Integer id) throws Exception {
        if (id != null && !listaClientes.isEmpty()) {
//            for (int i = 0; i <= listaClientes.size(); i++) {
//                if (listaClientes.get(i) != null && listaClientes.get(i).getCodCliente()== id) {
//                    return listaClientes.get(i);
//                }
//            }
            for (Cliente cliente : listaClientes) {
                if(cliente.getCodCliente() == id) {
                    return cliente;
                }
            }
        }
        return null;
    }
    
    public static Cliente obterByCod(Integer cod) throws Exception {
        if (cod != null && !listaClientes.isEmpty()) {
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i) != null && listaClientes.get(i).getCodCliente()== cod) {
                    return listaClientes.get(i);
                }
            }
        }
        return null;
    }
    
    //by Andre
    public static Cliente obterByNome(String nome) throws Exception {
        if (!nome.isEmpty() && !listaClientes.isEmpty()) {
            for (Cliente cliente : listaClientes) {
                if(cliente.getNome().trim().toLowerCase().equals(nome.trim().toLowerCase())) {
                    return cliente;
                }
            }
        }
        return null;
    }

}
