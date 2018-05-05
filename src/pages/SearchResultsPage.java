package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.google.common.collect.Ordering;




public class SearchResultsPage 
{

	@FindBy(xpath="//input[@name='s-ref-checkbox-8080061011']") //xpath to identify case material as plastic
	@CacheLookup
	WebElement select_plastic_case_material_id;
	
	@FindBy(xpath="//input[@id='low-price']") //id to find the webelement for min field
	@CacheLookup
	WebElement min_price_id;
	
	@FindBy(xpath="//input[@id='high-price']") //id to find the webelement for max field
	@CacheLookup
	WebElement max_price_id;
	
	@FindBy(xpath="//input[@class='a-button-input' and @value='Go']") //xpath to find the webelement id of Go button to refine search. 
	@CacheLookup
	WebElement go_button_id;
	
	//To retieve first elements select only 1st name
	@FindBy(css=".a-size-base.s-inline.s-access-title.a-text-normal") //xpath to find the webelement id of item 1 name. 
	@CacheLookup
	List<WebElement> search_element_name_1_id;
	
	//To retieve first 5 elements select only 2nd name
	@FindBy(css=".a-size-base.s-inline.s-access-title.a-text-normal") //xpath to find the webelement id of item 1 name. 
	@CacheLookup
	List<WebElement> search_element_name_2_id;
	
	//To retieve first 5 elements select only 3rd name
	@FindBy(css=".a-size-base.s-inline.s-access-title.a-text-normal") //xpath to find the webelement id of item 1 name. 
	@CacheLookup
	List<WebElement> search_element_name_3_id;
	
	//To retieve first 5 elements select only 4th name
	@FindBy(css=".a-size-base.s-inline.s-access-title.a-text-normal") //xpath to find the webelement id of item 1 name. 
	@CacheLookup
	List<WebElement> search_element_name_4_id;
	
	//To retieve first 5 elements select only 5th name
	@FindBy(css=".a-size-base.s-inline.s-access-title.a-text-normal") //xpath to find the webelement id of item 1 name. 
	@CacheLookup
	List<WebElement> search_element_name_5_id;
	
	/********item 1 description*********/
	@FindBy(xpath="//span[@id='priceblock_ourprice']") //xpath to find the webelement id of item 1 price. 
	@CacheLookup
	WebElement search_element_1_price_id;
	
	@FindBy(xpath="//span[@class='arp-rating-out-of-text']") //xpath to find the webelement id of item 1 rating. 
	@CacheLookup
	WebElement search_element_1_rating_id;
	
	/********item 2 description*********/
	@FindBy(xpath="//span[@id='priceblock_ourprice']") //xpath to find the webelement id of item 2 rating. 
	@CacheLookup
	WebElement search_element_2_price_id;
	
	@FindBy(xpath="//span[@class='arp-rating-out-of-text']") //xpath to find the webelement id of item 2 rating. 
	@CacheLookup
	WebElement search_element_2_rating_id;
	
	/********item 3 description*********/
	@FindBy(xpath="//span[@id='priceblock_ourprice']") //xpath to find the webelement id of item 3 rating. 
	@CacheLookup
	WebElement search_element_3_price_id;
	
	@FindBy(xpath="//span[@class='arp-rating-out-of-text']") //xpath to find the webelement id of item 3 rating. 
	@CacheLookup
	WebElement search_element_3_rating_id;
	
	/********item 4 description*********/
	@FindBy(xpath="//span[@id='priceblock_ourprice']") //xpath to find the webelement id of item 5 rating. 
	@CacheLookup
	WebElement search_element_4_price_id;
	
	@FindBy(xpath="//span[@class='arp-rating-out-of-text']") //xpath to find the webelement id of item 4 rating. 
	@CacheLookup
	WebElement search_element_4_rating_id;
	
	/********item 5 description*********/
	@FindBy(xpath="//span[@class='a-color-price a-text-bold']") //xpath to find the webelement id of item 4 rating. 
	@CacheLookup
	WebElement search_element_5_price_id;
	
	@FindBy(xpath="//span[@class='arp-rating-out-of-text']") //xpath to find the webelement id of item 5 rating. 
	@CacheLookup
	WebElement search_element_5_rating_id;
	
	//collections to add itemName
	ArrayList <String> itemNameStore = new ArrayList<String> ();
		
	//collections to add itemPriceAsc
	ArrayList <String> itemPriceBeforeSort = new ArrayList<String> ();
	
	//collections to add itemRatingAsc
	ArrayList <String> itemRatingBeforeSort = new ArrayList<String> ();
	
	
	
