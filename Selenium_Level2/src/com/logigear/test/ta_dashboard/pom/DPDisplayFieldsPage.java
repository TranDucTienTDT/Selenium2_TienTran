package com.logigear.test.ta_dashboard.pom;

import java.util.ArrayList;

import com.logigear.test.ta_dashboard.data_object.DataProfile;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.element.Element;

public class DPDisplayFieldsPage extends DPSettingPage{
	
	protected Element chkDisplayField;
	protected Element lblHeaderDisplayFields;
	
	public DPDisplayFieldsPage() {
		super(DPDisplayFieldsPage.class);
	}

	@Override
	public void initPageElements() {
		super.initPageElements();	
		this.lblHeaderDisplayFields = new Element(getLocator("lblHeaderDisplayFields").getBy());
	}
	
	public void chkDisplayField(String chkValue) {
		this.chkDisplayField = new Element(getLocator("chkDisplayField").getBy(chkValue));
	}
	
	//@author hanh.nguyen
	public enum DataProfileValueField {
		NAME("Name"),
		DESCRIPTION("Description"),
		ASSIGNED_USER("Assigned user"),
		LAST_UPDATE_DATE("Last update date"),
		CREATION_DATE("Creation date"),
		NOTES("Notes"),
		URL("URL"),
		LOCATION("Location"),
		REVISION_TIMESTAMP("Revision Timestamp"),
		STATUS("Status"),
		LAST_UPDATED_BY("Last updated by"),
		CREATED_BY("Created by"),
		CHECK_OUT_BY("Check out by");
		
		private String _dataProfileValueField;
		
		public String getValue() {
			return _dataProfileValueField;
		}

		public void setValue(String dataProfileValueField) {
			this._dataProfileValueField = dataProfileValueField;
		}

		private DataProfileValueField(String dataProfileValueField) {
			this._dataProfileValueField = dataProfileValueField;
		}
	}
	
	//@author hanh.nguyen
	public void selectDataProfilesDisplayField(String... displayField) {
		LOG.info("In \"Display Fields\" page, check on: " + displayField);
		for(String item : displayField) {
			chkDisplayField(item);
			chkDisplayField.check();
		}
	}
	
	//@author hanh.nguyen
	public DPSortFieldsPage submitDataProfilesDisplayFieldPage(String... displayField) {
		LOG.info("Submit \"Display Fields\" page.");
		selectDataProfilesDisplayField(displayField);
		clickButton(GeneralButton.NEXT);
		lblHeaderDisplayFields.waitForDisappear(Common.ELEMENT_TIMEOUT);
		return new DPSortFieldsPage();
	}
	
	//@author hanh.nguyen
	public DPSortFieldsPage submitDataProfilesDisplayFieldPage(DataProfile dataProfile) {
		submitDataProfilesDisplayFieldPage(dataProfile.getDisplayField());
		return new DPSortFieldsPage();
	}
	
	//@author hanh.nguyen
	public boolean isDataProfilesDisplayFieldPageDisplayCorrect(DataProfile dataProfile) {
		ArrayList<Boolean> isCorrect = new ArrayList<Boolean>(dataProfile.getDisplayField().length);
		for (String value : dataProfile.getDisplayField()) {
			chkDisplayField(value);
			isCorrect.add(chkDisplayField.isSelected());
		}
		if(isCorrect.contains(false)) {
			LOG.info("The Display Field checkboxes are not checked all.");
			return false;
		}
		else {
			LOG.info("The Display Field checkboxes are checked all.");
			return true;
		}
	}

}
