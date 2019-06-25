package com.logigear.test.ta_dashboard.pom;

import com.logigear.test.ta_dashboard.data_object.ChartPanel;
import com.logigear.test.ta_dashboard.data_object.Page;
import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.common.TestExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.common.TestExecutor;
import com.logigear.testfw.driver.BaseDriver;
import com.logigear.testfw.element.Element;
import com.logigear.testfw.utilities.Logger;

import bsh.org.objectweb.asm.Constants;

public class GeneralPage extends BasePOM {

	// Variable
	private String xpathMainSection = ("//div[@id='container']//li//a[contains(.,'%s')]");
	private String xpathSubSection = ("//div[@id='container']//li/a[contains(.,'%s')]");

	// Element
	protected Element lnkMyProfile;
	protected Element tabExecutionDashboard;
	protected Element lnkGlobalSetting;
	protected Element lnkAddPage;
	protected Element lnkChoosePanels;
	protected Element btnCreateNewPanel;
	protected Element lnkCreatePanel;
	protected Element lnkPage;
	protected Element lnkDelete;
	protected Element lnkEdit;
	protected Element lnkAdminister;
	protected Element lnkDataProfile;
	protected Element lnkPanels;
	//protected Element allLnkInSecondLine;
	protected Element lnkCreateDataProfile;
	public PageDialog pageDialog = new PageDialog();
	public PanelDialog panelDialog = new PanelDialog();
	public PanelConfigurationDialog panelConfigurationDialog = new PanelConfigurationDialog();
	public DPGeneralSettingsPage generalSettingPage = new DPGeneralSettingsPage();
	
	public GeneralPage(Class<?> derivedClass) {
		super(derivedClass);
	}

	@Override
	public void initPageElements() {
		this.lnkMyProfile = new Element(getLocator("lnkMyProfile").getBy());
		this.tabExecutionDashboard = new Element(getLocator("tabExecutionDashboard").getBy());
		this.lnkGlobalSetting = new Element(getLocator("lnkGlobalSetting").getBy());
		this.lnkAddPage = new Element(getLocator("lnkAddPage").getBy());
		this.lnkChoosePanels = new Element(getLocator("lnkChoosePanels").getBy());
		this.btnCreateNewPanel = new Element(getLocator("btnCreateNewPanel").getBy());
		this.lnkCreatePanel = new Element(getLocator("lnkCreatePanel").getBy());
		this.lnkDelete = new Element(getLocator("lnkDelete").getBy());
		this.lnkEdit = new Element(getLocator("lnkEdit").getBy());
		this.lnkAdminister = new Element(getLocator("lnkAdminister").getBy());
		this.lnkDataProfile = new Element(getLocator("lnkDataProfile").getBy());
		this.lnkCreateDataProfile = new Element(getLocator("lnkCreateDataProfile").getBy());
		this.lnkPanels = new Element(getLocator("lnkPanels").getBy());
	}
	
	public void lnkPage(String pageName)
	{
		new Element(getLocator("lnkPage").getBy(pageName));
	}
	
	public PanelPage clickMenu()
	{
		//..
		return new PanelPage();
	}
	
//	public int getNumbersOfLinkedButtonInSecondLine() {
//		return Element(getLocator("allLnkInSecondLine").getBy());
//	}

	/**
	 * Open Add New Page dialog or Edit Page dialog.
	 *
	 * @author hanh.nguyen
	 */
	public PageDialog openPageDialog() {
		logger.printMessage("Open \"New Page\" or \"Edit Page\" dialog.");
		lnkGlobalSetting.click();
		lnkAddPage.click();
		return new PageDialog();
	}

	/**
	 * @author nhan.tran
	 * @Description: Select menu item without <option>tab by hold/click
	 * @param selectedElement Element that should be select.
	 */

	public void selectMenuItem(Element menuElement, Element selectedElement) {
		try {
			menuElement.moveToElement();
			selectedElement.click();
		} catch (Exception error) {
			LOG.severe(String.format("Has error when select item in %d"));
		}
	}
	
	/**
	 * @author hanh.nguyen
	 * @Description: Verify that the page is opened or not
	 * @param pageName	name of the page
	 */
	public boolean isPageOpened(String pageName) {
		String actualTitle = TestExecutor.getInstance().getCurrentDriver().getTitle();
		boolean isOpened = actualTitle.contains(pageName);
		logger.printMessage("Is page \"" + pageName + "\" opened: " + isOpened);
		return isOpened;
	}

	/**
	 * @author: duy.nguyen
	 * @Description: Navigate to the page
	 * @param: menuPath The full path can be separated by "/"
	 */

