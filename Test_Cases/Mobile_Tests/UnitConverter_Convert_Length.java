package Mobile_Tests;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import Workflows.Mobile_ConvertLength;
import extensions.verify;
import utilities.common_opps;

public class UnitConverter_Convert_Length extends common_opps
{
	@Test
	public void Test001_ConvertLength() throws IOException, ParserConfigurationException, SAXException, InterruptedException
	{
		Mobile_ConvertLength.ConvertLength();
		verify.text_from_list(UnitConverter_BasicPage.convertResults, "1", 2);
	}
}
