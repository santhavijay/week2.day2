package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * 1 Launch the browser 2 Enter the username 3 Enter the password 4 Click Login
		 * 5 Click crm/sfa link 6 Click Leads link 7 Click Find leads 8 Click on Phone 9
		 * Enter phone number 10 Click find leads button 11 Capture lead ID of First
		 * Resulting lead 12 Click First Resulting lead 13 Click Delete 14 Click Find
		 * leads 15 Enter captured lead ID 16 Click find leads button 17 Verify message
		 * "No records to display" in the Lead List. This message confirms the
		 * successful deletion 18 Close the browser (Do not log out)
		 */
		WebDriverManager.chromedriver().setup();
		String property = System.getProperty("webdriver.chrome.driver");
		System.out.println(property);
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		WebElement logOut = driver.findElement(By.className("decorativeSubmit"));
		String attribute = logOut.getAttribute("value");
		System.out.println(attribute);
		if (attribute.equals("Logout")) {
			System.out.println("Login successfully");
		} else {
			System.out.println("Login failed");
		}
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(3000);
		// click lead tab
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(3000);
		// Click Find Lead button
		driver.findElement(By.partialLinkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		// enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9943827271");
		// click findLead button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		// click first match text val
		String matchData = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td[1]/div/a"))
				.getText();
		System.out.println("First record val : " + matchData);
		// click first match
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr/td[1]/div/a")).click();
		Thread.sleep(3000);
		// click delete button
		driver.findElement(By.linkText("Delete")).click();
		Thread.sleep(3000);
		// click Find lead tab
		driver.findElement(By.partialLinkText("Find Leads")).click();
		Thread.sleep(5000);
		// find LeadId and enter matched data
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(matchData);
		// click findlead button
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(3000);
		String norecords = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		System.out.println("text is : " + norecords);
		if(norecords.equals("No records to display"))
			System.err.println("Record deleted successfully");
		else
			System.out.println("record is still present");
	}

}
