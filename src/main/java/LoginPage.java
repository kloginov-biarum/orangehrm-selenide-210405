import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    private SelenideElement usernameInputFiled =  $("[name=\"username\"]");

   public void enterUsername(String usernameValue){
         usernameInputFiled.setValue(usernameValue);
   }

   private SelenideElement passwordInputField = $("[name=\"password\"]");
   public void enterPassword(String passwordValue){
         passwordInputField.setValue(passwordValue);
   }

   public void successLogin(String usernameValue, String passwordValue){
       enterUsername(usernameValue);
       enterPassword(passwordValue);
       clickOnLoginButton();
   }

    private SelenideElement loginButton = $("[type=\"submit\"]");

    public void clickOnLoginButton(){
        loginButton.click();
    }

    private SelenideElement alertContentText =   $(".oxd-alert-content-text");

    public void checkAlertContentText (String expectedAlertContentText){
        alertContentText.shouldHave(text(expectedAlertContentText));}

    private SelenideElement forgotYpuPasswordLink = $(".orangehrm-login-forgot-header");

    public void clickOnForgotYourPasswordLink(){
        forgotYpuPasswordLink.click();
    }

    private SelenideElement loginTitle = $(".orangehrm-login-title");

    public void loginTitleText(String loginTitlePage) {
        loginTitle.shouldHave(text(loginTitlePage));
    }


    private SelenideElement linkLinkedin = $("[href='https://www.linkedin.com/company/orangehrm/mycompany/']");

    public void linkLinkedinIsDisplayed() {
        linkLinkedin.shouldBe(visible);
    }

    private SelenideElement linkFacebook = $("[href='https://www.facebook.com/OrangeHRM/']");

    public void linkFacebookIsDisplayed() {
        linkFacebook.shouldBe(visible);
    }

    private SelenideElement linkTwitter = $("[href='https://twitter.com/orangehrm?lang=en']");

    public void linkTwitterIsDisplayed() {
        linkTwitter.shouldBe(visible);
    }

    private SelenideElement linkYoutube = $("[href='https://www.youtube.com/c/OrangeHRMInc']");

    public void linkYoutubeIsDisplayed() {
        linkYoutube.shouldBe(visible);
    }

    public void clickLinkLinkedin (){
        linkLinkedin.shouldBe(visible, Duration.ofSeconds(15));
        linkLinkedin.click();
    }

    private SelenideElement logo = $(byAttribute("alt","company-branding"));

    public void logoIsDisplayed() {
        logo.shouldBe(visible, Duration.ofSeconds(10));
    }


    public void logoIsCorrect(){
        logo.shouldHave(attributeMatching("src",".*ohrm_branding.png.*"));
    }


}
