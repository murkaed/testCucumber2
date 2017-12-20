package helper;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommandSteps {

    public static void pressButton(String button, BaseUtil baseUtil ) throws InterruptedException {
        WebElement element = baseUtil.driver.findElement(By.xpath("//self::node()[text()='"+button+"']"));
        element.click();
        Thread.sleep(2000);
    }

    public static void enterData(String name, String data, BaseUtil baseUtil){
        WebElement element = baseUtil.driver.findElement(By.xpath("//input[@name='"+name+"']"));
        element.click();
        element.sendKeys(data.toString());

    }
}
