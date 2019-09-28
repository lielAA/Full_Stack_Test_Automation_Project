package Web_Tests;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import Workflows.Web_Open_User_Helper;
import Workflows.Web_Select_New_Language;
import Workflows.db_Query;
import extensions.RefreshPage;
import extensions.Switch_To_Iframe;
import extensions.click;
import extensions.update;
import extensions.verify;
import utilities.common_opps;

public class YouTube_Change_language_and_Country extends common_opps
{
	@Test(groups = {"Hardcoded"})
	public void Test001_verifyForDefaultEnglishLanguage() throws IOException, ParserConfigurationException, SAXException, InterruptedException 
	{
		click.go_click(YoTu_Top_Toolbar.settings_button);
		verify.text_in_Element(YoTu_Top_Toolbar.Language_text, "English");	
		RefreshPage.Refresh_Page();
	}
	@Test(groups = {"DataBase"}) // This Test Verify Expected result straight through DB
	public void Test002_verifyForDefaultEnglishLanguageFromDB() throws IOException, ParserConfigurationException, SAXException, InterruptedException, FindFailed
	{
		click.go_click(YoTu_Top_Toolbar.settings_button);
		verify.text_in_Element(YoTu_Top_Toolbar.Language_text, db_Query.getMessage("ExpectedResult_YouTubbDB", "English"));
	}
	@Test(groups = {"Hardcoded"})
	public void Test003_SelectNewLanguage() throws IOException, ParserConfigurationException, SAXException, InterruptedException, FindFailed
	{
		Web_Select_New_Language.SelectNewLanguage("עברית");
		verify.Sikuli_image("./image_Repositories/login_Hebrew_Button.png");
	}
	@Test(groups = {"Hardcoded"})
	public void Test004_MoveToUserHelperIFRAME() throws IOException, ParserConfigurationException, SAXException, InterruptedException, FindFailed 
	{
		Web_Open_User_Helper.userHelperwindow("עזרה");
		verify.Sikuli_image("./image_Repositories/Helper_Iframe.png");
	}
	@Test(groups = {"Hardcoded"})
	public void Test005_SearchInsideUserHelperIFRAME() throws IOException, ParserConfigurationException, SAXException
	{
		update.update_text(YoTo_Helper_Iframe.SearchBox, "Sort");
		click.go_click(YoTo_Helper_Iframe.Search_button);
		Switch_To_Iframe.switchFromIFRAMEToMainPage();
	}
}