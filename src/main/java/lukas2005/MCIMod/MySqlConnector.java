package lukas2005.MCIMod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlConnector {
	public static ResultSet itemsQuery;
    public static void main ()
    {
        Connection conn = null;
        Statement st = null;
        
        try
        {
            String userName = "root";
            String password = "";
            String sterownik = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mcimoddatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName(sterownik);
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established");
            st = conn.createStatement();
            ResultSet query = st.executeQuery("SELECT * FROM items");
            itemsQuery = query;
        }
        catch (Exception e)
        {
            System.err.println("ERROR:" + e.getMessage());
        }
        finally
        {

        }
    }

}
