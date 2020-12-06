package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginRegisterPage {

	public static WebElement signin = null;
	public static WebElement createAcc = null;

	public WebElement getLogin(WebDriver driver) {
		signin = driver.findElement(By.xpath("//span[contains(text(),'Log')]"));
		return signin;
	}

	public WebElement createAccount(WebDriver driver) {
		createAcc = driver.findElement(By.id("login_signup_link"));
		return createAcc;
	}

	public WebElement emailTextBox(WebDriver driver) {
		WebElement emailId = driver.findElement(By.id("register_email"));
		return emailId;
	}

	public WebElement passwordTextBox(WebDriver driver) {
		WebElement password = driver.findElement(By.id("register_password"));
		return password;
	}

	public WebElement registerButton(WebDriver driver) {
		WebElement register = driver.findElement(By.id("register_email_submit"));
		return register;
	}
	
	public WebElement loginEmail(WebDriver driver) {
		WebElement emailTxtBox = driver.findElement(By.id("check_email"));
		return emailTxtBox;
	}
	public WebElement loginEmailSubmit(WebDriver driver) {
		WebElement emailSubmitButton = driver.findElement(By.id("login_email_submit"));
		return emailSubmitButton;
	}
	
	public WebElement loginPassword(WebDriver driver) {
		WebElement loginPasswordTxtBx = driver.findElement(By.id("login_password"));
		return loginPasswordTxtBx;
	}
	
	public WebElement loginButton(WebDriver driver) {
		WebElement loginButton = driver.findElement(By.id("login_submit"));
		return loginButton;
	}

}
