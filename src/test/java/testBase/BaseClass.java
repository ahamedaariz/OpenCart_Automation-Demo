package testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {

	public static WebDriver driver;
	public Logger logging;
	public ResourceBundle rb;
	
	@BeforeClass(groups = { "Master", "Sanity", "Regression" }) //Step8 groups added
	@Parameters("browser")
	public void setUp(String browservalue) {
		
		rb= ResourceBundle.getBundle("config");
		logging = LogManager.getLogger(this.getClass());
	
		if (browservalue.equals("chrome"))
		{
		ChromeOptions chrOptions = new ChromeOptions();
		chrOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		driver = new ChromeDriver(chrOptions);
		}
		
		else if (browservalue.equals("edge"))
		{
			EdgeOptions edgOptions = new EdgeOptions();
			edgOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
			driver = new EdgeDriver(edgOptions);
		}
		else
		{
			FirefoxOptions fireOptions = new FirefoxOptions();
			fireOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
			driver = new FirefoxDriver(fireOptions);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = { "Master", "Sanity", "Regression" }) //Step8 groups added
	public void tearDown() {
		driver.quit();
	}
	
	//Alphabetic
	public String randomeString()
	{
		String generateString1 = RandomStringUtils.randomAlphabetic(5);
		return (generateString1);
	}
	// numeric 
	public String randomeNumber()
	{
		String generateString2 = RandomStringUtils.randomNumeric(10);
		return (generateString2);
	}
	//Alphabetic +Numeric
	public String randomeAlphaNumeric()
	{
		String str = RandomStringUtils.randomAlphabetic(5);
		String num= RandomStringUtils.randomNumeric(10);
		return (str+"@" + num);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
	
}
