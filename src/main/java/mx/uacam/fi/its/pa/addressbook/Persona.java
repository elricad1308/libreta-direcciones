package mx.uacam.fi.its.pa.addressbook;

public class Persona {

    private int idDireccion;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public Persona () { }

    public Persona (int id, String nom, String ap, String eml, String tel) {
        this.setIdDireccion(id);
        this.setNombre(nom);
        this.setApellido(ap);
        this.setEmail(eml);
        this.setTelefono(tel);
    }

    @Override
    public String toString () {
        return String.format("%s, %s", getApellido(), getNombre());
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
