package comercial.rnegocio.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class frmMenuPrincipal extends JFrame {

    JLabel lblTitulo;
    JLabel lblTitulo2;
    JLabel lblTitulo3;;
    JLabel lblGenero;
    JLabel lblTiutlo0;
    JTextField txtTitulo;
    JTextField txtTitulo2;
    JTextField txtTitulo3;

   JComboBox cmbGenero;
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;
    
    public frmMenuPrincipal() {
        
        this.setSize(640, 400); 
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();
        
        pnlcentral.setLayout(new GridLayout(4, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        lblTiutlo0 = new JLabel("DATOS ESTUDIANTILES");
        
        lblTitulo = new JLabel("ETIQUETA 1:");
        lblTitulo2 = new JLabel("ETIQUETA 2:");
        lblTitulo3 = new JLabel("ETIQUETA 3:");
        lblGenero = new JLabel("GENERO");
        txtTitulo = new JTextField(2);
        txtTitulo2 = new JTextField(2);
        txtTitulo3 = new JTextField(2);  
        cmbGenero = new JComboBox(new String []{"masculino","femenino"});
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(lblTiutlo0, BorderLayout.NORTH);
        pnlcentral.add(lblTitulo);  
        pnlcentral.add(txtTitulo);
        pnlcentral.add(lblTitulo2);
        pnlcentral.add(txtTitulo2);
        pnlcentral.add(lblTitulo3); 
        pnlcentral.add(txtTitulo3);
        pnlcentral.add(lblGenero);
        pnlcentral.add(cmbGenero);
        pnlpie.add(btnLimpiar);
        pnlpie.add(btnAceptar);
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.print("error "+ex.getMessage());
                }
            }
        });
        this.add(lblTiutlo0, BorderLayout.NORTH);
        this.add(pnlcentral, BorderLayout.CENTER);
        this.add(pnlpie, BorderLayout.SOUTH);
        
        
    }
    
    public static void main(String[] args) {
        
        frmMenuPrincipal frmMenu = new frmMenuPrincipal();
        frmMenu.setVisible(true);
        
        
    }
    public void btnAceptarActionListener(ActionEvent e){
        JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction",JOptionPane.INFORMATION_MESSAGE);
    }
}
