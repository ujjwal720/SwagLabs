package TestCases;

import Pages.ApplicationNavigation;
import Pages.SwagLabsPageAggregator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class RegressionTestCase02 extends BaseTest {

    public SwagLabsPageAggregator swagLabsPageAggregator;
    public SoftAssert softAssert;
    public ApplicationNavigation applicatenavigate;


    @BeforeClass
    public void pageInit(){
        applicatenavigate=new ApplicationNavigation();
        swagLabsPageAggregator= new SwagLabsPageAggregator();
        softAssert=new SoftAssert();
    }


    @Test(description = "To Test End to End flow for the Websiteddd")
    public void Test02() throws InterruptedException {
        applicatenavigate.navigateToSwagLabsSite("QA");
        swagLabsPageAggregator.login.loginToApplication("standard_user","secret_sauce");
        swagLabsPageAggregator.productPage.selectProduct("Sauce Labs Backpack");
        swagLabsPageAggregator.productPage.addtoCart();
        swagLabsPageAggregator.productPage.clickContinue();
        swagLabsPageAggregator.checkout.setUpCheckOutInfo("Ujjwal","Shrivastava","396210");
        softAssert.assertEquals(swagLabsPageAggregator.finsh.getCheckoutMessage(),"HANK YOU FOR YOUR ORDER");
        softAssert.assertAll();
    }
}
