
package comercial.rnegocio.vistas;
import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import comercial.rnegocio.entidades.*;
import comercial.rnegocio.dao.*;
import comercial.rnegocio.impl.*;

public class ListaCliente extends JInternalFrame{

    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;
    public ListaCliente() {
      this.setSize(800,600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo=new JLabel("Listado de Clientes");
        tabla=new JTable();
        jscTabla=new JScrollPane(tabla);
        
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(jscTabla, BorderLayout.CENTER);
        cargarTabla();  
    }
    public void cargarTabla(){
        modelo=new DefaultTableModel();
        modelo.addColumn("Codigo");
//        modelo.addColumn("Cedula");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Telefono");
        
        List<Cliente> lista =new ArrayList<>();
        try {
            ICliente clienteDao = new ClienteImpl();
            lista=clienteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Cliente cli : lista){
        modelo.addRow(new Object[]{ cli.getCodigoc(),
        cli.getNombre(),cli.getApellido(),cli.getTelefono()});
        }
        tabla.setModel(modelo);
    }
    
}
