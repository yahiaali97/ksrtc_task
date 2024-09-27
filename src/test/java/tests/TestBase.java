package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import pages.HomePage;

public class TestBase {

	public static WebDriver driver;
	public static HomePage homePageObj;
	public static Properties prop;
	
	public  TestBase() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Properties\\data.properties");
		prop.load(fis);
	}

	@BeforeClass
	public void SetUp () {

		driver=new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.navigate().to(prop.getProperty("URL"));
		homePageObj = new HomePage(driver);
	}



	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
