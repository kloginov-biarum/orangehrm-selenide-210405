import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private SelenideElement header = $(".oxd-topbar-header-breadcrumb-module");

    public void checkHeader(String expectedHeaderText){
        header.shouldHave(text(expectedHeaderText));
    }

    private SelenideElement dropdownMenu = $(".oxd-userdropdown-icon");
    private SelenideElement logout = $(".oxd-dropdown-menu li:last-child");

    public void clickOnDropdownMenu(){
        dropdownMenu.shouldBe(Condition.visible, Duration.ofSeconds(15));
        dropdownMenu.click();
    }
    public void clickOnLogout(){
        logout.shouldBe(Condition.visible).click();
    }

}
