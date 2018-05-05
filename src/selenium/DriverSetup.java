package selenium;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

	static String pathToDriver = Paths.get("./").toAbsolutePath().toString() +
			File.separator + "driverExecutables" + File.separator;
    public enum Browser {
        Chrome,
        IE,
        Firefox
    }
    
	public static WebDriver setupDriver(Browser browser, String driverFileName) {
		WebDriver driver = null;
		String osName = (System.getProperty("os.name").toLowerCase().contains("mac") ? "mac" : "windows");
		if(browser == Browser.Chrome) {
			if (osName.equals("windows")) {
				System.setProperty("webdriver.chrome.driver", pathToDriver + driverFileName);
			} else {
				System.setProperty("webdriver.chrome.driver", pathToDriver + driverFileName);
			}
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //implicitly  wait 
		}
		
		else if(browser == Browser.Firefox) 
		{
		
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //implicitly  wait 
			
		}
		
		else if(browser == Browser.IE) {
			//Add config
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
}
