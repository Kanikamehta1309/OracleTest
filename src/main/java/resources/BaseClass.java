package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	public WebDriver driver;
	public String BaseURL;

	public WebDriver initializeDriver() throws IOException {
		String path = System.getProperty("user.dir");
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(path +
				"\\src\\main\\java\\resources\\Config.properties");
		prop.load(fis);
		String Browser = prop.getProperty("browser");
		//System.out.println(Browser);
		BaseURL = prop.getProperty("url");

		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
			String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36";
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			options.addArguments(String.format("user-agent=%s", userAgent));
			driver = new ChromeDriver(options);
		} else if (Browser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		} else if (Browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = null;
			System.out.println("Mention valid Browser name");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
