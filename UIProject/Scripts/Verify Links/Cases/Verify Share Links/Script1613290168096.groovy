import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def currentUrl

'Click on Share Via Facebook Link on dashbaord'
CustomKeywords.'com.vinsyt.Links.clickElement'(findTestObject('Dashboard Page/Header/Share Via Facebook'))

'Wait for the delay'
WebUI.delay(7)

'Verify the Text CONGRATULATIONS ON THE NEW ADDITION!'
WebUI.verifyElementText(findTestObject('Dashboard Page/Share Links Popup/Share Popup Header'), "CONGRATULATIONS ON THE NEW ADDITION!", FailureHandling.CONTINUE_ON_FAILURE)

'Verify the text WE VE MADE IT EASY TO SHARE THE GOOD NEWS'
WebUI.verifyElementText(findTestObject('Dashboard Page/Share Links Popup/Share Popup_SubHeader'), "WE'VE MADE IT EASY TO SHARE THE GOOD NEWS", FailureHandling.CONTINUE_ON_FAILURE)

'Verify the text WITH YOUR FRIENDS & FAMILY'
WebUI.verifyElementText(findTestObject('Dashboard Page/Share Links Popup/Share Popup_SubHeader_2'), "WITH YOUR FRIENDS & FAMILY", FailureHandling.CONTINUE_ON_FAILURE)

'Verify the Share via Facebook Link on the popup'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Share Links Popup/Share via Facebook'), FailureHandling.CONTINUE_ON_FAILURE)

'Verify the Share Via Email link on the popup'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Share Links Popup/Share via Email'), FailureHandling.CONTINUE_ON_FAILURE)

'Verify the Share a Dealer Review link'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Share Links Popup/Share a Dealer Review'), FailureHandling.CONTINUE_ON_FAILURE)

'Verify Google Review Link on the popup'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Share Links Popup/Share a Google Review'), FailureHandling.CONTINUE_ON_FAILURE)

'Click on Share via Facebook inside the popup'
WebUI.click(findTestObject('Dashboard Page/Share Links Popup/Share via Facebook'))

'Delay'
WebUI.delay(2)

'Switch to new Window'
WebUI.switchToWindowIndex(1)

'Delay'
WebUI.delay(5)

'Get the Current URL of the page'
currentUrl = WebUI.getUrl()

'Verify the facebook text'
if(currentUrl.contains('facebook.com')) {
	'Log Statement for Successful navigation'
	KeywordUtil.markPassed("Successfully Navigated to Facebook Page")
	'Close the newly opened window'
	WebUI.closeWindowIndex(1)
	'Switch to main window Page'
	WebUI.switchToWindowIndex(0)
}

'Click on Share via Email link on the Popup'
WebUI.click(findTestObject('Dashboard Page/Share Links Popup/Share via Email'))

'Verify the text on the popup \"Enter contacts below and we take care of the rest.\"'
WebUI.verifyElementText(findTestObject('Dashboard Page/Share Links Popup/Email Popup/Email Popup Header'), "Enter contacts below and we take care of the rest.")

'Click on \"Ask me Later\" button'
WebUI.click(findTestObject('Dashboard Page/Share Links Popup/Email Popup/Ask Me Later button'))

'Click on Share via Facebook link'
WebUI.click(findTestObject('Dashboard Page/Header/Share Via Facebook'))

'Click on \"Share a Dealer Review\" on the popup'
WebUI.click(findTestObject('Dashboard Page/Share Links Popup/Share a Dealer Review'))

'Verify the text \"I had a good experience\" on the popup'
WebUI.verifyElementText(findTestObject('Dashboard Page/Share Links Popup/Dealer Review/Good Experience'), "I had a good experience")

'Log Statement for Dealer Review Popup'
KeywordUtil.markPassed("Dealer Review Popup Opened")

'Delay'
WebUI.delay(2)

'Click on Popup Close link'
WebUI.click(findTestObject('Dashboard Page/Share Links Popup/Dealer Review/Popup_Close'))

'Click on Share Via Facebook link'
WebUI.click(findTestObject('Dashboard Page/Header/Share Via Facebook'))

'Click on Google Review Link'
WebUI.click(findTestObject('Dashboard Page/Share Links Popup/Share a Google Review'))

'Switch to new tab'
WebUI.switchToWindowIndex(1)

'Delay'
WebUI.delay(5)

'Get the current url of the page'
currentUrl = WebUI.getUrl()

if(currentUrl.contains('google.com')) {
	'Log Statement for Successful navigation'
	KeywordUtil.markPassed("Successfully Navigated to Google Review Page")
	'Close the newly opened window'
	WebUI.closeWindowIndex(1)
	'Switch to main window Page'
	WebUI.switchToWindowIndex(0)
}

'Delay'
WebUI.delay(3)

'Click on Popup Close'
WebUI.click(findTestObject('Dashboard Page/Share Links Popup/Popup_Close'))

'Click on View Hours link on the Dashbaord Page'
WebUI.click(findTestObject('Object Repository/Dashboard Page/Header/View Hours'))

'Verify View Hours Popup'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Service Links/Service Hours Timings'))

'Click on View Hours popup'
WebUI.click(findTestObject('Dashboard Page/Service Links/Service Hours Popup Close'))

'Click on Schedule Service link on the dashboard page'
WebUI.click(findTestObject('Object Repository/Dashboard Page/Header/Schedule Service'))

'Switch to new Window'
WebUI.switchToWindowIndex(1)

'Delay'
WebUI.delay(5)

'Get the current url of the page'
currentUrl = WebUI.getUrl()

''
if(currentUrl.contains(GlobalVariable.companyName)) {
	'Log Statement for Successful navigation'
	KeywordUtil.markPassed("Successfully Navigated to Service Page")
	'Close the newly opened window'
	WebUI.closeWindowIndex(1)
	'Switch to main window Page'
	WebUI.switchToWindowIndex(0)
}

'Delay'
WebUI.delay(2)

'Click on View Service History link'
WebUI.click(findTestObject('Dashboard Page/Header/View Service History'))

'Get the attribute value'
def attrName = WebUI.getAttribute(findTestObject('Dashboard Page/Service Tab Page/Service History_Highlight'), "id")

'Verification'
if(attrName.equals("servicesHistory")) {
	KeywordUtil.markPassed("Service History is highlighted")
}else {
	KeywordUtil.markFailed("Service History is not highlighted")
}

'Click on Add a Service Record Button'
WebUI.click(findTestObject('Dashboard Page/Service Tab Page/Add a Service Record'))

'Verify the text \"Add a Record\"'
WebUI.verifyElementText(findTestObject('Dashboard Page/Service Tab Page/Add a Record Popup Details/Header'), "Add a Record")

'Verify the text \"Add A Service History Record\"'
WebUI.verifyElementText(findTestObject('Dashboard Page/Service Tab Page/Add a Record Popup Details/Add A Service History Record'), "Add A Service History Record")

'Verify Date Calendar'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Service Tab Page/Add a Record Popup Details/Date Calendar Field'))

'Verify Provider:My Dealer text'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Service Tab Page/Add a Record Popup Details/Provider Label'))

'Verify Yes radio button'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Service Tab Page/Add a Record Popup Details/My Dealer Yes radio button'))

'Verify No Radio Button'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Service Tab Page/Add a Record Popup Details/My Dealer No radio button'))

'Verify Name Label'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Service Tab Page/Add a Record Popup Details/Name Label'))

WebUI.click(findTestObject('Dashboard Page/Service Tab Page/Add a Record Popup Details/Close link'))
