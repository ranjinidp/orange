package orangepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmergencyContactsPage {
	
	@FindBy(id="btnSaveEContact")
	private WebElement EditOrSave;
	
	@FindBy(xpath="//a[text()='Emergency Contacts']")
	private WebElement EmergencyContacts;
	
	@FindBy(id="btnAddContact")
	private WebElement AddButton;
	
	@FindBy(id="emgcontacts_name")
	private WebElement Name;
	
	@FindBy(id="emgcontacts_relationship")
	private WebElement Relationship;
	
	public EmergencyContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickEmergencyContactsButton() {
		EmergencyContacts.click();
	}
	
	public void clickAddButton() {
		AddButton.click();
	}
	
	public void setName(String name) {
		Name.sendKeys(name);
	}

	
	public void setRelationship(String relationship) {
		Relationship.sendKeys(relationship);
	}

	
	public void clickEditOrSaveButton() {
		EditOrSave.click();
	}

}
