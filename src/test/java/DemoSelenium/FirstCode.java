package DemoSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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
	@Feature("Login1")
	@Story("User logs in with valid credentials")
    @DisplayName("Test with spaces, expected passed")
	@Description("What a test does to be included here")
	public void pageLogin() {
		Common.driver.get(Constants.Login_URL);
		objPageDemo = new Page1(Common.driver);
		objPageDemo.loginPageFailed();
	}

	@Test
	@Feature("Login2")
	@Story("User logs in with valid api")
    @DisplayName("Test with API, expected passed")
	@Description("What a test does to be included api")
	public void testApiCallAndVerifyJson() {
		API.callAndVerifyResponse();
	}

	@AfterEach
	public void closeDriver() {
		Common.driver.quit();
	}

}
