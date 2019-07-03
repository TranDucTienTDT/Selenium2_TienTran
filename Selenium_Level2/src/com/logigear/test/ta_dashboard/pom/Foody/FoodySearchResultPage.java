package com.logigear.test.ta_dashboard.pom.Foody;

import com.logigear.testfw.element.Element;

public class FoodySearchResultPage extends FoodyGeneralPage{
	
	protected Element imgSearchResult;
	
	public FoodySearchResultPage() {
		super(FoodySearchResultPage.class);
	}
	
	@Override
	public void initPageElements() {
		this.initPageElements();
		//this.cbbLocation = new Element(getLocator("cbbLocation").getBy());
	}
	
	public void imgSearchResult(String name) {
		this.imgSearchResult = new Element(getLocator("imgSearchResult").getBy(name));
	}
	
	public FoodyStorePage chooseLocation(String location) {
		logger.printMessage("Choose a store: " + location);
		imgSearchResult(location);
		imgSearchResult.click();
		switchTab(1);
		return new FoodyStorePage();
	}
	
	

}
