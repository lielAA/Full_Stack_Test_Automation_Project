package page_objects_YouTube;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Left_Toolbar 
{
	@FindBy(xpath = "//*[@id = 'guide-renderer']/div[1]/ytd-guide-section-renderer[6]/div/ytd-guide-entry-renderer")
	public List<WebElement> User_Helper_buttons;
}
