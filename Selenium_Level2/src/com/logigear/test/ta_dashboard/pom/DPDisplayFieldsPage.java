package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.element.Element;

public class DPDisplayFieldsPage extends GeneralPage{
	
	protected Element lnkMenuOption;
	protected Element txtProfileName;
	protected Element cbbEntityType;
	protected Element btnNext;
	protected Element rowItem;
	
	public DPDisplayFieldsPage() {
		super(DPDisplayFieldsPage.class);
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

}
