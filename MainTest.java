package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.kredily.Kredily.basepages.BasePages;

public class MainTest extends BasePages{
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] 	data ={ {"gunjan.rawat@functionize.com","Rawat@9582830705"},{"Abhay97rawat@functionize.com","karbona26"},{"priyanka@functionize.com","priya@123"} };
		
		return data;
	}
	
	public MainTest(String browserName) {
		super(browserName);
		
		
	}
	
	SoftAssert sa=new SoftAssert();

	@Test(enabled=false)
	public void ValidLoginTest()
	{
		driver.findElement(By.xpath("(//a[text()='Sign In'])[1]")).click();
		driver.findElement(By.id("signInFormEmailAddress")).sendKeys("gunjan.rawat@functionize.com");
		driver.findElement(By.id("signInFormPassword")).sendKeys("Rawat@9582830705");
		driver.findElement(By.id("signinSubmitBtn")).click();
		Reporter.log("Test passed", true);
		WebElement text = driver.findElement(By.id("cnt"));
		Reporter.log(text.getText(), true);
		String expected="functionize";
		Assert.assertEquals(text.getText(), expected);
		
		
		
	}
	
	@Test ( dataProvider ="getData")
	public void InvalidLoginTest(String email, String password) 
	{
		driver.findElement(By.xpath("(//a[text()='Sign In'])[1]")).click();
		driver.findElement(By.id("signInFormEmailAddress")).sendKeys(email);
		Reporter.log(email, true);
		Reporter.log(password, true);
		driver.findElement(By.id("signInFormPassword")).sendKeys(password);
		driver.findElement(By.id("signinSubmitBtn")).click();
		Reporter.log("Test passed", true);
		
		
		
		
	}
	
	@Test   (enabled=false)
	public void Directory()
	{
		driver.findElement(By.xpath("(//a[text()='Sign In'])[1]")).click();
		driver.findElement(By.id("signInFormEmailAddress")).sendKeys("gunjan.rawat@functionize.com");
		driver.findElement(By.id("signInFormPassword")).sendKeys("Rawat@9582830705");
		driver.findElement(By.id("signinSubmitBtn")).click();
		Reporter.log("Test passed", true);
		WebElement text = driver.findElement(By.id("cnt"));
	
		String expected="functionize";
		Assert.assertEquals(text.getText(), expected);
		Reporter.log(text.getText(), true);
		driver.findElement(By.xpath("(//p[text()='Directory'])[2]/parent::a/preceding-sibling::a/div")).click();
		WebElement text1 = driver.findElement(By.xpath("//div[@class='col-md-10 col-9']/h3"));
		String expected1="DIRECTORY".toLowerCase();
		sa.assertEquals(text1, expected1);
		Reporter.log(text1.getText(), true);
		Reporter.log(expected1, true);
		driver.findElement(By.cssSelector("input[type='search']")).sendKeys("Gunjan");
		WebElement text2 = driver.findElement(By.xpath("(//div[@class='employee-profile'])[1]/following-sibling::span"));
		String expected2 ="Gunjan Rawat".toUpperCase();
		sa.assertEquals(text2.getText(), expected2);
		Reporter.log(text2.getText(), true);
		Reporter.log(expected2, true);
		
		Reporter.log("All soft assert are passed but test case is faling-", true);
		
		sa.assertAll();
		
		
		
		


	}
	
	

}
