package extensions;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utilities.common_opps;

public class RestAPI extends common_opps
{
	//POST method StudentAPI = create new student
	@SuppressWarnings("unchecked")
	public static void POST(String[] params , List<String> courseList) throws ParserConfigurationException, SAXException, IOException
	{
		try
		{
			requestParams.put("firstName", params[0]);
			requestParams.put("lastName", params[1]);
			requestParams.put("email", params[2]);
			requestParams.put("programme", params[3]);
			requestParams.put("courses", courseList); // send list of courses

			httpRequest.header("Content-Type" , "application/json");
			httpRequest.body(requestParams.toJSONString());

			httpRequest.post(getData("API_Resource"));
			test.log(LogStatus.PASS, "Post succeed");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Post has failed, see details:" + e);
			fail("Post has failed, see datails: " + e);
		}
	}
	//PUT method StudentAPI = update student parameters
	@SuppressWarnings("unchecked")
	public static void PUT(String ExpetedStudentToUpdate,String[] params) throws ParserConfigurationException, SAXException, IOException
	{
		try
		{			
			requestParams.put("firstName", params[0]);
			requestParams.put("lastName", params[1]);
			requestParams.put("email", params[2]);
			requestParams.put("programme", params[3]);

			httpRequest.header("Content-Type" , "application/json");
			httpRequest.body(requestParams.toJSONString());

			httpRequest.put(getData("API_Resource")+"/"+ExpetedStudentToUpdate);
			test.log(LogStatus.PASS, "Update student params succeed");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Update has failed, see details:" + e);
			fail("Update has failed, see datails: " + e);
		}
	}
	//DELETE method StudentAPI = Delete student 
	public static void DELETE(String ExpetedStudentToDelete)
	{
		try
		{			
			httpRequest.header("Content-Type" , "application/json");
			httpRequest.body(requestParams.toJSONString());

			httpRequest.delete(getData("API_Resource")+"/" + ExpetedStudentToDelete);
			test.log(LogStatus.PASS, "Delete student succeed");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Delete student has failed, see details:" + e);
			fail("Delete student has failed, see datails: " + e);
		}	
	}
	//return parameter from StudentAPI to assert it
	public static Response GET(String URL)
	{
		resp = httpRequest.get(URL);
		return resp;
	}
}
