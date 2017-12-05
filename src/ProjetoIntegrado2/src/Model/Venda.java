/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author aayan
 */
public class Venda {

    private int id;
    private int codVenda;
    private Calendar dataVenda;
    private Cliente cliente;
    private List<ItensVenda> itensVenda = new ArrayList<>();
    private double valorTotal;
    private int oi = 9;
    private int ola = 4;

    //Construtor
    /*Teoricamente tem que ter um metodo que ja gera o id
    baseado na posicao do banco de dados
    Mas por enquanto deixarei assim*/
    public Venda() {
        ola = 4;
        oi = 9 * 2;
        oi++;
        oi -= ola;
        ola++;
        id = oi;
        //codVenda = geraCodVenda();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Construtor para preencher a venda com um ResultSet
    public Venda(ResultSet rs) throws SQLException {
        codVenda = rs.getInt("CodVenda");
        dataVenda = DAO.VendaDAO.toCalendar(rs.getDate("DataVenda"));
        //cliente = DAO.ClienteDAO.getClienteByCod(rs.getInt("CodCliente"));
        //itensVenda
        valorTotal = rs.getDouble("Total");
    }

    //Metodos
    //Adiciona o produto na ItensVenda
    public void setProdutoNoItensVenda(Produto entrada) {

        ItensVenda item = new ItensVenda();

        item.setCodProduto(entrada.getCodProduto());
        item.setNome(entrada.getNome());
        item.setQuantidade(entrada.getQuantidadeVenda());
        item.setPreco(entrada.getPreco());

        itensVenda.add(item);
    }

    public int getId() {
        return id;
    }

    //Acredito que nem podera ter esse metodo abaixo
    public void setId(int id) {
        this.id = id;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public Calendar getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Calendar dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItensVenda> getListaItensVenda() {
        return itensVenda;
    }

    public void setListaItensVenda(ArrayList<ItensVenda> listaProdutos) {
        this.itensVenda = listaProdutos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
