package com.logigear.test.ta_dashboard.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;

public class ModifyPageTest extends Precondition{
	
	@Test
	public void DA_PANEL_TC064() {
		
		System.out.println(
				"DA_PANEL_TC064 - Verify that \"Check All/Uncheck All\" links are working correctly.			");
		
		String USERNAME = "administrator";
		String PASSWORD = "";
		String SAMPLE_REPO = "SampleRepository";
		
		LoginPage loginpage = new LoginPage();
		HomePage homePage = loginpage.login(USERNAME, PASSWORD, SAMPLE_REPO);
		
	}

}
