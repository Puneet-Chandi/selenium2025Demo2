package testBase;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;  //Logger is interface
	public Properties prop;
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
 	public void setup(String os, String br) throws IOException {
		
		//Loading config.properties
		
		FileInputStream fis = new FileInputStream("./src//test//resources//config.properties");
		
		prop=new Properties();
		prop.load(fis);
		
			
		logger = LogManager.getLogger(this.getClass());  // getting logger for current class
	
		//--------- For Remote execution -------------------------
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote")) {				
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN10);
			}else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
				}
			else {System.out.println("No Matching os found");
			return;
			}
		
		//browser
				switch(br.toLowerCase()) {
				case "chrome": capabilities.setBrowserName("chrome");break;
				case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
				case "firefox": capabilities.setBrowserName("FireFox");break;
				default: System.out.println("No Matching browser found");return;
				}//switch ends
				
				driver=new RemoteWebDriver(new URL("http://192.168.1.23:4444/wd/hub"),capabilities);
						
		}//end if
		
		//------------ for local execution ------- 
		if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
				switch(br.toLowerCase()) {
				case "chrome":   driver=new ChromeDriver();break;
				case "edge":     driver=new EdgeDriver();break;
				case "firefox":  driver=new FirefoxDriver();break;
				default:logger.info("Invalid Browser Name");return;	 // return will exit from current test case.	
		        }	
	     }// local execution if ends
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	//	driver.get("https://demo.opencart.com/");
		driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();
		logger.info("Application is launched successfully");
		
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();		
		logger.info("Browser is closed");
	}
	
	//---------------- SELECT -----------------
	public static void SelectByValue(WebElement ele, String val) {
		Select opt = new Select(ele);
		opt.selectByValue(val);	
	}
	public static void SelectByVisibleText(WebElement ele, String val) {
		Select opt = new Select(ele);
		opt.selectByVisibleText(val);
	}
	public static void SelectByIndex(WebElement ele, int index) {
		Select opt = new Select(ele);
		opt.selectByIndex(index);
	}
	
	//--------------- RANDOM Strings---------------
	Random r = new Random();
	
	public String getRandomAlphabetic(int charcount) {
		return RandomStringUtils.randomAlphabetic(charcount);
	}
	public String getRandomAlphanumric(int charcount) {
		return RandomStringUtils.randomAlphanumeric(charcount);
	}
	public String getRandomNumber(int count) {
		return RandomStringUtils.randomNumeric(count);		
	}
	public String getRandomNumberInRange(int min, int max) {
		return String.valueOf(r.nextInt(min, max));
	}
	//------------------ JavascriptExecutor ---------------
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	public Object scrollToElement(WebElement ele) {
			try {
					return jse.executeScript("arguments[0].scrollIntoView(true)",ele);
				}catch(Exception e) {
					return e;
				}
	}
	public Object scrollToBottom() {
		return jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	public Object scrollToTop() {
		return jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
}// class end
