package page;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Common;

public class Page1 {
	WebDriver driver;
	By Header=By.xpath("//h1");
	By getStarted=By.xpath("//*[@id='signupModalButton']");
	By Username=By.xpath("//input[@id='loginForm:username']");
	By Password=By.id("loginForm:password");
	By btnLogin=By.id("loginForm:continue");
	By messageError=By.xpath("//span[@class='ui-messages-error-summary']");

	public Page1(WebDriver driver) {
	this.driver=driver;
	}
	
	
	public void loginPageFailed() {
		Common.waitForPageLoad(driver, 20);   
		driver.findElement(Username).sendKeys("your_username");  ;
		driver.findElement(Password).sendKeys("your_password");
		driver.findElement(btnLogin).click();
        String expectedErrorMessage = "Username and password combination entered does not match our records. Please try again.";
        assertDoesNotThrow(() -> {
            String actualErrorMessage = driver.findElement(messageError).getText();
            assertEquals(expectedErrorMessage, actualErrorMessage, "Error message does not match expected.");
        });
	}
	
	public void veryHeader() {
	String getheadertext=driver.findElement(Header).getText();
	assertEquals("App & Browser Testing Made Easy", getheadertext);
	}
	public void clickOnGetStarted() {
	driver.findElement(getStarted).click();
	}
	
	
	
}
