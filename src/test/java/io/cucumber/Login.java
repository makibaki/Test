package io.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.Loginpage;

public class Login {

    public String username; // what does this do here?
    public String password; //same above // can be removed

    WebDriver driver;

    Loginpage loginpage = new Loginpage(driver);


    @Given("^Open the Firefox and launch the application$") //launching firefox should be independent from tests
    public void open_the_Firefox_and_launch_the_application() throws Throwable
    {
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\mkojic\\Desktop\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mkojic\\Desktop\\chromedriver.exe");

        //Instantiating driver object and launching browser
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();

        //Using get() method to open a webpage
        driver.get("https://iris-price.smithmicro.io"); // we should have environment files for urls
        Thread.sleep(1000);
        System.out.println("This Step open the Firefox and launch the application.");
    }

    @When("^Enter the Username (\\S+) and Password (\\S+)$")
    public void enter_the_Username_and_Password(String username, String password) throws Throwable
    {
//        this.username = username;
//        this.password = password;
//
//        driver.findElement(By.id("mat-input-0")).sendKeys(username);
//
//        driver.findElement(By.id("mat-input-1")).sendKeys(password);
        loginpage.Login(username, password);
        System.out.println("This step enters the Username and Password on the login page.");

    }

    @Then("^Click Login button$")
    public void Click_the_login() throws Throwable // why starting method with capital letters
    {
          loginpage.clickLogin();

        Thread.sleep(2000); // why sleep? please read selenium waits (explicit,implicint,fluent)
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://iris-price.smithmicro.io/" );
//        driver.findElement(By.xpath("/html/body/app-root/app-main-nav/main/app-login/mat-card/mat-card-actions/button")).click();
//
//        System.out.println("Mi smo carevi");
//        Thread.sleep(5000);
        //Closing the browser
//        driver.quit();
        System.out.println("This step click on the Reset button."); // we can use logger library for logging
    }

}
