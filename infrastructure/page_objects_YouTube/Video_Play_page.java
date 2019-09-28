package page_objects_YouTube;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Video_Play_page // identify elements for video container page
{
	@FindBy(id = "player-container")
	public WebElement player_container;
	
	@FindBy(how =How.XPATH , using = "//*[@class = 'ytp-left-controls']/button")
	public WebElement play_pause_button;
	
	@FindBy(how =How.XPATH , using = "//*[@class = 'ytp-right-controls']/button")
	public List<WebElement> right_control_buttons;
}
