package Mobile_Tests;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import extensions.click;
import extensions.verify;
import utilities.common_opps;

public class UnitConverter_Reset_Settings extends common_opps
{
	@Test
	public void Test001_ClickNavigationButton() throws IOException, ParserConfigurationException, SAXException, FindFailed, InterruptedException
	{
		click.go_click(UnitConverter_UpperToolbar.navigation_button);
		verify.verify_list_elem_by_text(UnitConverter_MenuPage.Menu_List, "Reset settings");
	}
	@Test
	public void Test002_clickResetSettings() throws IOException, ParserConfigurationException, SAXException
	{
		click.go_click_list_elem_by_text(UnitConverter_MenuPage.Menu_List, "Reset settings");
		verify.text_in_Element(UnitConverter_ResetSettingsFrame.reset_settings_message, "Reset all settings?");
		click.go_click(UnitConverter_ResetSettingsFrame.OK_Button);
	}
}
