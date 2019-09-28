package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import com.relevantcodes.extentreports.ExtentReports;
import extensions.click;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.restassured.RestAssured;
import page_objects_YouTube.Top_Toolbars;

public class common_opps extends base
{

	public static String getData (String nodeName) throws ParserConfigurationException, SAXException, IOException
	{
		File fXmlFile = new File("./configuration/DataConfig.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}
	//##################init WebBrowser######################################
	//@@@@@@@@@ choose browser type from DataConfig.xml file, using "browserType" variable @@@@@@@@@
	public static void initBrowser(String browserType) throws ParserConfigurationException, SAXException, IOException
	{
		switch(browserType.toLowerCase())
		{
		case "chrome":
			driver = initChromeDriver();
			break;
		case "firefox":
			driver = initFireFoxDriver();
			break;
		case "edge":
			driver = initEdgeDriver();
			break;
		case "opera":
			driver = initOperaDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.get(getData("URL"));
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(getData("wait_Time")), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(getData("wait_Time")), TimeUnit.SECONDS);
		ExplicityWait = new WebDriverWait(driver, Integer.parseInt(getData("wait_Time")));
		Action = new Actions(driver);
		screen = new Screen();
		JS = (JavascriptExecutor) driver;
	}
	//@@@@@@@@@ init chrome_Driver @@@@@@@@@
	public static WebDriver initChromeDriver() throws ParserConfigurationException, SAXException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", getData("ChromeDriverPath"));
		driver = new ChromeDriver();
		return driver;
	}
	//@@@@@@@@@ init FireFox_Driver @@@@@@@@@
	public static WebDriver initFireFoxDriver() throws ParserConfigurationException, SAXException, IOException 
	{
		System.setProperty("webdriver.gecko.driver", getData("FF_DriverPath"));
		driver = new FirefoxDriver();
		return driver;
	}
	//@@@@@@@@@ init Edge_Driver @@@@@@@@@ 
	public static WebDriver initEdgeDriver() throws ParserConfigurationException, SAXException, IOException
	{
		System.setProperty("webdriver.edge.driver", getData("Edge_DriverPath"));
		driver = new EdgeDriver();
		return driver;
	}
	//@@@@@@@@@ init opera_Driver @@@@@@@@@
	public static WebDriver initOperaDriver() throws ParserConfigurationException, SAXException, IOException
	{
		System.setProperty("webdriver.opera.driver", getData("Opera_DriverPath"));
		driver = new OperaDriver();
		return driver;
	}

	//##################init Mobile device######################################
	//@@@@@@@@@ choose mobile type from DataConfig.xml file @@@@@@@@@
	public static void initMobile() throws ParserConfigurationException, SAXException, IOException
	{
		dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("App_Package"));
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("App_Activity"));
		driver = new AndroidDriver<>(new URL(getData("Appium_Server_Address")), dc);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(getData("wait_Time")), TimeUnit.SECONDS);
		size = driver.manage().window().getSize();
	}

	//##################init API_service######################################
	//@@@@@@@@@ choose API type from DataConfig.xml file @@@@@@@@@
	public static void initAPI() throws ParserConfigurationException, SAXException, IOException
	{
		RestAssured.baseURI = getData("API_address"); // URL 
		httpRequest = RestAssured.given(); // init httpRequest
	}
	//##################init Electron Driver######################################
	//@@@@@@@@@ choose Electron type from DataConfig.xml file @@@@@@@@@
	public static void initElectronDriver(String App) throws ParserConfigurationException, SAXException, IOException
	{
		System.setProperty("webdriver.chrome.driver", getData("Electron_DriverPath"));
		ChromeOptions opt = new ChromeOptions();
		opt.setBinary(App);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("chromeOptions", opt);
		capabilities.setBrowserName("chrome");
		driver = new ChromeDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(getData("wait_Time")), TimeUnit.SECONDS);
		//	driver.manage().window().maximize();
	}
	//##################init Desktop Application######################################
	//@@@@@@@@@ choose Desktop type from DataConfig.xml file @@@@@@@@@
	public static void initWinAppDriver(String App, String URL) throws ParserConfigurationException, SAXException, IOException
	{
		dc = new DesiredCapabilities();
		dc.setCapability("app", App);
		Desktopdriver = new WindowsDriver(new URL(URL), dc);
		Desktopdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	//#######################Reports ############################################################

	//@@@@@@@@@ Open Report @@@@@@@@@
	public static void InstanceReport() throws ParserConfigurationException, SAXException, IOException // Open all Reports
	{
		extent = new ExtentReports(getData("ReportFilePath") +"Execution_" + timeStamp + "/" + getData("ReportFileName") + ".html");
	}
	//@@@@@@@@@ open specific Test in Report @@@@@@@@@
	public static void initReportsTest(String testName , String testDescription) 
	{
		test = extent.startTest(testName, testDescription);	
	}
	//@@@@@@@@@ Close specific Test in report @@@@@@@@@
	public static void finilizeReportsTest() 
	{
		extent.endTest(test);
	}
	//@@@@@@@@@ Close all Report @@@@@@@@@
	public static void finilizeExtentReports() 
	{
		extent.flush();
		extent.close();
	}

	//###############ScreenShots - define String "SSPath" contain: path + TimeStamp + add screenshot + unique name ##########################################################
	public static String takeScrrenShots() throws IOException, ParserConfigurationException, SAXException
	{
		String SSPath = getData("ReportFilePath") + "Execution_" + timeStamp + "/" + "screenshot_" + getRandomNumber() +".png" ;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File(SSPath));
		return SSPath;
	}

	//######Random Number for unique screenshot name #####################################
	public static int getRandomNumber()
	{
		Random rand = new Random();
		return rand.nextInt(99999999) + 1;
	}

	//############TestNG Annotations ##############################################

	@BeforeSuite
	public void startSuite() throws ParserConfigurationException, SAXException, IOException
	{
		InstanceReport(); // open Report
	}

	@AfterSuite
	public void closeSuite()
	{
		finilizeExtentReports(); // close report
	}

	@BeforeTest (groups = {"Hardcoded", "DataBase"})
	@Parameters({"platform"}) // platform parameter from SUITE xml file
	public void beforeClass(String platform) throws ParserConfigurationException, SAXException, IOException 
	{
		myPLatform = platform;
		switch (myPLatform.toLowerCase())
		{
		case "web":
			initBrowser(getData("browserType")); // init browser type
			break;
		case "mobile":
			initMobile(); // init mobile type
			break;	
		case "api":
			initAPI(); // init API type
			break;
		case "electron": // init electron type
			initElectronDriver(getData("Electron_App"));
			break;
		case "desktop": // init Desktop type
			initWinAppDriver(getData("DesktopAppID"), getData("WinAppDriverURL"));
			break;
		}
		manage_pages.init_elements(); // init all elements	
	}	
