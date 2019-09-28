package page_objects_YouTube;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Top_Toolbars // identify elements for YouTube Top_Toolbar 
{
	@FindBy(id = "search")
	public WebElement search_box;
	
	@FindBy(id = "search-icon-legacy")
	public WebElement search_button;
	
	@FindBy(id = "logo")
	public static WebElement main_page_button;
	
	@FindBy(xpath = "//*[@id='buttons']/ytd-topbar-menu-button-renderer[3]")
	public WebElement settings_button;
	
	@FindBy(xpath = "//*[@id ='language']/span[2]")
	//*[@id="language"]/span[2]
	public WebElement Language_text;
	
	@FindBy(id = "language")
	public WebElement Languages_List_button;
	
	@FindBy(xpath = "//div[@id = 'settings' and @class = 'style-scope yt-multi-page-menu-section-renderer']/ytd-account-settings/div/div[2]/paper-item/p")
	public List<WebElement> Languages_List;
	
	@FindBy(id = "guide-icon")
	public WebElement Guide_button;
}