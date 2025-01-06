import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.*;


public class LoginTest {

    @BeforeEach
    public void setUo(){
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

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



}
