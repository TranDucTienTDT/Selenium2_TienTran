package com.logigear.test.ta_dashboard.pom;

import java.util.ArrayList;
import java.util.Collections;

import com.logigear.testfw.element.Element;

public class PanelPage extends GeneralPage {

	protected Element lnkAddNew;
	protected Element lnkDeleteInTopPage;
	protected Element lnkCheckAll;
	protected Element lnkUncheckAll;
	protected Element lnkPanelName;
	protected Element chkPanelName;
	protected Element lnkEdit;
	protected Element lnkDelete;
	
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
	
	public void lnkPanelName(String panelName) {
		this.lnkPanelName =  new Element(getLocator("lnkPanelName").getBy(panelName));
	}
	
	public void chkPanelName(String panelName) {
		this.chkPanelName =  new Element(getLocator("chkPanelName").getBy(panelName));
	}
	
	public void lnkEdit(String panelName) {
		this.lnkEdit =  new Element(getLocator("lnkEdit").getBy(panelName));
	}
	
	public void lnkDelete(String panelName) {
		this.lnkDelete =  new Element(getLocator("lnkDelete").getBy(panelName));
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
	public Object clickLinkedText(LinkedText text) {
		if(text.equals(LinkedText.ADD_NEW)) {
			LOG.info("Click \"Add New\" linked text.");
			lnkAddNew.click();
		}
		if(text.equals(LinkedText.DELETE_IN_TOP)) {
			LOG.info("Click \"Delete\" linked text on top of page.");
			lnkDeleteInTopPage.click();
		}
		if(text.equals(LinkedText.CHECK_ALL)) {
			LOG.info("Click \"Check All\" linked text.");
			lnkCheckAll.click();
		}
		if(text.equals(LinkedText.UNCHECK_ALL)) {
			LOG.info("Click \"Uncheck All\" linked text.");
			lnkUncheckAll.click();
		}
		if(text.equals(LinkedText.ADD_NEW))
			return new PanelDialog();
		else
			return new PanelPage();
	}
	
	//@author hanh.nguyen
	public boolean isPanelCheckboxChecked(String panelName) {
		lnkPanelName(panelName);
		boolean isChecked = this.lnkPanelName.isSelected();
		LOG.info("The checkbox of panel \"" + panelName + "\" is checked: " + isChecked);
		return isChecked;
	}
	
	//@author hanh.nguyen
	public boolean arePanelCheckboxChecked (String[] pageNames) {
		ArrayList<Boolean> areCheck = new ArrayList<Boolean>(pageNames.length);
		for(int i = 0; i <= pageNames.length; i++) {
			Collections.fill(areCheck, isPanelCheckboxChecked(pageNames[i]));
		}
		if(areCheck.contains(false)) {
			LOG.info("The panel checkboxes are not checked all.");
			return false;
		}
		else {
			LOG.info("The panel checkboxes are checked all.");
			return true;
		}
	}
	
	//@author hanh.nguyen
	public PanelPage deleteAllPanels() {
		LOG.info("Delete all panels in Panel Page.");
		clickLinkedText(LinkedText.CHECK_ALL);
		clickLinkedText(LinkedText.DELETE_IN_TOP);
		acceptAlertPopup();
		return this;
	}
	
	//@author hanh.nguyen
	public PanelDialog clickEditLinkedText(String panelName) {
		LOG.info("Click in \"Edit\" linked text of panel: " + panelName);
		lnkEdit(panelName);
		lnkEdit.click();
		return new PanelDialog();
	}
}
