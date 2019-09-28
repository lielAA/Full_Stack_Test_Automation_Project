package Workflows;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import extensions.Actions;
import extensions.Switch_To_Iframe;
import extensions.click;
import utilities.common_opps;

public class Web_Open_User_Helper extends common_opps
{
	
	public static void userHelperwindow(String selectService) throws IOException, ParserConfigurationException, SAXException
	{
	Actions.Mouse_Hover(YoTu_Left_Toolbar.User_Helper_buttons.get(0));
	Actions.Scrool_Down(0 , 2000);
	click.go_click_list_elem_by_text(YoTu_Left_Toolbar.User_Helper_buttons, selectService);
	Switch_To_Iframe.switchToIFRAME(YoTo_Helper_Iframe.User_Helper_Iframe_one);
	Switch_To_Iframe.switchToIFRAME(YoTo_Helper_Iframe.User_Helper_Iframe_two);
	}
}
