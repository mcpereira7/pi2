package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataHoje {
    
    private Date data = new Date(System.currentTimeMillis());
    private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    public String getDataAtual(){
        return df.format(data);
    }
}
