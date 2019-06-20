package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.element.Element;

public class PanelPage extends GeneralPage {

	protected Element lnkAddNew;
	protected Element lnkDeleteInTopPage;
	protected Element lnkCheckAll;
	protected Element lnkUncheckAll;
	protected Element chkDeletePanel;
	
	public PanelPage() {
		super(PanelPage.class);
	}

	@Override
	public void initPageElements() {
		super.initPageElements();
		this.lnkAddNew = new Element(getLocator("lnkAddNew").getBy());
		this.lnkDeleteInTopPage = new Element(getLocator("lnkDeleteInTopPage").getBy());
		this.lnkCheckAll = new Element(getLocator("lnkCheckAll").getBy());
		this.lnkUncheckAll = new Element(getLocator("lnkUncheckAll").getBy());
	}
	
	public Element setPanelName(String panelName) {
		return new Element(getLocator("lnkUncheckAll").getBy(panelName));
	}

	/*
	 * Author: Tien Tran
	 * Method name: clickLinkAddNew()
	 * Purpose/Description: Click "Add New" on Panel List page.
	 * 
	 * */
	public PanelDialog clickLinkAddNew() {
		lnkAddNew.click();
		return new PanelDialog();
	}
	
	//@author hanh.nguyen
	public enum LinkedText {
		ADD_NEW("lnkAddNew"),
		DELETE_IN_TOP("lnkDeleteInTopPage"),
		CHECK_ALL("lnkCheckAll"),
		UNCHECK_ALL("lnkUncheckAll");
		
		private String _linkedText;
		
		private LinkedText(String linkedText) {
			this._linkedText = linkedText;
		}
		
		public String getValue() {
			return _linkedText;
		}

		public void setValue(String linkedText) {
			this._linkedText = linkedText;
		}
	}
	
	//@author hanh.nguyen
	public PanelPage clickLinkedText(LinkedText text) {
		if(text.equals(LinkedText.ADD_NEW)) {
			logger.printMessage("Click \"Add New\" linked text.");
			lnkAddNew.click();
		}
		if(text.equals(LinkedText.DELETE_IN_TOP)) {
			logger.printMessage("Click \"Delete\" linked text on top of page.");
			lnkDeleteInTopPage.click();
		}
		if(text.equals(LinkedText.CHECK_ALL)) {
			logger.printMessage("Click \"Check All\" linked text.");
			lnkCheckAll.click();
		}
		if(text.equals(LinkedText.UNCHECK_ALL)) {
			logger.printMessage("Click \"Uncheck All\" linked text.");
			lnkUncheckAll.click();
		}
		return new PanelPage();
	}
	
	//@author hanh.nguyen
	public boolean isPanelCheckboxChecked(String panelName) {
		return setPanelName(panelName).isSelected();
	}
	
	
}
