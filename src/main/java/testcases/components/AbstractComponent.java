package testcases.components;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class AbstractComponent {

	private static boolean _cookieAccepted = false;
	private final int DRIVER_WAIT_IN_SEC = 5;

	private WebDriverWait _wait;
	private WebDriver _driver;

	public AbstractComponent() throws Exception {
		_driver = DriverManager.getInstance().getDriver();
		PageFactory.initElements(_driver, this);
		_wait = new WebDriverWait(_driver, DRIVER_WAIT_IN_SEC);
	}

	@FindBy(xpath = "(//a[@class= 'nav-link dropdown-toggle'])[5]")
	private WebElement companyMenuButton;

	@FindBy(xpath = "//div[@class='new-menu-dropdown-layout-6-mid-container']//a[2]")
	private WebElement careersPage;

	@FindBy(xpath = "//div[@class='new-menu-dropdown-layout-6-mid-container']")
	private WebElement companyDropdownMenu;

	@FindBy(id = "wt-cli-accept-all-btn")
	private WebElement acceptCookie;
	
	public WebElement getCompanyMenuButton() {
		return companyMenuButton;
	}

	public WebElement getCompanyDropdownMenu() {
		return companyDropdownMenu;
	}

	public WebElement getCareersPage() {
		return careersPage;
	}

	public WebDriver getDriver() {
		return _driver;
	}

	public void acceptCookies() {
		if(!_cookieAccepted) {
			waitUntilClickable(acceptCookie).click();
			_cookieAccepted = true;
		}
	}
	
	public void assertVisible(WebElement element, String errorMessage) {
		Exception exception = null;
		try {
			waitUntilVisible(element);
		} catch (TimeoutException e) {
			exception = e;
		}
		Assert.assertNull(exception, errorMessage);
	}

	public WebElement waitUntilVisible(WebElement element) {
		return _wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitUntilClickable(WebElement element) {
		return _wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilPageIsLoaded() {
		_wait.until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));
	}
	
	public void assertVisible(By locator, String errorMessage) {
		Exception exception = null;
		try {
			_wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		} catch (TimeoutException e) {
			exception = e;
		}
		Assert.assertNull(exception, errorMessage);
	}

	public String takeScreenShot(String testname) {
		TakesScreenshot ts = (TakesScreenshot) _driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testname + ".png");
		try {
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return System.getProperty("user.dir") + "//reports" + testname + ".png";
	}

	public void scrollDown(int value) throws InterruptedException {
		JavascriptExecutor Scroll = (JavascriptExecutor) _driver;
		Scroll.executeScript("window.scrollBy(0," + value + ")", "");
		Thread.sleep(2000); // waits for scroll animations
	}
}
