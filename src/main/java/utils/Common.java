package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
//	private static WebDriver driver;
//	private static final Properties properties = new Properties();
//
//	static {
//		try (InputStream input = Common.class.getClassLoader().getResourceAsStream("Selectors.properties")) {
//			properties.load(input);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static String getSelector(String page, String element) {
//		String key = page + "." + element;
//		return properties.getProperty(key);
//	}
//
//	public void WebUI(WebDriver _driver) {
//		driver = _driver;
//	}
//
//	public static void sleep(double second) {
//		try {
//			Thread.sleep((long) (1000 * second));
//		} catch (InterruptedException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	public static void pressDownKey(int totalPress) {
//		for (int i = 1; i <= totalPress; i++) {
//			new Actions(driver).scrollByAmount(0, 500).perform();
//			sleep(1);
//		}
//	}
//
//	public static Boolean checkElementExist(By by) {
//		List<WebElement> listElement = driver.findElements(by);
//
//		if (listElement.size() > 0) {
//			System.out.println("Element existing: " + true);
//			return true;
//		} else {
//			System.out.println("Element existing: " + false);
//			return false;
//		}
//	}
//
//	public static void waitForElementVisible(By by) {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//		} catch (Throwable error) {
//			System.out.println("Timeout waiting for the element Visible. " + by.toString());
//			fail("Timeout waiting for the element Visible. " + by.toString());
//		}
//	}
//
//	public static boolean verifyElementVisible(By by) {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//			return true;
//		} catch (NoSuchElementException error) {
//			error.printStackTrace();
//			System.out.println("Timeout waiting for the element Visible. " + by.toString());
//			fail("Timeout waiting for the element Visible. " + by.toString());
//		}
//		return false;
//	}
//
//	public static void waitForPageLoaded() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40), Duration.ofMillis(500));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver)
//				.executeScript("return document.readyState").toString().equals("complete");
//
//		boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");
//		if (!jsReady) {
//			try {
//				wait.until(jsLoad);
//			} catch (Throwable error) {
//				error.printStackTrace();
//				fail("Timeout waiting for page load (Javascript)");
//			}
//		}
//	}

	/**
	 * Utility class containing common methods for Selenium actions.
	 */

	public static WebDriver driver;

	/**
	 * Sets the WebDriver instance to be used by utility methods.
	 *
	 * @param webDriver The WebDriver instance.
	 */
	public static void setDriver(WebDriver webDriver) {
		driver = webDriver;
	}

	/**
	 * Waits until the element identified by the given locator is present in the
	 * DOM.
	 *
	 * @param locator          The By locator strategy to identify the element.
	 * @param timeoutInSeconds The maximum time to wait for the element to be
	 *                         present.
	 */
	public static void waitUntilElementPresent(By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * Waits until the element identified by the given locator is visible on the web
	 * page.
	 *
	 * @param locator          The By locator strategy to identify the element.
	 * @param timeoutInSeconds The maximum time to wait for the element to be
	 *                         visible.
	 */
	public static void waitUntilElementVisible(By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * Waits until the element identified by the given locator is clickable.
	 *
	 * @param locator          The By locator strategy to identify the element.
	 * @param timeoutInSeconds The maximum time to wait for the element to be
	 *                         clickable.
	 */
	public static void waitUntilElementClickable(By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * Finds the WebElement based on the given locator.
	 *
	 * @param locator The By locator strategy to identify the element.
	 * @return The WebElement found using the given locator.
	 */
	public static WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * Clicks on the element identified by the given locator.
	 *
	 * @param locator The By locator strategy to identify the element to be clicked.
	 */
	public static void click(By locator) {
		findElement(locator).click();
	}

	/**
	 * Sets text in the element identified by the given locator.
	 *
	 * @param locator The By locator strategy to identify the element where text
	 *                needs to be set.
	 * @param text    The text to be set in the element.
	 */
	public static void setText(By locator, String text) {
		WebElement element = findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Hovers over the element identified by the given locator.
	 *
	 * @param locator The By locator strategy to identify the element to be hovered
	 *                over.
	 */
	public static void hoverOverElement(By locator) {
		WebElement element = findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// Additional methods can be added based on your requirements

	// Example JUnit 5 test method using the utility methods
	// ...
	/**
	 * Custom keyword name: getObjectId(By objPath)
	 *
	 * General description: This custom keyword is used to get the name of a test
	 * object.
	 *
	 * @param objPath The object in the Object Repository
	 * @return the string representing the test object's name
	 * @since 17/06/2023
	 * @author GreenCSR Automation team
	 */
	public static String getObjectId(By objPath) {
		try {
			return objPath.toString().split("/")[1];
		} catch (NullPointerException ex) {
			throw new NullPointerException("Object does not exist. Please check again!");
		}
	}

	/**
	 * Waits for the given WebDriver to load a web page completely, ensuring that
	 * the document's ready state becomes "complete" within the specified timeout.
	 *
	 * @param driver           The WebDriver instance that navigated to the web
	 *                         page.
	 * @param timeoutInSeconds The maximum time to wait for the page to complete
	 *                         loading, in seconds.
	 * @throws TimeoutException If the page load doesn't complete within the
	 *                          specified timeout.
	 */
	public static void waitForPageLoad(WebDriver driver, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

		ExpectedCondition<Boolean> pageLoadCondition = webDriver -> {
			assert webDriver != null;
			return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
		};

		wait.until(pageLoadCondition);
	}

	/**
	 * Verifies whether the text of a given element matches the expected message.
	 *
	 * @param objPath   The By selector of the element in the Object Repository.
	 * @param sMessage  The expected message to compare with the element's text.
	 * @param bExpected Boolean value to determine if the text should match the
	 *                  expected message.
	 * @return True if the actual message matches the expected message; otherwise,
	 *         false.
	 */
	public boolean confirmMatchContext(By objPath, String sMessage, boolean bExpected) {
		WebElement element = driver.findElement(objPath);
		String sActualMessage = element.getText().trim();

		boolean bResult = bExpected ? sActualMessage.equals(sMessage) : !sActualMessage.equals(sMessage);

		if (bResult) {
			System.out.println("Verification successful! Element returns the expected value: " + sMessage);
		} else {
			System.out.println("Verification failed! Element does not return the expected value: " + sMessage);
		}

		return bResult;
	}

	/**
	 * Sets up the WebDriver based on the specified browser type, allowing the
	 * automation tests to be executed on Chrome or Firefox browsers.
	 * 
	 * @param browserType The type of browser to use (e.g., "chrome" or "firefox").
	 * @throws IllegalArgumentException If the specified browser type is  unsupported. 
	 */
	public static void createDriverBrowser(String browserType) {
		// Set up WebDriver based on the specified browser type
		if (browserType.equalsIgnoreCase("chrome")) {
			// Configure Chrome driver
			System.setProperty("webdriver.chrome.driver", Constants.chromeDriverUrl);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} else if (browserType.equalsIgnoreCase("firefox")) {
			// Configure Firefox driver with additional preferences
			System.setProperty("webdriver.gecko.driver", Constants.geckoDriverUrl);
			FirefoxOptions options = new FirefoxOptions();
			// Ignore TLS certificate errors
			options.addPreference("browser.startup.page", 0);
			options.addPreference("browser.startup.homepage_override.mstone", "ignore");
			options.addPreference("browser.ssl_override_behavior", 1);
			options.addPreference("browser.ssl_override_warning_popup_enabled", false);
			driver = new FirefoxDriver(options);
		} else {
			// Throw exception for unsupported browser type
			throw new IllegalArgumentException("Unsupported browser type: " + browserType);
		}

		// Common configurations for both Chrome and Firefox
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
