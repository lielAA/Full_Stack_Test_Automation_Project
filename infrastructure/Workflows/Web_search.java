package Workflows;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import extensions.click;
import extensions.update;
import utilities.common_opps;

public class Web_search extends common_opps
{
	//######### workFlow for search value and click search ###########
	public static void go(String Search_value) throws IOException, ParserConfigurationException, SAXException 
	{
		update.update_text(YoTu_Top_Toolbar.search_box, Search_value);
		click.go_click(YoTu_Top_Toolbar.search_button);
	}	
}
