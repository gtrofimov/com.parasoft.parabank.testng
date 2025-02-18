/**
 * 
 */
package com.parabank;

import static org.testng.Assert.assertEquals;

import com.parabank.page.ParaBankBillPayPage;
import com.parabank.page.ParaBankBillPaymentCompletePage;
import com.parabank.page.ParaBankErrorPage;
import com.parabank.page.ParaBankWelcomeOnlineBankingPage;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BillPay {

	/**
	 * Parasoft auto generated base URL
	 * Use -DPARABANK_BASE_URL=http://localhost:8080 from command line
	 * or use System.setProperty("PARABANK_BASE_URL", "http://localhost:8080") to change base URL at run time.
	 */
	private static final String PARABANK_BASE_URL = "http://gamora.parasoft.com:8091";

	private WebDriver driver;

	@BeforeMethod
	public void beforeTest() {
		ChromeOptions opts = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.managed_default_content_settings.geolocation", 2);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		opts.setExperimentalOption("prefs", prefs);
		opts.addArguments("--start-maximized");
		//opts.addArguments("--incognito");
		opts.addArguments("--headless");
		opts.addArguments("--enable-strict-powerful-feature-restrictions");
		driver = new ChromeDriver(opts);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Name: farmers-bill-pay
	 * Recording file: farmers-bill-pay.json
	 *
	 * Parasoft recorded Selenium test on Thu Feb 22 2024 21:24:15 GMT-0800 (Pacific Standard Time)
	 */
	@Test
	public void testFarmersbillpay() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL) + "/parabank/index.htm");

		ParaBankWelcomeOnlineBankingPage paraBankWelcomeOnlineBankingPage = new ParaBankWelcomeOnlineBankingPage(
				driver);
		paraBankWelcomeOnlineBankingPage.setText1("john");
		paraBankWelcomeOnlineBankingPage.setPassword("demo");
		paraBankWelcomeOnlineBankingPage.clickLogInSubmit();

		ParaBankErrorPage paraBankErrorPage = new ParaBankErrorPage(driver);
		paraBankErrorPage.clickBillPayLink();

		ParaBankBillPayPage paraBankBillPayPage = new ParaBankBillPayPage(driver);
		paraBankBillPayPage.setPayeeNameText("John");
		paraBankBillPayPage.setPayeeAddressStreetText("Demo");
		paraBankBillPayPage.setPayeeAddressCityText("Beverly Hills");
		paraBankBillPayPage.setPayeeAddressStateText("CA");
		paraBankBillPayPage.setPayeeAddressZipCodeText("90210");
		paraBankBillPayPage.setPayeePhoneNumberText("1234567890");
		paraBankBillPayPage.setPayeeAccountNumberText("1234");
		paraBankBillPayPage.setVerifyAccountText("1234");
		paraBankBillPayPage.setAmountText("10.00");
		paraBankBillPayPage.clickSendPaymentSubmit();

		ParaBankBillPaymentCompletePage paraBankBillPaymentCompletePage = new ParaBankBillPaymentCompletePage(driver);
		assertEquals("$10.00", paraBankBillPaymentCompletePage.getAmountFieldText());
		paraBankBillPaymentCompletePage.clickLogOutLink();
	}

}