package pages;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ActivData {
    private BaseUtil base;


    public ActivData(BaseUtil base) {
        this.base = base;
    }

    public ActivData (WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }
    @FindBy (how = How.XPATH,using = "//div[4]/div/select")
    private WebElement select;

    @FindBy (how = How.XPATH,using = "//select/option[24]")
    private WebElement selectString;

    public void selectMoney(){
        select.click();
        selectString.click();

    }

    @FindBy (how = How.XPATH,using = "//input[@name = \"balanceInitial\"]")
    private WebElement input1;

    @FindBy (how = How.XPATH,using = "//input[@name = \"balanceRur\"]")
    private WebElement input2;

    public boolean srav(){
        return input1.getText().equals(input2.getText());
    }

    @FindBy (how=How.XPATH,using = "//div[2]/ul[@id]/li[2]/a")
    private WebElement buttonPriem;

    public void pressButtonPriem(){
        buttonPriem.click();
    }

    @FindBy (how=How.XPATH,using = "//input[@name=\"loanDebt_contract\"]/following-sibling::*/button")
    private WebElement dogovorButton;

    public void pressDogovorButton(){
        dogovorButton.click();
    }







}

