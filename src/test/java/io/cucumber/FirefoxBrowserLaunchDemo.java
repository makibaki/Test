package io.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowserLaunchDemo {
    public static void main(String[] args) throws InterruptedException {

        //Creating a driver object referencing WebDriver interface
        WebDriver driver;

        //Setting webdriver.gecko.driver property
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mkojic\\Desktop\\geckodriver.exe");

        //Instantiating driver object and launching browser
        driver = new FirefoxDriver();

        //Using get() method to open a webpage
        driver.get("https://iris-price.smithmicro.io");
        Thread.sleep(1000);
        WebElement username = driver.findElement(By.id("mat-input-0"));
        username.sendKeys("smaric@smithmicro.com");

        WebElement password = driver.findElement(By.id("mat-input-1"));
        password.sendKeys("Berlineta1!");
        Thread.sleep(5000);

        WebElement loginbtn = driver.findElement(By.xpath("/html/body/app-root/app-main-nav/main/app-login/mat-card/mat-card-actions/button"));
        loginbtn.click();
        System.out.println("Mi smo carevi");
        Thread.sleep(5000);
        //Closing the browser
        driver.quit();

    }
}
