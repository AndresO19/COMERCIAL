
package comercial.rnegocio.impl;
import comercial.rnegocio.dao.*;
import comercial.rnegocio.entidades.*;
import comercial.accesodatos.*;
import  java.util.*;
import java.sql.*;


public class CompraImpl implements ICompra {
    
    @Override
    public int insertar(Compra compra) throws Exception {
        int Filas = 0;
        String csql = "Insert into Compra (codigoC, codigoP, descripcion, precio) Values (?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, compra.getCliente().getCodigoc()));
        lstP.add(new Parametro(2, compra.getProducto().getCodigop()));
        lstP.add(new Parametro(3, compra.getDescripcion()));
        lstP.add(new Parametro(4, compra.getPrecio()));
      
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            Filas = con.ejecutarComando(csql, lstP);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return Filas;
    }
    
    
    @Override
    public Compra obtener(String codigo) throws Exception {
        Compra trata = null;
        Cliente cliente=null;
        ICliente clienteDao = new ClienteImpl();
        Producto producto=null;
        IProducto producDao=new ProductoImpl();
        String csql = "Select codigoc, codigoP, descripcion, precio From Compra Where codigo=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                cliente=new Cliente();
                cliente=clienteDao.obtener(rst.getString(1));
                producto =new Producto();
                producto = producDao.obtener(rst.getString(2));
                trata=new Compra();
                trata.setCliente(cliente);
                trata.setProducto(producto);
                trata.setDescripcion(rst.getString(3));
                trata.setPrecio(rst.getString(4));
               
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return trata;
    }
    
    
    @Override
    public ArrayList<Compra> obtener() throws Exception {
        ArrayList<Compra> comps = new ArrayList<>();
        Cliente cliente=null;
        ICliente clienteDao=new ClienteImpl();
        Producto producto=null;
        IProducto productoDao=new ProductoImpl();
        String csql="select codigoC, codigoP, descripcion, precio from Compra";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Compra comp=null;
            while(rst.next()){
                cliente=new Cliente();
                cliente=clienteDao.obtener(rst.getString(1));
                producto = new Producto();
                producto = productoDao.obtener(rst.getString(2));
                comp=new Compra();
                comp.setCliente(cliente);
                comp.setProducto(producto);
                comp.setDescripcion(rst.getString(3));
                comp.setPrecio(rst.getString(4));
             
                comps.add(comp);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return comps;
    }
}
