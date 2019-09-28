package Mobile_Tests;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import extensions.Actions;
import extensions.click;
import extensions.verify;
import utilities.common_opps;

public class UnitConverter_Asia_Currency extends common_opps
{
	@Test
	public void Test001_SwipeRightToLeftToLivingTab() throws IOException, ParserConfigurationException, SAXException, FindFailed
	{
		Actions.horizontalSwipeByPercentage(0.8,0.1,0.5,500);
		verify.text_in_Element(UnitConverter_DownSubjectToolbar.Currency_text, "Currency");
	}
	@Test
	public void Test002_SelectAsiaCurrency() throws IOException, ParserConfigurationException, SAXException
	{
		click.go_click(UnitConverter_UpperToolbar.Region_list_button);
		click.go_click_list_elem_by_text(UnitConverter_UpperToolbar.Region_list, "Asia");
		verify.verify_list_elem_by_text(UnitConverter_BasicPage.Country_names, "JPY");
	}	
}
