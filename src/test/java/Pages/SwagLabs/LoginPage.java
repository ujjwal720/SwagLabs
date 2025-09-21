package Pages.SwagLabs;

import Pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "user-name")
    public WebElement usrname;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement productcart;

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public void loginToApplication(String user, String pass){
        sendKeys(usrname,user);
        sendKeys(password,pass);
        loginButton.click();
        logger.debug("The following username has been logged in"+""+user);

    }





}
