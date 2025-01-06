import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LinkedInPage {
    private SelenideElement textHeader = $(".contextual-sign-in-modal__join-now");
    public void textHeaderIsDisplayed (String validText){
        textHeader.shouldHave(text(validText));

    }
}
