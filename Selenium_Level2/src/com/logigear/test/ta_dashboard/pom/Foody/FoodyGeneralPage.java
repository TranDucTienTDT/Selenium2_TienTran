package com.logigear.test.ta_dashboard.pom.Foody;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.common.TestExecutor;
import com.logigear.testfw.element.Element;

public class FoodyGeneralPage extends BasePOM {
	
	protected Element cbbLocation;
	protected Element cbbCategory;
	protected Element mneCategory;
	protected Element txtSearch;
	protected Element btnSearch;
	protected Element btnFilter;
	protected Element btnSelectType;
	protected Element btnChangeLanguage;
	protected Element mneLanguage;
	protected Element tblDelivery;
	
	public FoodyGeneralPage(Class<?> derivedClass) {
		super(derivedClass);
	}
	
	@Override
	public void initPageElements() {
		this.cbbLocation = new Element(getLocator("cbbLocation").getBy());
		this.cbbCategory = new Element(getLocator("cbbCategory").getBy());
		this.txtSearch = new Element(getLocator("txtSearch").getBy());
		this.btnSearch = new Element(getLocator("btnSearch").getBy());
		this.btnFilter = new Element(getLocator("btnFilter").getBy());
		this.btnSelectType = new Element(getLocator("btnSelectType").getBy());
		this.btnChangeLanguage = new Element(getLocator("btnChangeLanguage").getBy());
		this.tblDelivery = new Element(getLocator("tblDelivery").getBy());
	}
	
	public void mneCategory(String type, String subType) {
		this.mneCategory = new Element(getLocator("mneCategory").getBy(type, subType));
	}
	
	public void mneLanguage(String language) {
		this.mneLanguage = new Element(getLocator("mneLanguage").getBy(language));
	}
	
	public FoodySearchResultPage searchWithOnlyLocation(String location) {
		logger.printMessage("Enter value: " + location + " in \"Search\" textbox to search.");
		txtSearch.enter(location);
		btnSearch.click();
		tblDelivery.waitForDisappear(Common.ELEMENT_TIMEOUT);
		return new FoodySearchResultPage();
	}
	
	//author hanh.nguyen
	//The tabIndex starts with 0
	public void switchTab(int tabIndex) {
		try {
			LOG.info(String.format("Try to switch tab in browser."));
			WebDriver driver = (WebDriver) TestExecutor.getInstance().getCurrentDriver();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			if(tabIndex >= tabs.size() - 1) {
				LOG.severe("The index is out of bound.");
				return;
			}
			driver.switchTo().window(tabs.get(tabIndex));
		} catch (Exception error) {
			LOG.severe(String.format("Has error when switching tab in browser."));
			throw error;
		}
	}

}
