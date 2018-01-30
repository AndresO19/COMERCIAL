
package comercial.rnegocio.impl;
import comercial.rnegocio.dao.*;
import comercial.rnegocio.entidades.*;
import comercial.accesodatos.*;
import java.util.*;
import java.sql.*;


public class ClienteImpl implements ICliente {
    
     @Override
    public int insertar(Cliente cliente) throws Exception {
        int nFilas = 0;
        String csql = "Insert into Cliente (codigoc, nombre, apellido, telefono) Values (?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, cliente.getCodigoc()));
        lstP.add(new Parametro(2, cliente.getNombre()));
        lstP.add(new Parametro(3, cliente.getApellido()));
        lstP.add(new Parametro(4, cliente.getTelefono()));
        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            nFilas = con.ejecutarComando(csql, lstP);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nFilas;
    }
    
     @Override
    public Cliente obtener(String codigo) throws Exception {
        Cliente cliente = null;
        String csql = "Select codigoc, nombre, apellido, telefono From Cliente Where codigoc=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                cliente=new Cliente();
                cliente.setCodigoc(rst.getString(1));
                cliente.setNombre(rst.getString(2));
                cliente.setApellido(rst.getString(3));
                cliente.setTelefono(rst.getString(4));
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return cliente;
    }
    
    
     @Override
    public ArrayList<Cliente> obtener() throws Exception {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String csql="select codigoc, nombre, apellido, telefono from Cliente";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Cliente cliente=null;
            while(rst.next()){
                cliente=new Cliente();
                cliente.setCodigoc(rst.getString(1));
                cliente.setNombre(rst.getString(2));
                cliente.setApellido(rst.getString(3));
                cliente.setTelefono(rst.getString(4));
           
                clientes.add(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return clientes;
    }
    
}
