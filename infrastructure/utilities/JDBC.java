package utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class JDBC extends common_opps
{
	public static Connection con ;
	public static Statement stmt ;
	public static ResultSet rs ;

	public static void initJDBC() throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException, IOException
	{
		Class.forName("com.mysql.cj.jdbc.Driver"); // init Driver
		con = DriverManager.getConnection(getData("DB_URL")+ getData("DB_SetServerTimeZone"), getData("DB_user"), getData("DB_Pass"));
		stmt = con.createStatement();
	}
	// get data from DB
	public static void retrieveInfo(String query) throws SQLException
	{
		rs = stmt.executeQuery(query);
	}
	
	// parse data from retrieveInfo 
	public static String parseData() throws SQLException
	{
		String returnValue = null;
		while(rs.next())  
		{
			returnValue = rs.getString("ExpectedResult_YouTubbDB");
		}
		return returnValue;		
	}
	
	 
	public static void closeDBCon() throws SQLException
	{
		con.close();
	}
}

