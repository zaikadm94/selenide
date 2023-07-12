import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideTest {


    @BeforeEach
    void setup() {
        open("http://localhost:9999/");

    }


    @Test
    void shouldTest() {
        $("[data-test-id=name] input").setValue("Дмитрий Иванов");
        $("[data-test-id=phone] input").setValue("+79204544567");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }


    @Test
    void invalidNameTest() {
        $("[data-test-id=name] input").setValue("Дмитрий Ivanov");
        $("[data-test-id=phone] input").setValue("+79204544567");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }


    @Test
    void invalidPhoneTest() {
        $("[data-test-id=name] input").setValue("Дмитрий Иванов");
        $("[data-test-id=phone] input").setValue("+7920454456");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void invalidCheckBoxTest() {
        $("[data-test-id=name] input").setValue("Дмитрий Иванов");
        $("[data-test-id=phone] input").setValue("+79204544567");
        $("[type=button]").click();
        $("[data-test-id=agreement].input_invalid .checkbox__text").shouldBe(visible);
    }

    @Test
    void nameFieldIsEmptyTest() {
        $("[data-test-id=name] input").setValue("");
        $("[data-test-id=phone] input").setValue("+79204544567");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }


    @Test
    void phoneFieldIsEmptyTest() {
        $("[data-test-id=name] input").setValue("Дмитрий Иванов");
        $("[data-test-id=phone] input").setValue("");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }
}



