package Pages.SwagLabs;

import Pages.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    public ProductPage(){

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a")
   public WebElement addtocart;

    @FindBy(xpath = "//button[text()='Open Menu']")
    public WebElement closemenu;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logout;

    @FindBy(xpath = "//a[@class='btn_action checkout_button']")
    public WebElement cont;

    private static final Logger logger = LogManager.getLogger(ProductPage.class);

    public void selectProduct(String text){
        WebElement ele=driver.findElement(By.xpath("//div[text()='" + text + "']//following::div[2]/button"));
        ele.click();
        logger.debug("The Product has been selected"+" "+text);

    }

    public void addtoCart(){
        addtocart.click();
        logger.debug("The Product is added to n cart");
    }

    public void closemenu(){
        closemenu.click();
    }

    public void logout(){
        logout.click();
    }

    public void clickContinue(){
        cont.click();
        logger.debug("Click on the Continue button");
    }





}
