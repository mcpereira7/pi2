/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Red
 */
public class ProdutoDAO {

    private static Connection cn = null;
    

    public ProdutoDAO() {
        cn = ConnectionFactory.getConnection();
    }

    public static List<Produto> listarProduto() throws SQLException, Exception {
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
        } finally{
        }

        return listap;
    }

}
