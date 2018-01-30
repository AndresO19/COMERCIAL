package comercial.rnegocio.vistas;


import java.util.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import comercial.rnegocio.dao.*;
import comercial.rnegocio.entidades.*;
import comercial.rnegocio.impl.*;

public class CLIENTEV extends JInternalFrame {

    JLabel titulo;
    JLabel codigoc;
    JLabel nombre;
    JLabel apellido;
    JLabel telefono;
//    JLabel telefono;
//    JLabel direccion;
//    JLabel categoria;
//    JLabel sexo;
//    JLabel fechaNacimiento;
//    JLabel fechaIngreso;
//    JLabel salario;
//
    JTextField txtCod;
    JTextField txtNombre;
    JTextField txtApellido;
    JTextField txtTelefono;
//    JTextField txTelf;
//    JTextField txDir;
//    JComboBox<String> cmdCateg;
//    JTextField txtTitulo8;
//    JTextField txFechaNac;
//    JTextField txFechIng;
//    JTextField txSalario;
//
//    JComboBox cmbGenero;
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;
//
    public CLIENTEV() {
//
        this.setSize(640, 400);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(3, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo = new JLabel("DATOS DEL CLIENTE");

        codigoc = new JLabel("Codigo Cliente: ");

        nombre = new JLabel("Nombre: ");
        apellido = new JLabel("Apellido: ");
        telefono = new JLabel("Numero de Telefono: ");
//        telefono = new JLabel("NUMERO TELEFONO");
//        direccion = new JLabel("DIRECCION");
//        categoria = new JLabel("A");
//        sexo = new JLabel("GENERO");
//        fechaNacimiento = new JLabel("FECHA NACIMIENTO");
//        fechaIngreso = new JLabel("FECHA INGRESO");
//        salario = new JLabel("salario");
//
        txtCod = new JTextField();
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtTelefono = new JTextField();
//        txTelf = new JTextField();
//        txDir = new JTextField();
//        cmdCateg = new JComboBox<String>(new String[]{"Contrato", "Nombramiento"});
//        txtTitulo8 = new JTextField();
//        txFechaNac = new JTextField();
//        txFechIng = new JTextField();
//        txSalario = new JTextField();
//        cmbGenero = new JComboBox(new String[]{"masculino", "femenino"});
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo, BorderLayout.NORTH);
        pnlcentral.add(codigoc);
        pnlcentral.add(txtCod);
        pnlcentral.add(nombre);
        pnlcentral.add(txtNombre);
        pnlcentral.add(apellido);
        pnlcentral.add(txtApellido);
        pnlcentral.add(telefono);
        pnlcentral.add(txtTelefono);
//        pnlcentral.add(telefono);
//        pnlcentral.add(txTelf);
//        pnlcentral.add(direccion);
//        pnlcentral.add(txDir);
//        pnlcentral.add(categoria);
//        pnlcentral.add(cmdCateg);
//        pnlcentral.add(sexo);
//        pnlcentral.add(cmbGenero);
//        pnlcentral.add(fechaNacimiento);
//        pnlcentral.add(txFechaNac);
//        pnlcentral.add(fechaIngreso);
//        pnlcentral.add(txFechIng);
//        pnlcentral.add(salario);
//        pnlcentral.add(txSalario);
//
        pnlpie.add(btnLimpiar);
        pnlpie.add(btnAceptar);
//
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
        this.add(titulo, BorderLayout.NORTH);
        this.add(pnlcentral, BorderLayout.CENTER);
        this.add(pnlpie, BorderLayout.SOUTH);
        this.setClosable(true);

    }

    public static void main(String[] args) {

        CLIENTEV frmMenu = new CLIENTEV();
        frmMenu.setVisible(true);

    }
//
    public void btnAceptarActionListener(ActionEvent e) {
        try {
            Cliente nCliente = new Cliente();
            nCliente.setCodigoc(txtCod.getText());
            nCliente.setNombre(txtNombre.getText());
            nCliente.setApellido(txtApellido.getText());
            nCliente.setTelefono(txtTelefono.getText());
//            nCliente.setTelefono(txTelf.getText());
//            nCliente.setDireccion(txDir.getText());
//            nCliente.setCategoria(cmdCateg.getSelectedIndex() == 0 ? "C" : "N");
//            nCliente.setSexo(cmbGenero.getSelectedIndex() == 0 ? "M" : "F");
//            DateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
//            try {
//                nCliente.setFechaNacimiento(formatoFecha.parse(txFechaNac.getText()));
//                nCliente.setFechaIngreso(formatoFecha.parse(txFechIng.getText()));
//            } catch (Exception er) {
//                JOptionPane.showMessageDialog(this, "ERROR DE FECHA!!"+er.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//            }
//            nCliente.setSalario(Double.parseDouble(txSalario.getText()));
            ICliente cliDao = new ClienteImpl();
            if (cliDao.insertar(nCliente) > 0) {
                JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "PROCESO FALLIDO!!"+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
