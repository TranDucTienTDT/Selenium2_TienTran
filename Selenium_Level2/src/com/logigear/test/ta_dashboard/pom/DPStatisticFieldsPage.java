package com.logigear.test.ta_dashboard.pom;

import java.util.ArrayList;

import com.logigear.test.ta_dashboard.data_object.DataProfile;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.element.Element;

public class DPStatisticFieldsPage extends GeneralPage{
	
	protected Element lnkMenuOption;
	protected Element chkStatisticField;
	protected Element btnBack;
	protected Element btnFinish;
	protected Element btnCancel;
	protected Element lnkCheckAll;
	protected Element lnkUncheckAll;
	
	public DPStatisticFieldsPage() {
		super(DPStatisticFieldsPage.class);
	}

	@Override
	public void initPageElements() {
		super.initPageElements();	
		this.lnkMenuOption = new Element(getLocator("lnkMenuOption").getBy("Statistic Fields"));
		this.btnBack = new Element(getLocator("btnBack").getBy());
		this.btnFinish = new Element(getLocator("btnFinish").getBy());
		this.btnCancel = new Element(getLocator("btnCancel").getBy());
		this.lnkCheckAll = new Element(getLocator("lnkCheckAll").getBy());
		this.lnkUncheckAll = new Element(getLocator("lnkUncheckAll").getBy());
	}
	
	public void chkStatisticField(String statisticField) {
		this.chkStatisticField = new Element(getLocator("chkStatisticField").getBy(statisticField));
	}
	
	//@author hanh.nguyen
	public void selectDataProfilesStatisticField(String... statisticField) {
		LOG.info("In \"Statistic Fields\" page, check on: " + statisticField);
		for(String item : statisticField) {
			chkStatisticField(item);
			chkStatisticField.check();
		}
	}
		
	//@author hanh.nguyen
	public DataProfilesPage submitDataProfilesStatisticFieldPage(String... statisticField) {
		LOG.info("Submit \"Statistic Fields\" page.");
		selectDataProfilesStatisticField(statisticField);
		btnFinish.click();
		btnFinish.waitForDisappear(Common.ELEMENT_TIMEOUT);
		return new DataProfilesPage();
	}
	
	//@author hanh.nguyen
	public DataProfilesPage submitDataProfilesStatisticFieldPage(DataProfile dataProfile) {
		submitDataProfilesStatisticFieldPage(dataProfile.getStatisticField());
		return new DataProfilesPage();
	}
	
	//@author hanh.nguyen
	public boolean isDataProfilesStatisticFieldPageDisplayCorrect(DataProfile dataProfile) {
		ArrayList<Boolean> isCorrect = new ArrayList<Boolean>(dataProfile.getStatisticField().length);
		for (String value : dataProfile.getStatisticField()) {
			chkStatisticField(value);
			isCorrect.add(chkStatisticField.isSelected());
		}
		if (isCorrect.contains(false)) {
			LOG.info("The Statistic Field checkboxes are not checked all.");
			return false;
		} else {
			LOG.info("The Statistic Field checkboxes are checked all.");
			return true;
		}
	}

}
