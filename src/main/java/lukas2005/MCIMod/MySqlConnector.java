package lukas2005.MCIMod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnector {
	public static ResultSet itemsQuery;
    public static void main ()
    {
        Connection conn = null;
        Statement st = null;
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + Reference.MYSQL_URL + ":" + Reference.MYSQL_PORT + "/" + Reference.MYSQL_DATABASE + "?" + Reference.MYSQL_PARAMS, Reference.MYSQL_USER, Reference.MYSQL_PASSWD);
            Logger.info("Database connection established");
            st = conn.createStatement();
            ResultSet query = st.executeQuery("SELECT * FROM items");
            itemsQuery = query;
        }
        catch (SQLException e)
        {
        	Logger.warn("Cannot connect to database. Running on local backup", e);
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	Logger.error(e.getMessage());
		}
    }

}
