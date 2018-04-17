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
        return count > 0;
    }


    public void insertUser(String user,String password){
        c.query("INSERT INTO usuario (Nombre,Passwird,tipo) values ('"+user+"','"+password+"',2)");
    }

}
