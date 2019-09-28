package Workflows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extensions.RestAPI;
import io.restassured.response.Response;
import utilities.common_opps;

public class API_Acttions extends common_opps
{
	public static List<String> subjects = new ArrayList<String>();
	
	// POST new student to APIstudent
	public static void postNewStudent(String StudentFirstName, String StudentLastName, String StudentEmail, String StudentCourses) throws ParserConfigurationException, SAXException, IOException
	{
		String[] details = {StudentFirstName, StudentLastName, StudentEmail, StudentCourses};
		subjects.add("Electroincs");
		subjects.add("Computer Science");
		subjects.add("Automation");
		RestAPI.POST(details, subjects);
	}
	// UPDATE exist student from APIstudent
	public static void UpdateStudent(String ExpetedStudentToUpdate,String StudentNewFirstName, String StudentNewLastName, String StudentNewEmail, String StudentnewCourses ) throws ParserConfigurationException, SAXException, IOException
	{
		String[] details = {StudentNewFirstName, StudentNewLastName, StudentNewEmail, StudentnewCourses};
		RestAPI.PUT(ExpetedStudentToUpdate ,details);
	}
	// DELETE exist student from APIstudent
	public static void DeleteStudent(String ExpetedStudentToDelete)
	{
		RestAPI.DELETE(ExpetedStudentToDelete);
	}
	
	public static Response getDetails() throws ParserConfigurationException, SAXException, IOException
	{
		return RestAPI.GET(getData("API_address") + getData("API_Resource") + "/list");
	}	
}
