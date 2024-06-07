import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.navigateToUrl('https://sms-app-url.com/create-subscriber')

WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_MSISDN'), '1234567890')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_PackageID'), '1')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_Name'), 'John')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_Surname'), 'Doe')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_Email'), 'john.doe@example.com')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_Password'), 'password123')
WebUI.setText(findTestObject('ObjectRepository/Page_CreateSubscriber/input_SecurityKey'), 'security123')
WebUI.click(findTestObject('ObjectRepository/Page_CreateSubscriber/button_Submit'))

WebUI.verifyElementPresent(findTestObject('ObjectRepository/Page_CreateSubscriber/label_SuccessMessage'), 10)

WebUI.closeBrowser()
