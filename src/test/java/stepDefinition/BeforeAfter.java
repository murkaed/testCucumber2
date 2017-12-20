package stepDefinition;

import base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import pages.*;


public class BeforeAfter extends BaseUtil {
    public static Search page;
    public static Result resultPage;
    public static LoginPage loginPage;
    public static SelectFinOrgPage selectFinOrgPage;
    public static DolgPage dolgPage;
    public static ActivPage activPage;
    public static ActivData activData;
    public static ActivpagePriem activpagePriem;
    public static SearchPage searchPage;
    public static SprList sprList;
    public static PlanSchetovPage planSchetovPage;


    public static String ORGANIZATION = "10";


    private BaseUtil base;

    public BeforeAfter(BaseUtil base) {

        this.base = base;
    }

    @Before
    public void InitializeTest() {
        //  System.setProperty("webdriver.ie.driver",
        //  "C:\\Users\\user\\Desktop\\MS_Projects\\support\\IE_Server_32\\IEDriverServer.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Documents\\max\\chromedriver.exe");
        // base.driver = new InternetExplorerDriver();
        base.driver = new ChromeDriver();
        base.driver.manage().window().maximize();
        page = new Search(base.driver);
        resultPage = new Result(base.driver);
        loginPage = new LoginPage(base.driver);
        selectFinOrgPage = new SelectFinOrgPage(base.driver);
        dolgPage = new DolgPage(base.driver);
        activPage = new ActivPage(base.driver);
        activData = new ActivData(base.driver);
        activpagePriem = new ActivpagePriem(base.driver);
        searchPage = new SearchPage(base.driver);
        sprList = new SprList(base.driver);
        planSchetovPage = new PlanSchetovPage(base.driver);
    }

   //   @After
    // public void TearDownTest() {
   //     base.driver.quit();
   //     Reporter.log("Browser closed", true);
   // }

}
