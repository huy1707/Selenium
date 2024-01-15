package DemoSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import page.Page1;
import utils.API;
import utils.Common;
import utils.Constants;

public class FirstCode {
	public WebDriver driverPage;
	Page1 objPageDemo;

	@BeforeEach
	public void createDriver() {
		Common.setDriver(driverPage);
		Common.createDriverBrowser(Constants.sRunBrowser);
	}

	@Test
	public void pageLogin() {
		objPageDemo = new Page1(Common.driver);
		objPageDemo.loginPageFailed();
	}

	@Test
	public void testApiCallAndVerifyJson() {
		API.callAndVerifyResponse();
	}

	@AfterEach
	public void closeDriver() {
		Common.driver.quit();
	}

}
