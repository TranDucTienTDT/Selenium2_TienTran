package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.element.Element;

public class DPSortFieldsPage extends GeneralPage{
	
	public DPSortFieldsPage() {
		super(DPSortFieldsPage.class);
	}
	
	protected Element lnkMenuOption;
	protected Element rowItem;
	protected Element cbbField;
	protected Element btnAddLevel;
	protected Element btnNext;

	@Override
	public void initPageElements() {
		super.initPageElements();	
		this.lnkMenuOption = new Element(getLocator("lnkMenuOption").getBy());
		this.rowItem = new Element(getLocator("rowItem").getBy());
		this.cbbField = new Element(getLocator("cbbField").getBy());
		this.btnAddLevel = new Element(getLocator("btnAddLevel").getBy());
		this.btnNext = new Element(getLocator("btnNext").getBy());
	}
	
	//@author hanh.nguyen
	public void selectDataProfilesSortFields(String... sortField) {
		logger.printMessage("In \"Sort Fields\" page, select: " + sortField);
		for(String item : sortField) {
			cbbField.selectByTextContains(item);
			btnAddLevel.click();
		}
	}
	
	//@author hanh.nguyen
	public DPFilterFieldsPage submitDataProfilesSortFieldsPage(String... sortField) {
		logger.printMessage("Submit \"Sort Fields\" page.");
		selectDataProfilesSortFields(sortField);
		return new DPFilterFieldsPage();
	}

}
