package TestScripts;



	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;
	import org.testng.annotations.BeforeMethod;
	import org.testng.AssertJUnit;
	import java.lang.reflect.Method;
	import java.net.URL;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.CapabilityType;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;



	public class Test1 {
		
//		Lambdatest Credentails can be found here at https://www.lambdatest.com/capabilities-generator
	    String username = System.getenv("LT_USERNAME") == null ? "ashmaddy79" : System.getenv("LT_USERNAME"); 
	   String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "7QOKtAsZzPwfgA9g8PUIekOoefA3KY4Q6jfPYzVQDBFVQ8nSnh" : System.getenv("LT_ACCESS_KEY"); 
	   String buildName = System.getenv("LT_BUILD_NAME") == null ? "TestNG Parallel" : System.getenv("LT_BUILD_NAME");
		
	   public static WebDriver driver;

		@BeforeTest(alwaysRun = true)
		@Parameters(value = { "browser", "version", "platform" })
		protected void setUp(String browser, String version, String platform) throws Exception {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// set desired capabilities to launch appropriate browser on Lambdatest
			capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
			capabilities.setCapability(CapabilityType.VERSION, version);
			capabilities.setCapability(CapabilityType.PLATFORM, platform);
			capabilities.setCapability("build", "TestNG Parallel");
			capabilities.setCapability("build", buildName);
			capabilities.setCapability("name", "TestNG Parallel");
			capabilities.setCapability("network", true);
			capabilities.setCapability("video", true);
			capabilities.setCapability("console", true);
			capabilities.setCapability("visual", true);


			System.out.println("capabilities" + capabilities);

			// Launch remote browser and set it as the current thread
			String gridURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
			try {
				driver = new RemoteWebDriver(new URL(gridURL), capabilities);
			} catch (Exception e) {
				System.out.println("driver error");
				System.out.println(e.getMessage());
			}

		}
		@Test
		public static void test() throws Exception {
			try {

				
				driver.get("https://www.lambdatest.com/selenium-playground/");

				WebDriverWait wait = new WebDriverWait(driver,30);
				 
		         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[1]/div/div[1]/a[1]")));
		              // click on the compose button as soon as the "compose" button is visible
		         SoftAssert softAssert = new SoftAssert();
		         String actualTitle = driver.getTitle();
		     	System.out.println(actualTitle);
		     	String getActualTitle = driver.getTitle();
		     	softAssert.assertEquals(getActualTitle, "LamdaTest");
		     	System.out.println("Statement After Soft Assert failed");

				
				
				
				driver.get("https://www.lambdatest.com/selenium-playground/");
				
				driver.findElement(By.linkText("Javascript Alerts")).click();
				
				
				driver.findElement(By.xpath("//*[@id=\"__next\"]/section[3]/div/div/div[2]/div[1]/button")).click();
				
				String expectedAlert = "I am an alert box!";
				
				Alert alert = driver.switchTo().alert(); // switch to alert

				String alertMessage= driver.switchTo().alert().getText();
				
				Assert.assertEquals(alertMessage, expectedAlert);
				alert.accept();
				
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 

		}



		@AfterTest(alwaysRun = true)
		public void tearDown() throws Exception {
			driver.quit();
		}

	}


