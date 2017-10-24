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
    private static ArrayList<Venda> vendas;
    
    //Construtor
    public MockListaDeVenda() {
    }
    
    public List<Venda> getVendaByCod(int codVenda) {
        
        List<Venda> resultado = new ArrayList<>();
        
        if(codVenda > 0) {
            for (Venda venda : vendas) {
                if(venda != null && venda.getCodVenda() > 0) {
                   if(venda.getCodVenda() == codVenda) {
                       resultado.add(venda);
                   }
                }
            }
        }
        
        return resultado;
    }
    
    public List<Venda> getVendaByVendedor(String vendedor) {
        
        List<Venda> resultado = new ArrayList<>();
        
        if(vendedor != null) {
            for (Venda venda : vendas) {
                if(venda != null && venda.getVendedor() != null) {
                    if(vendedor.toUpperCase().equals(venda.getVendedor().toUpperCase())) {
                        resultado.add(venda);
                    }
                }
            }
        }
        
        return resultado;
    }
    
    public List<Venda> getVendaByData(Calendar de, Calendar ate) {
        
        List<Venda> resultado = new ArrayList<>();
        Calendar agora = Calendar.getInstance();
        
        if(!de.after(agora) || !ate.after(agora)) {
            
        }
        
        return resultado;
    }
    
    public List<Venda> getVendaByCliente(Cliente cliente) {
        return null;
    }
}
