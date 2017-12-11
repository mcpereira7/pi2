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
import java.sql.Timestamp;
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

    public static int getLastVendaID()
            throws SQLException, Exception {
        ResultSet rs = null;
        PreparedStatement stmt = null;

        int id = -1;

        String sql = "SELECT Id Ultimo FROM vendas WHERE Data = (SELECT MAX(Data) FROM vendas)";

        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt("Ultimo");
            }

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }

        return id;
    }

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

            Timestamp t = new Timestamp(de.getTime());
            Timestamp t2 = new Timestamp(ate.getTime());

            stmt.setTimestamp(1, t);
            stmt.setTimestamp(2, t2);
            stmt.setString(3, campoOrdenacao);
            stmt.setString(4, ASC ? "ASC" : "DESC");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getInt("Id"));
                venda.setDataVenda(rs.getDate("Data"));
                venda.setCliente(DAO.ClienteDAO.obter(rs.getInt("idCliente")));
                venda.setListaItensVenda(DAO.VendaDAO.getItensVenda(rs.getInt("id")));
                venda.setValorTotal(rs.getFloat("ValorTotal"));

                resultado.add(venda);
            }

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }

        return resultado;
    }

    public static void insertItensVenda(List<ItensVenda> listaItens, int idVenda)
            throws SQLException, Exception {

        PreparedStatement stmt = null;

        String sql = "INSERT INTO ItensVenda (idVenda, idProduto, Quantidade, Valor)"
                + "VALUES (?, ?, ?, ?)";

        cn = ConnectionFactory.getConnection();

        try {

            for (ItensVenda itensVenda : listaItens) {

                stmt = cn.prepareStatement(sql);
                stmt.setInt(1, idVenda);
                stmt.setInt(2, itensVenda.getCodProduto());
                stmt.setInt(3, itensVenda.getQuantidade());
                stmt.setFloat(4, (float) itensVenda.getPreco());

                stmt.execute();
            }
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }

    }

    public static List<ItensVenda> getItensVenda(int idVenda)
            throws SQLException, Exception {
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

                itemVenda.setCodProduto(rs.getInt("idProduto"));
                itemVenda.setPreco(rs.getFloat("valor"));
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
