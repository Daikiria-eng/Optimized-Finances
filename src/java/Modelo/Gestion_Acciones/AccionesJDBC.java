package Modelo.Gestion_Acciones;

import Modelo.Gestion_Acciones.*;
import Modelo.Gestion_Usuario.Validar_Usuario;
import Modelo.Pool_Conexiones.Conexion;
import Modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccionesJDBC implements Validar_Usuario{

//    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, correo, clave FROM cliente";
    private static final String SQL_INSERT = "INSERT INTO acciones(tipo_acciones, descripcion, tipo_gasto, fecha_inicio, fecha_final,id_usuario,valor) VALUES(?, ?, ?, ?, ?, ?,?)";
    private static final String SQL_DELETE_ACCION = "DELETE FROM acciones WHERE id_acciones=?;";
    private static final String SQL_UPDATE = "UPDATE acciones SET tipo_acciones=?,descripcion=?,tipo_gasto=?,fecha_inicio=?,fecha_final=?,valor=? WHERE id_acciones=?;";
    
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

    public int insert(Acciones acciones) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        System.out.println("checkpoint on AccionesJDBC");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, acciones.getTipo_Acciones());
            stmt.setString(2, acciones.getDescripcion());
            stmt.setString(3, acciones.getTipo_Gasto());
            stmt.setString(4, acciones.getFecha_Inicio());
            stmt.setString(5, acciones.getFecha_Final());
            stmt.setString(6, acciones.getId_usuario());
            stmt.setString(7, acciones.getValor());

            System.out.println("ejecutando query:" + SQL_INSERT);
            try {                
                rows = stmt.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error en registro de acciones:\n"+e);
            }
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public String[][] getAcciones(String id_usuario){
        Connection conn=null;
        ResultSet rs=null;
        Statement st=null;
        String[][] actions_v={};
        int size=0;
        try{
            conn=Conexion.getConnection();
            st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs=st.executeQuery(
                "SELECT id_acciones,tipo_acciones,descripcion,tipo_gasto,fecha_inicio,fecha_final,valor FROM acciones WHERE id_usuario="+id_usuario+";"
                );
            if(rs.last()){
                size=rs.getRow();
                actions_v=new String[size][7];
                System.out.println(size);
            }
            rs.first();
            int i=0;
            do{
                actions_v[i][0]=rs.getString("tipo_acciones");
                actions_v[i][1]=rs.getString("descripcion");
                actions_v[i][2]=rs.getString("tipo_gasto");
                actions_v[i][3]=rs.getString("fecha_inicio");
                actions_v[i][4]=rs.getString("fecha_final");
                actions_v[i][5]=rs.getString("valor");
                actions_v[i][6]=rs.getString("id_acciones");
                i++;
            }while(rs.next());

            return actions_v;
        }catch(Exception e){
            System.out.println("Error al obtener acciones:\n"+e);
        }finally{
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(st);
        }

        return null;
    }

    public boolean eliminar_accion(Acciones acc){
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=Conexion.getConnection();
            ps=conn.prepareStatement(SQL_DELETE_ACCION);
            ps.setString(1, acc.getId_Acciones());

            return ps.execute();
        } catch (Exception e) {
            System.out.println("Error eliminando acción:\n"+e);
        }finally{
            Conexion.close(conn);
            Conexion.close(ps);
        }

        return false;
    }

    public boolean actualizar_acciones(Acciones acc){
        PreparedStatement ps=null;
        Connection conn=null;
        try {
        //UPDATE acciones SET tipo_acciones=?,descripcion=?,tipo_gasto=?
        //,fecha_inicio=?,fecha_final=?,valor=? WHERE id_acciones=?;
            conn=Conexion.getConnection();
            ps=conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, acc.getTipo_Acciones());
            ps.setString(2, acc.getDescripcion());
            ps.setString(3, acc.getTipo_Gasto());
            ps.setString(4, acc.getFecha_Inicio());
            ps.setString(5, acc.getFecha_Final());
            ps.setString(6, acc.getValor());
            ps.setString(7, acc.getId_Acciones());
            System.out.println("Ejecutando query:\n"+SQL_UPDATE);
            int rows=ps.executeUpdate();
            System.out.println("No error reported:\n"+rows);
            return rows!=0;
        } catch (Exception e) {
            System.out.println("Error al actualizar acciones:\n"+e);
        }finally{
            Conexion.close(conn);
            Conexion.close(ps);
        }

        return false;
    }
    public static void main(String[] args){
        AccionesJDBC a=new AccionesJDBC();
        Acciones acc=new Acciones();
        /*String[][] v=a.getAcciones("4");
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.println(" [ "+v[i][j]+" ]");
            }            
        }*/
        /*acc.setTipo_Acciones("gastico");
        acc.setDescripcion("mecato");
        acc.setTipo_Gasto("gastiquitico");
        acc.setFecha_Inicio("2022-03-11");
        acc.setFecha_Final("2022-04-12");
        acc.setValor("300");
        acc.setId_Acciones("2");
        a.actualizar_acciones(acc);*/
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
   
    @Override
    public int validar(Usuario persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario listarID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}