package tests.amazonTest;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import pages.HomePage;
import pages.SearchResultsPage;
import selenium.DriverSetup;


public class AmazonTest {

	@BeforeClass(alwaysRun = true)
	public void setupClass()
	{
	
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setupTest()
	{

	}

	@Parameters()
	@Test(description = "Test Description")
	public void groupSetup() throws Exception{
		WebDriver driver = DriverSetup.setupDriver(DriverSetup.Browser.Chrome, "chromedriver.exe");
		driver.navigate().to("https://www.amazon.com");
		driver.manage().window().maximize();
		
		//created page object using page factory
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.search(); //call methods of HomePage Class
		
		
		SearchResultsPage searchresultpage = PageFactory.initElements(driver, SearchResultsPage.class);
		searchresultpage.refineSearchCaseMaterial(); //call methods of SearchResultsPage class
		searchresultpage.refineSearchMinMaxPrice();
		
		/*************Search 5 elements and call the methods for retrieving name of each element*******/
		searchresultpage.searchFirstElementname();
		//navigate back to search window
		driver.navigate().back();
		searchresultpage.searchSecondElementname();
		//navigate back to search window
		driver.navigate().back();
		searchresultpage.searchThirdElementname();
		//navigate back to search window
		driver.navigate().back();
		searchresultpage.searchForthElementname();
		//navigate back to search window
		driver.navigate().back();
		searchresultpage.searchFifthElementname();
		//navigate back to search window
		driver.navigate().back();
		
		//call sortPrice fuunction
		searchresultpage.sortPrice();
		
		//call sortRating fuunction
		searchresultpage.sortRating();
		
		searchresultpage.recommend();
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDownTest()
	{

	}
	
	@AfterClass(alwaysRun = true)
	public void tearDownClass()
	{

	}
}
