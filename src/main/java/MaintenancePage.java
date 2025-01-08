import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MaintenancePage {
    private SelenideElement maintenanceAdminPassword = $("[type=\"password\"]");
    private SelenideElement confirmButton = $("[type=\"submit\"]");
    private SelenideElement headerMaintance = $(".oxd-topbar-header-breadcrumb");
    private SelenideElement errorText = $("[class=\"oxd-form\"]");
    private SelenideElement errorTextPasswordEmpty = $ (".oxd-input-field-error-message");


    public void inputAdminPassword (String adminPassword){
        maintenanceAdminPassword.setValue(adminPassword);
    }
    public void clickConfirmButton (){
        confirmButton.click();
    }
    public void headerMaintanceText (String headerText){
        headerMaintance.shouldHave(text(headerText));
    }

    public void errorTextAreCorrect(String expectedMessage) {
        errorText.shouldBe(text(expectedMessage));
    }

    public void errorTextPasswordEmpty(String expectedMessage){
        errorTextPasswordEmpty.shouldBe(text(expectedMessage));
    }
}
