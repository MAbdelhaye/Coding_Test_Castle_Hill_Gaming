package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver driver;

	public void OpenBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/test/resources/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/src/test/resources/drivers/geckodriver.exe"); 
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+ "/src/test/resources/drivers/msedgedriver.exe"); 
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid browser");
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
	}
	

}
