
package comercial.rnegocio.entidades;


public class Cliente {
    private String codigoc;
    private String nombre;
    private String apellido;
    private String telefono;

    public Cliente() {
    }

    public Cliente(String codigoc, String nombre, String apellido, String telefono) {
        this.codigoc = codigoc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getCodigoc() {
        return codigoc; 
    }

    public void setCodigoc(String codigoc) {
        this.codigoc = codigoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
     @Override
    public String toString() {
        return nombre; 
    }
    
}
