package testcases.tests;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.pages.QAJobsPage;
import testcases.pages.ApplicationPage;

public class DisplayQAJobs extends BaseTest {
	private QAJobsPage _qaJobsPage;
	private ApplicationPage _applicationPage;

	public DisplayQAJobs() throws Exception {
		super();
		_qaJobsPage = new QAJobsPage();
		_applicationPage = new ApplicationPage();
	}

	@Test
	public void displayJobs() throws InterruptedException {
		getDriver().get("https://useinsider.com/careers/quality-assurance/");
		acceptCookies();
		
		scrollDown(300);		
		_qaJobsPage.getAllQAJobsButton().click();
			
		waitUntilPageIsLoaded();
		scrollDown(300);

		Thread.sleep(2000);	// it needs time to load combobox
		_qaJobsPage.getFilterLocationButton().click();
		_qaJobsPage.getSelectLocation().click(); // selects Istanbul as location

		scrollDown(300);
		// verify display jobs list
		assertVisible(_qaJobsPage.getJobList().get(0), "QA Jobs List can't display.");

		// verify display jobs whether all are Quality Assurance
		boolean result = _qaJobsPage.getQAJobTag().stream().allMatch(x -> x.getText().contains("Quality Assurance"));
		Assert.assertTrue(result);

		while (_qaJobsPage.getArrowRight().isEnabled()) {
			_qaJobsPage.getArrowRight().click();
			result = _qaJobsPage.getQAJobTag().stream().allMatch(x -> x.getText().contains("Quality Assurance"));
			Assert.assertTrue(result);
		}

		// verify display jobs whether all locations are Istanbul, Turkey
		boolean resultLocation = _qaJobsPage.getQAJobTag().stream()
				.allMatch(x -> x.getText().contains("Quality Assurance"));
		Assert.assertTrue(resultLocation);

		while (_qaJobsPage.getArrowRight().isEnabled()) {
			_qaJobsPage.getArrowRight().click();
			resultLocation = _qaJobsPage.getJobLocation().stream()
					.allMatch(x -> x.getText().contains("Istanbul, Turkey"));
			Assert.assertTrue(resultLocation);
		}
	}

	@Test(dependsOnMethods = "displayJobs")
	public void ViewRole() throws InterruptedException {
		scrollDown(200);
		// waits components are loaded
		Thread.sleep(1000);
		Actions action = new Actions(getDriver());
		// cursor moves to over the div element
		action.moveToElement(_qaJobsPage.getJobList().get(0));
		// then clicks the view role button
		_qaJobsPage.getViewRoleButton().get(0).click();

		// moves to the next tab
		Set<String> handle = getDriver().getWindowHandles();
		Iterator<String> iterator = handle.iterator();
		iterator.next(); // skip parent
		String childWindow = iterator.next(); // get the child one
		getDriver().switchTo().window(childWindow);

		// waits components are loaded
		Thread.sleep(2000);
		assertVisible(_applicationPage.getApplyButton(), "Application form can't be opened.");
	}
}
