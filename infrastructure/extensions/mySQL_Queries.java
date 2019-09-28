package extensions;

import static org.testng.Assert.fail;

import com.relevantcodes.extentreports.LogStatus;

import utilities.JDBC;

// Received relevant query from "db_Query" and execute it 

public class mySQL_Queries extends JDBC
{
	public static String queries(String query) 
	{
		String value = null;
		try
		{
			initJDBC();
			retrieveInfo(query);
			value = parseData();
			closeDBCon();
			test.log(LogStatus.PASS, "Query successfully created");
		}
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL, "Query to DB Failed, see Detailed: " + e);
			fail("Query to DB Failed" + e);
		}
		return value;
	}
}