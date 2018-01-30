
package comercial;
import comercial.rnegocio.impl.*;
import comercial.rnegocio.dao.*;
import comercial.rnegocio.entidades.*;
import comercial.accesodatos.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.*;
import java.util.*;


public class Compratest {
    
    public Compratest() {
    }
    
   @Test
    public void testGeneral(){
        ICompra comprDao=new CompraImpl();
////////        TEST INSERTAR
        int nfilas=0;
        Cliente cliente=new Cliente("1", "DANIEL", "CANDO", "2358974125");
        Producto producto=new Producto("1", "galletas.");
        Compra comp=new Compra(cliente, producto, "consumo", "15");
        try {
            nfilas=comprDao.insertar(comp);
            System.out.println("Filas insertadas: "+nfilas);
        } catch (Exception e) {
              System.out.println("Error: " + e.getMessage());
        }
        assertEquals(nfilas>0, true);
    
    
    
//    
//      //TEST LISTADO
//        
        ArrayList<Compra> tratamientos=new ArrayList<>();
        try {
            tratamientos=comprDao.obtener();
            for(Compra tra:tratamientos){
                System.out.println(tra.getCliente().getCodigoc()+"   "+tra.getProducto().getCodigop()+"   "+tra.getDescripcion()+"   "+tra.getPrecio());
            }
        } catch (Exception e) {
        }
        assertEquals(tratamientos!=null, true);
    }
    
}
