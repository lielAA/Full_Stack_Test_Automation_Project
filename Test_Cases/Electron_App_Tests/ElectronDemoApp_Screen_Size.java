package Electron_App_Tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import Workflows.Electron_screen;
import extensions.verify;
import utilities.common_opps;

public class ElectronDemoApp_Screen_Size extends common_opps
{
	@Test
	public void Test001_GetInfo() throws IOException, ParserConfigurationException, SAXException
	{
		Electron_screen.getInfo();
		verify.text_in_Element(ElectronMain.Field_Screen_Info, "Your screen is: 1536px x 864px");
	}
}
