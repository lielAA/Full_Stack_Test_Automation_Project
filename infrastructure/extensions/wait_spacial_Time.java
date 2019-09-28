package extensions;

import static org.testng.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import utilities.common_opps;

public class wait_spacial_Time extends common_opps
{
	
	// Thread Sleep for special situations 
	public static void wait_XX_Time(Integer time) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			Thread.sleep(time);
			test.log(LogStatus.PASS, "Time waiting pass succssfully");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Time waiting Failed, see details: " + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("Time waiting Failed, see details: " + e);
		}
	}
}
