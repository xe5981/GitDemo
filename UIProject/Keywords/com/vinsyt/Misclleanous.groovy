package com.vinsyt
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.testng.Assert


class Misclleanous {

	ArrayList<String> leftMenuNames;
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def static clickElement(TestObject to) {
		try {
			WebElement element = WebUI.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUI.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	/**
	 * This method is used for Clicking the Module from the left menu
	 * @param menuName
	 */
	@Keyword
	public void clickOnLeftMenuItems(String menuName){
		String[] headerName;
		WebUI.waitForElementVisible(findTestObject('Dashboard Page/Menu Link',[('menuName'):(menuName)]), GlobalVariable.short_timeout, FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo("Wait for the leftmenu: "+ menuName + " to be displayed")
		leftMenuNames =  getArrayElements(findTestObject('Dashboard Page/Left menu options'))
		if(leftMenuNames.contains(menuName)){
			WebUI.click(findTestObject('Dashboard Page/Menu Link',[('menuName'):(menuName)]), FailureHandling.STOP_ON_FAILURE);
			KeywordUtil.markPassed("Clicked on Menu Item: "+menuName);
//			WebUI.waitForElementVisible(findTestObject('Dashboard Page/Page Header Text'), GlobalVariable.short_timeout, FailureHandling.STOP_ON_FAILURE)
//			KeywordUtil.logInfo("Wait for the page header to be displayed")
//			String name = WebUI.getText(findTestObject('Dashboard Page/Page Header Text')).trim()
//			//			if(name.equalsIgnoreCase("Permission Groups") || name.equalsIgnoreCase("Preferred Manufacturers") || name.contains("Schedule Manager") || name.contains("Import History") || name.contains("Export History")){
//			//				headerName = name.split("[0-9+\\()]+");
//			//			}else{
//			//				headerName = name.replace(" ", "").split("[0-9+\\()]+");
//			//			}
//			WebUI.delay(1)
//			String changedMenuName = changeMenuName(menuName)
//			Assert.assertEquals(changedMenuName, name, "Menu Names did not match");
//			KeywordUtil.markPassed("Actual Name: "+changedMenuName+" and Expected Name: "+name+" are matched");
//			KeywordUtil.markPassed("Clicked on Menu Type: "+changedMenuName);
		}else{
			KeywordUtil.markFailed(menuName+" is not displayed in Left Menu Options")
		}
	}

	@Keyword
	public ArrayList<String> getArrayElements(TestObject to){
		List<WebElement> options = WebUiCommonHelper.findWebElements(to, GlobalVariable.medium_timeout)
		ArrayList<String> names = new ArrayList<String>();
		for (int i = 0; i < options.size(); i++) {
			String name = options.get(i).getText().trim();
			if(!name.isEmpty())
				names.add(options.get(i).getText().trim());
		}
		KeywordUtil.logInfo("List: "+ names);
		return names;
	}

	public String changeMenuName(String menuName){
		switch(menuName){
			case "Appointment":
				return menuName = "Appointments"
				break;
			case "Files":
				return menuName = "Import Files"
				break;
			case "SMS":
				return menuName = "SMS Sale"
				break;
			default:menuName = menuName
				return menuName
				break;
		}
	}
}