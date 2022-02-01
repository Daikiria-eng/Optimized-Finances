package Modelo;

public class Usuario {

    String id_Cliente;
    String nombres;
    String correo;
    String clave;

    public Usuario() {

    }

    public Usuario(String id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public Usuario(String nombres, String correo, String clave) {
        this.nombres = nombres;
        this.correo = correo;
        this.clave = clave;
    }

    public Usuario(String id_Cliente, String nombres, String correo, String clave) {
        this.id_Cliente = id_Cliente;
        this.nombres = nombres;
        this.correo = correo;
        this.clave = clave;
    }

    public Usuario(String correo,String clave){
        this.correo=correo;
        this.clave=clave;
    }
    
    public String getIdCliente() {
        return id_Cliente;
    }

    public void setIdCliente(String id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + id_Cliente + ", nombres=" + nombres + ", correo=" + correo + ", telefono=" + clave + '}';
    }
    
}