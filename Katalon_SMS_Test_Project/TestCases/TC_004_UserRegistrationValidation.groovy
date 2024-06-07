import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Valid Registration
WebUI.openBrowser('')

WebUI.navigateToUrl('https://sms-app-url.com/register')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_MSISDN'), '0987654321')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_PackageID'), '2')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_Name'), 'Jane')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_Surname'), 'Smith')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_Email'), 'jane.smith@example.com')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_Password'), 'password456')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_SecurityKey'), 'security456')
WebUI.click(findTestObject('ObjectRepository/Page_CreateSubscriber/button_Submit'))

WebUI.verifyElementPresent(findTestObject('ObjectRepository/Page_CreateSubscriber/label_SuccessMessage'), 10)

WebUI.closeBrowser()

// Invalid Registration
WebUI.openBrowser('')

WebUI.navigateToUrl('https://sms-app-url.com/register')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_MSISDN'), '123')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_PackageID'), '2')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_Name'), 'Jane')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_Surname'), 'Smith')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_Email'), 'jane.smith@example.com')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_Password'), 'weakpassword')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_SecurityKey'), 'security456')
WebUI.click(findTestObject('ObjectRepository/Page_CreateSubscriber/button_Submit'))

WebUI.verifyElementPresent(findTestObject('ObjectRepository/Page_CreateSubscriber/label_ErrorMessage'), 10)

WebUI.closeBrowser()
