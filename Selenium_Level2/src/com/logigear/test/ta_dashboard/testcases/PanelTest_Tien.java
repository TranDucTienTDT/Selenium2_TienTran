package com.logigear.test.ta_dashboard.testcases;

import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.data_object.GeneralPanel.PanelType;
import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.PanelDialog;
import com.logigear.test.ta_dashboard.pom.PanelDialog.PanelSettingType;
import com.logigear.test.ta_dashboard.pom.PanelPage;
import com.logigear.test.ta_dashboard.pom.PanelPage.LinkedText;
import com.logigear.testfw.common.BaseTest;

import junit.framework.Assert;

public class PanelTest_Tien extends BaseTest{
	@Test
	public void DA_PANEL_TC031() {

//		Navigate to Dashboard login page
//		Login with valid account
//		Click on Administer/Panels link
//		Click on Add new link
//		VP: Verify that chart panel setting form is displayed with corresponding panel type selected
//		
//		Select Indicator type
//		VP: Verify that indicator panel setting form is displayed with corresponding panel type selected
//		
//		Select Report type
//		VP: Verify that report panel setting form is displayed with corresponding panel type selected
//		
//		Select Heat Maps type
//		VP: Verify that heatmap panel setting form is displayed with corresponding panel type selected
//		
		HomePage homePage = precondition();

		homePage.waitForLoading()
				.gotoPanelPage()
				.clickLinkedText(LinkedText.ADD_NEW);
		PanelDialog panelDialog = new PanelDialog();
		boolean isChartSettingFormDisplayed = panelDialog.isPanelSettingFormDisplayed(PanelSettingType.CHART);
		Assert.assertTrue(isChartSettingFormDisplayed);

		boolean isIndicatorSettingFormDisplayed = panelDialog.selectPanelType(PanelType.INDICATOR)
																.isPanelSettingFormDisplayed(PanelSettingType.INDICATOR);
		Assert.assertTrue(isIndicatorSettingFormDisplayed);
		
		boolean isReportSettingFormDisplayed = panelDialog.selectPanelType(PanelType.REPORT)
				.isPanelSettingFormDisplayed(PanelSettingType.REPORT);
		Assert.assertTrue(isReportSettingFormDisplayed);
		
		boolean isHeatMapsSettingFormDisplayed = panelDialog.selectPanelType(PanelType.HEAT_MAP)
				.isPanelSettingFormDisplayed(PanelSettingType.HEAT_MAP);
		Assert.assertTrue(isHeatMapsSettingFormDisplayed);
	}
}
