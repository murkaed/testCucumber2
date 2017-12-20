package pages;

import base.BaseUtil;
import helper.CommandSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
    private BaseUtil base;


    public SearchPage(BaseUtil base) {
        this.base = base;
    }

    public SearchPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy (how = How.XPATH,using = "//td[@title=\"Поиск\"]")
    private WebElement searchButton;

    public void pressSearch(){
        searchButton.click();
    }

    @FindBy(how = How.XPATH,using = "//td[2]/select")
    private WebElement srlrctnum;
    @FindBy(how = How.XPATH,using = "//td/select/option[3]")
    private WebElement selectString;
    @FindBy(how = How.XPATH,using = "//input[@id]")
    private WebElement input;
    @FindBy(how = How.XPATH,using = "//a[@id=\"fbox_assetgrid_search\"]")
    private WebElement buttonSearch;


    public void selectNumber() throws InterruptedException {
        srlrctnum.click();
        selectString.click();
        input.click();
        input.clear();
        input.sendKeys("61401H43848484848484");
        buttonSearch.click();
        Thread.sleep(9000);

    }
    @FindBy(how = How.XPATH,using = "//input[@name=\"checkCell\"]")
    private WebElement checkbox;

    public void selectString() throws InterruptedException {
        checkbox.click();

    }
    @FindBy(how = How.XPATH,using = "//button[5]")
    private WebElement delete;

    public void deleteString(){
        delete.click();

    }

    @FindBy(how = How.XPATH,using = "//div[@class=\"modal-footer ng-scope\"]/button[1]")
    private WebElement deleteButton;

    public void deleteUtv(){
        deleteButton.click();
    }


}
