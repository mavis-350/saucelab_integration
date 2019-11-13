package saucelab_integration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class teamforge_login {
	public static final String USERNAME = "umakanthdiwakar";
	  public static final String ACCESS_KEY = "8e365023-c33c-42b4-af6f-403d26c60512";
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	  public static void main(String[] args) throws Exception {

	    DesiredCapabilities caps = DesiredCapabilities.chrome();
	    caps.setCapability("platform", "Windows 10");
	    caps.setCapability("version", "latest");
	    caps.setCapability("build", System.getenv("Teamforge") + "__" + System.getenv("1.0"));
		  
	    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);

	    driver.get("https://stage.forge.collab.net");
	    Thread.sleep(3000);
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//strong[contains(.,'Log In')]")).click();
	    Thread.sleep(3000);
		driver.findElement(By.id("okta-signin-username")).sendKeys("rakil");
		driver.findElement(By.id("okta-signin-password")).sendKeys("Invite@123");
	    driver.findElement(By.id("okta-signin-submit")).click();
	    Thread.sleep(3000);
	    driver.quit();   
	    String at = driver.getTitle();
	    String et = "TeamForge : My Page";
	    if(at.equalsIgnoreCase(et))
	    {
	    	System.out.println("Logged in Successfully");
	    }else 
	    {
	    	System.out.println("Test Failure");
	    }
	    
	}

}
