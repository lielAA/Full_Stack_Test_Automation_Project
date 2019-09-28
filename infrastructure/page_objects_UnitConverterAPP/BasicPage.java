package page_objects_UnitConverterAPP;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicPage 
{
	
	@FindBy (id = "tab0_input")
	public WebElement inputValueField;
	
	@FindBy (id = "tab0_selector")
	public WebElement dropBox_UnitsOfmeasurementButton;
	
	@FindBy (id = "text1")
	public List<WebElement> dropBox_UnitsOfmeasurementList;
	
	//########################################################################################3	
	
	// ############ Elements from Basic:Length page ################
	@FindBy (id = "unit_value")
	public List<WebElement> convertResults;
	
	@FindBy (xpath = "//*[@contentDescription='Open navigation drawer']")
	public WebElement navigation_button;
	
//########################################################################################3	
	
	// ############ Elements from Living:Currency page ################
	@FindBy (id = "unit_kind")
	public List<WebElement> Country_names;
}
