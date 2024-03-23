package testcases.tests;

import org.testng.annotations.AfterSuite;
import testcases.components.AbstractComponent;

public class BaseTest extends AbstractComponent {

	public BaseTest() throws Exception {
		super();
	}

	@AfterSuite
	public void tearDown() {
		getDriver().quit();
	}
}
