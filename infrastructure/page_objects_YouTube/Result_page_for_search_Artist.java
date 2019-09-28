package page_objects_YouTube;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Result_page_for_search_Artist 
{
	@FindBy(xpath = "//*[@id = 'secondary']/div/ytd-universal-watch-card-renderer/div/ytd-watch-card-rich-header-renderer/div/div/a/ytd-channel-name/div/div/yt-formatted-string")
	public WebElement artist_card_text;
	
	@FindBy(xpath = "//*[@id = 'items']/ytd-watch-card-compact-video-renderer/a/div/div/yt-formatted-string")
	public List<WebElement> Vertical_Albums_list_text;
	
	@FindBy(xpath = "//*[@id = 'secondary']/div/ytd-universal-watch-card-renderer/div[3]/ytd-watch-card-section-sequence-renderer[2]/div/ytd-horizontal-card-list-renderer/div[2]/div[2]/div/ytd-search-refinement-card-renderer")
	public List<WebElement> Horizontal_Albums_list;
	
	@FindBy(xpath = "//*[@id = 'secondary']/div/ytd-universal-watch-card-renderer/div[3]/ytd-watch-card-section-sequence-renderer[2]/div/ytd-horizontal-card-list-renderer/div[2]/div[3]")
	public WebElement Horizontal_Albums_Right_arrow;	
}
