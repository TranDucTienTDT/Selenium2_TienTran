package com.logigear.test.ta_dashboard.pom;

import com.logigear.test.ta_dashboard.data_object.ChartPanel;
import com.logigear.test.ta_dashboard.data_object.ChartPanel.Style;
import com.logigear.test.ta_dashboard.data_object.GeneralPanel.PanelType;
import com.logigear.testfw.element.Element;

public class PanelDialog extends GeneralPage{
	//General in Panel dialog
	protected Element tabDisplaySetting;
	protected Element radChart;
	protected Element radIndicator;
	protected Element radReport;
	protected Element radHeatMap;
	protected Element txtDisplayName;
	protected Element cbbDataProfile;
	protected Element btnOK;
	protected Element btnCancel;
	
	//In Chart Panel
	protected Element txtChartTitle;
	protected Element cbbChartType;
	protected Element radChartStyle2D;
	protected Element radChartStyle3D;
	protected Element chkShowTitle;
	protected Element cbbCategoryField;
	protected Element cbbSeriesField;
	protected Element txtCategoryCaption;
	protected Element txtSeriesCaption;
	protected Element radLegendsNone;
	protected Element radLegendsTop;
	protected Element radLegendsRight;
	protected Element radLegendsBottom;
	protected Element radLegendsLeft;
	protected Element chkDataLabelsSeries;
	protected Element chkDataLabelsCategories;
	protected Element chkDataLabelsValue;
	protected Element chkDataLabelsPercentage;
	
	//In Indicator panel
	protected Element txtIndicatorTitle;

	public PanelDialog() {
		super(PanelDialog.class);
	}
	
	@Override
	public void initPageElements() {
		//General in Panel dialog
		this.tabDisplaySetting = new Element(getLocator("tabDisplaySetting").getBy());
		this.radChart = new Element(getLocator("radChart").getBy());
		this.radIndicator = new Element(getLocator("radIndicator").getBy());
		this.radReport = new Element(getLocator("radReport").getBy());
		this.radHeatMap = new Element(getLocator("radHeatMap").getBy());
		this.txtDisplayName = new Element(getLocator("txtDisplayName").getBy());
		this.cbbDataProfile = new Element(getLocator("cbbDataProfile").getBy());
		this.btnOK = new Element(getLocator("btnOK").getBy());
		this.btnCancel = new Element(getLocator("btnCancel").getBy());
		
		//In Chart Panel
		this.txtChartTitle = new Element(getLocator("txtChartTitle").getBy());
		this.cbbChartType = new Element(getLocator("cbbChartType").getBy());
		this.radChartStyle2D = new Element(getLocator("radChartStyle2D").getBy());
		this.radChartStyle3D = new Element(getLocator("radChartStyle3D").getBy());
		this.chkShowTitle = new Element(getLocator("chkShowTitle").getBy());
		this.cbbCategoryField = new Element(getLocator("cbbCategoryField").getBy());
		this.cbbSeriesField = new Element(getLocator("cbbSeriesField").getBy());
		this.txtCategoryCaption = new Element(getLocator("txtCategoryCaption").getBy());
		this.txtSeriesCaption = new Element(getLocator("txtSeriesCaption").getBy());
		this.radLegendsNone = new Element(getLocator("radLegendsNone").getBy());
		this.radLegendsTop = new Element(getLocator("radLegendsTop").getBy());
		this.radLegendsRight = new Element(getLocator("radLegendsRight").getBy());
		this.radLegendsBottom = new Element(getLocator("radLegendsBottom").getBy());
		this.radLegendsLeft = new Element(getLocator("radLegendsLeft").getBy());
		this.chkDataLabelsSeries = new Element(getLocator("chkDataLabelsSeries").getBy());
		this.chkDataLabelsCategories = new Element(getLocator("chkDataLabelsCategories").getBy());
		this.chkDataLabelsValue = new Element(getLocator("chkDataLabelsValue").getBy());
		this.chkDataLabelsPercentage = new Element(getLocator("chkDataLabelsPercentage").getBy());
		
		//In Indicator panel
		this.txtIndicatorTitle = new Element(getLocator("txtIndicatorTitle").getBy());
	}

