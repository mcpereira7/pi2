/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Model;

import java.util.Calendar;
import java.sql.Date;

/**
 *
 * @author aayan
 */
public class Produto {

    //Atributos
    private int id; //id do banco de dados, preferencialmente automatico
    private int codProduto; //id que vai aparecer para o usuário, tbm automático
    private float preco;
    private Date dataCadastro;
    private String nome;
    private String plataforma;
    private String fornecedor;
    private String descricao;
    private String tipo;
    private int quantidadeVenda;
    private int quantidadeEstoque;//Se precisar

    //Construtor
    //Venda de produtos
    public int Venda(int quantidadeVenda) {
        if (quantidadeEstoque > 0) {
            quantidadeEstoque -= quantidadeVenda;
        }
        return quantidadeEstoque;
    }

    //Metodos
    public int getId() { //Banco de dados, não será usado.
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public void setQuantidadeVenda(int quantidadeVenda) {
        this.quantidadeVenda = quantidadeVenda;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
