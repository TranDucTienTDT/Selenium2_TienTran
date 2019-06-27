package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.element.Element;

public class DPDisplayFieldsPage extends GeneralPage{
	
	protected Element lnkMenuOption;
	protected Element chkDisplayField;
	protected Element btnNext;
	
	public DPDisplayFieldsPage() {
		super(DPDisplayFieldsPage.class);
	}

	@Override
	public void initPageElements() {
		super.initPageElements();	
		this.lnkMenuOption = new Element(getLocator("lnkMenuOption").getBy("General Settings"));
		this.btnNext = new Element(getLocator("btnNext").getBy());
	}
	
	public void chkDisplayField(String chkValue) {
		this.chkDisplayField = new Element(getLocator("chkDisplayField").getBy(chkValue));
	}
	
	//@author hanh.nguyen
	public enum DPDisplayFieldsCheckbox {
		NAME("name");
		
		String _dpDisplayFieldsCheckbox;
		
		public String getValue() {
			return _dpDisplayFieldsCheckbox;
		}

		public void setValue(String dpDisplayFieldsCheckbox) {
			this._dpDisplayFieldsCheckbox = dpDisplayFieldsCheckbox;
		}

		private DPDisplayFieldsCheckbox(String dpDisplayFieldsCheckbox) {
			this._dpDisplayFieldsCheckbox = dpDisplayFieldsCheckbox;
		}
	}
	
	//@author hanh.nguyen
	public void selectDataProfilesDisplayField(String... displayField) {
		logger.printMessage("In \"Display Fields\" page, check on: " + displayField);
		for(String item : displayField) {
			chkDisplayField(item);
			chkDisplayField.check();
		}
	}
	
	//@author hanh.nguyen
	public DPSortFieldsPage submitDataProfilesDisplayFieldPage(String... displayField) {
		logger.printMessage("Submit \"Display Fields\" page.");
		selectDataProfilesDisplayField(displayField);
		return new DPSortFieldsPage();
	}

}
