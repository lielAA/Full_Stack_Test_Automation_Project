package Workflows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import extensions.click;
import utilities.common_opps;

public class Desktop_Calculator extends common_opps
{
	//Sum Two numbers 
	public static void Sum(WebElement FirstNum,WebElement SecondNum) throws IOException, ParserConfigurationException, SAXException
	{
		click.go_click(FirstNum);
		click.go_click(Desktop_ArithmeticOperations.Plus_Btn);
		click.go_click(SecondNum);
		click.go_click(Desktop_ArithmeticOperations.Equal_Btn);
	}
	//Sub Two numbers
	public static void Sub(WebElement FirstNum,WebElement SecondNum, WebElement ThirdNum) throws IOException, ParserConfigurationException, SAXException
	{
		click.go_click(FirstNum);
		click.go_click(SecondNum);
		click.go_click(Desktop_ArithmeticOperations.Minus_Btn);
		click.go_click(ThirdNum);
		click.go_click(Desktop_ArithmeticOperations.Equal_Btn);
	}
	//Multiply Two numbers
	public static void multiply(WebElement FirstNum,WebElement SecondNum) throws IOException, ParserConfigurationException, SAXException
	{
		click.go_click(FirstNum);
		click.go_click(Desktop_ArithmeticOperations.Multiply_Btn);
		click.go_click(SecondNum);
		click.go_click(Desktop_ArithmeticOperations.Equal_Btn);
	}
}
