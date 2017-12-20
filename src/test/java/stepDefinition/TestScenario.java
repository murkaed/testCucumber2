package stepDefinition;

import base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.ru.Дано;
import helper.CommandSteps;
import org.junit.Assert;
import pages.SelectFinOrgPage;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static stepDefinition.BeforeAfter.*;


public class TestScenario extends BaseUtil {


    private BaseUtil base;

    public TestScenario(BaseUtil base) {
        this.base = base;
    }

    @Дано("^пользователь открывает сайт$")
    public void openApp() throws Throwable {
        base.driver.navigate().to("http://172.26.25.86:8081/sua/login");
     //   System.out.println("открыть сайт");
    }

    @Дано("^пользователь вводит валидные \"([^\"]*)\" и \"([^\"]*)\"$")
    public void пользователь_вводит_валидные_и(String login, String password) throws Throwable {
        loginPage.inputData(login, password);

    }

    @Дано("^пользователь нажимает кнопку \"([^\"]*)\"$")
    public void пользователь_нажимает_кнопку(String arg1) throws Throwable {
        CommandSteps.pressButton(arg1, base);
    }

    @Дано("^пользователь выбирает ФО типа \"([^\"]*)\"$")
    public void пользователь_выбирает_ФО_типа(String arg1) throws Throwable {
        selectFinOrgPage.switchFocusOnModal();
        selectFinOrgPage.findAndSelectOrganization(BeforeAfter.ORGANIZATION);
        //selectFinOrgPage.viborOrg();
    }

    @Дано("^пользователь проверяет наличие счета (\\d+) порядка с номером \"([^\"]*)\"$")
    public void пользователь_проверяет_наличие_счета_порядка_с_номером(int arg1, String arg2) throws Throwable {

    activPage.pressSpr();
    sprList.pressCell();

    planSchetovPage.search(arg2);
    Assert.assertTrue(planSchetovPage.prov());
    }

    @Дано("^пользователь проверяет наличие надписи \"([^\"]*)\"$")
    public void пользователь_проверяет_наличие_надписи(String arg1) throws Throwable {
        boolean actual = activPage.getTitlepage().equals(arg1);
        assertTrue(actual);
    }

    @Дано("^пользователь нажимает кнопку \"([^\"]*)\" и выбирает создание актива$")
    public void пользователь_нажимает_кнопку_и_выбирает_создание_актива(String arg1) throws Throwable {
        activPage.pressButton();
    }

    @Дано("^пользователь выбирает в выпадающем списке \"([^\"]*)\"$")
    public void пользователь_выбирает_в_выпадающем_списке(String arg1) throws Throwable {
        dolgPage.selectSS(arg1);
    }

    @Дано("^пользователь нажимает на кнопку \"([^\"]*)\"$")
    public void пользователь_нажимает_на_кнопку(String arg1) throws Throwable {
        dolgPage.pressButton();
    }

    @Дано("^пользователь проверяет наличие необходимых закладок на форме \"([^\"]*)\"$")
    public void пользователь_проверяет_наличие_необходимых_закладок_на_форме(String arg1, DataTable arg2) throws Throwable {
        List<String> list =arg2.asList(String.class);

     //   boolean act = list.equals(activPage.getListName());
        boolean asd = list.equals(activPage.getNavigationElementLabels());
        assertTrue(asd);
        //assertTrue(act);

    }




    @Дано("^пользователь заполняет все необходимые поля валидными данными$")
    public void пользователь_заполняет_все_необходимые_поля_валидными_данными(DataTable arg1) throws Throwable {
        List<String> list = arg1.asList(String.class);
        CommandSteps.enterData("accountNum", list.get(0), base);
        CommandSteps.enterData("balanceInitial", list.get(1), base);
        CommandSteps.enterData("balanceInitialCur", list.get(2), base);
        CommandSteps.enterData("balanceCur", list.get(3), base);
        activData.selectMoney();
    }

    @Дано("^проверка на автозаполнение поля \"([^\"]*)\"$")
    public void проверка_на_автозаполнение_поля(String arg1) throws Throwable {
        Assert.assertTrue(activData.srav());
    }

    @Дано("^пользователь жмет кнопку \"([^\"]*)\"$")
    public void пользователь_жмет_кнопку(String arg1) throws Throwable {
        activData.pressDogovorButton();

    }

    @Дано("^пользователь заполняет дату в \"([^\"]*)\"$")
    public void пользователь_заполняет_дату_в(String arg1) throws Throwable {
        activpagePriem.pressInputData();
        activpagePriem.inputDataa();

    }

    @Дано("^пользователь нажимает на кнопочку \"([^\"]*)\"$")
    public void пользователь_нажимает_на_кнопочку(String arg1) throws Throwable {
        activData.pressButtonPriem();
    }

    @Дано("^пользователь кликает кнопку \"([^\"]*)\"$")
    public void пользователь_кликает_кнопку(String arg1) throws Throwable {
activpagePriem.pressSave();
    }

    @Дано("^пользователь проверяет наличие созданного актива$")
    public void пользователь_проверяет_наличие_созданного_актива() throws Throwable {
    searchPage.pressSearch();
    searchPage.selectNumber();
    }

    @Дано("^пользователь удаляет созданный актив$")
    public void пользователь_удаляет_созданный_актив() throws Throwable {
    searchPage.selectString();
    searchPage.deleteString();
    searchPage.deleteUtv();
    }



}
