import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.annotation.SetUp as SetUp
import com.kms.katalon.core.annotation.SetupTestCase as SetupTestCase
import com.kms.katalon.core.annotation.TearDown as TearDown
import com.kms.katalon.core.annotation.TearDownTestCase as TearDownTestCase

@SetUp(skipped = false)
def setUp() {
//    'Open Browser and navigate to URL'
//    WebUI.openBrowser(findTestData('Vinsite_url').getValue(1, 1))
//
	WebUI.navigateToUrl(findTestData('Vinsite_url').getValue(1, 1))
    'Maximize Window'
    WebUI.maximizeWindow()

    'Wait until the page loads'
    WebUI.waitForPageLoad(30)

    if (!WebUI.getUrl().contains('index-referral')) {
        'Click on Lets go button'
        WebUI.click(findTestObject('Object Repository/Links/Buyer VIP/Lets go button'))

        'Delay for 3 seconds'
        WebUI.delay(3)

        for (def index : (0..4)) {
            'Click on next button'
            WebUI.click(findTestObject('Object Repository/Links/Buyer VIP/Next Button'))

            WebUI.delay(1)
        }
    }
}

@TearDown(skipped = true)
def tearDown() {
}

@SetupTestCase(skipped = true)
def setupTestCase() {
}

@TearDownTestCase(skipped = true)
def tearDownTestCase() {
}

/**
 * References:
 * Groovy tutorial page: http://docs.groovy-lang.org/next/html/documentation/
 */