package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PayByCardPage {

	private WebDriver driver;
	
	By cardNoTextBox = By.id("cnumber");
	By expirationMonthTextBox = By.id("expmon");
	By expirationYearTextBox = By.id("expyr");
	By cvvTextBox = By.id("cvv2");
	By cardHolderNameTextBox = By.id("cname2");
	
	public PayByCardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void fillAllTheFields(String cardNumber,String month,String year,String cvv,String cardHolderName) {
		typeText(cardNoTextBox,cardNumber);
		Select selectMonth = new Select(driver.findElement(expirationMonthTextBox));
		selectMonth.selectByValue(month);
		Select selectYear = new Select(driver.findElement(expirationYearTextBox));
		selectYear.selectByValue(year);
		typeText(cvvTextBox, cvv);
		typeText(cardHolderNameTextBox, cardHolderName);
	}



	public void typeText(By by,String text) {
		driver.findElement(by).sendKeys(text);
	}


}
