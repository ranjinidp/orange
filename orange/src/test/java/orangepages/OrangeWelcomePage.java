package orangepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import orangegenerics.OrangeWebGenerics;

public class OrangeWelcomePage {
	
	public OrangeWelcomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyHomePageIsDisplayed(WebDriverWait wait,String expectedUrl) {
//		return WebGeneric.verifyTitle(wait, expectedTitle);
		return OrangeWebGenerics.verifyUrl(wait, expectedUrl);
		//return OrangeWebGenerics.verifyElementDisplayed(wait, logoutLink);
	}
}
