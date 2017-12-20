package pages;

import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PlanSchetovPage {

    private BaseUtil base;


    public PlanSchetovPage(BaseUtil base) {
        this.base = base;
    }

    public PlanSchetovPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how= How.XPATH,using="//div[@class =\"ui-pg-div\"]/span")
    private WebElement searchButton;

    @FindBy(how= How.XPATH,using="//td/select")
    private WebElement searchSelect1;

    @FindBy(how= How.XPATH,using="//td/select/option[@value = \"parentBalanceAccountNum\"]")
    private WebElement searchCell1;

    @FindBy(how= How.XPATH,using="//td[@class = \"operators\"]/select")
    private WebElement searchSelect2;

    @FindBy(how= How.XPATH,using="//td[@class = \"operators\"]/select/option[4]")
    private WebElement searchCell2;

    @FindBy(how= How.XPATH,using="//td[@class = \"data\"]/input")
    private WebElement input;

    @FindBy(how= How.XPATH,using="//td[2]/a")
    private WebElement button;

    @FindBy(how= How.XPATH,using="//table[@id=\"accountplancogrid\"]")
    private WebElement cellProv;



    public void search(String a){
        searchButton.click();
        searchSelect1.click();
        searchCell1.click();
        searchSelect2.click();
        searchCell2.click();
        input.click();
        input.clear();
        input.sendKeys(a);
        button.click();

    }

    public boolean prov(){
        return cellProv.isDisplayed();
    }




}

