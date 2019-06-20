package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.common.Common;

public class HomePage extends GeneralPage {

	public HomePage() {
		super(HomePage.class);
	}

	@Override
	public void initPageElements() {
		super.initPageElements();		
	}

	/**
	 * @author 
	 * @description wait page loading.
	 * @param timeOutInSeconds
	 * @return
	 */
	public HomePage waitForLoading(int timeOutInSeconds) {
		tabExecutionDashboard.waitForDisplay(timeOutInSeconds);
		LOG.info("Page is loaded successfully");
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public HomePage waitForLoading() {
		waitForLoading(Common.ELEMENT_TIMEOUT);
		return this;
	}
	
	/**
	 * @author nhan.tran
	 * @Description: Check main page apears.
	 * 
	 */
	
	public boolean checkMainPageApears()
	{
		return tabExecutionDashboard.isExisted();
	}
	
	/**
	 * @author tien.duc.tran
	 * @description select Panel menu item
	 * 
	 */
	
//	public PanelPage openPanelListPage() {
//		this.selectMenuItem(itemAdminister, lnkPanel);
//		return new PanelPage();
//	}
	
}
