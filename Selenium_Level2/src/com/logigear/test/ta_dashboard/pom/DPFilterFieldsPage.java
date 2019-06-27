package com.logigear.test.ta_dashboard.pom;

import java.awt.List;
import java.util.ArrayList;

import com.logigear.testfw.element.Element;

public class DPFilterFieldsPage extends GeneralPage{
	
	protected Element lnkMenuOption;
	protected Element rowItem;
	protected Element cbbAndOrCondition;
	protected Element cbbField;
	protected Element cbbOperator;
	protected Element txtValue;
	protected Element btnAdd;
	protected Element btnRemove;
	protected Element tableListCondition;
	protected Element btnNext;
	
	public DPFilterFieldsPage() {
		super(DPFilterFieldsPage.class);
	}

	@Override
	public void initPageElements() {
		super.initPageElements();	
		this.lnkMenuOption = new Element(getLocator("lnkMenuOption").getBy("Filter Fields"));
		this.rowItem = new Element(getLocator("rowItem").getBy());
		this.cbbAndOrCondition = new Element(getLocator("cbbAndOrCondition").getBy());
		this.cbbField = new Element(getLocator("cbbField").getBy());
		this.cbbOperator = new Element(getLocator("cbbOperator").getBy());
		this.txtValue = new Element(getLocator("txtValue").getBy());
		this.btnAdd = new Element(getLocator("btnAdd").getBy());
		this.btnRemove = new Element(getLocator("btnRemove").getBy());
		this.tableListCondition = new Element(getLocator("tableListCondition").getBy());
		this.btnNext = new Element(getLocator("btnNext").getBy());
	}
	
	public void addDataProfilesFilterFields(String andOrCondition, String field, String operator, String value) {
		if(andOrCondition != null && cbbAndOrCondition.getText() != andOrCondition) {
			logger.printMessage("In \"And/Or\" combobox, select: " + andOrCondition);
			cbbAndOrCondition.selectByText(andOrCondition);
		}
		if(field != null && cbbField.getText() != field) {
			logger.printMessage("In \"Field\" combobox, select: " + field);
			cbbField.selectByText(field);
		}
		if(operator != null && cbbOperator.getText() != operator) {
			logger.printMessage("In \"Operator\" combobox, select: " + operator);
			cbbOperator.selectByText(operator);
		}
		if((value != null) && (txtValue.getText() != null || txtValue.getText() != value)) {
			logger.printMessage("In \"Value\" textbox, enter: " + value);
			txtValue.enter(value);
		}
		btnAdd.click();
	}
	
//	public boolean isFilterFieldsCorrect(String... filterField) {
//		ArrayList<String> condiList = (ArrayList<String>) tableListCondition.getOptions();
//		try {
//			for()
//		} catch (Exception error) {
//			LOG.severe(String.format("Has error when select item in %d"));
//		}
//	}

}
