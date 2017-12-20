package pages;

import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SprList {
    private BaseUtil base;

    public SprList(BaseUtil base) {
        this.base = base;
    }

    public SprList(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how= How.XPATH,using="//*[@id=\"10\"]/td[2]/a")
    private WebElement searchCell;

    public void pressCell() throws InterruptedException {
        Thread.sleep(3000);
        searchCell.click();
        Thread.sleep(3000);
    }

}
