package pages;

import base.BaseUtil;
import helper.CommandSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {


    private BaseUtil base;

    public LoginPage(BaseUtil base) {
        this.base = base;
    }
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }
    @FindBy (how = How.XPATH, using = "//self::node()[@id=\"username\"]")
    private WebElement loginInput;

    @FindBy (how = How.XPATH, using = "//self::node()[@id=\"password\"]")
    private WebElement passInput;

    public void inputData(String login, String pass){
        loginInput.clear();
        loginInput.sendKeys(login);
        passInput.clear();
        passInput.sendKeys(pass);
    }


}
