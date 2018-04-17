import javax.swing.*;
import java.sql.*;
public class Users {

    ResultSet res;
    Conexion c = new Conexion();
    public boolean userExist(String user) throws SQLException {
        res = c.query("Select * from usuario where Nombre ='"+user+"';");
        int count = 0;
        while(res.next()) {
            count++;
        }
        res.close();
        return count > 0;
    }


    public void insertUser(String user,String password){
        c.update("INSERT INTO usuario (Nombre,Password,tipo) values ('"+user+"','"+password+"',2);");
        
    }
    
    public boolean passExist(String pass) throws SQLException {
        res = c.query("Select * from usuario where Password ='"+pass+"';");
        int count = 0;
        while(res.next()) {
            count++;
        }
        res.close();
        return count > 0;
    }
    
    public int tipo(String user) throws SQLException {
    	
    	try {
    		res = c.query("select tipo from usuario where Nombre ='"+user+"';");
    		res.next();
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	return Integer.parseInt(res.getString(1));
    }
    
    

}
