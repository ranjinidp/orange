package orangepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import orangegenerics.OrangeWebGenerics;

public class OrangeLoginPage  {

	@FindBy(id="txtUsername")
	private WebElement unTB;
	
	@FindBy(id="txtPassword")
	private WebElement pwTB;
	
	@FindBy(id = "btnLogin")
	private WebElement loginBTN;
	
	@FindBy(xpath = "//span[text()='Invalid credentials']")
	private WebElement errMsg;
	
	public OrangeLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un) {
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
	}
	
	public void clickLoginButton() {
		loginBTN.click();
	}
	
	public boolean verifyErrMsgIsDisplayed(WebDriverWait wait) {
		return OrangeWebGenerics.verifyElementDisplayed(wait, errMsg);
	}
}
