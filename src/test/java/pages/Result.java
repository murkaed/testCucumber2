package pages;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class Result {
    private BaseUtil base;

    public Result(BaseUtil base) {
        this.base = base;
    }

    public Result(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }


    @FindBy(how = How.XPATH, using = "//input[@name=\"date_to\"]")
    private WebElement fieldDateResultPage;

    public String getDateResultPage() {
        return fieldDateResultPage.getText();
    }

    @FindBy(how = How.XPATH, using = "//input[@name='word']")
    private WebElement directionField;

    public void enterDirection(String direction) {
        directionField.clear();
        directionField.sendKeys(direction);
    }

    @FindBy(how = How.XPATH, using = "//input[@value='Подобрать']")
    private WebElement findButton;

    public void findButton(String name) {
        findButton.findElement(By.xpath("//input[@value='" + name + "']"));
        findButton.click();
    }

}
