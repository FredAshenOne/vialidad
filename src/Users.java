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
        c.update("INSERT INTO usuario (User,Password,Nombre,ApellidoP,ApellidoM) values ('"+user+"','"+password+"','"+name+"','"+app+"','"+apm+"');");
        
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
    
    public int getidUserByName(String nombre,String apellidoP ,String apellidoM) throws SQLException {
    	try {
    		res=c.query("Select id from propietario where nombre = '"+nombre+"' and ApellidoP ='"+apellidoP+"' and ApellidoM = '"+apellidoM+"';");
    		res.next();
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	return Integer.parseInt(res.getString(1));	
    }
    
    public boolean getExistingPropietario(String nombre, String apellidoP,String apellidoM)  {
    	int contador = 0;
    	try {
    		res=c.query("Select * from propietario where nombre = '"+nombre+"' and ApellidoP ='"+apellidoP+"' and ApellidoM = '"+apellidoM+"';");
    	
    	while(res.next()) {
    		contador++;
    	}
    	res.close();
    	
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	return contador > 0;	
    	
    }
    
    public void getPropietario(ResultSet r,JTextField t1,JTextField t2,JTextField t3) {
    	try {
    		t1.setText(r.getString("Nombre"));
    		t2.setText(r.getString("ApellidoP"));
    		t3.setText(r.getString("ApellidoM"));
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    

}
    


