package testcases.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcases.components.AbstractComponent;

public class CareersPage extends AbstractComponent {

	public CareersPage() throws Exception {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//div[@class='col-12 d-flex flex-wrap']")
	private WebElement locationsSection;

	@FindBy(xpath = "//section[@id='career-find-our-calling']//div[@class='row']")
	private WebElement teamsSection;

	@FindBy(xpath = "(//section[@class='elementor-section elementor-top-section elementor-element elementor-element-a8e7b90 elementor-section-full_width elementor-section-height-default elementor-section-height-default'])[1]")
	private WebElement lifeSection;

	public WebElement getLocationsSection() {
		return locationsSection;
	}

	public WebElement getTeamsSection() {
		return teamsSection;
	}

	public WebElement getLifeSection() {
		return lifeSection;
	}
}