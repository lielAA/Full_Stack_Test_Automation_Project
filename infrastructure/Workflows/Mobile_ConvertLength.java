package Workflows;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import extensions.click;
import utilities.common_opps;

public class Mobile_ConvertLength extends common_opps
{
	public static void ConvertLength() throws IOException, ParserConfigurationException, SAXException, InterruptedException
	{
		click.go_click(UnitConverter_BasicPage.inputValueField);
		click.go_click(UnitConverter_BasicPage.dropBox_UnitsOfmeasurementButton);
		click.go_click_list_elem(UnitConverter_BasicPage.dropBox_UnitsOfmeasurementList, 2);
		click.go_click(UnitConverter_keyboard_keys.keyboard_num1);
		click.go_click(UnitConverter_keyboard_keys.keyboard_num0);
		click.go_click(UnitConverter_keyboard_keys.keyboard_num0);
		click.go_click(UnitConverter_keyboard_keys.keyboard_OK);
	}
}
