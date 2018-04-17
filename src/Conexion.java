import java.sql.*;
public class Conexion {

	public String url = "jdbc:mysql://localhost:3306/", db = "vialidad",usuario = "root", password = "";
	Connection con;
	ResultSet myRs;
	
	public ResultSet query(String sentence) {
		try {
			con = DriverManager.getConnection(url+db,usuario,password);
			Statement mystmt = con.createStatement();
			myRs = mystmt.executeQuery(sentence);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return myRs;
	}
}
