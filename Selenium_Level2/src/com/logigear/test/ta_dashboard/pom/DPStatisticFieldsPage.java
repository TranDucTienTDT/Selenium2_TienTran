package com.logigear.test.ta_dashboard.pom;

import java.util.ArrayList;
import java.util.Arrays;

import com.logigear.test.ta_dashboard.data_object.DataProfile;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.element.Element;

public class DPStatisticFieldsPage extends GeneralPage{
	
	protected Element chkStatisticField;
	protected Element lblStatisticField;
	protected Element btnFinish;
	protected Element lnkCheckAll;
	protected Element lnkUncheckAll;
	
	public DPStatisticFieldsPage() {
		super(DPStatisticFieldsPage.class);
	}

	@Override
	public void initPageElements() {
		super.initPageElements();	
		this.btnFinish = new Element(getLocator("btnFinish").getBy());
		this.lnkCheckAll = new Element(getLocator("lnkCheckAll").getBy());
		this.lnkUncheckAll = new Element(getLocator("lnkUncheckAll").getBy());
	}
	
	public void chkStatisticField(String statisticField) {
		this.chkStatisticField = new Element(getLocator("chkStatisticField").getBy(statisticField));
	}
	
	public void lblStatisticField(String statisticField) {
		this.lblStatisticField = new Element(getLocator("lblStatisticField").getBy(statisticField));
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
		submitNewDataProfile();
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
	
	/**
	 * @author: tien.duc.tran
	 * @Description: isStatisticItemTypeDisplayCorrect (check checkboxes display properly)
	 * @param: String... statisticField
	 */
	
	public boolean isStatisticItemTypeDisplayCorrect(String... statisticField) {
		ArrayList<String> actualValue = (ArrayList<String>) lblStatisticField.getOptions();
		boolean isCorrect = false;
		try {
			if(actualValue.size() == 0)
				LOG.info("Data Profiles Statistic Fields table doesn't has any filter.");
			else {
				ArrayList<String> expectedValue = new ArrayList<String>(Arrays.asList(statisticField));
				if(actualValue.equals(expectedValue))
					isCorrect = true;
			}
		} catch (Exception error) {
			LOG.severe("Has error when checking Statistic Fields table.");
		}
		LOG.info("Is Statistic Fields table displayed correctly: " + isCorrect);
		return isCorrect;
	}
	
	/**
	 * @author: tien.duc.tran
	 * @Description: isStatisticItemTypeDisplayCorrect (check checkboxes display properly)
	 * @param: DataProfile dataProfile
	 */
	public boolean isStatisticItemTypeDisplayCorrect(DataProfile dataProfile) {
		boolean isCorrect = isStatisticItemTypeDisplayCorrect(dataProfile.getStatisticField());
		return isCorrect;
	}
	
	//@author hanh.nguyen	
	public DataProfilesPage submitNewDataProfile() {
		LOG.info("From \"Statistic Fields\" page, click \"Finish\" to sumit a new data profile and go to \"Data Profiles\" page.");
		btnFinish.click();
		btnFinish.waitForDisappear(Common.ELEMENT_TIMEOUT);
		return new DataProfilesPage();
	}

}
