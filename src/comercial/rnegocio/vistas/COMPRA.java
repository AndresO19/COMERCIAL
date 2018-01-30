/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comercial.rnegocio.vistas;

import comercial.rnegocio.dao.*;
import comercial.rnegocio.entidades.*;
import comercial.rnegocio.impl.*;
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
    
    List <Cliente> lstCliente; 
    
    List<Producto> lstProducto;
    
    JComboBox<Cliente> cmbCliente;
    JComboBox<Producto> cmbProducto;
    
    JLabel Titulo;
    JLabel Cliente;
    JLabel Producto;
    JLabel Descripcion;
    JLabel Precio;
  
    
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
        
        
        txDescripcion = new JTextField();
        txPrecio = new JTextField();
        cargarProducto();
        cmbProducto = new JComboBox(lstProducto.toArray());
        cargarCliente();
        cmbCliente = new JComboBox(lstCliente.toArray());
        btnAceptar = new JButton("ACEPTAR");
        btnLimpiar = new JButton("LIMPIAR");
        
        this.add(Titulo, BorderLayout.NORTH);
        
        pnlA.add(Cliente);
        pnlA.add(cmbCliente);
        pnlA.add(Producto);
        pnlA.add(cmbProducto);
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
         
         
             ICompra compraDao = new CompraImpl();
             Compra ncompra = new Compra();
             ncompra.setCliente((Cliente) cmbCliente.getSelectedItem());
             ncompra.setProducto((Producto) cmbProducto.getSelectedItem());
             ncompra.setDescripcion(txDescripcion.getText());
             ncompra.setPrecio(txPrecio.getText());
              ICompra compras = new CompraImpl();
              try{
                  
                  if (compras.insertar(ncompra) > 0) {

                JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

             }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
        }  
     }
         

    private void cargarProducto() {
        
        IProducto productoDao = new ProductoImpl();
        try{
            
            lstProducto = productoDao.obtener();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(this, "ERROR AL CARGAR LOS PRODUCTOS!!", "Transaction", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarCliente() {
       
        ICliente clienteDao = new ClienteImpl();
        try{
            
            lstCliente = clienteDao.obtener();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(this, "ERROR AL CARGAR LOS CLIENTES!!", "Transaction", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
}
