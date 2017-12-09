/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.productException;
import Model.Produto;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Red
 */
public class ProdutoDAO {

    private static Connection cn = null;

    public static void inserir(Produto produto) throws SQLException, Exception {
        cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "INSERT INTO produto(Codigo, Nome, Quantidade, Tipo, Plataforma, Preco, Fornecedor, Descricao) "
                + " VALUES(?,?,?,?,?,?,?,?)";

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, produto.getCodProduto());
            stmt.setString(2, produto.getNome());
            stmt.setInt(3, produto.getQuantidadeEstoque());
            stmt.setString(4, produto.getTipo());
            stmt.setString(5, produto.getPlataforma());
            stmt.setFloat(6, produto.getPreco());
            stmt.setString(7, produto.getFornecedor());
            stmt.setString(8, produto.getDescricao());
            stmt.execute();

        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }

    }

    public static List<Produto> listarProduto() throws SQLException, Exception {
//        abrindo a conexão com o banco
        cn = ConnectionFactory.getConnection();

        // Arraylist que recebe a lista de produtos
        List<Produto> listap = new ArrayList<Produto>();

        // Objetos Resulset e STM
        ResultSet rs = null;
        PreparedStatement stm = null;

        Produto p = null;

        // String de comando SQL
        String sql = "SELECT * FROM produto";

        try {
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                p = new Produto();
                p.setId(rs.getInt(1));
                p.setCodProduto(rs.getInt(2));
                p.setNome(rs.getString(3));
                p.setQuantidadeEstoque(rs.getInt(4));
                p.setTipo(rs.getString(5));
                p.setPlataforma(rs.getString(6));
                p.setPreco(rs.getFloat(7));
                p.setDescricao(rs.getString(8));
                listap.add(p);
            }
        } finally {
        }

        return listap;
    }

    public static List<Produto> procurarProduto(Integer codigo, String nome, String fornecedor, String tipo) throws SQLException, productException {
        List<Produto> listProduto = new ArrayList<Produto>();
        cn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = " SELECT  * FROM produto WHERE (Codigo = ? OR UPPER(Nome) LIKE UPPER(?) OR UPPER(Fornecedor) LIKE UPPER(?) OR UPPER(Tipo) LIKE UPPER(?))";

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.setString(2, "'%" + nome + "%'");
            stmt.setString(3, "'%" + fornecedor + "%'");
            stmt.setString(4, "'%" + tipo + "%'");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("Id"));
                p.setCodProduto(rs.getInt("Codigo"));
                p.setNome(rs.getString("Nome"));
                p.setQuantidadeEstoque(rs.getInt("Quantidade"));
                p.setTipo(rs.getString("Tipo"));
                p.setPlataforma(rs.getString("Plataforma"));
                p.setPreco(rs.getFloat("Preco"));
                p.setFornecedor(rs.getString("Fornecedor"));
                p.setDescricao(rs.getString("Descricao"));
                p.setDataCadastro(rs.getDate("DataCadastro"));
                listProduto.add(p);
            }
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }

        return listProduto;
    }

//    Validação do produto a ser gravado na base.
    public static void validaProduto(Produto produto) throws productException {
        if (produto == null) {
            throw new productException("Não foi informado produto.");
        }

        if (produto.getDescricao().equalsIgnoreCase(null)) {
            throw new productException("Descrição inválida.");
        }

        if (produto.getNome().equalsIgnoreCase(null)) {
            throw new productException("Nome inválido");
        }

        if (produto.getPlataforma().contentEquals("Escolha") && produto.getTipo().contentEquals("Jogo")) {
            throw new productException("Não foi informado uma plataforma para o produto. Escolha uma das opções.");
        }

        if (produto.getPreco() <= 5.00) {
            throw new productException("Preço inválido.");
        }

        if (produto.getQuantidadeEstoque() <= 0) {
            throw new productException("Quantidade inválida, informe a quantidade em estoque.");
        }

        if (produto.getTipo().contentEquals("Escolha")) {
            throw new productException("Tipo de produto inválido, selecione uma das opções");
        }

    }

    public static void atualizarQuantidadeEstoque(int CodProduto, int quantidade) throws SQLException, Exception {

        cn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "UPDATE produto SET quantidade = ? WHERE Codigo = ?";

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, quantidade);
            stmt.setInt(2, CodProduto);
            stmt.execute();

        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }

    }

}
