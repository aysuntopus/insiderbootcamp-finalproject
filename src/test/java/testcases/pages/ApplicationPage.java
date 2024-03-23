package testcases.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcases.components.AbstractComponent;

public class ApplicationPage extends AbstractComponent {

	public ApplicationPage() throws Exception {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "(//a[@class='postings-btn template-btn-submit shamrock'])[1]")
	private WebElement applyButton;

	public WebElement getApplyButton() {
		return applyButton;
	}
}
