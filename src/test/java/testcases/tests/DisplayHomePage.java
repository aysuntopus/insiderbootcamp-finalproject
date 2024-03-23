package testcases.tests;

import org.testng.annotations.Test;
import testcases.pages.HomePage;

public class DisplayHomePage extends BaseTest {
	private HomePage _homePage;

	public DisplayHomePage() throws Exception {
		super();
		_homePage = new HomePage();
	}

	@Test
	public void navigateMainPage() throws InterruptedException {
		getDriver().get("https://useinsider.com/");
		acceptCookies();
		assertVisible(_homePage.getBanner(), "Homepage isn't accessible.");
	}
}
