package pages;

import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class DolgPage {

    private BaseUtil base;

    public DolgPage(BaseUtil base) {
        this.base = base;
    }

    public DolgPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }
    @FindBy(how = How.XPATH,using = "//div[4]/div[2]/select")
    private WebElement selectField;
    @FindBy(how = How.XPATH,using = "//div[4]/div[2]/select/option[@value=\"7\"]")
    private WebElement select;
    @FindBy(how = How.XPATH,using = "//div[4]/div[2]/select/option[@value=\"9\"]")
    private WebElement select2;



    public void selectSS(String arg)
    {
        WebElement al;

        if(arg.equals("Ссудная и приравненная к ней задолженность")){
            al=select2;
        }
        else
            al = select;


        selectField.click();
        al.click();

    }

    public void pressButton(){
        select.click();
    }



}
