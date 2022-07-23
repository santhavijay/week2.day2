package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*http://leaftaps.com/opentaps/control/main
		
		* 1	Launch the browser
		* 2	Enter the username
		* 3	Enter the password
		* 4	Click Login
		* 5	Click crm/sfa link
		* 6	Click Leads link
		* 7	Click Find leads
		* 8	Enter first name
		* 9	Click Find leads button
		* 10 Click on first resulting lead
		* 11 Verify title of the page
		* 12 Click Edit
		* 13 Change the company name
		* 14 Click Update
		* 15 Confirm the changed name appears
		* 16 Close the browser (Do not log out)*/
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
		//click first resulting Lead
		String companyId = driver.findElement(By.xpath("//div[@id='ext-gen473']/div[1]/table/tbody/tr/td[1]/div/a")).getText();
		System.out.println(companyId);
		driver.findElement(By.xpath("//div[@id='ext-gen473']/div[1]/table/tbody/tr/td[1]/div/a")).click();
		Thread.sleep(3000);
		System.out.println("first id selected ");
		String title = driver.getTitle();
		System.out.println(title);
		String leadTitle = "View Lead | opentaps CRM";
		if(title.equals(leadTitle))
		{
			System.out.println("Navigated to Leaftab page successfully");
		}
		else
			System.out.println("failed to navigate to Leaftab");
		//click edit button
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("Jasmin");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		Thread.sleep(3000);
		String companyName = driver.findElement(By.id(("viewLead_companyName_sp"))).getText();
		System.out.println(companyName);
		String actual = "Jasmin" + " " + "(" + companyId + ")";
		System.out.println(actual);
		if(companyName.equals(actual))
			System.out.println("company name updated successfully");
		else
			System.out.println("failed to update the company name");
	}

}
