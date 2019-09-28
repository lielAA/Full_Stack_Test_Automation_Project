package Workflows;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import extensions.Actions;
import extensions.click;
import utilities.common_opps;

public class Web_Select_New_Language extends common_opps 
{
	// WorkFlow to select new language for all YouTube interface
	public static void SelectNewLanguage(String ExpectedLanguage) throws IOException, ParserConfigurationException, SAXException
	{
		click.go_click(YoTu_Top_Toolbar.Languages_List_button);
		Actions.Mouse_Hover(YoTu_Top_Toolbar.Languages_List_button);
		Actions.Scrool_Down(0 , 1000);
		click.go_click_list_elem_by_text(YoTu_Top_Toolbar.Languages_List, ExpectedLanguage);
	}
}
