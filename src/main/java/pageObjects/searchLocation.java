package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchLocation {

	public WebElement enterDestination(WebDriver driver) {
		WebElement enterDestination = driver.findElement(By.id("querytext"));
		return enterDestination;
	}
	
	public WebElement selectDestSuggestion(WebDriver driver) {
		WebElement selectDestSuggestion = driver.findElement(By.xpath("//ul[@id='ssg-suggestions']/li[1]"));
		return selectDestSuggestion;
	}
	public WebElement checkinButton(WebDriver driver) {
		WebElement checkinButton = driver.findElement(By.xpath("//button[@key='checkInButton']"));
		return checkinButton;
	}
	public List<WebElement> datePickerBox(WebDriver driver) {
		List<WebElement> Date = new ArrayList<WebElement>();
		List<WebElement> datePickerBox = driver.findElements(By.xpath("//div[@class='two-month-calendar']//table[1]/tbody//tr//td/time/span/span"));
		int count = datePickerBox.size();
		for(int i =0; i<count; i++) {
			Date.add(datePickerBox.get(i));
		}
		//System.out.println(Date.get(5).getText());
		return Date;
	}
	public WebElement checkOutButton(WebDriver driver) {
		WebElement checkOutButton = driver.findElement(By.xpath("//button[@key='checkOutButton']"));
		return checkOutButton;
	}
	
	public WebElement selectAdults(WebDriver driver) {
		WebElement selectAdults = driver.findElement(By.id("adults-input"));
		return selectAdults;
	}
	public WebElement searchButton(WebDriver driver) {
		WebElement searchButton = driver.findElement(By.xpath("//span[text()='Search']"));
		return searchButton;
	}
	
	public WebElement guestRating(WebDriver driver) {
		WebElement guestRating = driver.findElement(By.xpath("//ul[@class='toolbar-list']//*[contains(text(),'Guest')]"));
		return guestRating;
	}
	public WebElement selectGuestRating(WebDriver driver, String Rating) {
		WebElement selectGuestRating = driver.findElement(By.xpath("//li[@class='range__item']//*[contains(text(),'" + Rating + "')]"));
		return selectGuestRating;
	}
	
	public WebElement searchResort(WebDriver driver, String ResortName) {
		WebElement searchResort = driver.findElement(By.xpath("//ol[@id='js_itemlist']//*[contains(text(),'" + ResortName + "')]"));
		return searchResort;
	}
	
	public WebElement clickViewDeal(WebDriver driver, String ResortName) {
		WebElement clickViewDeal = driver.findElement(By.xpath("//*[contains(text(),'" + ResortName + "')]//parent::h3//parent::div//parent::div//following-sibling::section//*[contains(text(),'View Deal')]"));
		return clickViewDeal;
	}
	
	public WebElement clickResortName(WebDriver driver, String ResortName) {
		WebElement clickResortName = driver.findElement(By.xpath("//*[contains(text(),'" + ResortName + "')]"));
		return clickResortName;
	}
	
	public WebElement findRoom(WebDriver driver, String RoomType) {
		WebElement findRoom = driver.findElement(By.xpath("//*[contains(text(),'" + RoomType + "')]"));
		return findRoom;
	}
	public WebElement selectRoom(WebDriver driver, String RoomType) {
		WebElement selectRoom = driver.findElement(By.xpath("//*[contains(text(),'" + RoomType + "')]//parent::div//parent::div//following-sibling::div//*[contains(text(),'Select')]"));
		return selectRoom;
	}
	public WebElement scrollToGuestDetail(WebDriver driver) {
		WebElement scrollToGuestDetail = driver.findElement(By.xpath("//*[contains(text(),'GUEST DETAILS')]"));
		return scrollToGuestDetail;
	}
	
	public WebElement FirstNameTxtBox(WebDriver driver) {
		WebElement FirstNameTxtBox = driver.findElement(By.xpath("//input[@placeholder='Enter First Name']"));
		return FirstNameTxtBox;
	}
	
	public WebElement LastNameTxtBox(WebDriver driver) {
		WebElement LastNameTxtBox = driver.findElement(By.xpath("//input[@placeholder='Enter Last Name']"));
		return LastNameTxtBox;
	}
	
	public WebElement emailTextBox(WebDriver driver) {
		WebElement emailTextBox = driver.findElement(By.xpath("//input[@placeholder='Enter Email Address']"));
		return emailTextBox;
	}
	
	public WebElement mobileNumber(WebDriver driver) {
		WebElement mobileNumber = driver.findElement(By.xpath("//input[@placeholder='Enter Phone Number']"));
		return mobileNumber;
	}
	public WebElement proceedToPayment(WebDriver driver) {
		WebElement proceedToPayment = driver.findElement(By.xpath("//button[contains(text(),'Proceed To Payment Options')]"));
		return proceedToPayment;
	}
}
