package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class BaseClass {
	public static WebDriver driver;
	
	protected Logger logger;
	protected Properties propObject;

	@BeforeTest
	@Parameters({"os", "browser"})
	public void setup(String os, String browser) throws IOException {
		
		logger = LogManager.getLogger(this.getClass());
		
		propObject = new Properties();
		FileInputStream file = new FileInputStream("./src/test/resources/config.properties");
		propObject.load(file);
		
		
		if(propObject.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}else if(os.equalsIgnoreCase("linux")) {
				cap.setPlatform(Platform.LINUX);
			}else {
				System.out.println("No such environment");
				return;
			}
			
			switch(browser.toLowerCase()) {
				case "chrome": cap.setBrowserName("chrome"); break;
				case "firefox": cap.setBrowserName("firefox"); break;
				case "edge": cap.setBrowserName("MicrosoftEdge"); break;
				default: System.out.println("No such browser"); break;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			
		}else if(propObject.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (browser.toLowerCase()) {
		    case "chrome":
		        driver = new ChromeDriver();
		        break;
		    case "firefox":
		        driver = new FirefoxDriver();
		        break;
		    case "edge":
		        driver = new EdgeDriver();
		        break;
		    default:
		        throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		}
		

		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(propObject.getProperty("appurl"));
		
		

	}
	@AfterTest
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}