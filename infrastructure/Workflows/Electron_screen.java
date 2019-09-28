package Workflows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extensions.click;
import utilities.common_opps;

public class Electron_screen extends common_opps
{
	public static void getInfo() throws IOException, ParserConfigurationException, SAXException
	{
		click.go_click(ElectronMain.create_Window_button);
		click.go_click(ElectronMain.Info_button);
		click.go_click(ElectronMain.demo_toggle_button);
		click.go_click(ElectronMain.demo_toggle_button);
		click.go_click(ElectronMain.view_demo_button);
	}
}
