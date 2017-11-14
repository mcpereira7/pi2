package DAO;

import Model.Cliente;
import java.sql.SQLException;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO {

    private static Connection cn = null;

    public ClienteDAO() {
        cn = ConnectionFactory.getConnection();
    }

    public static void inserir(Cliente cliente) throws SQLException, Exception {
        PreparedStatement stmt = null;

        String sql = "INSERT INTO Cliente (id, codCliente, dataCadastro, nome, sexo, cpf, rg, dataNasc, telefone, "
                + "celular, email, cep, cidade, uf, endereco, endNumero, complemento, bairro, obs) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            stmt.setInt(2, cliente.getCodCliente());
            stmt.setDate(3, (Date) cliente.getDataCadastro());
            stmt.setString(4, cliente.getNome());
            stmt.setString(5, cliente.getSexo());
            stmt.setString(6, cliente.getCpf());
            stmt.setString(7, cliente.getRg());
            stmt.setDate(8, (Date) cliente.getDataNasc());
            stmt.setString(9, cliente.getTelefone());
            stmt.setString(10, cliente.getCelular());
            stmt.setString(11, cliente.getEmail());
            stmt.setString(12, cliente.getCep());
            stmt.setString(13, cliente.getCidade());
            stmt.setString(14, cliente.getUf());
            stmt.setString(15, cliente.getEndereco());
            stmt.setString(16, cliente.getEndNumero());
            stmt.setString(17, cliente.getComplemento());
            stmt.setString(18, cliente.getBairro());
            stmt.setString(19, cliente.getObs());
            
            stmt.execute();
            
        }finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void excluir (Integer Id) throws SQLException, Exception {
        PreparedStatement stmt = null;
        
        String sql = "UPDATE cliente SET disable=? WHERE (cliente_id =?) ";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setBoolean(1, true);
            stmt.setInt(2,  Id);
        }finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
        
    }
    
    public static void atualizar (Cliente cliente) throws SQLException, Exception {
        String sql = "UPDATE cliente SET id=?, codCliente=?, dataCadastro=?, nome=?, sexo=?, cpf=?, rg=?, dataNasc=?, telefone=?, "
                + "celular=?, email=?, cep=?, cidade=?, uf=?, endereco=?, endNumero=?, complemento=?, bairro=?, obs=? "
                + "WHERE (cliente_id=?)";
    }
}
