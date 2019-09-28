package Web_Tests;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import Workflows.Web_Play_Video;
import Workflows.Web_search;
import Workflows.db_Query;
import extensions.click;
import extensions.navigate_back;
import extensions.verify;
import extensions.wait_spacial_Time;
import utilities.common_opps;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.sikuli.script.FindFailed;
public class YouTube_search_and_play extends common_opps
{	
	@Test(groups = {"Hardcoded"})
	public void Test001_searchAndVerifyArtistCardName() throws IOException, ParserConfigurationException, SAXException, FindFailed  
	{
		Web_search.go("Queen");
		verify.text_in_Element(YoTu_page_result.artist_card_text, "Queen");
		verify.Sikuli_image("./image_Repositories/Queen_logo.png");
		navigate_back.back();
	}
	@Test(groups = {"DataBase"})  // This Test Verify Expected result straight through DB
	public void Test002_searchValueFromDB() throws IOException, ParserConfigurationException, SAXException, InterruptedException
	{
		click.go_click(YoTu_Top_Toolbar.search_button);
		wait_spacial_Time.wait_XX_Time(500);
		verify.text_in_Element(YoTu_page_result.artist_card_text ,db_Query.getMessage("ExpectedResult_YouTubbDB", "Queen"));
	}
	@Test(groups = {"Hardcoded"})
	public void Test003_VerifyHorizontalAlbumsListSize() throws IOException, ParserConfigurationException, SAXException
	{
		click.go_click(YoTu_page_result.Horizontal_Albums_Right_arrow);
		click.go_click(YoTu_page_result.Horizontal_Albums_Right_arrow);
		verify.list_size(YoTu_page_result.Horizontal_Albums_list, "10");
	}
	@Test(groups = {"Hardcoded"})
	public void Test004_VerifyVerticalAlbumsTextListAndClick() throws IOException, ParserConfigurationException, SAXException
	{
		verify.text_from_list(YoTu_page_result.Vertical_Albums_list_text, "Bohemian Rhapsody" , 0);
		click.go_click_list_elem(YoTu_page_result.Vertical_Albums_list_text , 0);
	}
	@Test(groups = {"Hardcoded"})
	public void Test005_PlayPauseAndMaximizeVideoContainer() throws InterruptedException, IOException, ParserConfigurationException, SAXException
	{
		Web_Play_Video.Play_Pause_Video();
	}	
}