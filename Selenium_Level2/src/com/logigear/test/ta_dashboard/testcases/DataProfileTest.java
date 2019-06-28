package com.logigear.test.ta_dashboard.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.data_object.ChartPanel;
import com.logigear.test.ta_dashboard.data_object.DataProfile;
import com.logigear.test.ta_dashboard.data_object.Page;
import com.logigear.test.ta_dashboard.pom.DPDisplayFieldsPage.DataProfileValueField;
import com.logigear.test.ta_dashboard.pom.DPGeneralSettingsPage;
import com.logigear.test.ta_dashboard.pom.DataProfilesPage;
import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.PanelPage;
import com.logigear.test.ta_dashboard.pom.PanelPage.LinkedText;

public class DataProfileTest extends Precondition{
	
		@Test
		public void TC_DA_DP_TC097()
		{
			LOG.info("Verify that all settings are recorded and updated correctly when user click on \"Finish\" buttons ");
			
			//init data
			DataProfile dataProfile = new DataProfile("Test 1", "Data Sets", 
										new String[] {DataProfileValueField.NAME.getValue()}, 
										new String[] {DataProfileValueField.NAME.getValue()}, 
										new String[] {"Assigned user=\"admistrator\""}, 
										new String[] {DataProfileValueField.NAME.getValue()});
			
//			Step	Log in Dashboard		
//			Step	Navigate to Data Profiles page		
//			Step	Input to "Name *" field: Test 1	
//			Step	Click "Item Type" dropped down menu and select any item		
//			Step	Click on Next		
//			Step	Check "Name" checkbox		
//			Step	Click on Next		
//			Step	Select "Name" in Field dropped down menu		
//			Step	Click Next		
//			Step	Add a filter criteria: A	
//			Step	Click Next		
//			Step	Check "Name" checkbox		
//			Step	Click "Finish"		
//			Step	Click on data profile created above: Test 1	
//			Step	Navigate through all pages		
//			VP		Check all settings done above are saved correctly: all settings done above are saved correctly

			HomePage homePage = preconditionLoginValid();
			boolean isGeneralSettingsPageCorrect = homePage.gotoGeneralSettingsPageByMenuItem()
															.submitDataProfilesGeneralSettingsPage(dataProfile)
															.submitDataProfilesDisplayFieldPage(dataProfile)
															.submitDataProfilesSortFieldsPage(dataProfile)
															.submitDataProfilesFilterFieldsPage(dataProfile)
															.submitDataProfilesStatisticFieldPage(dataProfile)
															.clickEditLinkedText(dataProfile.getName())
															.isDataProfilesGeneralSettingsPageDisplayCorrect(dataProfile);
			
			Assert.assertTrue(isGeneralSettingsPageCorrect, "\"General Settings\" page is not displayed correctly.");
			
			DPGeneralSettingsPage dpGeneralSettingsPage = new DPGeneralSettingsPage();
			//dpGeneralSettingsPage
		}
		
		@AfterMethod
		public void postCondition() {
			LOG.info("Post-conditions: delete page and panels");
			PanelPage panelPage = new PanelPage();
			panelPage.deleteAllPanels()
						.deletePage("TestPage");
		}
}
