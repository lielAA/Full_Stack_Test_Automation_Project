package page_objects_UnitConverterAPP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetSettingsFrame 
{
	@FindBy(id = "button1")
	public WebElement OK_Button;
	
	@FindBy (id = "message")
	public WebElement reset_settings_message;
}
