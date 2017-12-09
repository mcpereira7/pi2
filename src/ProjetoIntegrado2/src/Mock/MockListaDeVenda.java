
/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Mock;

import Model.Cliente;
import Model.Venda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aayan
 */
public class MockListaDeVenda {

    //Atributos
    private static List<Venda> listaDeVendas = new ArrayList<Venda>();

    private static int totalDeVendas = 0;

    //Metodos
    public static void inserirVenda(Venda novaVenda)
            throws Exception {
        //ID do "banco", nunca mostramos
        novaVenda.setId(totalDeVendas++);
        //Adicionando
        listaDeVendas.add(novaVenda);
    }

    public static List<Venda> listar()
            throws Exception {
        return listaDeVendas;
    }

    public static List<Venda> getVenda(int codVenda)
            throws Exception {

        List<Venda> resultado = new ArrayList<>();

        if (codVenda > 0) {
            for (Venda venda : listaDeVendas) {
                if (venda != null && venda.getCodVenda() > 0) {
                    if (venda.getCodVenda() == codVenda) {
                        resultado.add(venda);
                    }
                }
            }
        }

        return resultado;
    }

    public static Venda getVenda(Date data)
            throws Exception {

        for (Venda Venda : listaDeVendas) {
            if (Venda.getDataVenda() == data) {
                return Venda;
            }
        }
        return null;
    }

//    public static List<Venda> getVenda(Date de, Date ate)
//            throws Exception {
//
//        List<Venda> resultado = new ArrayList<>();
//        Date agora = Date.getInstance();
//
//        if (!de.after(agora) || !ate.after(agora)) {
//
//            for (Venda venda : listaDeVendas) {
//                if ((venda.getDataVenda().compareTo(de) == 0 || venda.getDataVenda().compareTo(de) >= 1)
//                        && (venda.getDataVenda().compareTo(de) == 0 || venda.getDataVenda().compareTo(de) >= 1)) {
//                    resultado.add(venda);
//                }
//            }
//            de.add(Calendar.DATE, 1);
//        }
//
//        return resultado;
//    }

    public static List<Venda> getVenda(Cliente cliente)
            throws Exception {

        List<Venda> resultado = new ArrayList<>();

        for (Venda venda : listaDeVendas) {
            if (venda.getCliente() == cliente) {
                resultado.add(venda);
            }
        }
        return resultado;
    }
}
