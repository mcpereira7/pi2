/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Mock;

import Model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aayan
 */
public class MockListaDeProduto {

    private static int totalProdutos = 0;

    public static List<Produto> listaProdutos = new ArrayList<Produto>();

    public static void adicionar(Produto p) throws Exception {
        listaProdutos.add(p);
        p.setId(totalProdutos++);
    }

    public static List<Produto> listar() throws Exception {
        return listaProdutos;
    }

    // Consulta produto
    public static List<Produto> ListarProduto(Integer codigo, String nome, String tipo, String fornecedor) throws Exception {

        try {
            if (codigo != null || nome != null || tipo != null || fornecedor != null) {
                for (Produto produto : listaProdutos) {
                    if ((produto.getCodProduto() == codigo) || (produto.getNome().toUpperCase().contains(nome.toUpperCase()))
                            || (produto.getTipo().equalsIgnoreCase(tipo)) || (produto.getFornecedor().equalsIgnoreCase(fornecedor))) {
                        listaProdutos.add(produto);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        try {
//            if (codigo != null) {
//                for (Produto pc : listaProdutos) {
//                    if (pc.getCodProduto() == codigo) {
//                        listaDeProduto.add(pc);
//                    }
//                }
//                if (nome != null) {
//                    for (Produto pn : listaProdutos) {
//                        if (pn.getNome().equalsIgnoreCase(nome)) {
//                            listaDeProduto.add(pn);
//                        }
//                    }
//                }
//                if (tipo != null) {
//                    for (Produto pt : listaProdutos) {
//                        if (pt.getTipo().equalsIgnoreCase(tipo)) {
//                            listaDeProduto.add(pt);
//                        }
//                    }
//                }
//                if (fornecedor != null) {
//                    for (Produto pf : listaProdutos) {
//                        if (pf.getFornecedor().equalsIgnoreCase(fornecedor)) {
//                            listaDeProduto.add(pf);
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        return listaProdutos;
        
    }

}
