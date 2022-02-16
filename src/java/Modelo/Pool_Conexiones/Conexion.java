package Modelo.Pool_Conexiones;

import java.sql.*;

public class Conexion {    
    private static final String JDBC_URL = ("jdbc:mysql://localhost:3306/optimizedfinances?useSSL=false&serverTimezone=UTC");
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "mysql";
    //private static final String JDBC_PASS = "1005680301";
    
    public static Connection getConnection() throws ClassNotFoundException {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            System.out.println("Connected to db");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return con;
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }

    public static void close(Statement st){
        try {
            st.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }    
}