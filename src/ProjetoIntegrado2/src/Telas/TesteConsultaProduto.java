/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;
import Model.Produto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TesteConsultaProduto {
    
static List<Produto> cadastraProduto(){
//    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//    Date data= new Date(System.currentTimeMillis());
ArrayList<Produto> listaProduto = new ArrayList<Produto>();
    Produto p;
    String str = "AAA";
    String tipo = "jogo";
    Random rd = new Random(100+1);
    int n=0;
    
    while(n<=5){
        p=new Produto();
        p.setCodProduto(n+1);
        p.setNome(str+(n+1));
        p.setFornecedor(str+(n+3));
        p.setTipo(tipo);
        p.setQuantidadeEstoque(10);
        p.setPreco(100.00f);
        listaProduto.add(p);
        n++;
             
    }
    return listaProduto;
}
/**
 *
 * @author Marcelo Pereira <marcelo.pereira@rerum.com.br>
 */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Produto> lista = cadastraProduto();
        Integer codigo =null;
        String nome= null;
        String tipo = null;
        String fornecedor =null;
        
        for(Produto p: lista){
            System.out.println("Codigo: "+ p.getCodProduto() + "| Nome: " + p.getNome() + " | Fornecedor: " + p.getFornecedor()
            + " | Tipo: "+ p.getTipo() + " | Qtd: " + p.getQuantidadeEstoque() + " | Valor: " + p.getPreco());
        }
        System.out.println("Informe o nome do produto: ");
        nome=sc.nextLine();
        
        
        
        for(Produto p : lista){
            if(nome!=null){
            if(p.getNome().toUpperCase().contains(nome.toUpperCase()) && !nome.isEmpty()){
                System.out.println("Codigo: "+ p.getCodProduto() + "| Nome: " + p.getNome() + " | Fornecedor: " + p.getFornecedor()
            + " | Tipo: "+ p.getTipo() + " | Qtd: " + p.getQuantidadeEstoque() + " | Valor: " + p.getPreco());
            }
            }else if(p.getCodProduto()==codigo && codigo!=null){
                System.out.println("Codigo: "+ p.getCodProduto() + "| Nome: " + p.getNome() + " | Fornecedor: " + p.getFornecedor()
            + " | Tipo: "+ p.getTipo() + " | Qtd: " + p.getQuantidadeEstoque() + " | Valor: " + p.getPreco());
            }
        }
    }
    
}
