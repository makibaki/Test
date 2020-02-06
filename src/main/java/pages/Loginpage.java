package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

    @FindBy(how = How.ID, using = "mat-input-0")
    public WebElement userName;

    @FindBy(how = How.ID, using = "mat-input-1")
    public WebElement passWord;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/app-main-nav/main/app-login/mat-card/mat-card-actions/button")
    public WebElement loginBtn;

    public Loginpage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void Login (String username, String password){
        userName.sendKeys(username);
        passWord.sendKeys(password);
    }

    public void clickLogin (){
        loginBtn.click();
    }
}
