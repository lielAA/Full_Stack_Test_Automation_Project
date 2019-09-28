package extensions;

import static org.testng.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import utilities.common_opps;

public class Expliciltly_wait extends common_opps 
{
	// Execute ExplicitlyWait for specific element
	public static void ExplicitlyWait_VisibiltyOFElement(WebElement elem) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			ExplicityWait.until(ExpectedConditions.visibilityOfElementLocated((By)elem));
			test.log(LogStatus.PASS, "Found and wait successfully to elem");
		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Error to execute explicitly wait" + e + "see screenshots: " + test.addScreenCapture(takeScrrenShots()));
			fail("Error to execute explicitly wait");
		}
	}
}
