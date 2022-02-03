package Modelo;

import Modelo.Gestion_Usuario.Validar_Usuario;
import Modelo.Pool_Conexiones.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioJDBC implements Validar_Usuario{

//    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, correo, clave FROM cliente";
    private static final String SQL_SELECT_LOGIN="SELECT nombres FROM usuario WHERE correo=? AND clave=?;";
    private static final String SQL_INSERT = "INSERT INTO usuario(nombres, correo, clave) VALUES(?, ?, ?)";
    private static final String SQL_INSERT_SALARIO="INSERT INTO salario (valor,periodo,id_usuario) VALUES (?,?,?);";
    private static final String SQL_VERIFICAR_SALARIO="SELECT id_salario FROM salario WHERE id_usuario=?;";
//    private static final String SQL_UPDATE = "UPDATE cliente SET nombre=?, apellido=?, correo=?, telefono=? WHERE id_cliente = ?";
//    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente=?";

//    public List<Persona> select() {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        Usuario persona = null;
//        List<Persona> personas = new ArrayList<Persona>();
//
//        try {
//            conn = Conexion.getConnection();
//            stmt = conn.prepareStatement(SQL_SELECT);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                String id_cliente = rs.getString("id_cliente");
//                String nombre = rs.getString("nombre");
//                String correo = rs.getString("correo");
//                String clave = rs.getString("clave");
//
//                persona = new Usuario();
//                persona.setIdCliente(id_cliente);
//                persona.setNombres(nombre);
//                persona.setCorreo(correo);
//                persona.setClave(clave);
//
//                personas.add(persona);
//            }
//
//        } catch (Exception ex) {
//
//        } finally {
//            Conexion.close(rs);
//            Conexion.close(stmt);
//            Conexion.close(conn);
//        }
//
//        return personas;
//    }

//    public Usuario listarID(String id) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        String SQL_SELECT_ID = "SELECT * FROM cliente WHERE id_cliente=" + id;
//
//        Usuario persona = new Usuario();
//
//        try {
//            conn = Conexion.getConnection();
//            stmt = conn.prepareStatement(SQL_SELECT_ID);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//
//                persona.setIdCliente(rs.getString(1));
//                persona.setNombres(rs.getString(2));
//                persona.setApellido(rs.getString(3));
//                persona.setCorreo(rs.getString(4));
//                persona.setClave(rs.getString(5));
//            }
//
//        } catch (Exception ex) {
//        } finally {
//            Conexion.close(rs);
//            Conexion.close(stmt);
//            Conexion.close(conn);
//
//        }
//
//        return persona;
//    }

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

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
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
                rs=st.executeQuery("SELECT id_usuario,nombres FROM usuario WHERE correo='"+persona.getCorreo()+"' AND clave='"+persona.getClave()+"';");
                if(rs.last()){
                    size=rs.getRow();
                    id_name=new String[size+1];
                    System.out.println(size+" espacio "+rs.getRow());
                    System.out.println(rs.getString("id_usuario")+" espacio "+rs.getString("nombres"));
                }else{
                    return null;
                }
                rs.first();
                id_name[0]=rs.getString("id_usuario");
                id_name[1]=rs.getString("nombres");

                return id_name;
            } catch (Exception e) {
                System.out.print("Error al ejecutar: "+e);
            }
        }catch(Exception err){
            System.out.println("Error al iniciar: "+err);
        }finally{
            Conexion.close(conn);
            Conexion.close(st);
            Conexion.close(rs);
        }
    
        return null;
    }

    public boolean salario(String valor,String periodo, String id_usuario){
        Connection conn=null;
        PreparedStatement ps=null;
        int rows=0;
        try{
            conn=Conexion.getConnection();
            ps=conn.prepareStatement(SQL_INSERT_SALARIO);
            ps.setString(1, valor);
            ps.setString(2, periodo);
            ps.setString(3, id_usuario);
            rows=ps.executeUpdate();
            System.out.println("Inserting:\n"+SQL_INSERT_SALARIO);
            try {                
                if(rows!=0) return true;
            } catch (Exception e) {
                System.out.println("Error insertando:\n"+e);
            }
        }catch (Exception e){
            System.out.println("Error al registrar salario\n:"+e);
        }finally{
            Conexion.close(ps);
            Conexion.close(conn);
        }

        return false;
    }

    public boolean validar_salario(String[] id_usuario){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        System.out.println(id_usuario[0]+" id usuario");
        String id=id_usuario[0];
        System.out.println(id);
        try{
            conn=Conexion.getConnection();
            ps=conn.prepareStatement(SQL_VERIFICAR_SALARIO);
            ps.setString(1, (String)id_usuario[0]);
            rs=ps.executeQuery();
            if(rs.next()) return true;
        }catch (Exception e){
            System.out.println("Error al verificar salario:\n"+e);
        }finally{
            Conexion.close(conn);
            Conexion.close(ps);
            Conexion.close(rs);
        }


        return false;
    }

//    public int update(Usuario p) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int rows = 0;
//
//        try {
//            conn = Conexion.getConnection();
//            System.out.println("ejecutando query: " + SQL_UPDATE);
//            stmt = conn.prepareStatement(SQL_UPDATE);
//
//            stmt.setString(1, p.getNombres());
//            stmt.setString(2, p.getCorreo());
//            stmt.setString(3, p.getClave());
//            stmt.setString(4, p.getIdCliente());
//
//            rows = stmt.executeUpdate();
//            if (rows == 1) {
//                rows = 1;
//            } else {
//                rows = 0;
//            }
//
//            System.out.println("Registros actualizado:" + rows);
//
//        } catch (Exception ex) {
//        } finally {
//            Conexion.close(stmt);
//            Conexion.close(conn);
//        }
//
//        return rows;
//    }

//    public int delete(Usuario persona) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int rows = 0;
//
//        try {
//            conn = Conexion.getConnection();
//            System.out.println("Ejecutando query:" + SQL_DELETE);
//            stmt = conn.prepareStatement(SQL_DELETE);
//            stmt.setString(1, persona.getIdCliente());
//            rows = stmt.executeUpdate();
//            System.out.println("Registros eliminados:" + rows);
//        } catch (Exception ex) {
//        } finally {
//            Conexion.close(stmt);
//            Conexion.close(conn);
//        }
//
//        return rows;
//    }

//    @Override
//    public int validar(Usuario persona) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        int r = 0;
//        String sql = "SELECT * FROM cliente WHERE correo=? AND clave=?";
//
//        try {
//            conn = Conexion.getConnection();
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, persona.getCorreo());
//            stmt.setString(2, persona.getClave());
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                r = +1;
//                persona.setCorreo(rs.getString("correo"));
//                persona.setClave(rs.getString("clave"));
//            }
//            if (r == 1) {
//                return 1;
//            } else {
//                return 0;
//            }
//
//        } catch (SQLException e) {
//        }
//        return 0;
//    }
//    

    @Override
    public int validar(Usuario persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario listarID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
