/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author aayan
 */
public class Venda {

    private int id;
    private int codVenda;
    //Vai ter um vendedor??????????
    private String vendedor;
    private Date dataVenda;
    private Cliente cliente;
    private List<Produto> listaProdutos;
    private double valorTotal;

    //Construtor
    /*Teoricamente tem que ter um metodo que ja gera o id
    baseado na posicao do banco de dados
    Mas por enquanto deixarei assim*/
    public Venda(int id) {
        this.id = id;
    }

    //Metodos
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

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
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

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
