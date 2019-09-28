package API_Tests;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import Workflows.API_Acttions;
import extensions.verify;
import utilities.common_opps;

public class StudentsList_CRUD extends common_opps
{
	@Test
	public void Test001_verifyStudentCreated() throws ParserConfigurationException, SAXException, IOException
	{
		API_Acttions.postNewStudent("Liel", "Adir", "liel.adir@gmail.com", "QA_Tester");
		verify.contains(API_Acttions.getDetails().getBody().asString(), "liel.adir@gmail.com");
	}
	@Test
	public void Test002_verifyStudentUpdated() throws ParserConfigurationException, SAXException, IOException
	{
		API_Acttions.UpdateStudent("101", "NewLiel", "NewAdir", "NewLiel@gmail.com", "Automation");
		verify.contains(API_Acttions.getDetails().getBody().asString(), "NewLiel@gmail.com");
	}
	@Test
	public void Test003_verifyStudentDeleted() throws ParserConfigurationException, SAXException, IOException
	{
		API_Acttions.DeleteStudent("101");
		verify.NOTcontains(API_Acttions.getDetails().getBody().asString(), "NewLiel@gmail.com");
	}
}
