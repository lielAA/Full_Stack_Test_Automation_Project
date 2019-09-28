package extensions;

import static org.testng.Assert.fail;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;
import com.relevantcodes.extentreports.LogStatus;
import utilities.common_opps;
public class update extends common_opps
{
	//####### SendKey to specific element ##########
	public static void update_text(WebElement elem , String value) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			elem.sendKeys(value);
			test.log(LogStatus.PASS, "Text send successfully to element");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "failed send keys to element, see details: " + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("Failed to update text");
		}
	}
	//clear text from text Field
	public static void clear_text(WebElement elem) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			elem.clear();
			test.log(LogStatus.PASS, "Text cleared successfully");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "failed sto cleared text, see details: " + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("failed sto cleared text, see details: " + e);
		}
	}
}