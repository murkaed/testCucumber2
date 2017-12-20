package pages;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ActivPage {

    LinkedList<String> listName = new LinkedList<String>();


    private BaseUtil base;

    public ActivPage(BaseUtil base) {
        this.base = base;
    }

    public ActivPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how = How.XPATH, using = "//ul/li/a")
    private WebElement button;

    @FindBy(how = How.XPATH, using = "//li/ul/li/a")
    private WebElement innerButton;

    @FindBy(how = How.XPATH, using = "//ol/li")
    private WebElement titlepage;


    public String getTitlepage() {
        return titlepage.getText();
    }

    public void pressButton() {
        button.click();
        innerButton.click();
    }


    @FindAll({@FindBy(how = How.XPATH, using = "//ul[@id=\"myTab\"]/li/a")})
    List<WebElement> xp13;
    public List<String> getNavigationElementLabels() {
        return xp13
                .stream()
                .limit(13)
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    public LinkedList<String> getListName() {
        LinkedList<String> dom = new LinkedList();

        for (WebElement s : xp13) {
            System.out.println(s.getText());
            dom.add(s.getText());
        }


        // listName.add(base.driver.findElement(By.xpath("//ul[@id=\"myTab\"]/li[1]/a")).getText());


        // for (int i = 0; i < 14; i++) {
        //  String st = "(//ul[@id=\"myTab\"]/li[" + i + "]/a)";


        //         String st = "//ul[@id=\"myTab\"]/li[3]/a";
        //        listName.add(base.driver.findElement(By.xpath(st)).getText());
        //        System.out.println(listName.get(i));

        return dom;
    }

    @FindBy (how = How.XPATH,using = "//ul[@class=\"nav navbar-nav\"]/li[3]/a")
    private WebElement nastrButton;

    @FindBy (how = How.XPATH,using = "//ul[@class=\"nav navbar-nav\"]/li[3]/ul/li[9]/a")
    private WebElement sprButton;

    public void pressSpr() throws InterruptedException {
        nastrButton.click();
        Thread.sleep(2000);
        sprButton.click();
    }




}
