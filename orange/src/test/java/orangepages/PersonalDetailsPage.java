package orangepages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage {

	@FindBy(xpath="//input[@id='btnSave']")
	private WebElement EditOrSave;
	
	@FindBy(xpath="//a[text()='Personal Details']")
	private WebElement PersonalDetails;
	
	@FindBy(id="personal_txtEmpFirstName")
	private WebElement FirstName;
	
	@FindBy(id="personal_txtEmpLastName")
	private WebElement LastName;
	
	@FindBy(id="personal_txtEmployeeId")
	private WebElement EmployeeId;
	
	@FindBy(xpath="//input[@id='personal_optGender_1']")
	private WebElement Gender;
	
	@FindBy(xpath="//select[@id='personal_cmbNation']")
	private WebElement Nationality;
	
	@FindBy(xpath="//select[@id='personal_cmbMarital']")
	private WebElement MartialStatus;
	
	@FindBy(xpath="//input[@id='personal_DOB']")
	private WebElement DOB;
	
	public PersonalDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickPersonalDetailsButton() {
		PersonalDetails.click();
	}
	
	public void setFirstName(String fn) {
		FirstName.sendKeys(fn);
	}
	
	public void setLastName(String ln) {
		LastName.sendKeys(ln);
	}
	
	public void setEmployeeID(String eid) {
		EmployeeId.sendKeys(eid);
	}
	
	public void setGender() {
		Gender.click();
		
	}
	
	public void setNationality(String nationality) {
		Nationality.sendKeys(nationality);
		
	}
	
	public void setMartialStatus(String ms) {

		MartialStatus.sendKeys(ms);
	}
	
	
	public void setDateOfBirth(String dob) {

		DOB.sendKeys(dob);
	}

	
	public void clickEditOrSaveButton() {
		EditOrSave.click();
	}
	
	public void clear() {
		List<WebElement> ls = new ArrayList<WebElement>();
		
		ls.add(FirstName);
		ls.add(LastName);
		ls.add(EmployeeId);
		ls.add(DOB);
		
		for (WebElement wb : ls) {
			wb.clear();
		}
	}



}
