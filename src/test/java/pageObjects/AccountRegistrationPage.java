package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage  extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(id="input-firstname")
	WebElement txtFirstName;
	
	@FindBy(id="input-lastname")
	WebElement txtLastName;
	
	@FindBy(id="input-email")
	WebElement txtEmail;
	
	@FindBy(id="input-telephone")
	WebElement txtTelephone;
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(id="input-confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement radSubscribe;

	@FindBy(xpath="//input[@name='agree']")
	WebElement chkAgreePolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement getConfirmationtextValue;
	
	
	public void setFirstName(String firstname)
	{
		txtFirstName.sendKeys(firstname);
	}
	
	public void setLastName(String lastname)
	{
		txtLastName.sendKeys(lastname);
	}
	
	public void setEmail(String emailaddress)
	{
		txtEmail.sendKeys(emailaddress);
	}
	
	public void setTelephone(String telephone)
	{
		txtTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String pswrd)	{
		txtPassword.sendKeys(pswrd);
	}
	
	public void setConfirmPassword(String confirmpswrd)	{
		txtConfirmPassword.sendKeys(confirmpswrd);
	}
	
	public void clickradioSubscribe()	{
		radSubscribe.click();
	}
	
	public void clickPolicy() {
		chkAgreePolicy.click();
	}
	
	public void clickContinueButton() {
		btnContinue.click();
	}
	public String getConfirmationMsg() {
		
		try {
			 return	(getConfirmationtextValue.getText());
		}
	 catch (Exception e) {
		return (e.getMessage());
	    }
	}
}
