package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import components.HeaderComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class MainPage {
    HeaderComponent header = new HeaderComponent();
    SelenideElement headerPromo = $("div.header-catalog-drop__promo");
    ElementsCollection nameHeader = $$(byAttribute("data-test", "ui-carousel-item"));
    public String nameProduct = " Мирамистин";

    public void existSearch() {
        header.fieldSearch.shouldBe(exist, visible);
    }

    public void existEnter() {
        header.fieldEnter.shouldBe(exist, visible);
    }

    public void existCart() {
        header.fieldCart.shouldBe(exist, visible);
    }

    public void checkChapter(String name) {
        nameHeader.findBy(text(name)).hover();
        headerPromo.shouldHave(text("Хиты продаж"));
    }

    public void searchProducts() {

        header.searchProduct(nameProduct);
    }

}
