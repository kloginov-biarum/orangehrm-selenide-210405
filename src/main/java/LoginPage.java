import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

   private SelenideElement usernameInputFiled =  $("[name=\"username\"]");

   public void enterUsername(String usernameValue){
         usernameInputFiled.setValue(usernameValue);
   }

   private SelenideElement passwordInputField = $("[name=\"password\"]");
   public void enterPassword(String passwordValue){
         passwordInputField.setValue(passwordValue);
   }

    private SelenideElement loginButton = $("[type=\"submit\"]");

    public void clickOnLoginButton(){
        loginButton.click();
    }

    private SelenideElement alertContentText =   $(".oxd-alert-content-text");

    public void checkAlertContentText (String expectedAlertContentText){
        alertContentText.shouldHave(text(expectedAlertContentText));}

}
