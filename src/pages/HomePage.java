package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{

	private WebDriver driver; 
	@FindBy(id="twotabsearchtextbox") 
	@CacheLookup
	WebElement search_field_id;
	
	@FindBy(xpath="//input[@class='nav-input' and @value='Go']") 
	@CacheLookup
	WebElement search_field_click_id;
	
	
	public void search()
	{
		search_field_id.sendKeys("ipad air 2 case");
		search_field_click_id.click();
		
		
	}
	
}
