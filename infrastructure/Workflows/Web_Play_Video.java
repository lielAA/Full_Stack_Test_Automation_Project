package Workflows;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import extensions.click;
import utilities.common_opps;

public class Web_Play_Video extends common_opps
{
	//########### workFlow for play/pause video in maximize view ###########
	public static void Play_Pause_Video() throws InterruptedException, IOException, ParserConfigurationException, SAXException
	{
		click.go_click(YoTu_Video_Play_page.play_pause_button);
		click.go_click_list_elem(YoTu_Video_Play_page.right_control_buttons, 8);
		click.go_click(YoTu_Video_Play_page.play_pause_button);
		Thread.sleep(5500);
		click.go_click_list_elem(YoTu_Video_Play_page.right_control_buttons, 8);
	}
}