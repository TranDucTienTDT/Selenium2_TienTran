package com.logigear.test.ta_dashboard.pom;

import java.util.ArrayList;

import com.logigear.test.ta_dashboard.data_object.DataProfile;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.element.Element;

public class DPFilterFieldsPage extends DPSettingPage{
	
	protected Element rowItem;
	protected Element cbbAndOrCondition;
	protected Element cbbField;
	protected Element cbbOperator;
	protected Element txtValue;
	protected Element btnAdd;
	protected Element btnRemove;
	protected Element tableListCondition;
	
	public DPFilterFieldsPage() {
		super(DPFilterFieldsPage.class);
	}

	@Override
	public void initPageElements() {
		super.initPageElements();	
		this.rowItem = new Element(getLocator("rowItem").getBy());
		this.cbbAndOrCondition = new Element(getLocator("cbbAndOrCondition").getBy());
		this.cbbField = new Element(getLocator("cbbField").getBy());
		this.cbbOperator = new Element(getLocator("cbbOperator").getBy());
		this.txtValue = new Element(getLocator("txtValue").getBy());
		this.btnAdd = new Element(getLocator("btnAdd").getBy());
		this.btnRemove = new Element(getLocator("btnRemove").getBy());
		this.tableListCondition = new Element(getLocator("tableListCondition").getBy());
	}
	
	//@author hanh.nguyen
	public void addDataProfilesFilterFields(String andOrCondition, String field, String operator, String value) {
		if(andOrCondition != null && cbbAndOrCondition.getText() != andOrCondition) {
			LOG.info("In \"And/Or\" combobox, select: " + andOrCondition);
			cbbAndOrCondition.selectByText(andOrCondition);
		}
		if(field != null && cbbField.getText() != field) {
			LOG.info("In \"Field\" combobox, select: " + field);
			cbbField.selectByText(field);
		}
		if(operator != null && cbbOperator.getText() != operator) {
			LOG.info("In \"Operator\" combobox, select: " + operator);
			cbbOperator.selectByText(operator);
		}
		if((value != null) && (txtValue.getText() != null || txtValue.getText() != value)) {
			LOG.info("In \"Value\" textbox, enter: " + value);
			txtValue.enter(value);
		}
		btnAdd.click();
	}
	
	//@author hanh.nguyen
	public int findStartNumberInFilterValue(String filterValue) {
		int start;
		if(filterValue.startsWith("and")) 
			start = 5;
		else if(filterValue.startsWith("or")) 
			start = 4;
		else 
			start = 1;
		return start;
	}
	
	//@author hanh.nguyen
	public String[] splitFilterValue(String filterValue){
		ArrayList<String> splitValue;
		int start = findStartNumberInFilterValue(filterValue);	;
		if(filterValue.startsWith("and") || filterValue.startsWith("or")) {
			splitValue = new ArrayList<String>(4);
			if(filterValue.startsWith("and")) 
				splitValue.add("and");
			else if(filterValue.startsWith("or")) 
				splitValue.add("or");
		}
		else 
			splitValue = new ArrayList<String>(3);
		String[] operator = {"=", "Like", ">", ">=", "<", "<=", "<>"};
		for (String x : operator) {
			if(filterValue.contains(x)) {
				int end = filterValue.indexOf(x);
				splitValue.add(filterValue.substring(start, end - 1));
				splitValue.add(x);
				splitValue.add(filterValue.substring(end + x.length() + 1, filterValue.length() - 1));
			}
		}
		String[] result = (String[]) splitValue.toArray();
		return result;
	}
	
	//@author hanh.nguyen
	public void addDataProfilesFilterFields(String... filterValue) {
		LOG.info("In Data Profiles \"Filter Fields\" page, add filter value: " + filterValue);
		for (String value : filterValue) {
			String[] splitValue = splitFilterValue(value);
			if(splitValue.length == 3)
				addDataProfilesFilterFields("", splitValue[0], splitValue[1], splitValue[2]);
			else
				addDataProfilesFilterFields(splitValue[0], splitValue[1], splitValue[2], splitValue[3]);
		}
	}
	
	//@author hanh.nguyen
	public boolean isFilterFieldsTableDisplayCorrect(String... filterField) {
		String[] actualValue = (String[]) tableListCondition.getOptions().toArray();
		boolean isCorrect = false;
		try {
			if(actualValue.length == 0)
				LOG.info("Data Profiles Filter Fields table doesn't has any filter.");
			else {
				if(actualValue.equals(filterField))
					isCorrect = true;
			}
		} catch (Exception error) {
			LOG.severe("Has error when checking Filter Fields table.");
		}
		LOG.info("Is Filter Fields table displayed correctly: " + isCorrect);
		return isCorrect;
	}
	
	//@author hanh.nguyen
	public boolean isFilterFieldsTableDisplayCorrect(DataProfile dataProfile) {
		boolean isCorrect = isFilterFieldsTableDisplayCorrect(dataProfile.getFilterField());
		return isCorrect;
	}
	
	//@author hanh.nguyen
	public DPStatisticFieldsPage submitDataProfilesFilterFieldsPage(String... filterValue) {
		LOG.info("Submit \"Filter Fields\" page.");
		addDataProfilesFilterFields(filterValue);
		clickButton(GeneralButton.NEXT);
		btnAdd.waitForDisappear(Common.ELEMENT_TIMEOUT);
		return new DPStatisticFieldsPage();
	}
	
	//@author hanh.nguyen
	public DPStatisticFieldsPage submitDataProfilesFilterFieldsPage(DataProfile dataProfile) {
		submitDataProfilesFilterFieldsPage(dataProfile.getFilterField());
		return new DPStatisticFieldsPage();
	}

}
