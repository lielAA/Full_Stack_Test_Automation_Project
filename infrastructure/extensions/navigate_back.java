package extensions;

import static org.testng.Assert.fail;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.relevantcodes.extentreports.LogStatus;
import utilities.common_opps;

public class navigate_back extends common_opps
{
	//############# Navigate back to last page ########
	public static void back() throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			driver.navigate().back();
			test.log(LogStatus.PASS, "navigate back successfully");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "navigate back Failed, see details: "  + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("navigate back Failed, see details " + e);
		}
	}
}