	public void goToPage(String menuPath, int timeOutInSeconds) {
		if (menuPath.contains("/")) {
			String[] path = menuPath.split("/");
			String path1 = path[0];
			String path2 = path[1];
			String xpathMainPath = String.format(xpathMainSection, path1);
			String xpathSubPath = String.format(xpathSubSection, path2);

			Element lnkXpathMainPath = new Element(xpathMainPath);
			Element lnkXpathSubPath = new Element(xpathSubPath);
			try {
				lnkXpathMainPath.waitForDisplay(timeOutInSeconds);
				lnkXpathMainPath.click();
				lnkXpathSubPath.waitForDisplay(timeOutInSeconds);
				lnkXpathSubPath.click();
			} catch (Exception error) {
				throw error;
			}
		} else {
			String xpathMainPath = String.format(xpathMainSection, menuPath);
			Element lnkXpathMainPath = new Element(xpathMainPath);
			
			try {
				lnkXpathMainPath.waitForDisplay(timeOutInSeconds);
				lnkXpathMainPath.click();
			} catch (Exception error) {
				throw error;
			}
		}
	}

	/**
	 * @author: duy.nguyen
	 * @Description: get the currently URL
	 * @param: url (output) URL
	 */
	public String getUrl() {
		String url = TestExecutor.getInstance().getCurrentDriver().getCurrentUrl();
		return url;
	}
	
	/**
	 * @author NhanTran
	 * @description: getText of element
	 * */
	public String getTextOfElementAfter(String elementBefore)
	{
		String xpath = String.format("//ul[./li/a[text()='%s']]/li)[2]", elementBefore);
		Element element = new Element(xpath);
		String result = element.getText();
		return result;
	}
	
	/**
	 * Open Add New Panel dialog.
	 *
	 * @author hanh.nguyen
	 * @param isFromChoosePanels open the dialog from "Choose Panels" linked button
	 *                           or from "Global Setting" linked button
	 */
	
	public PanelDialog openPanelDialog(boolean isFromChoosePanels) {
		logger.printMessage("Open \"Add New Panel\" dialog.");
		if (isFromChoosePanels) {
			if(lnkChoosePanels.isAttributePresent("class")) {
				lnkChoosePanels.moveToElement();
				lnkChoosePanels.click();
			}
			btnCreateNewPanel.click();
		} else if (!isFromChoosePanels) {
			selectMenuItem(lnkGlobalSetting, lnkCreatePanel);
		}
		return new PanelDialog();
	}
	
	//@author hanh.nguyen
	public DPGeneralSettingsPage openGeneralSettingsPageByMenuItem() {
		logger.printMessage("Open \"General Settings\" page by selecting menu item.");
		selectMenuItem(lnkGlobalSetting, lnkCreateDataProfile);
		return new DPGeneralSettingsPage();
	}
	
	/**
	 * @author: tien.duc.tran
	 * @Description: createProfile (click Create Profile from Global Setting button)
	 * @param: profileName, itemType
	 * 
	 */
//	public DPGeneralSettingsPage createProfile(String profileName, String itemType) {
//		logger.printMessage("Create a new data profile.");
//		selectMenuItem(lnkGlobalSetting, lnkCreateDataProfile);
//		generalSettingPage.txtProfileName.enter(profileName);
//		generalSettingPage.cbbEntityType.selectByText(itemType);
//		generalSettingPage.btnNext.click();
//		return new DPGeneralSettingsPage();
//	}
	
	//@author hanh.nguyen
	public GeneralPage addNewPage(Page page)
	{
		logger.printMessage("Add a Page: " + page.getPageName());
		openPageDialog();
		pageDialog.fillInfoInPageDialog(page);
		pageDialog.btnOK.click();
		pageDialog.btnOK.waitForDisappear(Common.ELEMENT_TIMEOUT);
		return this;
	}
	
	//@author hanh.nguyen
	public GeneralPage addChartPanel(ChartPanel chartPanel, boolean isFromChoosePanels) {
		logger.printMessage("Add a Chart Panel: " + chartPanel.getDisplayName());
		openPanelDialog(isFromChoosePanels);
		panelDialog.fillInforInChartPanelDialog(chartPanel);
		panelDialog.btnOK.click();
		panelDialog.btnOK.waitForDisappear(Common.ELEMENT_TIMEOUT);
		return this;
	}
	
	//@author hanh.nguyen
	public GeneralPage cancelPanelConfiguration() {
		panelConfigurationDialog.cancelPanelConfiguration();
		return this;
	}
	
	//@author hanh.nguyen
	public GeneralPage deletePage(String pageName) {
		logger.printMessage("Delete page: " + pageName);
		selectMenuItem(lnkGlobalSetting, lnkDelete);
		acceptAlertPopup();
		return this;
	}
	
	//@author hanh.nguyen
	public void acceptAlertPopup() {
		TestExecutor.getInstance().getCurrentDriver().waitForAlertPopupPresent(Common.ELEMENT_TIMEOUT);
		TestExecutor.getInstance().getCurrentDriver().switchTo().alert().accept();
	}
	
//	public GeneralPage deleteAllPage() {
//		
//	}
	
	//@author hanh.nguyen
	public PanelPage gotoPanelPage() {
		logger.printMessage("Go to Panel Page.");
		selectMenuItem(lnkAdminister, lnkPanels);
		//panelPage.lnkAddNew.waitForDisplay(Common.ELEMENT_TIMEOUT);
		return new PanelPage();
	}
	
}

