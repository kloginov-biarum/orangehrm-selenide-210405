import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v85.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.*;


public class LoginTest extends BaseTest{




    @Test
    public void successLogin()  {
        $("[name=\"username\"]").shouldBe(visible, ofSeconds(10)).setValue("Admin");
        $("[name=\"password\"]").setValue("admin123");
        $(".orangehrm-login-button").click();
        $(".oxd-topbar-header-breadcrumb-module")
                .shouldBe(visible, ofSeconds(10))
                .shouldHave(text("Dashboard"));
        //Check that Upgrade button is displayed and has a text "Upgrade"
        $(".orangehrm-upgrade-button").shouldBe(visible, ofSeconds(10)).shouldHave(text("Upgrade"));
    }

    @Test
    public void successLoginWithPO(){
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.checkHeader("Dashboard");
    }


    @Test
    public void invalidPassword() {
        LoginPage loginPage = new LoginPage();
        //1. Enter valid username "Admin"
        loginPage.enterUsername("Admin");
        //2. Enter invalid password "admin"
        loginPage.enterPassword("admin");
        //3. Click on the login button
        loginPage.clickOnLoginButton();
        //4. Check that error message is displayed with text "Invalid credentials"
        loginPage.checkAlertContentText("Invalid credentials");
    }


    //
    @Test
    public void forgotPasswordTest(){
        //Follow the link Forgot your password?
        $(".orangehrm-login-forgot-header").click();
        //Check that username inout field is displayed
        $("[name=\"username\"]").shouldBe(visible);
        //Header with text "Reset Password" is displayed
        $(".orangehrm-forgot-password-title").shouldHave(text("Reset Password"));
        //Reset password button is displayed
        $(".oxd-button--secondary").shouldBe(visible);
    }

    @Test
    public void forgotPasswordTestWithPO() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnForgotYourPasswordLink();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        resetPasswordPage.usernameInputFieldIsDisplayed();
        //Header with text "Reset Password" is displayed
        resetPasswordPage.resetPasswordMessage("Reset Password");
        //Reset password button is displayed
        resetPasswordPage.resetPasswordButtonIsDisplayed();
    }


    @Test
    public void logoutTest(){
        //Login with valid credentials
        $("[name=\"username\"]").setValue("Admin");
        $("[name=\"password\"]").setValue("admin123");
        $(".orangehrm-login-button").click();
        //Click on the user icon dropdown
        $(".oxd-userdropdown-icon").shouldBe(visible, ofSeconds(10)).click();
        //Click on the Logout button
        $("[role=\"menu\"] li:last-child").click();
        //Check that the user is redirected to the login page
        $(".orangehrm-login-title").shouldBe(visible, ofSeconds(10)).shouldHave(text("Login"));
    }

    @Test
    public void logoutTestWithPO(){
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.clickOnDropdownMenu();
        dashboardPage.clickOnLogout();
        loginPage.loginTitleText("Login");
    }

    @Test
    public void allLinksAreDisplayed(){
        LoginPage loginPage = new LoginPage();
        //LinkedIn
        loginPage.linkLinkedinIsDisplayed();
        //Facebook
        loginPage.linkFacebookIsDisplayed();
        //X (Twitter)
        loginPage.linkTwitterIsDisplayed();
        //Youtube
        loginPage.linkYoutubeIsDisplayed();
    }

    @Test
    public void linkedInLinkISCorrect() {
        LoginPage loginPage = new LoginPage();
        //Follow the LinkedIn link
        loginPage.clickLinkLinkedin();
        //Check that "LinkedIn" text contains on the page
        LinkedInPage linkedInPage = new LinkedInPage();
        switchTo().window(1);
        linkedInPage.textHeaderIsDisplayed("LinkedIn");
    }

    @Test
    public void logoIsDisplayed(){
        LoginPage loginPage = new LoginPage();
        loginPage.logoIsDisplayed();
        loginPage.logoIsCorrect();
    }

}
