package com.logigear.test.ta_dashboard.pom;

import com.logigear.test.ta_dashboard.data_object.DataProfile;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.element.Element;

public class DPGeneralSettingsPage extends DPSettingPage{
	
	protected Element txtName;
	protected Element cbbItemType;
	protected Element cbbRelatedData;
	protected Element rowItem;
	
	public DPGeneralSettingsPage() {
		super(DPGeneralSettingsPage.class);
	}

	@Override
	public void initPageElements() {
		super.initPageElements();	
		this.txtName = new Element(getLocator("txtName").getBy());
		this.cbbItemType = new Element(getLocator("cbbItemType").getBy());
		this.cbbRelatedData = new Element(getLocator("cbbRelatedData").getBy());
		this.rowItem = new Element(getLocator("rowItem").getBy());
	}
	
	/**
	 * @author: tien.duc.tran
	 * @Description: isItemTypeExist (Check all fields of selected "Item Type" item are populated correctly)
	 * @param: 
	 */
	
	public boolean isItemTypeExist() {
		//Lam mot ham check rowItem co display trong table hay khong?
		return true;
	}
	
//	//@author hanh.nguyen
//	public enum TableNavigatedPage{
//		GENERAL_SETTINGS("General Settings"),
//		DISPLAY_FIELDS("Display Fields"),
//		SORT_FIELDS("Sort Fields"),
//		FILTER_FIELDS("Filter Fields"),
//		STATISTIC_FIELDS("Statistic Fields");
//		
//		private String tableNavigatedPage;
//		
//		public String getValue() {
//			return tableNavigatedPage;
//		}
//
//		public void setValue(String _tableNavigatedPage) {
//			this.tableNavigatedPage = _tableNavigatedPage;
//		}
//
//		private TableNavigatedPage(String _tableNavigatedPage) {
//			this.tableNavigatedPage = _tableNavigatedPage;
//		}
//	}
//	
	
	//@author hanh.nguyen
	public void fillInDataProfilesGeneralSettingsPage(String name, String itemType, String relatedData) {
		if((name != null) && (txtName.getText() != null || txtName.getText() != name)) {
			LOG.info("In \"Name\" textbox, enter: " + name);
			txtName.enter(name);
		}
		if(itemType != null && cbbItemType.getText() != itemType) {
			LOG.info("In \"Item Type\" combobox, select: " + itemType);
			cbbItemType.selectByText(itemType);
		}
		if(relatedData != null && cbbRelatedData.getText() != relatedData) {
			LOG.info("In \"Related Data\" combobox, select: " + relatedData);
			cbbRelatedData.selectByText(relatedData);
		}
	}
	
	//@author hanh.nguyen
	public DPDisplayFieldsPage submitDataProfilesGeneralSettingsPage(String name, String itemType, String relatedData) {
		LOG.info("Submit \"General Settings\" page.");
		fillInDataProfilesGeneralSettingsPage(name, itemType, relatedData);
		clickButton(GeneralButton.NEXT);
		txtName.waitForDisappear(Common.ELEMENT_TIMEOUT);
		return new DPDisplayFieldsPage();
	}
	
	//@author hanh.nguyen
	public DPDisplayFieldsPage submitDataProfilesGeneralSettingsPage(DataProfile dataProfile) {
		submitDataProfilesGeneralSettingsPage(dataProfile.getName(), dataProfile.getItemType(), dataProfile.getRelatedData());
		return new DPDisplayFieldsPage();
	}
	
	//@author hanh.nguyen
	public boolean isDataProfilesGeneralSettingsPageDisplayCorrect(DataProfile dataProfile) {
		boolean isCorrect = false;
		String actualValue = txtName.getText() + cbbItemType.getSelectedOption() + cbbRelatedData.getSelectedOption();
		String relatedData = dataProfile.getRelatedData();
		if(dataProfile.getRelatedData() == null)
			relatedData = "None";
		String expectedValue = dataProfile.getName() + dataProfile.getItemType() + relatedData;
		if(actualValue.equals(expectedValue))
			isCorrect = true;
		LOG.info("Is Data Profiles \"General Settings\" page display correct: " + isCorrect);
		return isCorrect;
	}

}
