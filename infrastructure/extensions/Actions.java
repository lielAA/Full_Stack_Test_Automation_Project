package extensions;

import static org.testng.Assert.fail;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchShortcuts;
import utilities.common_opps;

public class Actions extends common_opps
{
	//############# Execute Mouse_Hover by Action ########
	public static void Mouse_Hover(WebElement elem) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			Action.moveToElement(elem).build().perform();
			test.log(LogStatus.PASS, "Mouse Hover execute successfully");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Mouse Hover Fafiled, see details: "  + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("Mouse Hover Fafiled");
		}
	}

	//############ Execute Scrolling down by JSExecution ###############
	public static void Scrool_Down(int Horizontal , int Vertical) throws IOException, ParserConfigurationException, SAXException
	{
		try 
		{
			JS.executeScript("window.scrollBy(" + Horizontal + "," + Vertical + ")");
			test.log(LogStatus.PASS, "Scrool down page execute successfully");

		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Scroll down Fafiled, see details: "  + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("Scroll down Fafiled");
		}
	}
	// Horizontal right to left Swiping by generic resolution and dimensions 
		public static void horizontalSwipeByPercentage(double startPercentage, double endPercentage, double anchorPercentage, int duration) throws IOException, ParserConfigurationException, SAXException
		{
			try
			{
			int startPoint = (int) (size.width * startPercentage); // width start point swiping
			int anchor = (int) (size.height * anchorPercentage); // height anchor point
	        int endPoint = (int) (size.width * endPercentage); // width end point swiping
	        ((TouchShortcuts) driver).swipe(startPoint,anchor,endPoint,anchor,duration);  
	        test.log(LogStatus.PASS, "Swipe from right to left execute successfully");
			}
			catch (Exception e)
			{
				test.log(LogStatus.FAIL, "Error - Swipe from right to left failed"+ e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
				fail("Error - Swipe from right to left failed");
			}
		}
}
