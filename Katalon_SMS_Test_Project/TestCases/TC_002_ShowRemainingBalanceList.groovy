import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.navigateToUrl('https://sms-app-url.com/login')
WebUI.setText(findTestObject('ObjectRepository/Page_UserLogin/input_MSISDN'), '1234567890')
WebUI.setText(findTestObject('ObjectRepository/Page_UserLogin/input_Password'), 'password123')
WebUI.click(findTestObject('ObjectRepository/Page_UserLogin/button_Login'))

WebUI.verifyElementPresent(findTestObject('ObjectRepository/Page_UserLogin/label_SuccessMessage'), 10)

WebUI.navigateToUrl('https://sms-app-url.com/show-remaining-balance')

WebUI.verifyElementPresent(findTestObject('ObjectRepository/Page_ShowRemainingBalanceList/label_BalanceDetails'), 10)

WebUI.closeBrowser()
