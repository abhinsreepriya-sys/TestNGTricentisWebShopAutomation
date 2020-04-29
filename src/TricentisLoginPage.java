import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TricentisLoginPage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Scenario1
		// Navigate to the Site
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		// Click on the Login Button
		WebElement LoginBtn = driver.findElement(By.xpath("//a[@href='/login']"));
		LoginBtn.click();
		Thread.sleep(2000);

		// Enter the username and password
		WebElement EmailTB = driver.findElement(By.id("Email"));
		EmailTB.sendKeys("abhinsreepriya@gmail.com");
		Thread.sleep(2000);

		WebElement PwdTB = driver.findElement(By.id("Password"));
		PwdTB.sendKeys("test123!");
		Thread.sleep(2000);

		// Click on login button
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		// Scenario1 completed

		// Scenario2
		// navigate to apparel and shoes
		WebElement AppandShoeBtn = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[4]/a"));
		AppandShoeBtn.click();
		Thread.sleep(4000);
		// driver.findElement(By.xpath("//a[@href='/blue-jeans']/img")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[1]/a/img")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("addtocart_36_EnteredQuantity")).clear();
		driver.findElement(By.id("addtocart_36_EnteredQuantity")).sendKeys("5");
		WebElement AddToCart = driver.findElement(By.id("add-to-cart-button-36"));
		AddToCart.click();
		Thread.sleep(5000);

		Actions actions = new Actions(driver);
		WebElement ShCtLink = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
		actions.moveToElement(ShCtLink).perform();
		Thread.sleep(7000);
		WebElement GoToCart = driver.findElement(By.xpath("//input[@class='button-1 cart-button']"));
		GoToCart.click();
		Thread.sleep(2000);
		// scenario2 completed

		// Scenario3
		Select s=new Select(driver.findElement(By.id("CountryId")));
		s.selectByVisibleText("India");
		Thread.sleep(2000);
		driver.findElement(By.id("ZipPostalCode")).sendKeys("670620");
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[1]/ul/li[4]/a")).click();
		if(driver.getPageSource().contains("Put your conditions of use information here"))
		{
			System.out.println("Text is displayed");
		}
		else {
			System.out.println("Text not present");
		}
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(4000);
		// scenario 3 completed

		/*// Scenario 4
		//driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("Cognizant");
		//Select s1=new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
		//s1.selectByVisibleText("India");
		//Thread.sleep(2000);
		//driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Banaras");
		//driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("prana123");
		//Thread.sleep(4000);
		//driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("670620");
		//Thread.sleep(2000);
		//driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9635489620");
		//Thread.sleep(8000);
		Select s2=new Select(driver.findElement(By.id("billing-address-select")));
		s2.selectByIndex(0);
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click();
		driver.findElement(By.xpath("PickUpInStore")).click();
		driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();
		//writeCodeforselecting radio button
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click();
		//writeCodeforselecting payment details
		driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();
		Thread.sleep(2000);
		// driver.close();
*/
		//select address from dropdown
		Select selectDrpDwnAddr=new Select(driver.findElement(By.id("billing-address-select")));
		selectDrpDwnAddr.selectByValue("1424250");
		//click on continue
		driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click();
		Thread.sleep(2000);
		//click the pickup checkbox
		driver.findElement(By.xpath("//*[@id=\"PickUpInStore\"]")).click();
		//click on continue
		driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();
		Thread.sleep(2000);
		//select credit card
		driver.findElement(By.id("paymentmethod_0")).click();
		Thread.sleep(2000);
		//click on continue
		driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
		Thread.sleep(2000);
		//click on continue-payment
		driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
		Thread.sleep(2000);
		//Verfy name ph no and item in the given tab
		String name="abhinsreepriya";
		String phone= "9636568963";
		if(driver.getPageSource().contains(name)) {
			System.out.println("name is verified: "+name);
			}
		else if(driver.getPageSource().contains(phone)){
			System.out.println("Verified phone number is right");
			}
		else {
			System.out.println("verified name and phone is not correct");
		}
		
		//click confirm
		driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();
		WebElement OrderNumber= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[1]"));
		System.out.println(OrderNumber);
		/*driver.findElement(By.id("paymentmethod_2")).click();
		//click on continue
		driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
		//select visa from dropdown
		Select selectDrpDwnCard=new Select(driver.findElement(By.id("CreditCardType")));
		selectDrpDwnCard.selectByVisibleText("Visa");
		//card holder name
		driver.findElement(By.id("CardholderName")).sendKeys("Abhins");
		//card number
		driver.findElement(By.id("CardNumber")).sendKeys("4315789456123698");
		//Expiration month & year
		Select selectMonth=new Select(driver.findElement(By.id("ExpireMonth")));
		selectMonth.selectByVisibleText("06");
		Select selectYear=new Select(driver.findElement(By.id("ExpireYear")));
		selectYear.selectByVisibleText("2022");
		//select card code
		driver.findElement(By.id("CardCode")).sendKeys("123");
		//click on continue
		driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
		*/
		
		
		
	}

}
