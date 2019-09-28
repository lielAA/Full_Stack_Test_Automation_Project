package page_objects_ElectronAPIDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mainPage 
{
	@FindBy(id = "button-app-sys-information")
	public WebElement Info_button;
	
	@FindBy(id = "button-windows")
	public WebElement create_Window_button;
	
	@FindBy(id = "screen-info-demo-toggle")
	public WebElement demo_toggle_button;
	
	@FindBy(id = "screen-info")
	public WebElement view_demo_button;
	
	@FindBy(id = "got-screen-info")
	public WebElement Field_Screen_Info;
}
