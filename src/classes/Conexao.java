package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {
    private static final String CONN = "jdbc:mysql://localhost/farmacia?zeroDateTimeBehavior=convertToNull";
    //10.10.138.10:3306
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    
    public static boolean executar(String sql){
        try{
            Class.forName( DRIVER );
            Connection conn = 
                    DriverManager.getConnection(CONN, USER, PASSWORD);
            Statement st = conn.createStatement();
            st.execute(sql);
            return true;
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
    public static ResultSet consultar(String sql){
        ResultSet rs = null;
        try{
            Class.forName( DRIVER );
            Connection conn = 
                    DriverManager.getConnection(CONN, USER, PASSWORD);
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, e.toString()); 
        }
        return rs;
    }
}
