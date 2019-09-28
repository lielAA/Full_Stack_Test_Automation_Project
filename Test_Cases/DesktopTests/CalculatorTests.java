package DesktopTests;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import Workflows.Desktop_Calculator;
import extensions.verify;
import utilities.common_opps;

public class CalculatorTests extends common_opps
{
	@Test
	public void Test001_SumTwoNumbers() throws IOException, ParserConfigurationException, SAXException
	{
		Desktop_Calculator.Sum(Desktop_CalcuatorNumbers.num_3, Desktop_CalcuatorNumbers.num_6);
		verify.text_in_Element(Desktop_ArithmeticOperations.Result_Field, "9");
	}
	@Test
	public void Test002_SubTwoNumbers() throws IOException, ParserConfigurationException, SAXException
	{
		Desktop_Calculator.Sub(Desktop_CalcuatorNumbers.num_1, Desktop_CalcuatorNumbers.num_0, Desktop_CalcuatorNumbers.num_1);
		verify.text_in_Element(Desktop_ArithmeticOperations.Result_Field, "9");
	}
	@Test
	public void Test003_MultiplyTwoNumbers() throws IOException, ParserConfigurationException, SAXException
	{
		Desktop_Calculator.multiply(Desktop_CalcuatorNumbers.num_3, Desktop_CalcuatorNumbers.num_3);
		verify.text_in_Element(Desktop_ArithmeticOperations.Result_Field, "9");
	}
}