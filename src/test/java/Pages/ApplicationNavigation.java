package Pages;

public class ApplicationNavigation extends BasePage {

    private static final String SWAG_QA_URL="https://www.saucedemo.com/v1/";

    private static final String SWAG_PROD_URL="https://www.saucedemoprod.com/";


    public void navigateToSwagLabsSite(String enviroment){

        if(enviroment=="QA"){

            driver.get(SWAG_QA_URL);
        }

        else{

            driver.get(SWAG_PROD_URL);
        }

    }








}
