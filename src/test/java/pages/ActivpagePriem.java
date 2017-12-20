package pages;

import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ActivpagePriem {
    private BaseUtil base;

    public ActivpagePriem(BaseUtil base) {
        this.base = base;
    }

    public ActivpagePriem (WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how= How.XPATH,using = "//input[@name=\"startDate\"]")
    private WebElement inputData;

    //WebElement inputData = base.driver.findElement(By.xpath("//input[@name=\"startDate\"]"));

    public void pressInputData() throws InterruptedException {
        Thread.sleep(3000);
        inputData.click();
        inputData.clear();
    }

    public void inputDataa(){
        inputData.sendKeys("18.12.2017");
    }

    @FindBy(how = How.XPATH,using = "//div[@class=\"row form-group\"]/div[@class=\"col-md-12\"]/button[@form]")
    private WebElement saveButton;
    public void pressSave() throws InterruptedException {
        saveButton.click();
        Thread.sleep(5000);
    }

}
