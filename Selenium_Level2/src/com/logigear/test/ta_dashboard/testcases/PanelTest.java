package com.logigear.test.ta_dashboard.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.data_object.ChartPanel;
import com.logigear.test.ta_dashboard.data_object.Page;
import com.logigear.test.ta_dashboard.pom.GeneralPage;
import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.test.ta_dashboard.pom.PanelConfigurationDialog;
import com.logigear.test.ta_dashboard.pom.PanelPage.LinkedText;
import com.logigear.testfw.common.BaseTest;

public class PanelTest extends BaseTest{
	
		@Test
		public void TC064_Verify_that_Check_All_Uncheck_All_links_are_working_correctly()
		{
			//init data
			Page page = new Page("TestPage");
			ChartPanel chartPanel1 = new ChartPanel("ChartPanel1", "Name");
			ChartPanel chartPanel2 = new ChartPanel("ChartPanel2", "Name");
			
//			Step	Navigate to Dashboard login page
//			Step	Select a specific repository 
//			Step	Enter valid Username and Password
//			Step	Click 'Login' button
//			Step	Click 'Add Page' button
//			Step	Enter Page Name
//			Step	Click 'OK' button
//			Step	Click 'Choose Panels' button below 'main_hung' button
//			Step	Click 'Create new panel' button
//			Step	Enter a name to Display Name
//			Step	Click OK button
//			Step	Click Cancel button
//			Step	Click 'Create new panel' button
//			Step	Enter a name to Display Name
//			Step	Click OK button
//			Step	Click Cancel button
//			Step	Click 'Administer' link
//			Step	Click 'Panels' link
//			Step	Click 'Check All' link
			
			GeneralPage generalPage = precondition();
			generalPage.addNewPage(page)
					.addChartPanel(chartPanel1, true)
					.cancelPanelConfiguration()							
					.addChartPanel(chartPanel2, true)	
					.cancelPanelConfiguration()
					.gotoPanelPage()
					.clickLinkedText(LinkedText.CHECK_ALL);
			
//			homePage.gotoPanelPage()
//						.clickCheckAllLinkedButton()
//						.IsCheckboxChecked();
			
//			VP	Check that 'hung_a' checkbox and 'hung_b' checkbox are checked
//			Step	Click 'Uncheck All' link
//			VP	Check that 'hung_a' checkbox and 'hung_b' checkbox are unchecked
			
		
	}
}
