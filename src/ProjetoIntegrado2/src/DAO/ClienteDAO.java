package DAO;

import Model.Cliente;
import java.sql.SQLException;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static void atualizar(Cliente cliente) throws SQLException, Exception {
        PreparedStatement stmt = null;

        //id=?, codCliente=?, dataCadastro=?,
        String sql = "UPDATE cliente SET nome=?, sexo=?, cpf=?, rg=?, dataNasc=?, telefone=?, "
                + "celular=?, email=?, cep=?, cidade=?, uf=?, endereco=?, endNumero=?, complemento=?, bairro=?, obs=? "
                + "WHERE (cliente_id=?)";

        try {
            stmt = cn.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSexo());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getRg());
            stmt.setDate(5, (Date) cliente.getDataNasc());
            stmt.setString(6, cliente.getTelefone());
            stmt.setString(7, cliente.getCelular());
            stmt.setString(8, cliente.getEmail());
            stmt.setString(9, cliente.getCidade());
            stmt.setString(10, cliente.getUf());
            stmt.setString(11, cliente.getEndereco());
            stmt.setString(12, cliente.getEndNumero());
            stmt.setString(13, cliente.getComplemento());
            stmt.setString(14, cliente.getBairro());
            stmt.setString(15, cliente.getObs());
            stmt.setInt(15, cliente.getId());

            stmt.execute();
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static void excluir(Integer Id) throws SQLException, Exception {
        PreparedStatement stmt = null;

        String sql = "UPDATE cliente SET disable=? WHERE (cliente_id =?) ";

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setBoolean(1, true);
            stmt.setInt(2, Id);
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }

    }

    public static List<Cliente> listar() throws SQLException, Exception {
        List<Cliente> listaClientes = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        String sql = "SELECT * FROM ciente where disable = ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setBoolean(0, false);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setCodCliente(rs.getInt("codCliente"));
                cliente.setDataCadastro(new Date(rs.getTimestamp("dataCadastro").getTime()));
                cliente.setNome(rs.getString("nome"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDataNasc(new Date(rs.getTimestamp("dataNasc").getTime()));
                cliente.setTelefone(rs.getString("Telefone"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setCep(rs.getString("cep"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUf(rs.getString("uf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setEndNumero(rs.getString("endNumero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setObs(rs.getString("obs"));
                
                listaClientes.add(cliente);
            }
            
        } finally {
            ConnectionFactory.closeConnection(cn,stmt,rs);
        }
        return listaClientes;
    }
    
    public static List<Cliente> procurar(Integer cod, String nome) throws SQLException, Exception{
        List<Cliente> listaClientes = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        //Removi o ( = LIKE) porque não ta certo e coloquei um '' ali no LIKE UPPER acho que pode precisar. ACHO
        String sql = "SELECT * FROM cliente WHERE (codCliente = ? OR UPPER(nome) LIKE UPPER('?')) AND disable = ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(0, cod);
            stmt.setString(1, "%" + nome + "%");
            stmt.setBoolean(2, false);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setCodCliente(rs.getInt("codCliente"));
                cliente.setDataCadastro(new Date(rs.getTimestamp("dataCadastro").getTime()));
                cliente.setNome(rs.getString("nome"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDataNasc(new Date(rs.getTimestamp("dataNasc").getTime()));
                cliente.setTelefone(rs.getString("Telefone"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setCep(rs.getString("cep"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUf(rs.getString("uf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setEndNumero(rs.getString("endNumero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setObs(rs.getString("obs"));
                
                listaClientes.add(cliente);
            }
            
        } finally{
            ConnectionFactory.closeConnection(cn,stmt,rs);
        }
        return listaClientes;
    }
    
    public static Cliente obter (Integer id)
            throws SQLException, Exception {
        
        String sql = "SELECT * FROM cliente WHERE id = ? AND disable = ?";
        
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        try {
            
            stmt = cn.prepareStatement(sql);
            
            stmt.setInt(0, id);
            stmt.setBoolean(1, false);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                Cliente cliente = new Cliente ();
                
                cliente.setId(rs.getInt("id"));
                cliente.setCodCliente(rs.getInt("codCliente"));
                cliente.setDataCadastro(new Date(rs.getTimestamp("dataCadastro").getTime()));
                cliente.setNome(rs.getString("nome"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDataNasc(new Date(rs.getTimestamp("dataNasc").getTime()));
                cliente.setTelefone(rs.getString("Telefone"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setCep(rs.getString("cep"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUf(rs.getString("uf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setEndNumero(rs.getString("endNumero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setObs(rs.getString("obs"));
                
                return cliente;
            }
            
        } finally{
            ConnectionFactory.closeConnection(cn,stmt,rs);
        }
        
        
        return null;
    }
    
    public static Cliente obterByCod (Integer codCliente)
            throws SQLException, Exception {
        
        String sql = "SELECT * FROM cliente WHERE codCliente = ? AND disable = ?";
        
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        try {
            
            stmt = cn.prepareStatement(sql);
            
            stmt.setInt(0, codCliente);
            stmt.setBoolean(1, false);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                Cliente cliente = new Cliente ();
                
                cliente.setId(rs.getInt("id"));
                cliente.setCodCliente(rs.getInt("codCliente"));
                cliente.setDataCadastro(new Date(rs.getTimestamp("dataCadastro").getTime()));
                cliente.setNome(rs.getString("nome"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDataNasc(new Date(rs.getTimestamp("dataNasc").getTime()));
                cliente.setTelefone(rs.getString("Telefone"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setCep(rs.getString("cep"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUf(rs.getString("uf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setEndNumero(rs.getString("endNumero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setObs(rs.getString("obs"));
                
                return cliente;
            }
            
        } finally{
            ConnectionFactory.closeConnection(cn,stmt,rs);
        }
        
        
        return null;
    }
}
