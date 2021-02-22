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

WebUI.openBrowser(findTestData('Vinsite_url').getValue(1, 1))

WebUI.maximizeWindow()

WebUI.delay(5)

WebUI.click(findTestObject('Links/Buyer VIP/Lets go button'))

WebUI.delay(3)

for (def index : (0..4)) {
    WebUI.click(findTestObject('Links/Buyer VIP/Next Button'))

    WebUI.delay(1)
}

WebDriver driver = DriverFactory.getWebDriver()

//Storing the links in a list and traversing through the links
List<WebElement> linksList = driver.findElements(By.tagName('a'))

linksList.addAll(driver.findElements(By.tagName('img')))

println('Size of full links and images -----> ' + linksList.size())

List<WebElement> activeLinks = new ArrayList<WebElement>()

for (int i = 0; i < linksList.size(); i++) {
    println(linksList.get(i).getAttribute('href'))

    if ((linksList.get(i).getAttribute('href') != null) && !(linksList.get(i).getAttribute('href').contains('javascript'))) {
        activeLinks.add(linksList.get(i))
    }
}

println('Size of active links and images -----> ' + activeLinks.size())

for (int j = 0; j < activeLinks.size(); j++) {
    HttpURLConnection connection = ((new URL(activeLinks.get(j).getAttribute('href')).openConnection()) as HttpURLConnection)

    connection.connect()

    String response = connection.getResponseMessage()

    connection.disconnect()

    println((activeLinks.get(j).getAttribute('href') + '---->') + response)
}

