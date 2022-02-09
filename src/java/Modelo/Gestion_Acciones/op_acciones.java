package Modelo.Gestion_Acciones;

/**
 *
 * @author user
 */
public class op_acciones {
    private Nodo cab,ult,p;
    AccionesJDBC acc_j=new AccionesJDBC();
    int cont=0;
    String id_usuario="";
    
    public op_acciones(String id_usuario){
        cab=null;
        ult=null;
        this.id_usuario=id_usuario;
    }
    
    public void llenar_lista(){
        String[][] actions_v=acc_j.getAcciones(id_usuario);
        try{
            for(int i=0;i<actions_v.length;i++){
                p=new Nodo();
                if(p==null){
                    System.out.println("No hay espacio en memoria");
                }else{
                    p.tipo_acciones=actions_v[i][0];
                    p.descripcion=actions_v[i][1];
                    p.tipo_gasto=actions_v[i][2];
                    p.fecha_inicio=actions_v[i][3];
                    p.fecha_final=actions_v[i][4];
                    p.valor=actions_v[i][5];
                    p.id_acciones=actions_v[i][6];
                    p.id_usuario=id_usuario;
                    cont+=1;
                    if(cab==null) cab=p;
                    else ult.liga=p;
                }
                ult=p;
            }
        }catch(Exception e){
            System.out.println("Error llenando lista");
        }
    }
 
    /*public void imprimir_lista_consola(){
        p=cab;
        while(p!=null){
            System.out.println(" [ "+p.descripcion+" | "+p.valor+" ]");
            p=p.liga;
        }
    }*/
   
    public String[][] obtener_acciones_l(){
        String[][] actions_v2=new String[cont][7];
        p=cab;
        if(cab==null){
            System.out.println("Lista vacía: no se llenará vector");
        }else{
            try {                
                int i=0;
                while(p!=null){
                    actions_v2[i][0]=p.tipo_acciones;
                    actions_v2[i][1]=p.descripcion;
                    actions_v2[i][2]=p.tipo_gasto;
                    actions_v2[i][3]=p.fecha_inicio;
                    actions_v2[i][4]=p.fecha_final;
                    actions_v2[i][5]=p.valor;
                    actions_v2[i][6]=p.id_acciones;
                    i++;
                    p=p.liga;
                }

                return actions_v2;
            } catch (Exception e) {
                System.out.println("Error exportando vector:\n"+e);
            }
        }

        return null;
    }
}