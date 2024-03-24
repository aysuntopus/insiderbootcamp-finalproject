package testcases.components;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	private static DriverManager _instance = null;
	private final WebDriver _driver;

	private DriverManager() throws Exception {
		String path = System.getProperty("user.dir");
		String browserName = getProfileBrowserName();
		if(browserName == null) {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(path + "//src//test//resources//globaldata.properties");
			prop.load(fis);
			browserName = prop.getProperty("browser");
		}

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", path + "\\chromedriver-win32\\chromedriver.exe");
			_driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", path + "\\firefoxdriver-win32\\geckodriver.exe");
			_driver = new FirefoxDriver();
		} else {
			throw new Exception("Browser is not supported.");
		}
		_driver.manage().window().maximize();
	}

	public static DriverManager getInstance() throws Exception {
		if (_instance == null) {
			_instance = new DriverManager();
		}
		return _instance;
	}

	public WebDriver getDriver() {
		return _driver;
	}

	public String getProfileBrowserName() {
		try {
			InputStream is = getClass().getClassLoader()
					.getResourceAsStream("properties-from-pom.properties");
			Properties properties = new Properties();
			properties.load(is);
			return properties.getProperty("browserName");
		}
		catch (Exception e) {
			return null;
		}
	}
}
