/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Mock;

import Model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aayan
 */
public class MockListaDeProduto {

    private static int totalProdutos = 0;

    private static List<Produto> listaProdutos = new ArrayList<Produto>();

    public static void adicionar(Produto p) throws Exception {
        p.setId(totalProdutos++);
        listaProdutos.add(p);
    }

    public static List<Produto> listar() throws Exception {
        return listaProdutos;
    }

    public static void RefreshLista(List<Produto> lista) {
        listaProdutos.clear();
        listaProdutos.addAll(lista);
    }

    public static List<Produto> procurar(Integer codigo, String nome, String tipo, String fornecedor) throws Exception{
        List<Produto> resultados = new ArrayList<Produto>();

       
            for (Produto p : listaProdutos) {
                if (codigo != null && nome != null && tipo != null && fornecedor != null && !listaProdutos.isEmpty()) {
                    if (p.getCodProduto() == codigo && p.getNome().toUpperCase().contains(nome.toUpperCase()) && p.getFornecedor().toUpperCase().contains(fornecedor.toUpperCase())
                            && p.getTipo().toUpperCase().contains(tipo.toUpperCase())) {
                        resultados.add(p);
                    }
                } else if (codigo != null) {
                    if (p.getCodProduto() == codigo) {
                        resultados.add(p);
                    }
                } else if (nome != null) {
                    if (p.getNome().toUpperCase().contains(nome.toUpperCase())) {
                        resultados.add(p);
                    }
                } else if (fornecedor != null) {
                    if (p.getFornecedor().toUpperCase().contains(fornecedor.toUpperCase())) {
                        resultados.add(p);
                    }
                } else if (tipo != null) {
                    if (p.getTipo().toUpperCase().contains(tipo.toUpperCase())) {
                        resultados.add(p);
                    }
                } else  if ((codigo == null ||codigo.equals(""))&& (nome == null || nome.equals(""))&& (tipo == null || tipo.equals(""))&& (fornecedor == null ||fornecedor.equals(""))) {
                        resultados.add(p);
                    }
            }
        
        return resultados;
    }
    
    public static Produto selecionaProduto(Integer codigo){
        for(Produto p : listaProdutos){
            if(p.getCodProduto()==codigo){
                return p;
            }
        }
        return null;
    }
}