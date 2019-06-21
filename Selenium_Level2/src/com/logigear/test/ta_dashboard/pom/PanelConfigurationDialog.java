package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.element.Element;

public class PanelConfigurationDialog extends BasePOM{
	 protected Element btnCancel;
	 protected Element btnOK;

	public PanelConfigurationDialog() {
		super(PanelConfigurationDialog.class);
	}
	
	@Override
	public void initPageElements() {
		this.btnCancel = new Element(getLocator("btnCancel").getBy());
		this.btnOK = new Element(getLocator("btnOK").getBy());
	}
	
	//@author hanh.nguyen
	protected GeneralPage cancelPanelConfiguration() {
		logger.printMessage("In dialog \"Panel Configuration\", click \'Cancel\" button.");
		btnCancel.click();
		btnCancel.waitForDisappear(Common.ELEMENT_TIMEOUT);
		return new GeneralPage(GeneralPage.class);
	}
	
}
