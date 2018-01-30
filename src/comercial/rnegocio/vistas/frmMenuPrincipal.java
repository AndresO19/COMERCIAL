package comercial.rnegocio.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import comercial.rnegocio.dao.*;
import comercial.rnegocio.entidades.*;
import comercial.rnegocio.impl.*;


public class frmMenuPrincipal extends JFrame {

    JMenuBar menuBarraPrincipal;
    JMenu menuInicio;
    JMenuItem menuItemLogin;
    JMenuItem menuItemSalir;
    ///////////////////////////////
    JMenu menuCliente;
    JMenuItem nuevoCliente;
    JMenuItem modificarCliente;
    JMenuItem eliminarCliente;
    JMenuItem buscarCliente;
    JMenuItem listCliente;
    /////////////////////////////////////////
    JMenu menuProducto;
    JMenuItem nuevoProducto;
    JMenuItem modificarProducto;
    JMenuItem eliminarProducto;
    JMenuItem buscarProducto;
    JMenuItem listProducto;
    ///////////////////////////////////////////////
    JMenu menuCompra;
    JMenuItem nuevoCompra;
    JMenuItem modificarCompra;
    JMenuItem eliminarCompra;
    JMenuItem buscarCompra;
    JMenuItem listCompra;
    ///////////////////////////////////////
    JDesktopPane escritorio;

    public frmMenuPrincipal() {
        escritorio = new JDesktopPane();
        escritorio.setBackground(new Color(50, 30, 70));

        menuBarraPrincipal = new JMenuBar();
        //menu Inicio
        menuInicio = new JMenu("Inicio");
        menuItemLogin = new JMenuItem("Iniciar Sesion");
        menuItemSalir = new JMenuItem("Salir");
        menuItemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    menuSalirActionPerformed(e);
                } catch (Exception ex) {
                    System.out.println("error: " + ex.getMessage());
                }
            }
        });
        menuBarraPrincipal.add(menuInicio);
        menuInicio.add(menuItemLogin);
        menuInicio.add(menuItemSalir);
        
        menuCliente = new JMenu("CLIENTE");
        nuevoCliente = new JMenuItem("Nuevo CLIENTE");
        nuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoClienteActionPerformed(e);
            }
        });
        modificarCliente = new JMenuItem("Modificar Cliente");
        eliminarCliente = new JMenuItem("Eliminar Cliente");
        buscarCliente = new JMenuItem("Buscar Cliente");
        listCliente = new JMenuItem("Listar Clientes");
        listCliente.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaClienteActionPerformed(e);
            }
        });
        menuCliente.add(nuevoCliente);
        menuCliente.add(modificarCliente);
        menuCliente.add(eliminarCliente);
        menuCliente.addSeparator();
        menuCliente.add(buscarCliente);
        menuCliente.add(listCliente);
        
        menuBarraPrincipal.add(menuCliente);
       
        ////////////////////////////////////////////
        menuProducto = new JMenu("PRODUCTO");
        nuevoProducto = new JMenuItem("Nuevo Producto");
//        nuevoProducto.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                NuevoProductoActionPerformed(e);
//            }
//        });
        modificarProducto = new JMenuItem("Modificar Producto");
        eliminarProducto = new JMenuItem("Eliminar Producto");
        buscarProducto = new JMenuItem("Buscar Producto");
        listProducto = new JMenuItem("Listar Producto");
//        listCliente.addActionListener( new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                listaClienteActionPerformed(e);
//            }
//        });
        menuProducto.add(nuevoProducto);
        menuProducto.add(modificarProducto);
        menuProducto.add(eliminarProducto);
        menuProducto.addSeparator();
        menuProducto.add(buscarProducto);
        menuProducto.add(listProducto);
        
        menuBarraPrincipal.add(menuProducto);
       
        ///////////////////////////////////////////////////////////////
        menuCompra = new JMenu("COMPRA");
        nuevoCompra = new JMenuItem("Nueva Compra");
        nuevoCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoCompraActionPerformed(e);
            }
        });
        modificarCompra = new JMenuItem("Modificar Compra");
        eliminarCompra = new JMenuItem("Eliminar Compra");
        buscarCompra = new JMenuItem("Buscar Compra");
        listCompra = new JMenuItem("Listar Compra");
//        listCliente.addActionListener( new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                listaClienteActionPerformed(e);
//            }
//        });
        menuCompra.add(nuevoCompra);
        menuCompra.add(modificarCompra);
        menuCompra.add(eliminarCompra);
        menuCompra.addSeparator();
        menuCompra.add(buscarCompra);
        menuCompra.add(listCompra);
        
        menuBarraPrincipal.add(menuCompra);
       
        ///////////////////////////////////////////////////////////////////////
        
        
        
        this.setLayout(new BorderLayout());
        //this.setSize(360,240);
        this.add(menuBarraPrincipal, BorderLayout.NORTH);
        this.add(escritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //PARA MAXIMIZAR LA VENTANA
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//terminar proceso de la ventana ejecutada
        

    }

    public static void main(String[] args) {
        frmMenuPrincipal ventana = new frmMenuPrincipal();
        ventana.setVisible(true);
    }

    public void menuSalirActionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
     public void listaClienteActionPerformed(ActionEvent e) {
        ListaCliente frm = new ListaCliente();
        escritorio.add(frm);
        frm.setVisible(true);
    }
     
     public void NuevoClienteActionPerformed(ActionEvent e) {
        CLIENTEV frm = new CLIENTEV();
        escritorio.add(frm);
        frm.setVisible(true);
    }

      public void NuevoCompraActionPerformed(ActionEvent e) {
        COMPRA frm = new COMPRA();
        escritorio.add(frm);
        frm.setVisible(true);
    }
}
