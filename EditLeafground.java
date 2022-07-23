package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeafground {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.id("email")).sendKeys("santha1.vijay@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input")).sendKeys("hello",Keys.TAB);
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
		String textbox = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input")).getAttribute("disabled");
		boolean enabled = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input")).isEnabled();
		System.out.println(textbox);
		if(textbox.equals("true"))
			System.out.println("box is disabled");
		else
			System.out.println("box is enabled");
		if(enabled)
			System.out.println("it is editable");
		
		else
			System.out.println("not editable");
	}

}
