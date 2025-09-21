package Pages.SwagLabs;

import Pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout extends BasePage {

    public Checkout(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@id='first-name']")
    public WebElement firstname;

    @FindBy(xpath="//input[@id='last-name']")
    public WebElement lastname;

    @FindBy(xpath="//input[@id='postal-code']")
    public WebElement zipcode;

    @FindBy(xpath="//input[@value='CONTINUE']")
    public WebElement continuebutton;

    @FindBy(xpath="//a[@class='btn_action cart_button']")
    public WebElement finishbtn;

    private static final Logger logger = LogManager.getLogger(Checkout.class);

    public void setUpCheckOutInfo(String first_name, String last_name, String zip_code){
             sendKeys(firstname,first_name);
             sendKeys(lastname,last_name);
             sendKeys(zipcode,zip_code);
             continuebutton.click();
             super.waitForElement(finishbtn);
             super.elementtoClickable(finishbtn);
             logger.debug("The checkout information has been entered with"+first_name+" "+last_name+" "+zip_code);

    }





}
