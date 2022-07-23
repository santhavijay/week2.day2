package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafgroundbutton {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.findElement(By.xpath("//button[@id='home']")).click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);
		String expected = "TestLeaf - Selenium Playground";
		if(title.equals(expected))
			System.out.println("reached home page");
		else
			System.out.println("not reached home");
	}

}
