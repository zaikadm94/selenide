import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideTest {



@Test
    void shouldTest () {

    open("http://localhost:9999/");
     $("[data-test-id=name] input").setValue("Дмитрий Иванов");
     $("[data-test-id=phone] input").setValue("+79204544567");
     $("[data-test-id=agreement]").click();
     $("[type=button]").click();
     $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }



    @Test
    void invalidInputTest () {

        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Дмитрий Ivanov");
        $("[data-test-id=phone] input").setValue("+79204544567");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input__sub").shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }
}



