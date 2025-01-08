import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MaintenancePage {
    private SelenideElement maintenanceAdminPassword = $("[type=\"password\"]");
    private SelenideElement confirmButton = $("[type=\"submit\"]");
    private SelenideElement headerMaintance = $(".oxd-topbar-header-breadcrumb");



    public void inputAdminPassword (String adminPassword){
        maintenanceAdminPassword.setValue(adminPassword);
    }
    public void clickConfirmButton (){
        confirmButton.click();
    }
    public void headerMaintanceText (String headerText){
        headerMaintance.shouldHave(Condition.text(headerText));
    }
}
