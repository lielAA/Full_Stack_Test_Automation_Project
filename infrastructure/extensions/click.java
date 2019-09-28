package extensions;

import static org.testng.Assert.fail;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;
import com.relevantcodes.extentreports.LogStatus;
import utilities.common_opps;

public class click extends common_opps
{
	//####### click on specific element ##########
	public static void go_click(WebElement elem) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			elem.click();
			test.log(LogStatus.PASS, "Element clicked Successfully");
		}
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL, "failed to click on Element, see details: " + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("error click in element");
		}
	}
	
	//######## click on specific element from List ############
	public static void go_click_list_elem(List <WebElement> elem , Integer i) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			elem.get(i).click();
			test.log(LogStatus.PASS, "Element from List clicked Successfully");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "failed to click on Element from List, see details: " + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("failed to click on Element from List");
		}
	}
	//##### find and click on element from list and identify by visible text --> For loop is find every element by his text and click on the relevant ########
	public static void go_click_list_elem_by_text(List <WebElement> elem, String Expected_Value) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			for (int i=0 ; i<elem.size() ; i++)
			{
				if(elem.get(i).getText().equals(Expected_Value))
				{
					elem.get(i).click();
					test.log(LogStatus.PASS, "Element from List found (by visible text) and clicked Successfully");
					break;
				}
			}
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "failed to click on Element from List by visible text, see details: " + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("failed to click on Element from List by visible text");
		}
	}
}