//#####################################################################################################
//#####################################################################################################
//################# Configuration only for independent test Running	###################################
//#####################################################################################################
//#####################################################################################################
	//	@BeforeClass (groups = {"Hardcoded", "DataBase"})
	//	public void beforeClass() throws ParserConfigurationException, SAXException, IOException 
	//	{
	//		switch (getData("AutomationType").toLowerCase())
	//		{
	//		case "web":
	//			initBrowser(getData("browserType")); // init browser type
	//			break;
	//		case "mobile":
	//			initMobile(); // init mobile type
	//			break;		
	//		case "api":
	//			initAPI(); // init API type
	//			break;
	//		case "electron":
	//			initElectronDriver(getData("Electron_App"));
	//			break;
	//		case "desktop": // init Desktop type
	//			initWinAppDriver(getData("DesktopAppID"), getData("WinAppDriverURL"));
	//			break;
	//		}
	//		InstanceReport();
	//		manage_pages.init_elements(); // init all elements	
	//	}
//#####################################################################################################
//#####################################################################################################
	@BeforeMethod (groups = {"Hardcoded", "DataBase"})
	public void BeforeAnyMethod(Method method)
	{
		initReportsTest(method.getName().split("_")[0] , method.getName().split("_")[1]); // Open Specific Test
	}
	@AfterMethod (groups = {"Hardcoded", "DataBase"})
	public void AfterAnyMethod() throws ParserConfigurationException, SAXException, IOException 
	{
		finilizeReportsTest(); // close specific Test 
	}

//#####################################################################################################
//#####################################################################################################
//################# Configuration only for independent test Running	###################################
//#####################################################################################################
//#####################################################################################################	
	//	@AfterClass (groups = {"Hardcoded", "DataBase"})
	//	public void afterClass() throws IOException, ParserConfigurationException, SAXException, InterruptedException 
	//	{
	//		if(getData("AutomationType").toLowerCase().equals("web"))
	//		{
	//			click.go_click(Top_Toolbars.main_page_button); //After any Test case back to main YouTube page
	//		}
	//		else if (getData("AutomationType").toLowerCase().equals("mobile"))
	//		{
	//			((AppiumDriver<?>) driver).resetApp(); // reset Application after any Test case 
	//		}	
	//		else if(getData("AutomationType").toLowerCase().equals("desktop"))
	//		{
	//			Desktopdriver.quit();
	//			Runtime rt = Runtime.getRuntime();
	//		}
	//		if(getData("AutomationType").toLowerCase().equals("web") ||  getData("AutomationType").toLowerCase().equals("mobile") || getData("AutomationType").toLowerCase().equals("electron"))
	//			driver.quit(); // quit session
	//		finilizeExtentReports();
	//	}
//#####################################################################################################
//#####################################################################################################
	@AfterTest(groups = {"Hardcoded", "DataBase"})
	public void afterClass() throws IOException, ParserConfigurationException, SAXException, InterruptedException 
	{
		if(myPLatform.toLowerCase().equals("web"))
		{
			click.go_click(Top_Toolbars.main_page_button); //After any Test case back to main YouTube page
		}
		else if (myPLatform.toLowerCase().equals("mobile"))
		{
			((AppiumDriver<?>) driver).resetApp(); // resetApplication after any Test case 
		}	
		else if(myPLatform.toLowerCase().equals("desktop"))
		{
			Desktopdriver.quit();
			Runtime rt = Runtime.getRuntime();
		}
		if(myPLatform.toLowerCase().equals("web") ||  myPLatform.toLowerCase().equals("mobile") || myPLatform.toLowerCase().equals("electron"))
			driver.quit(); // quit session
	}
}