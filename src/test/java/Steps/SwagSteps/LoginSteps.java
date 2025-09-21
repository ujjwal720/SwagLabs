package Steps.SwagSteps;

import Pages.SwagLabs.LoginPage;
import Steps.BaseSteps;
import io.qameta.allure.Step;

public class LoginSteps extends BaseSteps {

    LoginPage login =new LoginPage();


    @Step("To login an application")
    public void LoginToApplication(String username, String pass){

         login.loginToApplication(username,pass);
         logMessageWithScreenshot("User has been succesfully logged in");
    }




}
