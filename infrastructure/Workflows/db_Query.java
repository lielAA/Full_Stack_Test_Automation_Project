package Workflows;

import extensions.mySQL_Queries;

public class db_Query 
{
	// return relevant query to DB in order to get expected result
	public static String getMessage(String expectedResult, String value)
	{
		return mySQL_Queries.queries("SELECT " + expectedResult + " FROM automation_project_test.youtubbdb WHERE searchValue_YouTubbDB = " + "'" +  value + "'" + ";");
	}
	
	
	
}
