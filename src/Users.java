import javax.swing.*;
import java.sql.*;
public class Users {

    ResultSet res;
    Conexion c = new Conexion();
    public boolean userExist(String user) throws SQLException {
        res = c.query("Select * from usuario where User ='"+user+"';");
        int count = 0;
        while(res.next()) {
            count++;
        }
        res.close();
        return count > 0;
    }


    public void insertUser(String user,String password,String name,String app,String apm){
        c.update("INSERT INTO usuario (User,Password,Nombre,ApellidoP,ApellidoM,tipo) values ('"+user+"','"+password+"','"+name+"','"+app+"','"+apm+"',2);");
        
    }
    
    public boolean login(String pass,String user) throws SQLException {
        res = c.query("Select * from usuario where User = '"+user+"' and Password ='"+pass+"';");
        int count = 0;
        while(res.next()) {
            count++;
        }
        res.close();
        return count > 0;
    }
    
    public int tipo(String user) throws SQLException {
    	
    	try {
    		res = c.query("select tipo from usuario where User ='"+user+"';");
    		res.next();
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	return Integer.parseInt(res.getString(1));
    }
    
    public boolean dataCheck(JTextField txt1,JTextField txt2,JTextField txt3,JTextField txt4,JTextField txt5,JTextField txt6) {
    	if(txt1.getText().length() > 0 && txt2.getText().length()>0 && txt3.getText().length()>0 
    			&& txt4.getText().length()>0 && txt5.getText().length()>0 && txt6.getText().length()>0) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public String name(String user) throws SQLException {
    	try {
    		res = c.query("Select Nombre,ApellidoP,ApellidoM from usuario where User ='"+user+"'; ");
    		res.next();
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}return res.getString("Nombre")+" "+res.getString("ApellidoP")+" "+res.getString("ApellidoM");
    }
    
    

}
