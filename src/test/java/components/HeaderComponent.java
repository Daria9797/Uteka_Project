package components;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderComponent {

    public SelenideElement fieldSearch = $("#ui-search-input");
    public SelenideElement fieldEnter = $(By.linkText("Войти"));
    public SelenideElement fieldCart = $(By.linkText("Корзина")),
    resultSearch = $(".search-input__products a");

    public void searchProduct(String nameProduct) {
        fieldSearch.setValue(nameProduct);
        resultSearch.click();
    }


}
