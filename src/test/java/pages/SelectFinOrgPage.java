package pages;

import base.BaseUtil;
import helper.CommandSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SelectFinOrgPage {
    private BaseUtil base;

    public SelectFinOrgPage(BaseUtil base) {
        this.base = base;
    }

    public SelectFinOrgPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }


    @FindBy(how= How.XPATH,using="//div[contains(@class,'modal-dialog')]/descendant::input[contains(@ng-model,'searchStr')]")
    private WebElement searchField;
    @FindBy(how= How.XPATH,using="//div[contains(@class, 'modal-dialog')]/descendant::button[contains(text(),'Поиск')]")
    private WebElement submitButton;
    @FindBy(how= How.XPATH,using= "//div[contains(@class, 'modal-dialog')]/descendant::button[contains(text(),'Выбрать')]")
    private WebElement approveButton;
    @FindBy(how= How.XPATH,using="(//div[contains(@class,'modal-dialog')])[1]")
    private WebElement dialog;

    public void findAndSelectOrganization(String organization) throws InterruptedException {
        searchField.clear();
        searchField.sendKeys(organization);
        submitButton.click();
        approveButton.click();
        Thread.sleep(2000);
    }

    public void switchFocusOnModal() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dialog.click();
    }
    }