	/*
	 * Author: Tien Tran
	 * Method name: clickRadioButton()
	 * Purpose/Description: click all radio button on the page
	/**
	 * @author tien.duc.tran
	 * 
	 * 
	 * @description 
	 * 
	 * clickIndicatorRadioButton()
	 * clickReportRadioButton()
	 * clickHeatMapRadioButton()
	 */

	public PanelDialog clickIndicatorRadioButton() {
		radIndicator.click();
		return this;
	}	
	
	public PanelDialog clickReportRadioButton() {
		radReport.click();
		return this;
	}

	public PanelDialog clickHeatMapRadioButton() {
		radHeatMap.click();
		return this;
	}
	
	//@author hanh.nguyen
	public PanelDialog selectPanelType(PanelType panelType) {
		if(panelType == PanelType.CHART) {
			logger.printMessage("Select \"Chart\" radio button");
			radChart.check();
		}
		if(panelType == PanelType.INDICATOR) {
			logger.printMessage("Select \"Indicator\" radio button");
			radIndicator.check();
		}
		if(panelType == PanelType.REPORT) {
			logger.printMessage("Select \"Report\" radio button");
			radReport.check();
		}
		if(panelType == PanelType.HEAT_MAP) {
			logger.printMessage("Select \"Heat Map\" radio button");
			radHeatMap.check();
		}
		return new PanelDialog();
	}
	
	//@author hanh.nguyen
	public PanelDialog fillInforInGeneralPanelDialog(String dataProfile, String displayName) {
		if(dataProfile != null && dataProfile != txtDisplayName.getText()) {
			logger.printMessage("In \"Display Name\" combobox, select: " + dataProfile);
			cbbDataProfile.selectByText(dataProfile);
		}
		if(txtDisplayName.getText() == null || (txtDisplayName.getText() != displayName && displayName != null)) {
			logger.printMessage("In \"Display Name\" textbox, enter: " + displayName);
			txtDisplayName.enter(displayName);
		}
		return new PanelDialog();	
	}
	
	//@author hanh.nguyen
	public PanelDialog fillInforInChartPanelDialog(ChartPanel chartPanel) {
		selectPanelType(PanelType.CHART);
		fillInforInGeneralPanelDialog(chartPanel.getDataProfile(), chartPanel.getDisplayName());
		if(txtChartTitle.getText() != null || (txtChartTitle.getText() != chartPanel.getChartTitle() && chartPanel.getChartTitle() != null)) {
			logger.printMessage("In \"Chart Title\" textbox, enter: " + chartPanel.getChartTitle());
			txtChartTitle.enter(chartPanel.getChartTitle());
		}
		if(chartPanel.getIsShowTitle() == true) {
			logger.printMessage("Check in checkbox \"Show Title\".");
			chkShowTitle.check();
		}
		else if (chartPanel.getIsShowTitle() == false) {
			logger.printMessage("Uncheck in checkbox \"Show Title\".");
			chkShowTitle.uncheck();
		}
		if(chartPanel.getChartType() != cbbChartType.getText() && chartPanel.getChartType() != null) {
			logger.printMessage("In \"Chart Type\" combobox, select: " + chartPanel.getChartType());
			cbbChartType.selectByText(chartPanel.getChartType());
		}
		if(chartPanel.getStyle() == Style.STYLE2D) {
			logger.printMessage("Check in radio button \"2D\".");
			radChartStyle2D.check();
		}
		else if (chartPanel.getStyle() == Style.STYLE3D) {
			logger.printMessage("Check in radio button \"3D\".");
			radChartStyle3D.check();
		}
		if(chartPanel.getChartType() != cbbChartType.getText() && chartPanel.getChartType() != null) {
			logger.printMessage("In \"Chart Type\" combobox, select: " + chartPanel.getChartType());
			cbbChartType.selectByText(chartPanel.getChartType());
		}
		if(chartPanel.getSeries() != null && chartPanel.getSeries() != cbbSeriesField.getText()) {
			logger.printMessage("In \"Series\" combobox, select: " + chartPanel.getSeries());
			cbbSeriesField.selectByText(chartPanel.getSeries());
		}
		return new PanelDialog();
	}
	
	//@author hanh.nguyen
	public void addChartPanel(ChartPanel chartPanel) {
		openPanelDialog(false);
		fillInforInChartPanelDialog(chartPanel);
		btnOK.click();
		return;
	}
	
}