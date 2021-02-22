import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

'Initiate webdriver agent'
WebDriver driver = DriverFactory.getWebDriver()

try {
    'Click on Lets go button'
    WebUI.click(findTestObject('Links/Buyer VIP/Lets go button'))

    'Delay for 3 seconds'
    WebUI.delay(3)

    for (def index : (0..4)) {
        'Click on next button'
        WebUI.click(findTestObject('Links/Buyer VIP/Next Button'))

        WebUI.delay(1)
    }
}
catch (Exception e) {
    KeywordUtil.logInfo('Terms and Conditions Popup is not displayed')
} 

WebUI.click(findTestObject('Links/Buyer VIP/My Reviews Link/My Reviews Link'))

'Storing the links in a list and traversing through the links'
List<WebElement> links = driver.findElements(By.tagName(tagName))

'This line will print the number of links and the count of links.'
KeywordUtil.logInfo('No of Photo links on My Reviews Page are' + links.size())

println('No of Photo links on My Reviews Page are ' + links.size())

//checking the links fetched.
//for (int i = 0; i < links.size(); i++) {
for (def i : (0..links.size() - 1)) {
    WebElement E1 = links.get(i)

    String url = E1.getAttribute(attributeName)

    CustomKeywords.'com.vinsyt.Links.verifyLinks'(url)
}

WebUI.click(findTestObject('Links/Buyer VIP/My Reviews Link/Dealership Link'))

'Storing the links in a list and traversing through the links'
List<WebElement> dealershipLinks = driver.findElements(By.tagName(tagName))

'This line will print the number of links and the count of links.'
KeywordUtil.logInfo('No of Photo links on Dealership link are ' + dealershipLinks.size())

println('No of Photo links on Dealership link are ' + dealershipLinks.size())

//checking the links fetched.
//for (int i = 0; i < links.size(); i++) {
for (def j : (0..dealershipLinks.size() - 1)) {
    WebElement E2 = dealershipLinks.get(j)

    String dealerUrl = E2.getAttribute(attributeName)

    CustomKeywords.'com.vinsyt.Links.verifyLinks'(dealerUrl)
}

WebUI.click(findTestObject('Links/Buyer VIP/My Reviews Link/Sales Advisors Link'))

'Storing the links in a list and traversing through the links'
List<WebElement> advisorsLinks = driver.findElements(By.tagName(tagName))

'This line will print the number of links and the count of links.'
KeywordUtil.logInfo('No of Photo links on Sales Advisors page are ' + advisorsLinks.size())

println('No of Photo links on Sales Advisors page are ' + advisorsLinks.size())

//checking the links fetched.
//for (int i = 0; i < links.size(); i++) {
for (def k : (0..advisorsLinks.size() - 1)) {
    WebElement E3 = advisorsLinks.get(k)

    String advisorUrl = E3.getAttribute(attributeName)

    CustomKeywords.'com.vinsyt.Links.verifyLinks'(advisorUrl)
}

WebUI.click(findTestObject('Links/Buyer VIP/My Reviews Link/New Vehicles'))

'Storing the links in a list and traversing through the links'
List<WebElement> newVehicleLinks = driver.findElements(By.tagName(tagName))

'This line will print the number of links and the count of links.'
KeywordUtil.logInfo('No of Photo links on New Vehicles are ' + newVehicleLinks.size())

println('No of Photo links on New Vehicles are ' + newVehicleLinks.size())

//checking the links fetched.
//for (int i = 0; i < links.size(); i++) {
for (def l : (0..newVehicleLinks.size() - 1)) {
    WebElement E4 = newVehicleLinks.get(l)

    String vehicleUrl = E4.getAttribute(attributeName)

    CustomKeywords.'com.vinsyt.Links.verifyLinks'(vehicleUrl)
}

WebUI.click(findTestObject('Links/Buyer VIP/My Reviews Link/Pre-Owned Vehicles'))

'Storing the links in a list and traversing through the links'
List<WebElement> preownedLinks = driver.findElements(By.tagName(tagName))

'This line will print the number of links and the count of links.'
KeywordUtil.logInfo('No of Photo links on Pre Owned page are ' + preownedLinks.size())

println('No of Photo links on Pre Owned page are ' + preownedLinks.size())

//checking the links fetched.
//for (int i = 0; i < links.size(); i++) {
for (def m : (0..preownedLinks.size() - 1)) {
    WebElement E5 = preownedLinks.get(m)

    String preOwnedvehicleUrl = E5.getAttribute(attributeName)

    CustomKeywords.'com.vinsyt.Links.verifyLinks'(preOwnedvehicleUrl)
}