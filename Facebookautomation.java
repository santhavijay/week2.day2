package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebookautomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.linkText("Create New Account")).click();
//enter first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Santha");
//enter surname
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("kumari");
//enter mobile
		driver.findElement(By.name("reg_email__")).sendKeys("99438");
//enter password
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("kitty");
//select day by index
		WebElement day = driver.findElement(By.id("day"));
		Select dobj = new Select(day);
		dobj.selectByIndex(22);
//select month by text
		WebElement month = driver.findElement(By.id("month"));
		Select mobj = new Select(month);
		mobj.selectByVisibleText("Dec");
//select year by value
		WebElement year = driver.findElement(By.id("year"));

		Select yobj = new Select(year);
		yobj.selectByValue("2013");
//select female radio button
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		
		System.out.println("task completed");
	}

}
