package Modelo.Gestion_Acciones;

/**
 *
 * @author daykiria
 */
public class ListaAcciones {
    private Nodo cab,ult,p,q;
    String[][] metas, gastos, ahorros;
    
    public ListaAcciones(String[][] metas,String[][] gastos,
            String[][] ahorros){
        this.metas=metas;
        this.gastos=gastos;
        this.ahorros=ahorros;
        cab=null;
        ult=null;
    }
    
    public void llenar_acciones(){
        if(metas!=null){
            for(int i=0;i<metas.length;i++){
                try {
                    p=new Nodo();
                    if(p==null){
                        System.out.println("Lista vacía");
                    }else{
                        p.id_accion=metas[i][0];
                        p.titulo=metas[i][1];
                        p.valor=metas[i][2];
                        p.fecha_final=metas[i][3];
                        p.tipo_accion="meta";
                        if(cab==null) cab=p;
                        else ult.liga=p;                        
                    }ult=p;                    
                } catch (Exception e) {
                    System.out.println("Error a llenar metas:\n"+e);
                }
            }
        }else{
            System.out.println("Vector vacío, no se llenará la lista");
        }
        if(gastos!=null){
            for(int i=0;i<gastos.length;i++){
                try {
                    p=new Nodo();
                    if(p==null){                    
                        System.out.println("Lista vacía");
                    }else{
                        p.id_accion=gastos[i][0];
                        p.titulo=gastos[i][1];
                        p.valor=gastos[i][2];
                        p.fecha_final=gastos[i][3];
                        p.tipo_accion="gasto";
                        if(cab==null) cab=p;
                        else ult.liga=p;
                    }ult=p;
                } catch (Exception e) {
                    System.out.println("Error al llenar gastos:\n"+e);
                }
            }
        }else{
            System.out.println("Vector vacío, no se llenará la lista");
        }
        if(ahorros!=null){
            for(int i=0;i<ahorros.length;i++){
                try {
                    p=new Nodo();
                    if(p==null){
                        System.out.println("Lista vacía");
                    }else{
                        p.id_accion=ahorros[i][0];
                        p.titulo=ahorros[i][1];
                        p.valor=ahorros[i][2];
                        p.fecha_inicio=ahorros[i][3];
                        p.fecha_final=ahorros[i][4];
                        p.tipo_accion="ahorro";
                        if(cab==null) cab=p;
                        else ult.liga=p;
                    }ult=p;
                } catch (Exception e) {
                    System.out.println("Error al llenar ahorros");
                }
            }
        }else{
            System.out.println("Vector vacío, no se llenará la lista");
        }
    }
    
    /*public void destructor(){
        p=cab;        
        while(p!=null){
            q=p.liga;
            p=p.liga;
            p=q;
        }
    }*/
}