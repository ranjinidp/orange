package orangepages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsPage {
	
	@FindBy(id="btnSave")
	private WebElement EditOrSave;
	
	@FindBy(xpath="//a[text()='Contact Details']")
	private WebElement ContactDetails;
	
	@FindBy(xpath="//input[@id='contact_street1']")
	private WebElement Address1;
	
	@FindBy(xpath="//input[@id='contact_street2']")
	private WebElement Address2;
	
	@FindBy(id="contact_city")
	private WebElement City;
	
	@FindBy(id="contact_province")
	private WebElement State;
	
	@FindBy(id="contact_country")
	private WebElement Country;
	
	@FindBy(id="contact_emp_work_telephone")
	private WebElement WorkTelPhone;
	
	@FindBy(id="contact_emp_work_email")
	private WebElement Email;
	
	public ContactDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickContactDetailsButton() {
		ContactDetails.click();
	}
	
	public void setAddress1(String add1) {
		Address1.sendKeys(add1);
	}
	
	public void setAddress2(String add2) {
		Address2.sendKeys(add2);
	}
	
	public void setCity(String city) {
		City.sendKeys(city);
	}
	
	public void setState(String stat) {
		State.sendKeys(stat);
	}
	
	public void setCountry(String country) {
		Country.sendKeys(country);
	}
	
	public void setWorkPhone(String WorkPhone) {
		WorkTelPhone.sendKeys(WorkPhone);
	}
	
	public void setEmail(String email) {
		Email.sendKeys(email);
	}
	
	public void clickEditOrSaveButton() {
		EditOrSave.click();
	}
	
	public void clear() {
		List<WebElement> list = new ArrayList<WebElement>();
		
		list.add(Address1);
		list.add(Address2);
		list.add(City);
		list.add(State);
		list.add(WorkTelPhone);
		list.add(Email);
	
		
		for (WebElement webele : list) {
			webele.clear();
		}
	}

}
