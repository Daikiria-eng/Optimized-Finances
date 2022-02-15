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
    String sql_insertar_meta="INSERT INTO metas (titulo,precio,fecha_final,id_usuario) values (?,?,?,?);";
    String sql_insertar_ahorro="INSERT INTO ahorro (titulo,valor,fecha_inicio,fecha_final,id_usuario) values (?,?,?,?,?);";
    String sql_insertar_gasto="INSERT INTO gastos (titulo,precio,fecha_final,id_usuario) values (?,?,?);";

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

    @Override
    public int validar(Usuario persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario listarID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}