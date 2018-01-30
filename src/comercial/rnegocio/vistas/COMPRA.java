/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comercial.rnegocio.vistas;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class COMPRA extends JInternalFrame{
    
    JLabel Titulo;
    JLabel Cliente;
    JLabel Producto;
    JLabel Descripcion;
    JLabel Precio;
  
    JTextField txCliente;
    JTextField txProducto;
    JTextField txDescripcion;
    JTextField txPrecio;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlA;
    JPanel pnlB;
    
    public COMPRA(){
        
        this.setSize(800, 400);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        pnlA = new JPanel();
        pnlB = new JPanel();
        
        pnlA.setLayout(new GridLayout(12, 2, 5, 5));
        pnlB.setLayout(new GridLayout(1, 2, 5, 5));
        
        Titulo = new JLabel("DATOS DE LA COMPRA");
        
        Cliente = new JLabel("Nombre del Cliente");
        Producto = new JLabel("Producto");
        Descripcion = new JLabel("Descripcion");
        Precio = new JLabel("Precio");
        
        txCliente = new JTextField();
        txProducto = new JTextField();
        txDescripcion = new JTextField();
        txPrecio = new JTextField();
        
        btnAceptar = new JButton("ACEPTAR");
        btnLimpiar = new JButton("LIMPIAR");
        
        this.add(Titulo, BorderLayout.NORTH);
        
        pnlA.add(Cliente);
        pnlA.add(txCliente);
        pnlA.add(Producto);
        pnlA.add(txProducto);
        pnlA.add(Descripcion);
        pnlA.add(txDescripcion);
        pnlA.add(Precio);
        pnlA.add(txPrecio);
        
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.print("error " + ex.getMessage());
                }
            
            }
        });
        
        this.add(Titulo, BorderLayout.NORTH);
        this.add(pnlA, BorderLayout.CENTER);
        this.add(pnlB, BorderLayout.SOUTH);
        this.setClosable(true);
        
    }
    
       public static void main(String[] args) {

        COMPRA frmcompra = new COMPRA();
        frmcompra.setVisible(true);

    }
       
       
     public void btnAceptarActionListener(ActionEvent e) {
         
         
            
     }
    
}
