package orangetests;

import org.testng.annotations.Test;

import orangegenerics.OrangeBaseTest;
import orangegenerics.OrangeExcel;
import orangepages.ContactDetailsPage;
import orangepages.EmergencyContactsPage;
import orangepages.PersonalDetailsPage;
import orangepages.PhotographPage;

public class OrangeValidLogin extends OrangeBaseTest {

	//@Test(priority = 1)
/*	public void testValidLogin() {
//		get data from excel file
		String un=OrangeExcel.getData(XL_PATH, "ValidLogin", 1, 0);
		String pw=OrangeExcel.getData(XL_PATH, "ValidLogin", 1, 1);
		String eUrl=OrangeExcel.getData(XL_PATH, "ValidLogin", 1, 2);
		String fMsg=OrangeExcel.getData(XL_PATH, "ValidLogin", 1, 3);
		
//		1.	Enter valid user name (admin)
		OrangeLoginPage l=new OrangeLoginPage(driver);
		l.setUserName(un);
		
//		2.	Enter valid password (manager)
		l.setPassword(pw);
		
//		3.	Click on login button
		l.clickLoginButton();
		
//		4.	Verify that home page is displayed
		OrangeWelcomePage e=new OrangeWelcomePage(driver);
		boolean result = e.verifyHomePageIsDisplayed(wait,eUrl);
		Assert.assertTrue(result,fMsg);
		
		MyInfoPage m = new MyInfoPage(driver);
		m.clickMyInfoButton();
	}*/
		
	@Test(priority = 1)	
	public void testPersonalDetails() throws InterruptedException {
		
		String fn=OrangeExcel.getData(XL_PATH, "PersonalDetails", 1, 0);
		String ln=OrangeExcel.getData(XL_PATH, "PersonalDetails", 1, 1);
		String eid=OrangeExcel.getData(XL_PATH, "PersonalDetails", 1, 2);
		//String gnder=OrangeExcel.getData(XL_PATH, "PersonalDetails", 1, 3);
		String nat=OrangeExcel.getData(XL_PATH, "PersonalDetails", 1, 3);
		String ms=OrangeExcel.getData(XL_PATH, "PersonalDetails", 1, 4);
		String db=OrangeExcel.getData(XL_PATH, "PersonalDetails", 1, 5);
		
		PersonalDetailsPage p = new PersonalDetailsPage(driver);
		
		p.clickPersonalDetailsButton();
		p.clickEditOrSaveButton();
		p.clear();
		
		Thread.sleep(3000);
		
		p.setFirstName(fn);
		p.setLastName(ln);
		p.setEmployeeID(eid);
		p.setGender();
		p.setNationality(nat);
		p.setMartialStatus(ms);
		p.setDateOfBirth(db);
		
		Thread.sleep(3000);
		
		}
		
	@Test(priority = 2)	
	public void testContactDetails() throws InterruptedException {
			
		
		String aone=OrangeExcel.getData(XL_PATH, "ContactDetails", 1, 0);
		String atwo=OrangeExcel.getData(XL_PATH, "ContactDetails", 1, 1);
		String city=OrangeExcel.getData(XL_PATH, "ContactDetails", 1, 2);
		String state=OrangeExcel.getData(XL_PATH, "ContactDetails", 1, 3);
		String country=OrangeExcel.getData(XL_PATH, "ContactDetails", 1, 4);
		String wrkphn=OrangeExcel.getData(XL_PATH, "ContactDetails", 1, 5);
		String email=OrangeExcel.getData(XL_PATH, "ContactDetails", 1, 6);
		
	    ContactDetailsPage c= new ContactDetailsPage(driver);
	    
	    c.clickContactDetailsButton();
	    c.clickEditOrSaveButton();
	    c.clear();
	   
	    c.setAddress1(aone);
	    c.setAddress2(atwo);
	    c.setCity(city);
	    c.setState(state);
	    c.setCountry(country);
	    c.setWorkPhone(wrkphn);
	    c.setEmail(email);
	    c.clickEditOrSaveButton();
	    Thread.sleep(4000);
		}
	
	@Test(priority = 3)	
	public void testEmergency() throws InterruptedException {
			
	    
	    String nme=OrangeExcel.getData(XL_PATH, "EmergencyContacts", 1, 0);
	    String rel=OrangeExcel.getData(XL_PATH, "EmergencyContacts", 1, 1);
	    
	    EmergencyContactsPage em = new EmergencyContactsPage(driver);
	    em.clickEmergencyContactsButton();
	    em.clickAddButton();
	    em.setName(nme);
	    em.setRelationship(rel);
	    em.clickEditOrSaveButton();
	    Thread.sleep(3000);
		}

	
	
	@Test(priority = 4)	
	public void testPic() throws InterruptedException {
	    
	    String path=OrangeExcel.getData(XL_PATH, "PicPath", 1, 0);
	    
	    PhotographPage pi= new PhotographPage(driver);
	   
	    pi.clickPhotographButton();	    
	    pi.clickChooseFileButton(path);
	    pi.clickEditOrSaveButton();
	    Thread.sleep(3000);
		}

	
}
