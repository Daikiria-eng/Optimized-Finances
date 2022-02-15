package Modelo;

import Modelo.Gestion_Usuario.Validar_Usuario;
import Modelo.Pool_Conexiones.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioJDBC implements Validar_Usuario{
    private static final String SQL_SELECT_LOGIN="SELECT nombres FROM usuario WHERE correo=? AND clave=?;";
    private static final String SQL_INSERT = "INSERT INTO usuario(nombres, correo, clave) VALUES(?, ?, ?)";
    private static final String SQL_DELETE_USUARIO="DELETE FROM usuario WHERE id_usuario=?;";    

    public int insert(Usuario persona) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, persona.getNombres());
            stmt.setString(2, persona.getCorreo());
            stmt.setString(3, persona.getClave());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public String[] iniciar(Usuario persona) throws ClassNotFoundException{
        Connection conn=null;
        //PreparedStatement stmt=null;
        ResultSet rs=null;
        Statement st=null;
        String[] id_name={};
        int size=0;

        try{
            conn=Conexion.getConnection();
            st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            try {
                rs=st.executeQuery("SELECT id_usuario,nombres,correo FROM usuario WHERE correo='"+persona.getCorreo()+"' AND clave='"+persona.getClave()+"';");
                if(rs.last()){
                    size=rs.getRow();
                    id_name=new String[size+1];
                }else{
                    return null;
                }
                rs.first();
                id_name[0]=rs.getString("id_usuario");
                id_name[1]=rs.getString("nombres");
                id_name[2]=rs.getString("correo");

                return id_name;
            } catch (Exception e) {
                System.out.print("Error al obtener credenciales:\n"+e);
            }
        }catch(Exception err){
            System.out.println("Error al auntenticar: "+err);
        }finally{
            Conexion.close(conn);
            Conexion.close(st);
            Conexion.close(rs);
        }
    
        return null;
    }

    public boolean eliminar_usuario(Usuario p){
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=Conexion.getConnection();
            ps=conn.prepareStatement(SQL_DELETE_USUARIO);
            ps.setString(1, p.getIdCliente());
            return ps.execute();
        } catch (Exception e) {
            System.out.println("Error al eliminar:\n"+e);
        }

        return false;
    }

    @Override
    public int validar(Usuario persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario listarID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
