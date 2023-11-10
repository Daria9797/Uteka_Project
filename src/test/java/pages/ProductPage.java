package pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    MainPage main=new MainPage();
    SelenideElement titleProduct=$(".product-page-card__title h1"),
    subCart= $(byAttribute("data-test", "buy-button")),
    infoSubCart=$(byAttribute("data-test", "to-cart-button"));

    public void checkNameProduct(){
        titleProduct.shouldHave(ownText(main.nameProduct),visible);
    }

    public void submitCart(){
         subCart.click();
    }

    public void openCart(){
        infoSubCart.click();
    }

}
