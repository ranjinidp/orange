package orangepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhotographPage {
	@FindBy(xpath="//img[@id='empPic']")
	private WebElement Photograph;
	
	@FindBy(xpath="//input[@id='btnSave']")
	private WebElement EditOrSave;
	
	@FindBy(xpath="//input[@id='photofile']")
	private WebElement ChooseFile;
	
	public PhotographPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickPhotographButton() {
		Photograph.click();
	}
	
	public void clickEditOrSaveButton() {
		EditOrSave.click();
	}
	
	public void clickChooseFileButton(String picPath) {
		ChooseFile.sendKeys(picPath);
	}


}
