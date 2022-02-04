package Modelo.Gestion_Salario;

import Modelo.Pool_Conexiones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class SalarioJDBC {
    private static final String SQL_INSERT_SALARIO="INSERT INTO salario (valor,periodo,id_usuario) VALUES (?,?,?);";

    public boolean insertar_salario(Salario s) {
        Connection conn = null;
        PreparedStatement ps = null;
        int r=0;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT_SALARIO);
            ps.setString(1, s.getValor());
            ps.setString(2, s.getPeriodo());
            ps.setString(3, s.getId_usuario());
            System.out.println("Inserting:\n" + SQL_INSERT_SALARIO);
            r=ps.executeUpdate();
            if (r!=0) {
                System.out.println("Insertado");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al registrar salario\n:" + e);
        } finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }

        return false;
    }
    public String[] validar_salario(Salario s) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String[] salario_v;
        int size = 0;
        //String id=id_usuario[0];
        System.out.println("id_usuario = " + s.getId_usuario());
        try {
            conn = Conexion.getConnection();
            st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery("SELECT valor,periodo FROM salario WHERE id_usuario=" + s.getId_usuario() + ";");
            if (rs.last()) {
                System.out.println(rs);
                size = rs.getRow();
                salario_v = new String[size+1];
            } else {
                return null;
            }

            rs.first();
            salario_v[0] = rs.getString("valor");
            salario_v[1] = rs.getString("periodo");

            return salario_v;

        } catch (Exception e) {
            System.out.println("Error al verificar salario:\n" + e);
        } finally {
            Conexion.close(conn);
            Conexion.close(st);
            Conexion.close(rs);
        }

        return null;
    }

}
