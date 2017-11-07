/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Exceptions.ClienteException;

/**
 * Alexandre Vinicius Ferreida da Silva
 *
 * @author alexandre.vfsilva Turma A
 */
//
public class ValidadorCliente {

    // Valida todos os dados de cadastro obrigatórios do cliente.
    public static void validacao(Cliente cliente) throws ClienteException {

        if (cliente == null) {
            throw new ClienteException("Não foi Informado um CLIENTE válido");
        }
        if (cliente.getNome() == null || "".equals(cliente.getNome())) {
            throw new ClienteException("É necessário informar um NOME válido de cliente");
        }
        if (cliente.getCpf() == null || "".equals(cliente.getCpf())) {
            throw new ClienteException("É necessário informar um CPF válido do cliente");
        }
        if (cliente.getEmail() == null || "".equals(cliente.getEmail())) {
            throw new ClienteException("É necessário informar um EMAIL válido do cliente");
        }
        if (cliente.getCep() == null || "".equals(cliente.getCep())) {
            throw new ClienteException("É necessario informar um CEP válido do cliente");
        }
        if (cliente.getEndereco() == null || "".equals(cliente.getEndereco())) {
            throw new ClienteException("É necessário informar um ENDEREÇO válido do cliente");
        }
        if (cliente.getCidade() == null || "".equals(cliente.getCidade())) {
            throw new ClienteException("É necessário informar uma CIDADE válida do cliente");
        }
        if (cliente.getCelular() == null || "".equals(cliente.getCelular())) {
            throw new ClienteException("É necessário informar um CELULAR válido do cliente");
        }
        if (cliente.getRg() == null || "".equals(cliente.getRg())) {
            throw new ClienteException("É necessário informar um RG válido do cliente");
        }
        if (cliente.getUf() == null || "".equals(cliente.getUf())) {
            throw new ClienteException("É necessário informar um UF válido do cliente");
        }
        if (cliente.getDataNasc() == null || "".equals(cliente.getDataNasc())) {
            throw new ClienteException("É necessário informar uma DATA de NASCIMENTO válida do cliente");
        }
        if(cliente.getSexo() == null || "".equals(cliente.getSexo())){
            throw new ClienteException ("É necessário informar um SEXO válido do cliente");
        }
    }

}
