/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Model;

import java.util.Calendar;

/**
 *
 * @author aayan
 */
public class Produto {

    //Atributos
    private int id; //id do banco de dados, preferencialmente automatico
    private int codProduto; //id que vai aparecer para o usuário, tbm automático
    private float preco;
    private Calendar dataCadastro;
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

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
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

    /// métodos para código de produto
    public static String CodigoFornecedor(Produto p) {
        String abc;
        String cba = p.getFornecedor();

        switch (cba.charAt(0)) {
            case 'A':
                abc = "1";
                break;
            case 'B':
                abc = "2";
                break;
            case 'C':
                abc = "3";
                break;
            case 'D':
                abc = "4";
                break;
            case 'E':
                abc = "5";
                break;
            case 'F':
                abc = "6";
                break;
            case 'G':
                abc = "7";
                break;
            case 'H':
                abc = "8";
                break;
            case 'I':
                abc = "9";
                break;
            case 'J':
                abc = "10";
                break;
            case 'K':
                abc = "11";
                break;
            case 'L':
                abc = "12";
                break;
            case 'M':
                abc = "13";
                break;
            case 'N':
                abc = "14";
                break;
            case 'O':
                abc = "15";
                break;
            case 'P':
                abc = "16";
                break;
            case 'Q':
                abc = "17";
                break;
            case 'R':
                abc = "18";
                break;
            case 'S':
                abc = "19";
                break;
            case 'T':
                abc = "20";
                break;
            case 'U':
                abc = "21";
                break;
            case 'V':
                abc = "22";
                break;
            case 'W':
                abc = "23";
                break;
            case 'X':
                abc = "24";
                break;
            case 'Y':
                abc = "25";
                break;
            case 'Z':
                abc = "26";
                break;
            default:
                abc = "546";
                break;
        }

        return abc;
    }

    public static String CodigoTipo(Produto p) {
        String abc;
        String tipo = p.getTipo();

        switch (tipo) {
            case "Jogos":
                abc = "1100";
                break;
            case "Periféricos":
                abc = "1200";
                break;
            case "Itens Diversos":
                abc = "1300";
                break;
            default:
                abc = "1404";
                break;
        }

        return abc;
    }

    public static String CodigoPlataforma(Produto p) {
        String abc;

        String tipo = p.getPlataforma();

        switch (tipo) {
            case "Nintendo Switch":
                abc = "1";
                break;
            case "PC":
                abc = "2";
                break;
            case "Playstation 3":
                abc = "3";
                break;
            case "Playstation 4":
                abc = "4";
                break;
            case "Xbox 360":
                abc = "5";
                break;
            case "Xbox One":
                abc = "6";
                break;
            case "Wii":
                abc = "7";
                break;
            case "Wii U":
                abc = "8";
                break;
            default:
                abc = "14";
                break;
        }
        return abc;
    }

    public static int CodigoProduto(Produto p) {
        StringBuilder codigo = new StringBuilder();
        int c = 0;

        codigo.append(p.getNome().length());
        codigo.append(CodigoFornecedor(p));
        codigo.append(CodigoTipo(p));
        codigo.append(CodigoPlataforma(p));

        c = Integer.parseInt(codigo.toString());

        return c;
    }

}
