package orangegenerics;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import orangepages.MyInfoPage;
import orangepages.OrangeLoginPage;
import orangepages.OrangeWelcomePage;

public class OrangeBaseTest implements OrangeIAutoConstants {

	public static WebDriver driver;
	public static WebDriverWait wait;
	
	@Parameters({"grid","remoteAddr","browserName"})
	@BeforeTest
	public void openApp(@Optional("") String grid,@Optional("") String remoteAddr,@Optional("") String  browserName) throws MalformedURLException {
		String appURL = getValue("URL");
		long ito = Long.parseLong(getValue("ITO"));
		long eto = Long.parseLong(getValue("ETO"));
		
		if(grid.equals(""))
		{
			grid=getValue("GRID");
		}
		
		if(remoteAddr.equals(""))
		{
			remoteAddr=getValue("REMOTE");
		}
		
		if(browserName.equals(""))
		{
			browserName= getValue("BROWSER");
		}
		
		if(grid.equalsIgnoreCase("YES"))
		{
			Reporter.log("Opening "+browserName+" in remote system",true);
			URL gridURL=new URL(remoteAddr);
			
			if(browserName.equalsIgnoreCase("chrome")) 
			{
				Reporter.log("Opening Chrome in Remote system",true);
				driver=new RemoteWebDriver(gridURL,new ChromeOptions());
			}
			else
			{
				Reporter.log("Opening Firefox in Remote system",true);
				driver=new RemoteWebDriver(gridURL,new FirefoxOptions());
			}
			
		}
		else
		{
			if(browserName.equalsIgnoreCase("chrome")) 
			{
				Reporter.log("Opening Chrome in local system",true);
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else
			{
				Reporter.log("Opening Firefox in local system",true);
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
		}
		
		
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ito));
		wait=new WebDriverWait(driver, Duration.ofSeconds(eto));
		
		//**************************************************
		
//		get data from excel file
		String un=OrangeExcel.getData(XL_PATH, "ValidLogin", 1, 0);
		String pw=OrangeExcel.getData(XL_PATH, "ValidLogin", 1, 1);
		String eUrl=OrangeExcel.getData(XL_PATH, "ValidLogin", 1, 2);
		String fMsg=OrangeExcel.getData(XL_PATH, "ValidLogin", 1, 3);
		
//		1.	Enter valid user name (admin)
		OrangeLoginPage l=new OrangeLoginPage(driver);
		l.setUserName(un);
		
//		2.	Enter valid password (manager)
		l.setPassword(pw);
		
//		3.	Click on login button
		l.clickLoginButton();
		
//		4.	Verify that home page is displayed
		OrangeWelcomePage e=new OrangeWelcomePage(driver);
		boolean result = e.verifyHomePageIsDisplayed(wait,eUrl);
		Assert.assertTrue(result,fMsg);
		
		MyInfoPage m = new MyInfoPage(driver);
		m.clickMyInfoButton();
	}
	
	
	@AfterTest
	public void closeApp() {
		driver.close();
	}
	
	public static String getValue(String key) {
		String value="";
		Properties p=new Properties();
		try {
				p.load(new FileInputStream(CONFIG_PATH));
				value=p.getProperty(key);
		}
		catch (Exception e) {
			
		}
		
		return value;
	}
}
