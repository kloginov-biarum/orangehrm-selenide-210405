import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class ResetPasswordPage {

    private SelenideElement usernameInputField = $("[name=\"username\"]");

    public void usernameInputFieldIsDisplayed(){
        usernameInputField.shouldBe(Condition.visible, Duration.ofSeconds(6));
    }

    private SelenideElement resetPasswordHeader = $("h6");
    private SelenideElement resetPasswordButton = $(".oxd-button:nth-child(2)");

    public void resetPasswordMessage(String resetPasswordValue) {
        resetPasswordHeader.shouldHave(Condition.text(resetPasswordValue));
    }
    public void resetPasswordButtonIsDisplayed() {
        resetPasswordButton.shouldBe(Condition.visible);
    }

}
