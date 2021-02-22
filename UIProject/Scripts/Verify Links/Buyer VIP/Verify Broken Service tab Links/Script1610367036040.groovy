import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
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

'Click on How-to-Videos Tab'
WebUI.click(findTestObject('Links/Buyer VIP/Service Page/Service Tab'))

'Storing the links in a list and traversing through the links'
List<WebElement> links = driver.findElements(By.tagName(tagName))

'This line will print the number of links and the count of links.'
KeywordUtil.logInfo('No of Manual links are ' + links.size())
println 'No of links are ' + links.size() 

//checking the links fetched.
//for (int i = 0; i < links.size(); i++) {
for (def i : (0..links.size()-1)) {
    WebElement E1 = links.get(i)

    String url = E1.getAttribute(attributeName)

    CustomKeywords.'com.vinsyt.Links.verifyLinks'(url)
}