package TestCases;

import Pages.SwagLabs.LoginPage;
import Pages.SwagLabs.ProductPage;
import Utility.ExcelUtils;
import org.testng.annotations.*;

import java.io.IOException;

public class RegressionExcelTest extends BaseTest {


    public LoginPage login;
    public ProductPage productpage;

    @BeforeClass
    public void pageinit(){

        login=new LoginPage();
        productpage=new ProductPage();

    }



    /*
    When we are using the dataprovider the before method will run for each testdata
    the testng will treat each testdata as the seprate method so the before method will
    run for the each testdata.

   This is basically improtant to remember

    */


    @Test(dataProvider = "logintestdata")
    public void ExcelRegression(String username, String passwoed){

        login.loginToApplication(username, passwoed);
    }


    @DataProvider
    public Object[][] logintestdata() throws IOException {

        ExcelUtils excel=new ExcelUtils("C:\\Users\\UjjwalShrivastava\\IdeaProjects\\SwagLabs\\src\\test\\java\\Utility\\ExcelUsers.xlsx");
        int rows=excel.getnorows();
        int cols=excel.getlastcell();
        Object[][] data=new Object[rows][cols];
        for(int i=0;i<=rows-1;i++){
            for(int j=0;j<=cols-1;j++){

              data[i][j]  =excel.readExcelData(i,j);
            }
        }

        return data;
    }


   @AfterMethod
    public void logout(){

        productpage.closemenu();
        productpage.logout();
    }






}
