package TestCases;

import Pages.ApplicationNavigation;
import Pages.SwagLabs.Checkout;
import Pages.SwagLabs.LoginPage;
import Pages.SwagLabs.ProductPage;
import Pages.SwagLabsPageAggregator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import profiles.BaseUserSwagLabs;

public class RegressionTestCase01 extends BaseTest{

   public SwagLabsPageAggregator swagLabsPageAggregator;
    public SoftAssert softAssert;
    public ApplicationNavigation applicatenavigate;
    public BaseUserSwagLabs testdata=new BaseUserSwagLabs() ;


    @BeforeClass
    public void pageInit(){
        applicatenavigate=new ApplicationNavigation();
        swagLabsPageAggregator= new SwagLabsPageAggregator();
        softAssert=new SoftAssert();

    }

    /*
    you can use it for creating the testdata
     */

    public RegressionTestCase01(){

        testdata.username="standard_user";
        testdata.password="secret_sauce";
        testdata.Products="Sauce Labs Backpack";

    }
    @Test(description = "To Test End to End flow for the Websiteddd")
    public void Test01() throws InterruptedException {
        applicatenavigate.navigateToSwagLabsSite("QA");
        swagLabsPageAggregator.login.loginToApplication(testdata.username,testdata.password);
        swagLabsPageAggregator.productPage.selectProduct(testdata.Products);
        swagLabsPageAggregator.productPage.addtoCart();
        swagLabsPageAggregator.productPage.clickContinue();
        swagLabsPageAggregator.checkout.setUpCheckOutInfo("Ujjwal","Shrivastava","396210");
        softAssert.assertEquals(swagLabsPageAggregator.finsh.getCheckoutMessage(),"THANK YOU FOR YOUR ORDER");
        softAssert.assertAll();
    }

    @Test()
    public void mains(){



    }




}
