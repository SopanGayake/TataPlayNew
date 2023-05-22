package TestCases;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.TestBase1;
import Pages.LoginPage;

public class LoginPageTesting extends TestBase1 {
	LoginPage login;
	@BeforeMethod
	public void setup() throws IOException
	{
	initalization();
	login = new LoginPage();
	}
	@Test (enabled = true)
	public void verifyFacebookLogoTest()
	{
	login.verifyFacebookLogo();
	}
	@Test (enabled = true)
	public void PrintUser()
	{
	String name = LoginPage.student();
	System.out.println(name);
	}
	@Test
	public void verifyTitleTest()
	{
	String Tital=login.verifyTitle();
	System.out.println(Tital);
	}
	@Test
	public void verifyTagLine()
	{
	login.verifyTagLine();
	}
	@Test 
	public void loginToAppTest() throws IOException
	{
		String username = login.loginToApp();
		AssertJUnit.assertEquals(username, "Sopan V. Gayke Patil");
		System.out.println(username);
	}
	@Test 
	public void readExcelFile1() throws  IOException 
	{
		LoginPage.readExcelFile();
	}
	@AfterMethod
	public void exit() {
	driver.close();
	}

}
