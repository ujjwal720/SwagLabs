package TestCases;

import Pages.ApplicationNavigation;
import Pages.SwagLabsPageAggregator;
import Steps.SwagSteps.LoginSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import profiles.BaseUserSwagLabs;

public class AllureTest extends BaseTest {

    public SwagLabsPageAggregator swagLabsPageAggregator;
    public SoftAssert softAssert;
    public ApplicationNavigation applicatenavigate;
    public BaseUserSwagLabs testdata=new BaseUserSwagLabs() ;
    public LoginSteps loginsteps;


    @BeforeClass
    public void pageInit(){
        applicatenavigate=new ApplicationNavigation();
        swagLabsPageAggregator= new SwagLabsPageAggregator();
        softAssert=new SoftAssert();
        loginsteps=new LoginSteps();

    }

    /*
    you can use it for creating the testdata
     */

    public AllureTest(){

        testdata.username="standard_user";
        testdata.password="secret_sauce";
        testdata.Products="Sauce Labs Backpack";
    }


    @Test(description = "To Test End to End flow for the Websiteddd")
    public void Test01() throws InterruptedException {
        applicatenavigate.navigateToSwagLabsSite("QA");
        Thread.sleep(3000);
        loginsteps.LoginToApplication(testdata.username, testdata.password);
        Thread.sleep(3000);
        softAssert.assertEquals("man","maz");
        Thread.sleep(3000);
        softAssert.assertAll();

    }
}
