package Modelo.Gestion_Acciones;

public class Acciones {
    String id_Acciones;
    String tipo_Acciones;
    String titulo;
    String fecha_Inicio;
    String fecha_Final;
    String id_usuario;
    String valor;

    public Acciones() {}

    public Acciones(String id_Acciones) {
        this.id_Acciones = id_Acciones;
    }

    public Acciones(String tipo_Acciones, String descripcion, String tipo_Gasto, String fecha_Inicio, String fecha_Final, String id_usuario) {
        this.tipo_Acciones = tipo_Acciones;
        this.titulo = titulo;
        this.fecha_Inicio = fecha_Inicio;
        this.fecha_Final = fecha_Final;
        this.id_usuario=id_usuario;
        this.valor=valor;
    }

    public String getId_Acciones() {
        return id_Acciones;
    }

    public void setId_Acciones(String id_Acciones) {
        this.id_Acciones = id_Acciones;
    }

    public String getTipo_Acciones() {
        return tipo_Acciones;
    }

    public void setTipo_Acciones(String tipo_Acciones) {
        this.tipo_Acciones = tipo_Acciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha_Inicio() {
        return fecha_Inicio;
    }

    public void setFecha_Inicio(String fecha_Inicio) {
        this.fecha_Inicio = fecha_Inicio;
    }

    public String getFecha_Final() {
        return fecha_Final;
    }

    public void setFecha_Final(String fecha_Final) {
        this.fecha_Final = fecha_Final;
    }

    public void setId_usuario(String id_usuario){
        this.id_usuario=id_usuario;
    }
    public String getId_usuario(){
        return id_usuario;
    }

    public void setValor(String valor){
        this.valor=valor;
    }
    public String getValor(){
        return valor;
    }

    @Override
    public String toString() {
        return "Acciones{" + "id_Acciones=" + id_Acciones + ", tipo_Acciones=" + tipo_Acciones + ", descripcion=" + titulo + ", fecha_Inicio=" + fecha_Inicio + ", fecha_Final=" + fecha_Final + '}';
    }
}