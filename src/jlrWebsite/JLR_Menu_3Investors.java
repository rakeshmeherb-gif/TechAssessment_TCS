package jlrWebsite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JLR_Menu_3Investors {
	
	public static WebDriver investorsLabel(WebDriver driver)
	{

		String menu = driver.findElement(By.xpath("//nav[@class='nav-2024']/div[3]/div[3]/div/div")).getText();
		System.out.println("*** Getting the label of on menu item : '"+menu+"'");

		return driver;
	}

	public static WebDriver investorsDropdownItems(WebDriver driver)
	{
		//Menu items are not visible until the "INVESTORS" menu item is clicked
		driver.findElement(By.xpath("//div[@class='nav-2024__item-wrap nav-2024__item-wrap--left']/div[3]")).click();
		
		//Loading all the INVESTORS drop down items - Finding the parent element
		WebElement investors = driver.findElement(By.xpath("//div[@class='nav-2024__item-wrap nav-2024__item-wrap--left']/div[3]/div[2]/div"));

		// Find the child element
		List<WebElement> investorsList = investors.findElements(By.xpath("./child::*")); 
		String menu = driver.findElement(By.xpath("//nav[@class='nav-2024']/div[3]/div[3]/div/div")).getText();
		System.out.println("*** We are clicking on menu item '"+menu+"' and getting the list of dropdown items : "+investorsList.size());		

		// iterate the list
		for ( WebElement i : investorsList ) 
		{
			// Print the child elements
			System.out.println(i.getText());			
		}
		
		return driver;
	}

}
