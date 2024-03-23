package testcases.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcases.components.AbstractComponent;

public class HomePage extends AbstractComponent {

	public HomePage() throws Exception {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(css = "div[class = 'd-flex flex-column align-items-center justify-content-center text-center']")
	private WebElement homeBanner;

	public WebElement getBanner() {
		return homeBanner;
	}
}
