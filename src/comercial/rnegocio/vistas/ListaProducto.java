package comercial.rnegocio.vistas;
import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import comercial.rnegocio.entidades.*;
import comercial.rnegocio.dao.*;
import comercial.rnegocio.impl.*;

public class ListaProducto extends JInternalFrame{

    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public ListaProducto() {
      this.setSize(800,600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo=new JLabel("Listado de Productos");
        tabla=new JTable();
        jscTabla=new JScrollPane(tabla);
        
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();  
    }
    public void cargarTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");        
        
        List<Producto> lista =new ArrayList<>();
        try {
            IProducto productoDao = new ProductoImpl();
            lista=productoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Producto p : lista){
        modelo.addRow(new Object[]{ p.getCodigop(), p.getNombre()});
        }
        tabla.setModel(modelo);
    }    
}
