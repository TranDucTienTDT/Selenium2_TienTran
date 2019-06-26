package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.element.Element;

public class DPGeneralSettingsPage extends GeneralPage{
	
	protected Element lnkMenuOption;
	protected Element txtProfileName;
	protected Element cbbEntityType;
	protected Element btnNext;
	protected Element rowItem;
	
	public DPGeneralSettingsPage() {
		super(DPGeneralSettingsPage.class);
	}

	@Override
	public void initPageElements() {
		super.initPageElements();	
		this.lnkMenuOption = new Element(getLocator("lnkMenuOption").getBy("General Settings"));
		this.txtProfileName = new Element(getLocator("txtProfileName").getBy());
		this.cbbEntityType = new Element(getLocator("cbbEntityType").getBy());
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

		return new DPGeneralSettingsPage();
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

}
