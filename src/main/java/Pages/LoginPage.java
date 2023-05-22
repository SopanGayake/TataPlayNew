package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase1;
public class LoginPage extends TestBase1{
	
	//Object Repository
		@FindBy(xpath="//img[@alt='Facebook']") private WebElement FacebookLogo;
		@FindBy(xpath="//h2[@class='_8eso']") private WebElement TagLine;
		@FindBy(xpath="//input[@id='email']") private WebElement userIdTextbox;
		@FindBy(xpath="//input[@id='pass']") private WebElement passwordTextbox;
		@FindBy(xpath="//button[@name='login']") private WebElement loginBtn;	
		@FindBy(xpath="//span[text() = 'Sopan V. Gayke Patil']") private WebElement UserName;
		
	
		public LoginPage()
		{
		PageFactory.initElements(driver, this);
		}
		public void verifyFacebookLogo()
		{
			FacebookLogo.isDisplayed();
		}
		public void verifyTagLine()
		{
			TagLine.isDisplayed();
		}
		public String verifyTitle()
		{
		return driver.getTitle();
		}
		public String loginToApp() throws IOException
		{
			userIdTextbox.sendKeys(readPropertyFile("username"));
			passwordTextbox.sendKeys(readPropertyFile("password"));
			loginBtn.click();
			return UserName.getText();
		}
	
		public static String student()
		{
			return "Sopan";
		}
	}

		//Encapsulation = data (private) + method (public)


