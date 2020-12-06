package oracle.Trivago;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Generic;
import pageObjects.HomePage;
import pageObjects.loginRegisterPage;
import pageObjects.searchLocation;
import resources.BaseClass;
import resources.datePicker;
import resources.variables;

public class HomePageNav extends BaseClass {
	String path = System.getProperty("user.dir");
	Generic gen = new Generic();
	String email = "";
	String password = "";
	String parentWindow;
	String childWindow1;
	String childWindow2;
	HomePage home = new HomePage();
	variables va = new variables();
	loginRegisterPage login = new loginRegisterPage();
	Actions action;
	datePicker dp = new datePicker();
	searchLocation searchPlace = new searchLocation();

	@BeforeMethod
	public void homePageNav() throws IOException {
		driver = initializeDriver();
		/*
		 * Open Trivago website
		 * 
		 */
		driver.get(BaseURL);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		email = gen.randomEmailId();
		password = gen.randomPassword();
		action = new Actions(driver);

	}

	@Test(priority = 1)
	public void CreateAccount() throws IOException, InterruptedException {

		/*
		 * 
		 * Create an account – Generate random username and password in the proper
		 * format
		 */
		login.createAccount(driver).click();
		login.emailTextBox(driver).sendKeys(email);
		login.passwordTextBox(driver).sendKeys(password);
		login.registerButton(driver).click();
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void helpSupport() throws InterruptedException {
		/*
		 * 
		 * Login to the website Use appropriate validations
		 * 
		 */
		login.getLogin(driver).click();
		login.loginEmail(driver).sendKeys(email);

		/*
		 * boolean isdisplay = login.loginEmailSubmit(driver).isDisplayed(); boolean
		 * isEnable = login.loginEmailSubmit(driver).isEnabled();
		 */

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0]. click();", login.loginEmailSubmit(driver)); // login.loginEmailSubmit(driver).click();
		login.loginPassword(driver).sendKeys(password);
		login.loginButton(driver).click();
		action.moveToElement(home.navAccount(driver)).build().perform();

		/*
		 * Navigate to Account Settings****
		 */
		home.navAccountSettings(driver).click();
		home.navHelpSupport(driver).click();

		/*
		 * In the Help and Support section , select “I found an error while using
		 * Trivago” Create a ticket and store the ticket id.
		 */
		Select se = new Select(home.selectIssue(driver));
		se.selectByValue(va.topic);

		Select se1 = new Select(home.selectErrorType(driver));
		se1.selectByValue(va.ErrorType);
		home.subjectTextBox(driver).sendKeys(va.Subject);
		home.descriptionTextBox(driver).sendKeys(va.Description);
		home.hotelName(driver).sendKeys(va.HotelName);
		home.bookingSite(driver).sendKeys(va.BookingSite);
		home.checkinDate(driver).click();
		dp.selectDate(home.datePicker(driver), va.CheckinDate);
		home.attachment(driver).sendKeys(path + va.Attachments);
		home.sendMessage(driver).click();

		// *****Validate the Success Message****
		String successMessage = home.successMessage(driver).getText();
		Assert.assertEquals(successMessage, va.expectedSuccessMsg);
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void bookResort() throws InterruptedException {

		// ***Search for Goa as the location *****
		searchPlace.enterDestination(driver).sendKeys("Goa");
		searchPlace.selectDestSuggestion(driver).click();

		/*
		 * In the Filters ,
		 * 
		 * a. set the date range as 25th December to 27th December
		 * 
		 * b. Hotels rated above 8.5
		 * 
		 * c. Number of Adults as 1
		 * 
		 */
		WebElement checkInDate = dp.selectDate(searchPlace.datePickerBox(driver), "25-12-2020");

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", checkInDate);

		WebElement checkOutDate = dp.selectDate(searchPlace.datePickerBox(driver), "27-12-2020");
		executor.executeScript("arguments[0].click();", checkOutDate);
		executor.executeScript("arguments[0].clear();", "searchPlace.selectAdults(driver)");
		executor.executeScript("arguments[0].value='1';", "searchPlace.selectAdults(driver)");
		searchPlace.searchButton(driver).click();

		action.moveToElement(searchPlace.guestRating(driver)).build().perform();
		searchPlace.guestRating(driver).click();
		searchPlace.selectGuestRating(driver, "8.5").click();

		/*
		 * 
		 * Check if Azaya Beach Resort Goa is listed
		 * 
		 */

		boolean resortAvailability = searchPlace.searchResort(driver, "Azaya Beach Resort Goa").isDisplayed();
		System.out.println("Is Resort Available: " + resortAvailability);

		/*
		 * 
		 * View Deal for Seashell Villas The Villa
		 * 
		 */
		String parentWindow = driver.getWindowHandle();
		searchPlace.clickViewDeal(driver, "Seashell Villas The Villa").click();

		/*
		 * 
		 * Scroll down and select the Essence Room King Bed with Breakfast and Dinner
		 * 
		 */
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for (int i = 0; i < tabs.size(); i++) {
			if (!tabs.get(i).equals(parentWindow)) {
				childWindow1 = tabs.get(i);
				driver.switchTo().window(tabs.get(i));

			}
		}

		searchPlace.clickResortName(driver, "Seashell Villas The Villa").click();

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		for (int i = 0; i < tabs2.size(); i++) {
			if (!tabs2.get(i).equals(parentWindow) || !tabs2.get(i).equals(childWindow1)) {
				childWindow2 = tabs.get(i);
				driver.switchTo().window(tabs.get(i));

			}
		}

		/*
		 * 
		 * Select a villa and Reserve the room
		 * 
		 */
		executor.executeScript("arguments[0].scrollIntoView(true);",
				searchPlace.findRoom(driver, "Junior Suite King bed with Breakfast"));
		searchPlace.selectRoom(driver, "Junior Suite King bed with Breakfast").click();

		/*
		 * 
		 * Enter your personal details – Again randomly generate data
		 * 
		 */

		executor.executeScript("arguments[0].scrollIntoView(true);", searchPlace.scrollToGuestDetail(driver));
		searchPlace.FirstNameTxtBox(driver).sendKeys(gen.firstName());
		searchPlace.LastNameTxtBox(driver).sendKeys(gen.lastName());
		searchPlace.emailTextBox(driver).sendKeys(email);
		searchPlace.mobileNumber(driver).sendKeys(gen.phoneNum());

		/*
		 * Click on Final Details
		 * 
		 */
		searchPlace.proceedToPayment(driver).click();
	}
}
