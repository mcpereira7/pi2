/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connection.ConnectionFactory;
import java.sql.Connection;

/**
 *
 * @author Red
 */
public class ProdutoDAO {

    private static Connection cn = null;

    public ProdutoDAO() {
        cn = ConnectionFactory.getConnection();
    }
    
    
}
