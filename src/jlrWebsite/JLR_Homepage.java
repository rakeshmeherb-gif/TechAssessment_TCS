package jlrWebsite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class JLR_Homepage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");

		//Added SELENIUM Dependency to Initializing Chrome browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jaguarlandrover.com/");
		driver.manage().window().maximize();

		//Synchronization - Using Implicit Wait to load the complete website (This sets a global timeout for finding elements across the entire test script)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		//Added TESTNG Dependency to Checking whether homepage is loaded with "Company" menu
		String menu = driver.findElement(By.xpath("//nav[@class='nav-2024']/div[3]/div/div/div")).getText();
		assertEquals(menu, "Company");
		System.out.println("JLR Homepage is loaded with Header menus. Example : "+menu);
		
		System.out.println("*** Below are the Header menu items ***");

		//Loading all the Header links left to Logo - Finding the parent element
		WebElement leftelements = driver.findElement(By.xpath("//div[@class='nav-2024__item-wrap nav-2024__item-wrap--left']"));

		// Find the child element
		List<WebElement> leftlist = leftelements.findElements(By.xpath("./child::*")); 

		// iterate the list
		for ( WebElement i : leftlist ) {	      
			// Print the child elements
			System.out.println(i.getText());
		}

		//Loading all the Header links right to Logo - Finding the parent element
		WebElement rightelements = driver.findElement(By.xpath("//div[@class='nav-2024__item-wrap nav-2024__item-wrap--right']"));

		// Find the child element
		List<WebElement> rightlist = rightelements.findElements(By.xpath("./child::*")); 

		// iterate the list
		for ( WebElement i : rightlist ) 
		{	      
			// Print the child elements
			System.out.println(i.getText());
		}

		//Calling Company class
		JLR_Menu_1Company.companyLabel(driver);
		JLR_Menu_1Company.companyDropdownItems(driver);
		
		//Calling Brands class
		JLR_Menu_2Brands.brandsLabel(driver);
		JLR_Menu_2Brands.brandsDropdownItems(driver);
		
		//Calling Investors class
		JLR_Menu_3Investors.investorsLabel(driver);
		JLR_Menu_3Investors.investorsDropdownItems(driver);
		
	}

}
