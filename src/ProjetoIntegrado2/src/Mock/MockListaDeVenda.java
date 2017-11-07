/*
 * Andre de Amorim Yamamoto
 * aay.andre@outlook.com
 * Turma A
 */
package Mock;

import Model.Cliente;
import Model.Venda;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author aayan
 */
public class MockListaDeVenda {

    //Atributos
    private static List<Venda> listaDeVendas = new ArrayList<Venda>();

    private static int totalDeVendas = 0;

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

    public static List<Venda> getVenda(String vendedor)
            throws Exception {

        List<Venda> resultado = new ArrayList<>();

        if (vendedor != null) {
            for (Venda venda : listaDeVendas) {
                if (venda != null && venda.getVendedor() != null) {
                    if (vendedor.toUpperCase().equals(venda.getVendedor().toUpperCase())) {
                        resultado.add(venda);
                    }
                }
            }
        }

        return resultado;
    }

    public static Venda getVenda(Calendar data)
            throws Exception {

        for (Venda Venda : listaDeVendas) {
            if (Venda.getDataVenda() == data) {
                return Venda;
            }
        }
        return null;
    }

    public static List<Venda> getVenda(Calendar de, Calendar ate)
            throws Exception {

        List<Venda> resultado = new ArrayList<>();
        Calendar agora = Calendar.getInstance();

        if (!de.after(agora) || !ate.after(agora)) {

            for (Venda venda : listaDeVendas) {
                if (venda.getDataVenda().after(de) && venda.getDataVenda().before(ate)){
                    resultado.add(venda);
                }
            }
            de.add(Calendar.DATE, 1);
        }

        return resultado;
    }

    public static List<Venda> getVenda(Cliente cliente)
            throws Exception {
        return null;
    }
}
