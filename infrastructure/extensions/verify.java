package extensions;

import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.xml.sax.SAXException;
import com.relevantcodes.extentreports.LogStatus;
import utilities.common_opps;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;

public class verify extends common_opps
{
	//###### verify Text for specific element #########
	public static void text_in_Element(WebElement elem , String Expected_value) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			if(myPLatform.equalsIgnoreCase("desktop"))
				assertEquals(elem.getAttribute("Name").replace("Display is", "").trim(), Expected_value);
			
		//########################################################
		//###### Configuration for independent running ###########
		//########################################################
//			if(getData("AutomationType").equalsIgnoreCase("desktop"))
//				assertEquals(elem.getAttribute("Name").replace("Display is", "").trim(), Expected_value);
			else
				assertEquals(elem.getText(),Expected_value);
			test.log(LogStatus.PASS, "Text found in Element");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Error with finding text, see details" + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("Error in founding text");
		}
		catch (AssertionError e)
		{
			test.log(LogStatus.FAIL, "Text not found in element, see details: "+ e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("Text NOT found in element");
		}
	}
	// ####### verify Text for specific element through list #############
	public static void text_from_list(List<WebElement> elem, String Expected_value , Integer Index) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			assertEquals(elem.get(Index).getText(),Expected_value);
			test.log(LogStatus.PASS, "Text Found in List element ");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Error with finding text from list, see details" + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("Error in founding text in list");
		}
		catch (AssertionError e)
		{
			test.log(LogStatus.FAIL, "Text not found in element from list, see details: "+ e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("Text not found in list element");
		}
	} 
	
	// ######## verify correct list size ###############
	public static void list_size(List<WebElement> elem, String Expected_value) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			assertEquals(String.valueOf(elem.size()), Expected_value);
			test.log(LogStatus.PASS, "List size is Commensurate");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Error with finding list, see details: "+ e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("Error in founding list");
		}
		catch (AssertionError e)
		{
			test.log(LogStatus.FAIL, "List size is Commensurate, see details: "+ e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("List size is Commensurate");
		}
	}
	// ######### verify image by Sikuli engine ##########
	public static void Sikuli_image(String imagePath) throws FindFailed, IOException, ParserConfigurationException, SAXException
	{
		try
		{
			screen.find(imagePath);
			test.log(LogStatus.PASS, "Image found Successfully");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Failed to found Image, see details :" + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("Failed to found Image");
		}
	}
	
	// ######### verify element from list and identify by visible text --> For loop is check every element by his text ##########
	public static void verify_list_elem_by_text(List <WebElement> elem, String Expected_Value) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			for (int i=0 ; i<elem.size() ; i++)
			{
				if(elem.get(i).getText().equals(Expected_Value))
				{
					test.log(LogStatus.PASS, "Element from List found (by visible text) and verify Successfully");
					break;
				}
				else
					continue;
			}
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "failed to verify Element from List by visible text, see details: " + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("failed to verify Element from List by visible text");
		}
	}	
	
	// verify contains string inside string
	public static void contains(String Resposne, String text)
	{
		try
		{
			assertTrue(Resposne.contains(text));
			test.log(LogStatus.PASS, "String "+ text + " exist inside the overall text");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL,"Error, see details: " + e); 
			fail("Error, see details: " + e);
		}
		catch (AssertionError e)
		{
			test.log(LogStatus.FAIL,"String "+ text + " not exist inside the overall text, see details: " + e);
			fail("String "+ text + " not exist inside the overall text, see details: " + e);
		}
	}
	// verify NOT contains string inside string
	public static void NOTcontains(String Resposne, String text)
	{
		try
		{
			assertFalse(Resposne.contains(text));
			test.log(LogStatus.PASS, "String "+ text + " NOT exist inside the overall text");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL,"Error, see details: " + e); 
			fail("Error, see details: " + e);
		}
		catch (AssertionError e)
		{
			test.log(LogStatus.FAIL,"String "+ text + " IS exist inside the overall text, see details: " + e);
			fail("String "+ text + " IS exist inside the overall text, see details: " + e);
		}
	}
}