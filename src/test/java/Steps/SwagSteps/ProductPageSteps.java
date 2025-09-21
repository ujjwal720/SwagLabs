package Steps.SwagSteps;

import Pages.SwagLabs.ProductPage;
import Steps.BaseSteps;
import io.qameta.allure.Step;

public class ProductPageSteps extends BaseSteps {

    ProductPage productPage=new ProductPage();

    @Step("Add the Product of swag labs to the cart")
    public void addProductToCart(String product){
        productPage.selectProduct(product);
        productPage.addtoCart();
        productPage.clickContinue();
        logMessageWithScreenshot("The product has been added to the cart which is"+" "+ product);

    }
}
