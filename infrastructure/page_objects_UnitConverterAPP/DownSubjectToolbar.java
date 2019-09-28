package page_objects_UnitConverterAPP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownSubjectToolbar 
{
	@FindBy (id = "tab0_layout0")
	public static WebElement Length_button;
	
	@FindBy (id = "tab0_layout1")
	public static WebElement Area_button;
	
	
	@FindBy (id = "tab0_layout2")
	public static WebElement weight_button;
	
	@FindBy (id = "tab0_layout3")
	public static WebElement Volume_button;
	
	//###################################################
	
	@FindBy (id = "text_living0")
	public WebElement Currency_text;
	
	@FindBy (id = "text_living1")
	public static WebElement Temp_text;
	
	@FindBy (id = "text_living2")
	public static WebElement Time_text;
	
	@FindBy (id = "text_living3")
	public static WebElement Speed_text;
}
