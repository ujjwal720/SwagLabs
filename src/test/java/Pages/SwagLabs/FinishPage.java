package Pages.SwagLabs;

import Pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishPage extends BasePage {

    public FinishPage(){

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//h2[@class='complete-header']")
    WebElement checkoutMessage;

    private static final Logger logger = LogManager.getLogger(FinishPage.class);

    public String getCheckoutMessage(){
        String message = getText(checkoutMessage);
         logger.debug("Thank you for your order");
        return message;
    }





}
