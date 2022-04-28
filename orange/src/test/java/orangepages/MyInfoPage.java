package orangepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {
	
	@FindBy(xpath="//b[text()='My Info']")
	private WebElement MyInfo;
	
	public MyInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickMyInfoButton() {
		MyInfo.click();
	}

}
