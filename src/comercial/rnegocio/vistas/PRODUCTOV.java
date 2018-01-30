package comercial.rnegocio.vistas;
import comercial.accesodatos.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import comercial.rnegocio.dao.*;
import comercial.rnegocio.impl.*;
import comercial.rnegocio.entidades.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class PRODUCTOV extends JInternalFrame{
    JLabel lblCodigo;
    JLabel lblNombre;    
    JLabel lblTitulo0;
    
    JTextField txtCodigo;
    JTextField txtNombre; 
    
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public PRODUCTOV() {
        this.setSize(200, 200);
        this.setLayout(new BorderLayout());
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(2, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Producto");
        
        lblCodigo= new JLabel("Código:");
        lblNombre= new JLabel("Nombre:");
        
        txtCodigo = new JTextField(2);
        txtNombre= new JTextField(2);        
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);        
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);
        this.setClosable(true);
    }
    public static void main(String[] args) {
        PRODUCTOV pro= new PRODUCTOV();
        pro.setVisible(true);
    } 
    public void btnAceptarActionListener(ActionEvent e){
        try {
            Producto producto = new Producto();
            producto.setCodigop(txtCodigo.getText());
            producto.setNombre(txtNombre.getText());
            IProducto productoDao = new ProductoImpl();
            if(productoDao.insertar(producto)>0 ){
                JOptionPane.showMessageDialog(this,"Registrado correctamente!!",
                "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error desconocido: "+ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
}
 
 