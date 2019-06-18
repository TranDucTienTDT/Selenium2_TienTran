package com.logigear.test.ta_dashboard.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;

public class ModifyPageTest extends BaseTest{
	
	@Test
	public void TC001() {
		
		System.out.println(
				"TC001 - Verify that user can login specific repository successfully via Dashboard login page with correct credentials");
		
		String USERNAME = "administrator";
		String PASSWORD = "";
		String SAMPLE_REPO = "SampleRepository";
		
		LoginPage loginpage = new LoginPage();
		HomePage homePage = loginpage.login(USERNAME, PASSWORD, SAMPLE_REPO);
		
		String checkTab = homePage.checkActiveTab();
		String expectedTab = "class com.logigear.testfw.element.Element";
		Assert.assertEquals(checkTab, expectedTab, "Can't login with correct credentials");
	}

}