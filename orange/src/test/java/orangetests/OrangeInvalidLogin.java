package orangetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangegenerics.OrangeBaseTest;
import orangegenerics.OrangeExcel;
import orangepages.OrangeLoginPage;
//DDT-data driven testing
public class OrangeInvalidLogin extends OrangeBaseTest
{

	@Test(priority = 2)
	public void testInvalidLogin() throws InterruptedException {
		
		int rc=OrangeExcel.getRowCount(XL_PATH, "InvalidLogin");
		for(int i=1;i<=rc;i++) {
//		Read data from excel
		String un=OrangeExcel.getData(XL_PATH, "InvalidLogin", i, "Username");
		String pw=OrangeExcel.getData(XL_PATH, "InvalidLogin", i, "Password");
		String failMsg=OrangeExcel.getData(XL_PATH, "InvalidLogin", i, "FailMsg");
		
//		•	Enter invalid user name (abcd)
		OrangeLoginPage l=new OrangeLoginPage(driver);
		l.setUserName(un);
		
//		•	Enter invalid password (xyz)
		l.setPassword(pw);
		Thread.sleep(1000);
		
//		•	Click on login button
		l.clickLoginButton();
		
//		•	Verify that error msg is displayed
		boolean result = l.verifyErrMsgIsDisplayed(wait);
		Assert.assertTrue(result,failMsg);
		Thread.sleep(1000);
		}
	}
}