	public void refineSearchCaseMaterial() throws InterruptedException
	{
			select_plastic_case_material_id.click();
			Thread.sleep(3000);
		
	}
	
	public void refineSearchMinMaxPrice()
	{
		
		min_price_id.sendKeys("20");
		
		max_price_id.sendKeys("100");
		
		go_button_id.click();
				
		
	}
	
	/*************item 1 retreival *******/
	public void searchFirstElementname()
	{
		
		String item1Description="";
		for(int i=0;i<1;i++)
		{
			item1Description= search_element_name_1_id.get(i).getText();
			search_element_name_1_id.get(i).click();
			
			
		}
		//add item 1 price to array list
		itemNameStore.add(item1Description);
		System.out.println("***********************Item 1 retreival***********************");
		System.out.println("Name of the product: "+item1Description);
		
		//item 1 price
		String item1Price = search_element_1_price_id.getText();
		String newItem1PriceAss = item1Price.substring(1,3);
		int x = Integer.parseInt(newItem1PriceAss);
		//Assert whether the given product is in range $20 and $100
		Assert.assertTrue(20<= x && 100>=x);
		
		//print the price of the product
		System.out.println("Price of the product: "+item1Price);
		System.out.println("Assertion passed");
		
		////add item 1 price to array list
		itemPriceBeforeSort.add(item1Price);
				
		//item 1 rating retrieval
		String item1Rating = search_element_1_rating_id.getText();
		System.out.println("Rating of the product: "+item1Rating);
		
		//add item 1 rating to array list 
		itemRatingBeforeSort.add(item1Rating);
		
		
						
	}
	
		
	/************** item 2 retrieval ************/
	
	public void searchSecondElementname()
	{
		
		String item2Description="";
		for(int i=1;i<2;i++)
		{
			item2Description = search_element_name_2_id.get(i).getText();
			search_element_name_2_id.get(i).click();
			
			
		}
		//add item 2 price to array list
		itemNameStore.add(item2Description);
		System.out.println("***********************Item 2 retreival***********************");
		System.out.println("Name of the product: "+item2Description);
		
		//item 2 price
		String item2Price = search_element_2_price_id.getText();
		String newItem2PriceAss = item2Price.substring(1,3);
		int x = Integer.parseInt(newItem2PriceAss);
		//Assert whether the given product is in range $20 and $100
		Assert.assertTrue(20<= x && 100>=x);
		
		//print the price of product
		System.out.println("Price of the product: "+item2Price);
		System.out.println("Assertion passed");
		
		//add item 2 price to array list
		itemPriceBeforeSort.add(item2Price);
		
		//item 2 rating retrieve 
		String item2Rating = search_element_2_rating_id.getText();
		System.out.println("Rating of the product: "+item2Rating);
		
		//add item 2 rating to array list 
		itemRatingBeforeSort.add(item2Rating);
		
		
				
	}
	
	/************** item 3 retrieval ************/
	
	public void searchThirdElementname()
	{
		
		String item3Description="";
		for(int i=2;i<3;i++)
		{
			item3Description= search_element_name_3_id.get(i).getText();
			search_element_name_3_id.get(i).click();
			
			
		}
		//add item 3 price to array list
		itemNameStore.add(item3Description);
		System.out.println("***********************Item 3 retreival***********************");
		System.out.println("Name of the product: "+item3Description);
		
		//item 3 price
		String item3Price = search_element_3_price_id.getText();
		String newItem3PriceAss = item3Price.substring(1,3);
		int x = Integer.parseInt(newItem3PriceAss);
		//Assert whether the given product is in range $20 and $100
		Assert.assertTrue(20<= x && 100>=x);
		
		//print the price of the product
		System.out.println("Price of the product: "+item3Price);
		System.out.println("Assertion passed");
		
		
		//add item 3 price to array list
		itemPriceBeforeSort.add(item3Price);
		
		
		//item 3 rating retrieve 
		String item3Rating = search_element_3_rating_id.getText();
		System.out.println("Rating of the product: "+item3Rating);
		
		//add item 3 rating to array list 
		itemRatingBeforeSort.add(item3Rating);
		
				
	}
	
