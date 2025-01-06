import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private SelenideElement header = $(".oxd-topbar-header-breadcrumb-module");

    public void checkHeader(String expectedHeaderText){
        header.shouldHave(text(expectedHeaderText));
    }

}
