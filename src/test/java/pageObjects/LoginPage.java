package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="input-email")
	WebElement txtLoginEmail;
	
	@FindBy(id="input-password")
	WebElement txtLoginPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement getConfirmationtextValue;
	
	public void setEmailLogin(String loginmail)
	{
		txtLoginEmail.sendKeys(loginmail);
	}
	
	public void setEmailPassword(String loginpassword)
	{
		txtLoginPassword.sendKeys(loginpassword);
	}
	
	public void clickLoginButton() {
		btnLogin.click();
	}

}
