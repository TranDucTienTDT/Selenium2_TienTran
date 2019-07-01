package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.element.Element;

public class DPSettingPage extends BasePOM {
	protected Element lnkSettingOption;
	protected Element btnGeneral;
	
	public DPSettingPage(Class<?> derivedClass) {
		super(derivedClass);
	}

	@Override
	public void initPageElements() {
		this.lnkSettingOption = new Element(getLocator("lnkSettingOption").getBy());
		this.btnGeneral = new Element(getLocator("btnGeneral").getBy());
	}

	//@author hanh.nguyen
	public enum TableNavigatedPage{
		GENERAL_SETTINGS("General Settings"),
		DISPLAY_FIELDS("Display Fields"),
		SORT_FIELDS("Sort Fields"),
		FILTER_FIELDS("Filter Fields"),
		STATISTIC_FIELDS("Statistic Fields");

		private String tableNavigatedPage;

		public String getValue() {
			return tableNavigatedPage;
		}

		public void setValue(String _tableNavigatedPage) {
			this.tableNavigatedPage = _tableNavigatedPage;
		}

		private TableNavigatedPage(String _tableNavigatedPage) {
			this.tableNavigatedPage = _tableNavigatedPage;
		}
	}

	/**
	 * @author: tien.duc.tran
	 * @Description: navigateSettingPage (Select left side menu item)
	 * @param: option
	 */

	public Object navigateSettingPage (TableNavigatedPage option) {

		lnkSettingOption = new Element(getLocator("lnkMenuOption").getBy(option.getValue()));
		lnkSettingOption.click();
		lnkSettingOption.waitForDisplay(Common.ELEMENT_TIMEOUT);

		if(option == TableNavigatedPage.GENERAL_SETTINGS) {
			return new DPGeneralSettingsPage();
		}else if(option == TableNavigatedPage.DISPLAY_FIELDS) {
			return new DPDisplayFieldsPage();
		}else if(option == TableNavigatedPage.SORT_FIELDS) {
			return new DPSortFieldsPage();
		}else if(option == TableNavigatedPage.FILTER_FIELDS) {
			return new DPFilterFieldsPage();
		}else if(option == TableNavigatedPage.STATISTIC_FIELDS) {
			return new DPStatisticFieldsPage();
		}else
			return this;

	}

	//@author tien.duc.tran
	public enum GeneralButton{
		BACK("Back"),
		NEXT("Next"),
		FINISH("Finish"),
		CANCEL("Cancel");

		private String generalButton;

		public String getValue() {
			return generalButton;
		}

		public void setValue(String _generalButton) {
			this.generalButton = _generalButton;
		}

		private GeneralButton(String _generalButton) {
			this.generalButton = _generalButton;
		}
	}

	/**
	 * @author: tien.duc.tran
	 * @Description: clickButton (click button Back, next, finish, cancel)
	 * @param: generalButton
	 */

	public void clickButton(GeneralButton generalButton) {
		btnGeneral = new Element(getLocator("btnGeneral").getBy(generalButton.getValue()));
		btnGeneral.click();
	}

}