	/************** item 4 retrieval 
	 * @throws InterruptedException ***************/
	public void searchForthElementname() throws InterruptedException
	{
		
		String item4Description="";
		
		for(int i=3;i<4;i++)
		{
			item4Description= search_element_name_4_id.get(i).getText();
			search_element_name_4_id.get(i).click();
			
		}
		//add item 4 price to array list
		itemNameStore.add(item4Description);
		System.out.println("***********************Item 4 retreival***********************");
		System.out.println("Name of the product: "+item4Description);
		
		//item 4 price
		
		/*String item4Price = search_element_4_price_id.getText();
		String newItemPrice = item4Price.substring(5,10);
		String newItem4PriceAss = newItemPrice.substring(1,3);*/
		
		String item4Price = search_element_4_price_id.getText();
		String newItem4PriceAss = item4Price.substring(1,3);
		
		int x = Integer.parseInt(newItem4PriceAss);
		//Assert whether the given product is in range $20 and $100
		Assert.assertTrue(20<= x && 100>=x);
		
		//price of the product
		System.out.println("Price of the product: "+item4Price);
		System.out.println("Assertion passed");
		
		//add item 4 price to array list
		itemPriceBeforeSort.add(item4Price);	
		
		//item 4 rating retrieve 
		String item4Rating = search_element_4_rating_id.getText();
		System.out.println("Rating of the product: "+item4Rating);
		
		//add item 4 rating to array list 
		itemRatingBeforeSort.add(item4Rating);
				
				
	}
	/************** item 5 retrieval ***************/
	
	public void searchFifthElementname()
	{
		
		String item5Description="";
		for(int i=4;i<5;i++)
		{
			item5Description= search_element_name_5_id.get(i).getText();
			search_element_name_5_id.get(i).click();
			
			
		}
		//add item 5 price to array list
		itemNameStore.add(item5Description);
		System.out.println("***********************Item 5 retreival***********************");
		System.out.println("Name of the product: "+item5Description);
		
		//item 5 price
		/*String item5Price = search_element_5_price_id.getText();
		String newItem5PriceAss = item5Price.substring(1,3); */
		String item5Price = search_element_5_price_id.getText();
		String newItemPrice = item5Price.substring(5,10);
		String newItem5PriceAss = newItemPrice.substring(1,3);
		
		int x = Integer.parseInt(newItem5PriceAss);
		//Assert whether the given product is in range $20 and $100
		Assert.assertTrue(20<= x && 100>=x);
		
		//print the price of the product
		System.out.println("Price of the product: "+newItemPrice);
		System.out.println("Assertion passed");
		
		//add item 5 price to array list
		itemPriceBeforeSort.add(newItemPrice);
		
		//item 5 rating retrieve 
		String item5Rating = search_element_5_rating_id.getText();
		System.out.println("Rating of the product: "+item5Rating);
		
		//add item 5 rating to array list 
		itemRatingBeforeSort.add(item5Rating);
					
	}
	
	
	
	public void sortPrice()
	{
		ArrayList <String> itemPriceToSort = new ArrayList<String> (itemPriceBeforeSort);
		System.out.println();
		System.out.println("*********unsorted list of Price*********");
		System.out.println(itemPriceToSort);
		Collections.sort(itemPriceToSort);
		System.out.println();
		System.out.println("***********sorted according to price***********");
		System.out.println(itemPriceToSort);
		
		//Although we need to use Assert.assertThat() function here for some reason I could not get that methoad after trying multiple times so used this alternative method
		boolean sorted = Ordering.natural().isOrdered(itemPriceToSort);
		System.out.println("check sorted list of Price :"+sorted);
		
		
	}
	
	
	public void sortRating()
	{
		ArrayList <String> itemRatingToSort = new ArrayList<String> (itemRatingBeforeSort);
		System.out.println();
		System.out.println("*********unsorted list of all Rating*********");
		System.out.println(itemRatingToSort);
		Collections.sort(itemRatingToSort);
		System.out.println();
		System.out.println("***********sorted according to Rating********");
		System.out.println(itemRatingToSort);
		
	}
	

	public String recommend()
	{
		
		HashMap<String,Integer> namePrice = new HashMap<>();
		ArrayList<Float> arr = new ArrayList<Float>();
		
		//give weights for price and rating
		int priceStringSize= itemPriceBeforeSort.size();
		Float result;

		for(int i=0;i<priceStringSize;i++)
		{
			
			//Price is multiplied by 0.4 and Rating is multiplied by 0.6 and product of both is added to give a rating
			result = Float.parseFloat(itemPriceBeforeSort.get(i).substring(1))* 0.4f + Float.parseFloat(itemRatingBeforeSort.get(i).substring(0,3))* 0.6f;
			namePrice.put(result.toString(),i);
			arr.add(result);			
			
			
		}
		Collections.sort(arr);
		int index = namePrice.get(arr.get(0).toString());
		System.out.println();
		System.out.println("Recomended item with best rating and price : "+itemNameStore.get(index));
		return itemNameStore.get(index);
				
	}
	
}
