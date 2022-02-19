package Modelo.Gestion_Consejos;

/**
 *
 * @author daykiria
 */
public class ListaConsejos {
    private Nodo cab,ult,p;
    String[][] exportar={{"Apunta tus gastos fijos","Los gastos fijos son los que pagamos todos los meses, como alquiler, agua, luz, teléfono, Internet, etc. Es importante resaltar que debes incluir en la lista los impuestos…. ¡que no se te olvide!"},
        {"Separa al menos el 10% de tus ingresos cada mes","Antes de pagar los gastos fijos, trata de reservar al menos el 10% de tu renta para invertirlo. Esta será una excelente manera para entender de forma simple cómo administrar el dinero, en caso que no tengas mucho tiempo para hacer algunos cálculos.\n"},
        {"Mantén tus gastos personales separados de los de tu negocio","Esta sugerencia vale para quien ya tiene un emprendimiento o pretende comenzar uno. Muchos pequeños y medianos emprendedores todavía tienen dificultades para separar los gastos personales de los gastos del negocio, lo que puede llevarte no sólo a acumular pérdidas, sino incluso a la quiebra."},
        {"Trata en lo posible de no pedir financiaciones","Las financiaciones son un peligro para el pequeño y mediano negocio, ya que representan un compromiso a largo plazo y suelen cobrar intereses elevados."},
        {"Amortiza tus deudas lo antes posible","Si ya has obtenido un préstamo a tu nombre, piensa en abonar más cuotas simultáneamente para reducir la duración del contrato y, claro, los intereses."},
        {"Estudia sobre inversiones","Invertir es una forma de asegurarse de que no gastarás tu dinero en algo superfluo. Pero cuando usamos la palabra “inversión”, puede parecer que estamos hablando de algo que requiere mucho conocimiento previo."},
        {"Establece objetivos financieros","Antes de seguir adelante es importante conocer la diferencia entre metas y objetivos. Aunque estemos acostumbrados a usar estas dos palabras indistintamente, pueden tener ciertas diferencias de significado: "},
        {"Paga al contado siempre que puedas","Esto puede sonar a cliché, pero cualquier especialista en finanzas nos dirá que una de las formas más efectivas de cómo administrar el dinero, tiene que ver con comprar algo sólo cuando tengamos el dinero para hacerlo."},
        {"Evita usar tu tarjeta de crédito","¿Quiere decir que nunca deberías usar tu tarjeta de crédito? ¡Por supuesto que no! Las tarjetas de crédito representan una gran comodidad para el consumidor, además de ser el método de pago en línea más común. "},
        {"Establece límites a los gastos variables","Todo lo que no es un gasto fijo es un gasto variable. O sea, un tipo de gasto que, en principio, se puede dejar para más tarde. Pero sabemos que, en la práctica, la gente no quiere dejar de privarse de pequeños placeres, como salir con amigos, hacer un viaje o comprar algo que no sea esencial."},};
    public ListaConsejos(){
        cab=null;
        ult=null;
    }
    
    public void llenar_consejos(){
        try{
            for(int i=0;i<exportar.length;i++){
                p=new Nodo();
                if(p==null){
                    System.out.println("No espacio en memoria");
                }else{
                    p.id=i+1;
                    p.titulo=exportar[i][0];
                    p.Consejo=exportar[i][1];
                    if(cab==null) cab=p;
                    else ult.liga=p;
                }ult=p;
            }
        }catch(Exception e){
            System.out.println("Error llenado consejos:\n"+e);
        }
    }
    
    public String[][] importar_consejos(){
        ListaConsejos lc=new ListaConsejos();
        lc.llenar_consejos();
        String[][] importar=new String[10][2];
        p=cab;
        int i=0;
        while(p!=null){
            exportar[i][0]=p.titulo;
            exportar[i][1]=p.Consejo;
            i++;
            p=p.liga;
        }
        
        return exportar;
    }
}
