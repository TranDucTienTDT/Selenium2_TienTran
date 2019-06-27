package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.common.Common;
import com.logigear.testfw.element.Element;

public class DPGeneralSettingsPage extends GeneralPage{
	
	protected Element lnkMenuOption;
	protected Element txtName;
	protected Element cbbItemType;
	protected Element cbbRelatedData;
	protected Element btnNext;
	protected Element rowItem;
	
	public DPGeneralSettingsPage() {
		super(DPGeneralSettingsPage.class);
	}

	@Override
	public void initPageElements() {
		super.initPageElements();	
		this.lnkMenuOption = new Element(getLocator("lnkMenuOption").getBy("General Settings"));
		this.txtName = new Element(getLocator("txtName").getBy());
		this.cbbItemType = new Element(getLocator("cbbItemType").getBy());
		this.cbbRelatedData = new Element(getLocator("cbbRelatedData").getBy());
		this.btnNext = new Element(getLocator("btnNext").getBy());
		this.rowItem = new Element(getLocator("rowItem").getBy());
	}
	
	/**
	 * @author: tien.duc.tran
	 * @Description: selectSetting (Check all fields of selected "Item Type" item are populated correctly)
	 * @param: option
	 */
	
	public DPGeneralSettingsPage selectSetting(String option) {
		
		lnkMenuOption = new Element(getLocator("lnkMenuOption").getBy(option));
		lnkMenuOption.click();

		return this;
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
	
	//@author hanh.nguyen
	public void fillInDataProfilesGeneralSettingsPage(String name, String itemType, String relatedData) {
		if((name != null) && (txtName.getText() != null || txtName.getText() != name)) {
			txtName.enter(name);
		}
		if(itemType != null && cbbItemType.getText() != itemType) {
			cbbItemType.selectByText(itemType);
		}
		if(relatedData != null && cbbRelatedData.getText() != relatedData) {
			cbbRelatedData.selectByText(relatedData);
		}
	}
	
	//@author hanh.nguyen
	public DPDisplayFieldsPage submitDataProfilesGeneralSettingsPage(String name, String itemType, String relatedData) {
		fillInDataProfilesGeneralSettingsPage(name, itemType, relatedData);
		btnNext.click();
		btnNext.waitForDisappear(Common.ELEMENT_TIMEOUT);
		return new DPDisplayFieldsPage();
	}

}
