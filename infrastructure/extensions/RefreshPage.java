package extensions;

import static org.testng.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import utilities.common_opps;

public class RefreshPage extends common_opps
{
	// Refresh current page (F5)
	public static void Refresh_Page() throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			driver.navigate().refresh();;
			test.log(LogStatus.PASS, "refresh page pass successfully");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "nrefresh page  Failed, see details: "  + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("refresh page  Failed, see details " + e);
		}
	}
}
