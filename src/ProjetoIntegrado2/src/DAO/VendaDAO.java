/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package DAO;

import Model.ItensVenda;
import Model.Venda;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author aayan
 */
public class VendaDAO {

    private static Connection cn = null;

    public VendaDAO() {
        cn = ConnectionFactory.getConnection();
    }

    public static void inserir(Venda venda)
            throws SQLException, Exception {

        PreparedStatement stmt = null;

        String sql = "INSERT INTO vendas (idCliente, ValorTotal)"
                + "VALUES (?, ?)";

        cn = ConnectionFactory.getConnection();

        try {
            
            int idCliente = ClienteDAO.obterByCod(venda.getCliente().getCodCliente()).getId();
            
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            stmt.setFloat(2, venda.getValorTotal());

            stmt.execute();

        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static int countVendas()
            throws SQLException, Exception {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT COUNT(id) AS quantidade FROM vendas";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();

            int quantidade = rs.getInt("quantidade");

            return quantidade;

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
    }

    public static List<Venda> listar()
            throws SQLException, Exception {

        List<Venda> resultado = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM vendas";

        cn = ConnectionFactory.getConnection();

        try {

            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();

                //venda.setCodVenda(rs.getInt("id"));
                venda.setDataVenda(rs.getDate("Data"));
                venda.setValorTotal(rs.getFloat("ValorTotal"));

                resultado.add(venda);
            }

            return resultado;

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
    }

//    public static Venda getVendaByCod(int codVenda)
//            throws SQLException, Exception {
//
//        ResultSet rs = null;
//        PreparedStatement stmt = null;
//
//        Venda venda = new Venda();
//
//        String sql = "SELECT * FROM vendas WHERE id = ?";
//
//        cn = ConnectionFactory.getConnection();
//
//        try {
//
//            //Prepara ou cria um objeto adaptado para o SQL
//            stmt = cn.prepareStatement(sql);
//
//            /*
//            Adiciona o codVenda ao objeto criado acima, preenchendo o ? da
//            string com a posicao inserida
//             */
//            stmt.setInt(1, codVenda);
//
//            rs = stmt.executeQuery();
//
//            venda.setCodVenda(rs.getInt("id"));
//            venda.setDataVenda(toCalendar(rs.getDate("Data")));
//            venda.setValorTotal(rs.getDouble("ValorTotal"));
//
//        } finally {
//            ConnectionFactory.closeConnection(cn, stmt, rs);
//        }
//
//        return venda;
//    }

    //Pode retornar uma lista. Talvez esteja ERRADO
//    public static Venda getVendaByData(Calendar data)
//            throws SQLException, Exception {
//
//        ResultSet rs = null;
//        PreparedStatement stmt = null;
//
//        Venda venda = new Venda();
//
//        String sql = "SELECT * FROM vendas WHERE Data = '?'";
//
//        cn = ConnectionFactory.getConnection();
//
//        try {
//
//            stmt = cn.prepareStatement(sql);
//
//            stmt.setDate(1, (Date) data.getTime());
//
//            rs = stmt.executeQuery();
//
//            venda.setCodVenda(rs.getInt("id"));
//            venda.setDataVenda(toCalendar(rs.getDate("Data")));
//            venda.setValorTotal(rs.getDouble("ValorTotal"));
//
//        } finally {
//            ConnectionFactory.closeConnection(cn, stmt, rs);
//        }
//
//        return venda;
//    }

    public static List<Venda> getVendaByDates(Date de, Date para)
            throws SQLException, Exception {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Venda> resultado = new ArrayList<>();

        String sql = "SELECT * FROM vendas WHERE Data BETWEEN '?' AND '?'";

        cn = ConnectionFactory.getConnection();

        try {

            stmt = cn.prepareStatement(sql);

            stmt.setDate(1, (java.sql.Date) de);
            stmt.setDate(2, (java.sql.Date) para);

            rs = stmt.executeQuery();

            while (rs.next()) {
                //Construtor adaptado
                Venda venda = new Venda(rs);
                resultado.add(venda);
            }

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }

        return resultado;
    }

    public static List<Venda> getVendaRelatorio(Date de, Date ate, String campoOrdenacao, boolean ASC)
            throws SQLException, Exception {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Venda> resultado = new ArrayList<>();

        String sql = "SELECT * FROM vendas WHERE Data BETWEEN ? AND ? ORDER BY ? ?";

        cn = ConnectionFactory.getConnection();

        try {
            
            stmt = cn.prepareStatement(sql);

            stmt.setDate(1, new java.sql.Date(de.getTime()));
            stmt.setDate(2, new java.sql.Date(ate.getTime()));
            stmt.setString(3, campoOrdenacao);
            stmt.setString(4, ASC ? "ASC" : "DESC");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda(rs);
                resultado.add(venda);
            }

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }

        return resultado;
    }

    public static List<ItensVenda> getItensVenda(int idVenda) throws SQLException, Exception {
        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<ItensVenda> ItensVenda = new ArrayList<>();

        String sql = "SELECT * FROM ItensVenda WHERE idVenda = ?";

        cn = ConnectionFactory.getConnection();

        try {

            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, idVenda);

            rs = stmt.executeQuery();

            while (rs.next()) {
                ItensVenda itemVenda = new ItensVenda();

                itemVenda.setCodProduto(rs.getInt("codProduto"));
                itemVenda.setNome(rs.getString("nome"));
                itemVenda.setPreco(rs.getFloat("preco"));
                itemVenda.setQuantidade(rs.getInt("quantidade"));
                ItensVenda.add(itemVenda);
            }

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return ItensVenda;
    }

    public static Calendar toCalendar(Date data) {
        Calendar dataCal = Calendar.getInstance();
        dataCal.setTime(data);
        return dataCal;
    }
}
