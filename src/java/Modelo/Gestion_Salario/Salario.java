package Modelo.Gestion_Salario;

/**
 *
 * @author user
 */
public class Salario {
    String id_usuario;
    String valor;
    String periodo;

    public Salario(){}

    public Salario(String id_usuario, String valor, String periodo){
        this.valor=valor;
        this.periodo=periodo;
        this.id_usuario=id_usuario;
    }

    public String getValor(){
        return valor;
    }
    public void setValor(String valor){
        this.valor=valor;
    }

    public String getPeriodo(){
        return periodo;
    }
    public void setPeriodo(String periodo){
        this.periodo=periodo;
    }

    public String getId_usuario(){
        return id_usuario;
    }
    public void setId_usuario(String id_usuario){
        this.id_usuario=id_usuario;
    }

    @Override
    public String toString(){
        return "Salario{ "+" valor="+valor+" periodo="+periodo+" id_usuario="+id_usuario+" }";
    }
}
