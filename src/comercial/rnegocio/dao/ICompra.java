
package comercial.rnegocio.dao;
import comercial.rnegocio.entidades.*;
import java.util.*;

public interface ICompra {
    
     public int insertar (Compra cliente) throws Exception;
    public Compra obtener(String codigo) throws Exception;
     public ArrayList<Compra> obtener () throws Exception;
}
