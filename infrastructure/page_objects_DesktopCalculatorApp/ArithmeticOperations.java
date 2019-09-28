package page_objects_DesktopCalculatorApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArithmeticOperations
{
	@FindBy(name = "Display is 9")
	public WebElement Result_Field;
	
	@FindBy(name = "Plus")
	public WebElement Plus_Btn;
	
	@FindBy(name = "Minus")
	public WebElement Minus_Btn;
	
	@FindBy(name = "Multiply by")
	public WebElement Multiply_Btn;
	
	@FindBy(name = "Divide by")
	public WebElement Divide_Btn;
	
	@FindBy(name = "Equals")
	public WebElement Equal_Btn;
}