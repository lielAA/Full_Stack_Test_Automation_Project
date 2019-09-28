package page_objects_YouTube;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_Helper_Iframe 
{
	@FindBy(id = "google-feedback-wizard")
	public WebElement User_Helper_Iframe_one;
	
	@FindBy (xpath = "//*[@id = 'content-container' and @class = 'ghp-content']/iframe[2]")
	public WebElement User_Helper_Iframe_two;
	
	@FindBy (id = "header-title")
	public WebElement User_Helper_Iframe_Title;
	
	@FindBy (className = "help-panel-header__search-input")
	public WebElement SearchBox;
	
	@FindBy (className = "help-panel-header__search-button")
	public WebElement Search_button;
	
	@FindBy (xpath = "//*[@class='help-panel-views']/div[8]/div/h4")
	public WebElement search_results_headear;
	
	@FindBy (xpath = "//*[@class='help-panel-views']/div[8]/div/h4")
	public WebElement search_results_header;
	
}
