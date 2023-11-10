package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    MainPage main = new MainPage();
    SelenideElement titleCart = $(byAttribute("data-test", "title")),
            descriptionProduct = $(".cart-page-product-preview").$(byAttribute("data-test", "title")),
            submitDelete = $(byAttribute("data-test", "delete")),
            submitDeleteInPopap = $(".question-popup__actions").$(byText("Удалить")),
            afterDeleteText = $(byAttribute("data-test", "cart-empty"));

    public void checkAddProduct() {
        titleCart.shouldHave(text("В корзине 1 товар"), visible);
        descriptionProduct.shouldHave(ownText(main.nameProduct), visible);
    }

    public void deleteProducts() {
        submitDelete.click();
        submitDeleteInPopap.click();
        afterDeleteText.shouldHave(text("Ваша корзина пуста"));
    }


}
