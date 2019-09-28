package extensions;

import static org.testng.Assert.fail;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;
import com.relevantcodes.extentreports.LogStatus;
import utilities.common_opps;

public class Switch_To_Iframe extends common_opps 
{
	// Switch from main page to IFRAME
	public static void switchToIFRAME(WebElement elem) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			driver.switchTo().frame(elem);
			test.log(LogStatus.PASS, "Switched successfully to Iframe");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Switched to Iframe was failed, see details: " + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("Switched to Iframe was failed");
		}
	}
	
	// Switch back to default page (from IFRAME)
	public static void switchFromIFRAMEToMainPage() throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			driver.switchTo().defaultContent();
			test.log(LogStatus.PASS, "Switched successfully to main page");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Switched to main page was failed, see details: " + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("Switched to main page was failed");
		}
	}

}
