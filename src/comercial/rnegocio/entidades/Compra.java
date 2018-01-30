
package comercial.rnegocio.entidades;


public class Compra {
    private Cliente cliente;
    private Producto producto;
    private String descripcion;
    private  String precio;

    public Compra() {
    }

    public Compra(Cliente cliente, Producto producto, String descripcion, String precio) {
        this.cliente = cliente;
        this.producto = producto;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    
    
}
