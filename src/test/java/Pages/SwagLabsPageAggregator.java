package Pages;

import Pages.SwagLabs.Checkout;
import Pages.SwagLabs.FinishPage;
import Pages.SwagLabs.LoginPage;
import Pages.SwagLabs.ProductPage;

public class SwagLabsPageAggregator {

    public Checkout checkout;
    public ProductPage productPage;
    public LoginPage login;
    public FinishPage finsh;

    public SwagLabsPageAggregator(){
        checkout=new Checkout();
        productPage=new ProductPage();
        login=new LoginPage();
        finsh =new FinishPage();

    }

}
