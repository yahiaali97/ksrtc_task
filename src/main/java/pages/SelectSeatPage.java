package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectSeatPage {

	private WebDriver driver;
	
	By selectSeatBtn = By.xpath("//input[@class='btnSelectLO select-service-btn']");
	By boardingPoint = By.xpath("//li[contains(@class,'p-2 Forward-boarding active1')]");
	By droppingPointTab = By.id("Forwarddroping-tab");
	By droppingPoint = By.xpath("//li[@class='p-2 Forward-droping']");
	By phoneNumberTextBox = By.id("mobileNo");
	By emailTextBox = By.id("email");
	By makePayementBtn = By.id("PgBtn");
	By seatsAvailable = By.xpath("(//li[contains(@class,'availSeatClassS')])");
	By passengerNameTextBox = By.id("passengerNameForward0");
	By passengerGender = By.id("genderCodeIdForward0");
	By passengerAge = By.id("passengerAgeForward0");
	By selectConcession = By.id("concessionIdsForward0");

	public SelectSeatPage(WebDriver driver) {
		this.driver = driver;
	}

	public PayByCardPage selectAndMakePayment(String phoneNo,String email,String name,String gender,String age,String concession) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(selectSeatBtn));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectSeatBtn));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(selectSeatBtn));
		wait.until(ExpectedConditions.visibilityOfElementLocated(boardingPoint));
		clickOn(boardingPoint);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(droppingPointTab));
		clickOn(droppingPointTab);
		clickOn(droppingPoint);
		typeText(phoneNumberTextBox, phoneNo);
		typeText(emailTextBox, email);
		clickOn(seatsAvailable);
		typeText(passengerNameTextBox, name);
		typeText(passengerGender, gender);
		typeText(passengerAge, age);
		typeText(selectConcession, concession);
		clickOn(makePayementBtn);

		return new PayByCardPage(driver);
	}

	public void typeText(By by,String text) {
		driver.findElement(by).sendKeys(text);
	}

	public void clickOn(By by) {
		driver.findElement(by).click();
	}

}
