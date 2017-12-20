package pages;

import base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import java.util.List;
import org.openqa.selenium.By;
import java.util.stream.Collectors;

public class Search {
    private BaseUtil base;

    public Search(BaseUtil base) {
        this.base = base;
    }

    public Search(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how = How.XPATH, using = "//img[@class=\"brand_logo\"]")
    private WebElement logo;

    public void isLogoPresent() {
        try {
            logo.isDisplayed();
        } catch (Exception e) {
            System.out.println("Логотип не найден");
        }
    }

    @FindAll({@FindBy(how = How.XPATH, using = "//div/nav/a")})
    private List<WebElement> navigationElements;

    public List<String> getNavigationElementLabels() {
        return navigationElements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @FindBy(how = How.XPATH, using = "//div/a[@id=\"pop_up\"]")
    private WebElement callOrderButtonLabel;

    public boolean isButtonLabelValid(String label) {
        return callOrderButtonLabel.getText().equals(label);
    }

    @FindBy(how = How.XPATH, using = "//h1[text()='творчество начинается здесь!']")
    private WebElement textArea;

    public void isTextEquals(String title){
        textArea.findElement(By.xpath("//h1[text()='" + title + "']"));
    }

    @FindBy(how = How.XPATH, using = "//select")
    private List<WebElement> fieldsDropDown;

    public List<String> fieldsDropDownArePresent() {
        return fieldsDropDown
                .stream()
                .map(w -> w.getAttribute("placeholder"))
                .collect(Collectors.toList());
    }

    @FindBy(how = How.XPATH, using = "//select[@name=\"search\"]/option")
    private List<WebElement> dropDownTownElements;
    @FindBy(how = How.XPATH, using = "//select[@id='search']")
    private WebElement fieldDropDownTown;

    public void fieldDropDownTownClick() {
        fieldDropDownTown.click();
    }

    public List<String> getDropDownTownElements() {
        return dropDownTownElements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String dropdownListResultTownClick() {
        return dropDownTownElements.get(4).getText();
    }

    public void choiceSelectedTownClick() {
        dropDownTownElements.get(4).click();
    }

    public void verifyReflectedTown() {
        fieldDropDownTown.getText().contains(dropDownTownElements.get(4).getText());
    }


    @FindBy(how = How.XPATH, using = "//select[@name=\"direction\"]/option")
    private List<WebElement> dropDownDirectionElements;
    @FindBy(how = How.XPATH, using = "//select[@id='field']")
    private WebElement fieldDropDownDirection;

    public void fieldDropDownDirectionClick() {
        fieldDropDownDirection.click();
    }

    public List<String> getDropDownDirectionElements() {
        return dropDownDirectionElements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String dropdownListResultDirectionClick() {
        return dropDownDirectionElements.get(1).getText();
    }

    public void choiceSelectedDirectionClick() {
        dropDownDirectionElements.get(1).click();
    }

    public void verifyReflectedDirection() {
        fieldDropDownDirection.getText()
                .contains(dropDownDirectionElements.get(1)
                        .getText());
    }

    @FindBy(how = How.XPATH, using = "//input[@name=\"date_to\"]")
    private WebElement fieldDate;

    public boolean fieldDropDownCalendarIsDisplayed(String fieldDates) {
        return fieldDate.getText().equals(fieldDates);
    }

    @FindBy(how = How.XPATH, using = "//div[@id=\"ui-datepicker-div\"]")
    private WebElement dropDownCalendar;

    public void isDropDownCalendarPresent() {
        fieldDate.click();
        try {
            dropDownCalendar.isDisplayed();
        } catch (Exception e) {
            System.out.println("Выпадающий календарь не найден");
        }
    }

    public void fieldDropCalendarClick() {
        fieldDate.click();
    }

    public void searchDateInput(String searchDate) {
        fieldDate.clear();
        fieldDate.sendKeys(searchDate);
    }

    public String getEnteredDate() {
        return fieldDate.getText();
    }

    public void inputDate(String value){
        fieldDate.clear();
        fieldDate.sendKeys(value);
    }

    @FindBy(how = How.XPATH, using = "//input[@value='Найти']")
    private WebElement buttonEnter;

    public void buttonEnterClick(String name){
        buttonEnter.findElement(By.xpath("//input[@value='" + name + "']"));
        buttonEnter.click();
    }
    //td[text()="10"]

/*
    @FindBy(how = How.XPATH, using = "//input[@value='Найти']")
    @FindBy(how = How.XPATH, using = "//input[@value='Подобрать']")
    private WebElement button;

    public void buttonClick(String name){
        button.findElement(By.xpath("//input[@value='" + name + "']"));
        button.click();
    }
    */
}
