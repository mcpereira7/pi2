/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aayan
 */
public class Venda {

    private int id;
    private int codVenda;
    private Date dataVenda;
    private Cliente cliente;
    private List<ItensVenda> itensVenda = new ArrayList<>();
    private float valorTotal;

    //Construtor
    /*Teoricamente tem que ter um metodo que ja gera o id
    baseado na posicao do banco de dados
    Mas por enquanto deixarei assim*/
    public Venda() {
    }

    //Construtor para preencher a venda com um ResultSet
    public Venda(ResultSet rs) throws SQLException, Exception {
        codVenda = rs.getInt("id");
        dataVenda = rs.getDate("Data");
        cliente = DAO.ClienteDAO.obter(rs.getInt("idCliente"));
        itensVenda = DAO.VendaDAO.getItensVenda(rs.getInt("idVenda"));
        valorTotal = rs.getFloat("ValorTotal");
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

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
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

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

}
