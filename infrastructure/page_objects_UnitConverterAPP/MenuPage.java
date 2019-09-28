package page_objects_UnitConverterAPP;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage 
{
	@FindBy(id = "design_menu_item_text")
	public List<WebElement> Menu_List;	
}
