
package comercial.rnegocio.vistas;
import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import comercial.rnegocio.entidades.*;
import comercial.rnegocio.dao.*;
import comercial.rnegocio.impl.*;

public class ListaCompra extends JInternalFrame{

    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    
    public ListaCompra() {
      this.setSize(800,600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo=new JLabel("Listado de Compras");
        tabla=new JTable();
        jscTabla=new JScrollPane(tabla);
        
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();  
    }
    public void cargarTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("Cliente");
//      
        modelo.addColumn("Producto");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");
        
        List<Compra> lista =new ArrayList<>();
        try {
            ICompra compraDao = new CompraImpl();
            lista=compraDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Compra c : lista){
        modelo.addRow(new Object[]{ c.getCliente(),
        c.getProducto(),c.getDescripcion(),c.getPrecio()});
        }
        tabla.setModel(modelo);
    }
    
}
