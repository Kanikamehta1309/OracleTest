package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	

		
	public WebElement navAccount(WebDriver driver) {
		WebElement navAccountId = driver.findElement(By.xpath("//span[@id='user-text']//span[2]"));
		return navAccountId;
	}
	
	public WebElement navAccountSettings(WebDriver driver) {
		WebElement navAccountSettings = driver.findElement(By.xpath("//a[text()='Account settings']"));
		return navAccountSettings;
	}
	
	public WebElement navHelpSupport(WebDriver driver) {
		WebElement navHelpSupport = driver.findElement(By.xpath("//a[text()='Help and support']"));
		return navHelpSupport;
	}
	
	public WebElement selectIssue(WebDriver driver) {
		WebElement 	selectIssue = driver.findElement(By.id("error-topics"));
		return selectIssue;
	}
	
	public WebElement selectErrorType(WebDriver driver) {
		WebElement 	selectErrorType = driver.findElement(By.id("error-encounter"));
		return selectErrorType;
	}
	
	public WebElement subjectTextBox(WebDriver driver) {
		WebElement 	subjectTextBox = driver.findElement(By.id("subject"));
		return subjectTextBox;
	}
	
	public WebElement descriptionTextBox(WebDriver driver) {
		WebElement 	descriptionTextBox = driver.findElement(By.id("description"));
		return descriptionTextBox;
	}
	public WebElement hotelName(WebDriver driver) {
		WebElement 	hotelName = driver.findElement(By.id("hotel-name"));
		return hotelName;
	}
	
	public WebElement bookingSite(WebDriver driver) {
		WebElement 	bookingSite = driver.findElement(By.id("booking-site"));
		return bookingSite;
	}
	public WebElement checkinDate(WebDriver driver) {
		WebElement 	checkinDate = driver.findElement(By.id("checkin-date"));
		return checkinDate;
	}
	
	public List<WebElement> datePicker(WebDriver driver){
		List<WebElement> days = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(By.xpath("//table[@id='grid']//tbody//button"));
		for(int i =0; i<elements.size();i++) {
			days.add(elements.get(i));
		}
		return days;
	}
	
	public WebElement attachment(WebDriver driver) {
		WebElement 	attachment = driver.findElement(By.xpath("//span[text()='Choose a file']"));
		return attachment;
	}
	
	public WebElement sendMessage(WebDriver driver) {
		WebElement 	sendMessage = driver.findElement(By.xpath("//button[text()='Send message']"));
		return sendMessage;
	}
	
	public WebElement successMessage(WebDriver driver) {
		WebElement 	successMessage = driver.findElement(By.xpath("//p[contains(@class,'profile-management__message')]//parent::div/h4"));
		return successMessage;
	}
	
	
	
	
}
