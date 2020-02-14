package io.cucumber;

import common.PropertyValues;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import pageObjcets.loginPageObjects.Loginpage;

import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver;
    String username;
    String password;

    Loginpage loginpage = new Loginpage(driver);


    @Given("^Open the Firefox and launch the application$") //launching firefox should be independent from tests
    public void open_the_Firefox_and_launch_the_application() throws Throwable
    {

        //BaseClass.open("");
        System.setProperty("webdriver.gecko.driver", PropertyValues.getPropertiesData("mozzila"));
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mkojic\\IdeaProjects\\Ali tutorial\\resources\\drivers\\chromedriver.exe");

        //Instantiating driver object and launching browser
        driver = new FirefoxDriver();
//        driver = new ChromeDriver();

        //Using get() method to open a webpage
        driver.get(PropertyValues.getPropertiesData("iris")); // we should have environment files for urls
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("This Step open the Firefox and launch the application.");
//        driver.quit();
    }

    @When("^Enter the Username (\\S+) and Password (\\S+)$")
    public void enter_the_Username_and_Password(String username, String password) throws Throwable
    {
        Loginpage loginpage = new Loginpage(driver);
        this.username = username;
        this.password = password;

        driver.findElement(By.id("mat-input-0")).sendKeys(username);

        driver.findElement(By.id("mat-input-1")).sendKeys(password);

        System.out.println("This step enters the Username and Password and clicks login");
//        driver.quit();


    }

    @Then("^Click Login button$")
    public void click_the_login() throws Throwable
    {
        Loginpage loginpage = new Loginpage(driver);
        loginpage.clickLogin();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://iris-price.smithmicro.io/" );

//        driver.findElement(By.id("mat-input-0")).sendKeys(username);
//
//        driver.findElement(By.id("mat-input-1")).sendKeys(password);

//        driver.findElement(By.xpath("/html/body/app-root/app-main-nav/main/app-login/mat-card/mat-card-actions/button")).click();
//
//        System.out.println("Mi smo carevi");
//        Thread.sleep(5000);
        //Closing the browser
        driver.quit();
        System.out.println("This step click on the Reset button."); // use logger library for logging
    }

}
