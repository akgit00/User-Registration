package swing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class dbConnection {

	public static void main(String[] args) {
	    System.out.println("Running database");
	    
	    UserRegistration db = new UserRegistration();
	    try {
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    db.disconnect();
	    

	}

}
