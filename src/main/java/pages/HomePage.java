package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	
	By tripRouteText = By.xpath("//a[contains(.,'Chikkamagaluru - Bengaluru')]");
	By nextDayDate =By.xpath("(//a[contains(@class,'ui-state-default')])[2]");
	By searchForBusBtn = By.xpath("//button[contains(.,'Search for Bus')]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterTripInformation() {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(tripRouteText));
		clickOn(tripRouteText);
		clickOn(nextDayDate);
		
	}
	
	public SelectSeatPage selectSeat() throws InterruptedException {	
		

		//driver.manage().window().maximize();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(searchForBusBtn));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchForBusBtn));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(searchForBusBtn));
		//driver.findElement(searchForBusBtn).click();

		return new SelectSeatPage(driver);
	}
	
	public void clickOn(By by) {
		driver.findElement(by).click();
	}
}
