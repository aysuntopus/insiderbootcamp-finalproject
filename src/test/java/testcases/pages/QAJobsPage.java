package testcases.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcases.components.AbstractComponent;

public class QAJobsPage extends AbstractComponent {

	public QAJobsPage() throws Exception {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//div[@class='button-group d-flex flex-row']//a")
	private WebElement allQAJobsButton;

	@FindBy(xpath = "(//span[@class='selection']//span)[1]")
	private WebElement filterLocationButton;

	@FindBy(xpath = "(//ul[@id='select2-filter-by-location-results'])[1]")
	private WebElement locationDropdownList;

	@FindBy(xpath = "(//ul[@id='select2-filter-by-location-results'])[1]//li[2]")
	private WebElement selectLocation;

	@FindBy(xpath = "//div[@id='jobs-list']//div")
	private List<WebElement> jobList;

	@FindBy(xpath = "//div[@id='jobs-list']//div[1]//div//div")
	private List<WebElement> jobLocation;

	@FindBy(xpath = "//div[@id='jobs-list']//div[1]//span")
	private List<WebElement> qaJobTag;

	@FindBy(xpath = "//div[@class='jobs-pagination']//button[2]")
	private WebElement arrowRight;

	@FindBy(xpath = "//section[@id='career-position-list']//div[@class='row']//div[1]//div[1]//a[1]")
	private List<WebElement> viewRoleButton;
	
	public WebElement getAllQAJobsButton() {
		return allQAJobsButton;
	}

	public WebElement getFilterLocationButton() {
		return filterLocationButton;
	}

	public WebElement getLocationDropdownList() {
		return locationDropdownList;
	}

	public WebElement getSelectLocation() {
		return selectLocation;
	}

	public List<WebElement> getJobList() {
		return jobList;
	}

	public List<WebElement> getJobLocation() {
		return jobLocation;
	}

	public List<WebElement> getQAJobTag() {
		return qaJobTag;
	}

	public WebElement getArrowRight() {
		return arrowRight;
	}

	public List<WebElement> getViewRoleButton() {
		return viewRoleButton;
	}
}
