package page_objects_UnitConverterAPP;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpperToolbar 
{
	@FindBy(id = "toolbar_spinner")
	public WebElement Region_list_button;
	
	@FindBy(id = "text1")
	public List<WebElement> Region_list;
	
	@FindBy (xpath = "//*[@contentDescription='Open navigation drawer']")
	public WebElement navigation_button;
	
}
