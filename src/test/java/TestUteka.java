import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CartPage;
import pages.MainPage;
import pages.ProductPage;

public class TestUteka extends TestBase {

    MainPage main = new MainPage();
    ProductPage product = new ProductPage();
    CartPage cart = new CartPage();


    @Test
    @Tag("BLOCKER")
    @DisplayName("На главной странице отображаются поиск,кнопка авторизации,корзина")
    public void existMainElements() {
        main.existSearch();//проверяем наличие формы поиска
        main.existEnter();//проверяем наличие кнопки авторизации
        main.existCart();//проверяем наличие корзины
    }


    @ValueSource(strings = {
            "Косметика",
            "Ортопедия",
            "Оптика"
    })
    @Tag("NORMAL")
    @ParameterizedTest(name = "При наведении на раздел {0} отображаются хиты продаж")
    public void chapterHasBestsellers(String chapter) {
        main.checkChapter(chapter); //наводим на раздел и проверяем в нём наличие хитов продаж
    }


    @Test
    @Tag("BLOCKER")
    @DisplayName("Название найденного товара совпадает с его названием в карточке.")
    public void nameMatchCard() {
        main.searchProducts();//ищем и выбираем товар
        product.checkNameProduct();//проверяем,что название найденного товара совпадает с его названием в карточке
    }


    @Test
    @Tags({@Tag("BLOCKER"), @Tag("REGRESS")})
    @DisplayName("Выбранный товар добавляется в корзину.")
    public void changeInsideSubmit() {
        main.searchProducts();//ищем и выбираем товар
        product.submitCart(); //добавляем товар в корзину
        product.openCart();//переходим в корзину
        cart.checkAddProduct();//проверяем ,что товар добавился в корзину с соответствующим названием
    }


    @Test
    @Tags({@Tag("NORMAL"), @Tag("REGRESS")})
    @DisplayName("Товар удаляется с корзины.")
    public void deleteProduct() {
        main.searchProducts();//ищем и выбираем товар
        product.submitCart(); //добавляем товар в корзину
        product.openCart();//переходим в корзину
        cart.deleteProducts();//удаляем товар и проверяем что корзина пустая
    }

}
