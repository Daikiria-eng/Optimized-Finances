package Modelo.Gestion_Acciones;

import Modelo.Gestion_Acciones.*;
import Modelo.Gestion_Usuario.Validar_Usuario;
import Modelo.Usuario;
import Modelo.Pool_Conexiones.Conexion;
import java.sql.*;
/**
 *
 * @author daykiria
 */
public class AccionesJDBC implements Validar_Usuario{
    private final String sql_insertar_meta="INSERT INTO metas (titulo,precio,fecha_final,id_usuario) values (?,?,?,?);";
    private final String sql_insertar_ahorro="INSERT INTO ahorros (titulo,valor,fecha_inicio,fecha_final,id_usuario) values (?,?,?,?,?);";
    private final String sql_insertar_gasto="INSERT INTO gastos (titulo,precio,fecha_final,id_usuario) values (?,?,?,?);";
    
    private final String sql_get_meta="SELECT id_meta,titulo,precio,fecha_final FROM metas WHERE id_usuario=";
    private final String sql_get_ahorros="SELECT id_ahorro,titulo,valor,fecha_inicio,fecha_final FROM ahorros WHERE id_usuario=";
    private final String sql_get_gastos="SELECT id_gasto,titulo,precio,fecha_final FROM gastos WHERE id_usuario=";
    
    private final String sql_delete_accion="DELTE FROM ? WEHRE ?=?;";

    public boolean insertar_meta(Acciones acc){
        Connection conn=null;
        PreparedStatement ps=null;
        int rows=0;
        
        try {
            conn=Conexion.getConnection();
            ps=conn.prepareStatement(sql_insertar_meta);
            ps.setString(1, acc.getTitulo());
            ps.setString(2, acc.getValor());
            ps.setString(3, acc.getFecha_Final());
            ps.setString(4, acc.getId_usuario());
            rows=ps.executeUpdate();
            
            return rows!=0;
        } catch (Exception e) {
            System.out.println("Error insertando meta:\n"+e);
        }finally{
            Conexion.close(conn);
            Conexion.close(ps);
        }
    
        return false;
    }
    
    public boolean insertar_gasto(Acciones acc){
        Connection conn=null;
        PreparedStatement ps=null;
        int rows=0;
        try {
            conn=Conexion.getConnection();
            ps=conn.prepareStatement(sql_insertar_gasto);
            ps.setString(1, acc.getTitulo());
            ps.setString(2, acc.getValor());
            ps.setString(3, acc.getFecha_Final());
            ps.setString(4, acc.getId_usuario());
            rows=ps.executeUpdate();
            
            return rows!=0;
        } catch (Exception e) {
            System.out.println("Error insertando gasto:\n"+e);
        }finally{
            Conexion.close(conn);
            Conexion.close(ps);
        }
    
        return false;
    }
    
    public boolean insertar_ahorro(Acciones acc){
        Connection conn=null;
        PreparedStatement ps=null;
        //(titulo,valor,fecha_inicio,fecha_final,id_usuario)
        int rows=0;
        try {
            conn=Conexion.getConnection();
            ps=conn.prepareStatement(sql_insertar_ahorro);
            ps.setString(1, acc.getTipo_Acciones());
            ps.setString(2, acc.getValor());
            ps.setString(3, acc.getFecha_Inicio());
            ps.setString(4, acc.getFecha_Final());
            ps.setString(5, acc.getId_usuario());
            rows=ps.executeUpdate();
            return rows!=0;
        } catch (Exception e) {
            System.out.println("Error insertando ahorro:\n"+e);
        } finally {
            Conexion.close(conn);
            Conexion.close(ps);
        }
    
        return false;
    }
    
    public boolean eliminar_accion(Acciones acc){
        Connection conn=null;
        PreparedStatement ps=null;
        int rows=0;
        try {
            conn=Conexion.getConnection();
            String[] nombre
            ps=conn.prepareStatement(sql_delete_accion);
            
        } catch (Exception e) {
            System.out.println("Error al eliminar accion:\n"+e);
        } finally {
            Conexion.close(conn);
            Conexion.close(ps);
        }
        
        return false;
    }
    
    public String[][] get_metas(Usuario p){
        String[][] metas_v={};
        Connection conn=null;
        ResultSet rs=null;
        Statement st=null;
        int sz=0;
        
        try {
            conn=Conexion.getConnection();
            st=conn.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE
            );
            rs=st.executeQuery(sql_get_meta+p.getIdCliente());
            if(rs.last()){
                sz=rs.getRow();
                metas_v=new String[sz][4];
            }
            rs.first();
            int i=0;
            do {
                metas_v[i][0]=rs.getString("id_meta");
                metas_v[i][1]=rs.getString("titulo");
                metas_v[i][2]=rs.getString("precio");
                metas_v[i][3]=rs.getString("fecha_final");
                i++;
            } while (rs.next());
            
            return metas_v;
        } catch (Exception e) {
            System.out.println("Error al obtener metas:\n"+e);
        } finally {
            Conexion.close(conn);
            Conexion.close(st);
            Conexion.close(rs);
        }
    
        return null;
    }
    
    public String[][] get_ahorros(Usuario u){
        Connection conn=null;
        ResultSet rs=null;
        Statement st=null;
        int sz=0;
        String[][] ahorros_v={};
        
        try {
            conn=Conexion.getConnection();
            st=conn.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE
            );
            rs=st.executeQuery(sql_get_ahorros+u.getIdCliente());
            if(rs.last()){
                sz=rs.getRow();
                ahorros_v=new String[sz][5];
            }
            rs.first();
            int i=0;
            do {                
                ahorros_v[i][0]=rs.getString("id_ahorro");
                ahorros_v[i][1]=rs.getString("titulo");
                ahorros_v[i][2]=rs.getString("valor");
                ahorros_v[i][3]=rs.getString("fecha_inicio");
                ahorros_v[i][4]=rs.getString("fecha_final");
                i++;
            } while (rs.next());
            
            return ahorros_v;
        } catch (Exception e) {
            System.out.println("Error al obtener ahorros:\n"+e);
        } finally {
            Conexion.close(conn);
            Conexion.close(st);
            Conexion.close(rs);
        }
        
        return null;
    }
    
    public String[][] get_gastos(Usuario u){
        String[][] gastos_v={};
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        int sz=0;
        
        try {
            conn=Conexion.getConnection();
            st=conn.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE
            );
            rs=st.executeQuery(sql_get_gastos+u.getIdCliente());
            
            if(rs.last()){
                sz=rs.getRow();
                gastos_v=new String[sz][4];
            }
            rs.first();
            int i=0;
            do {                
                gastos_v[i][0]=rs.getString("id_gasto");
                gastos_v[i][1]=rs.getString("titulo");
                gastos_v[i][2]=rs.getString("precio");
                gastos_v[i][3]=rs.getString("fecha_final");
                i++;
            } while (rs.next());
            
            return gastos_v;
        } catch (Exception e) {
            System.out.println("Error al obtener gastos:\n"+e);
        } finally {
            Conexion.close(conn);
            Conexion.close(st);
            Conexion.close(rs);
        }
    
        return null;
    }
    
    /*public static void main(String[] args){
        AccionesJDBC a=new AccionesJDBC();
        Usuario u=new Usuario();
        u.setIdCliente("1");
        String[][] test=a.get_gastos(u);
        for(int i=0;i<test.length;i++){
            for(int j=0;j<test[0].length;j++){
                System.out.print(" [ "+test[i][j]+" ] ");
            }System.out.println("");
        }
    }*/

    @Override
    public int validar(Usuario persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario listarID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}