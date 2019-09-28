package utilities;

import org.openqa.selenium.support.PageFactory;

import page_objects_DesktopCalculatorApp.ArithmeticOperations;
import page_objects_DesktopCalculatorApp.CalcuatorNumbers;
import page_objects_ElectronAPIDemo.mainPage;
import page_objects_YouTube.Top_Toolbars;
import page_objects_YouTube.User_Helper_Iframe;
import page_objects_YouTube.Left_Toolbar;
import page_objects_YouTube.Result_page_for_search_Artist;
import page_objects_YouTube.Video_Play_page;
import page_objects_UnitConverterAPP.BasicPage;
import page_objects_UnitConverterAPP.DownSubjectToolbar;
import page_objects_UnitConverterAPP.MenuPage;
import page_objects_UnitConverterAPP.TopSubjectToolbar;
import page_objects_UnitConverterAPP.UpperToolbar;
import page_objects_UnitConverterAPP.keyboard_keys;
import page_objects_UnitConverterAPP.ResetSettingsFrame;
public class manage_pages extends base
{
	//####### init all element from pageObjects pages #############
	public static void init_elements()
	{
		// init for youtube web browser
		YoTu_Top_Toolbar = PageFactory.initElements(driver , Top_Toolbars.class);
		YoTu_page_result = PageFactory.initElements(driver , Result_page_for_search_Artist.class);
		YoTu_Left_Toolbar = PageFactory.initElements(driver , Left_Toolbar.class);
		YoTu_Video_Play_page = PageFactory.initElements(driver , Video_Play_page.class); 
		YoTo_Helper_Iframe = PageFactory.initElements(driver, User_Helper_Iframe.class);
		
		// init for UnitConverter APP mobile
		UnitConverter_BasicPage = PageFactory.initElements(driver, BasicPage.class);
		UnitConverter_keyboard_keys = PageFactory.initElements(driver, keyboard_keys.class);
		UnitConverter_TopSubjectToolbar = PageFactory.initElements(driver, TopSubjectToolbar.class);
		UnitConverter_DownSubjectToolbar = PageFactory.initElements(driver, DownSubjectToolbar.class);
		UnitConverter_UpperToolbar = PageFactory.initElements(driver, UpperToolbar.class);
		UnitConverter_MenuPage = PageFactory.initElements(driver, MenuPage.class);
		UnitConverter_ResetSettingsFrame = PageFactory.initElements(driver, ResetSettingsFrame.class);
		
		// init for Electron_Demo_APP 
		ElectronMain = PageFactory.initElements(driver, mainPage.class);
		
		//init for Desktop_Alarm&Clocks App
		Desktop_ArithmeticOperations = PageFactory.initElements(Desktopdriver, ArithmeticOperations.class);
		Desktop_CalcuatorNumbers = PageFactory.initElements(Desktopdriver, CalcuatorNumbers.class);
	}
}
