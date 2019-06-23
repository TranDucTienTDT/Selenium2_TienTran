package com.logigear.test.ta_dashboard.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.DataProfileSettingPage;
import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.testfw.common.BaseTest;

public class DataProfileTest_Tien extends BaseTest{

	@Test
	public void DA_DP_TC095() {
		/*
		 * Log in Dashboard
		 * Navigate to Data Profiles page
		 * Input to "Name *" field
		 * Click "Item Type" dropped down menu and choose Test Modules
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Description, Version, Priority, Last update date, Creation date, Notes, 
		 * Check out machine, Location, Recent result, Assigned user, 
		 * Status, Last updated by, Created by, Check out user
		 */ 
		HomePage homePage = precondition();
		DataProfileSettingPage generalSettingPage = homePage.createProfile("TestA","Test Modules");
		boolean expectedResult = generalSettingPage.selectSetting("Statistic Fields").isItemTypeExist();
		Assert.assertTrue(expectedResult, "The item types don't display as expected");

		/* Navigate to General Settings page
		 * Click "Item Type" dropped down menu and choose Test Cases
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Title, Notes, Location, Recent result
		 */ 
		
		/* Navigate to General Settings page
		 * Click "Item Type" dropped down menu and choose Test Objectives
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Title, Notes, Location, Recent result, Source
		 */ 
		
		/* Navigate to General Settings page
		 * Click "Item Type" dropped down menu and choose Data Sets
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Description, Assigned user, Last update date, Creation date, Notes, 
		 * Check out machine, Location, Version, Status, Last updated by, Created by, Check out user
		 */ 
		
		/* Navigate to General Settings page
		 * Click "Item Type" dropped down menu and choose Actions
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Description, Assigned user, Last update date, Creation date, Notes, 
		 * Check out machine, Location, Version, Status, 
		 * Last updated by, Created by, Verbose description, Check out user
		 */ 
		
		/* Navigate to General Settings page
		 * Click "Item Type" dropped down menu and choose Interface Entities
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Description, Assigned user, Last update date, Creation date, Notes, 
		 * Check out machine, Location, Version, Status, Last updated by, Created by, Check out user
		 */ 
		
		/* Navigate to General Settings page
		 * Click "Item Type" dropped down menu and choose Test Results
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Reported by, Start time, Duration, Variation, Passed, Warnings, Automated/Manual, 
		 * Notes, Location, Date of run, End time, Comment, Result, Failed, Errors, Run Machine
		 */
		
		/* Navigate to General Settings page
		 * Click "Item Type" dropped down menu and choose Test Case Results
		 * Navigate to Statistic page
		 * VP: Check all fields of selected "Item Type" item are populated correctly
		 * Name, Date of run, Passed, Warnings, Notes, Location, Result, Failed, Errors
		 */
	}
}
