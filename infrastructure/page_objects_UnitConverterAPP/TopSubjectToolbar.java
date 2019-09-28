package page_objects_UnitConverterAPP;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopSubjectToolbar 
{
	@FindBy (className = "android.widget.LinearLayout")
	public List<WebElement> Buttons;
}
