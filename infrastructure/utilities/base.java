package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.simple.JSONObject;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.windows.WindowsDriver;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import page_objects_DesktopCalculatorApp.ArithmeticOperations;
import page_objects_DesktopCalculatorApp.CalcuatorNumbers;
import page_objects_ElectronAPIDemo.mainPage;
import page_objects_UnitConverterAPP.BasicPage;
import page_objects_UnitConverterAPP.DownSubjectToolbar;
import page_objects_UnitConverterAPP.MenuPage;
import page_objects_UnitConverterAPP.ResetSettingsFrame;
import page_objects_UnitConverterAPP.TopSubjectToolbar;
import page_objects_UnitConverterAPP.UpperToolbar;
import page_objects_UnitConverterAPP.keyboard_keys;
import page_objects_YouTube.Top_Toolbars;
import page_objects_YouTube.User_Helper_Iframe;
import page_objects_YouTube.Video_Play_page;
import page_objects_YouTube.Left_Toolbar;
import page_objects_YouTube.Result_page_for_search_Artist;

public class base 
{
	//Drivers
	public static WebDriver driver;
	public static DesiredCapabilities dc;
	public static WindowsDriver<?> Desktopdriver;
	
	//global variable to select relevant execution platform
	public static String myPLatform;
	
	//Objects for YouTube and Web Browser
	public static Top_Toolbars YoTu_Top_Toolbar;
	public static Result_page_for_search_Artist YoTu_page_result;
	public static Left_Toolbar YoTu_Left_Toolbar;
	public static Video_Play_page YoTu_Video_Play_page;
	public static User_Helper_Iframe YoTo_Helper_Iframe;

	//Objects For UnitConverter APP and mobile
	public static BasicPage UnitConverter_BasicPage;
	public static keyboard_keys UnitConverter_keyboard_keys;
	public static TopSubjectToolbar UnitConverter_TopSubjectToolbar;
	public static DownSubjectToolbar UnitConverter_DownSubjectToolbar;
	public static UpperToolbar UnitConverter_UpperToolbar;
	public static MenuPage UnitConverter_MenuPage;
	public static ResetSettingsFrame UnitConverter_ResetSettingsFrame;
	
	//Objects for API Testing - students service
	public static RequestSpecification httpRequest;
	public static JSONObject requestParams = new JSONObject();
	public static Response resp;
	
	//Objects for Electron Application Testing 
	public static mainPage ElectronMain;
	
	//Objects for Desktop Applications Testing
	public static ArithmeticOperations Desktop_ArithmeticOperations; 
	public static CalcuatorNumbers Desktop_CalcuatorNumbers;
	
	//Objects for extensions
	public static Actions Action;
	public static Screen screen;
	public static JavascriptExecutor JS;
	public static WebDriverWait ExplicityWait;
	public static Dimension size;

	//Objects for Report
	public static ExtentReports extent;
	public static ExtentTest test;
	
	//String getting current Date
	public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd-ss").format(Calendar.getInstance().getTime());
}