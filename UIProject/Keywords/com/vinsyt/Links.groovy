package com.vinsyt
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import org.apache.http.Header
import org.apache.http.HttpHost
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.config.RequestConfig
import org.apache.http.client.methods.HttpHead
import org.apache.http.impl.client.HttpClients

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


class Links {
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

	@Keyword
	public void isImageBroken(WebElement image) {
		if (image.getAttribute("naturalWidth").equals("0")) {
			KeywordUtil.markPassed(image.getAttribute("outerHTML") + " is broken.")
			//System.out.println(image.getAttribute("outerHTML") + " is broken.");
		}
	}

	@Keyword
	public static void verifyLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			KeywordUtil.logInfo("URL inside Keyword: "+ url)
			//Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
			httpURLConnect.setRequestMethod("GET");
			httpURLConnect.setRequestProperty("Content-Type", "application/json");
			httpURLConnect.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 11_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");
			httpURLConnect.setConnectTimeout(2000);
			httpURLConnect.setReadTimeout(2000);
			httpURLConnect.connect();

			KeywordUtil.markPassed("HTTP Response Code: "+ httpURLConnect.getResponseCode())
			if(httpURLConnect.getResponseCode()==200){
				KeywordUtil.logInfo( "Link URL: "+linkUrl)
				System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+" is a Valid link");
				KeywordUtil.markPassed(linkUrl+" - "+httpURLConnect.getResponseMessage()+" is a Valid link");
			}
			if(httpURLConnect.getResponseCode()>=400)
			{
				KeywordUtil.logInfo( "Link URL: "+linkUrl)
				System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+" is a broken link");
				KeywordUtil.markFailed(linkUrl+" - "+httpURLConnect.getResponseMessage()+" is a broken link");
			}

		}catch (Exception e) {
		}
	}

	@Keyword
	public static boolean verifyPdfLinks(String linkUrl) {
		KeywordUtil.logInfo("URL inside Keyword: "+ linkUrl)
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(linkUrl).openConnection();
			con.setRequestMethod("HEAD");
			con.setConnectTimeout(2000);
			con.setReadTimeout(2000);
			return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}}

}