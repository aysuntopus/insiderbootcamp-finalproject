package testcases.tests;

import org.testng.annotations.Test;
import testcases.pages.CareersPage;

public class DisplayCareerPage extends BaseTest {
	private CareersPage _careersPage;
	private DisplayHomePage _homePage;

	public DisplayCareerPage() throws Exception {
		super();
		_careersPage = new CareersPage();
		_homePage = new DisplayHomePage();
	}

	@Test
	public void displayCareerPage() throws InterruptedException {
		_homePage.navigateMainPage();
		getCompanyMenuButton().click();
		waitUntilVisible(getCompanyDropdownMenu());
		getCareersPage().click();

		// verify sections at CareersPage
		assertVisible(_careersPage.getLocationsSection(), "Locations section isn't visible.");
		assertVisible(_careersPage.getLifeSection(), "Life section isn't visible.");
		assertVisible(_careersPage.getTeamsSection(), "Teams section isn't visible.");
	}
}
