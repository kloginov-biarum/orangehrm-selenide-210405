import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SidePanel {

    private ElementsCollection links = $$(".oxd-main-menu-item-wrapper");

    private SelenideElement leaveLink = $("[href=\"/web/index.php/leave/viewLeaveModule\"]");

    private SelenideElement maintenanceLink = $("[href=\"/web/index.php/maintenance/viewMaintenanceModule\"]");

    public void clickOnTheLeaveLink(){
        leaveLink.click();
    }
    public void amountOfLinksEquals(int expectedValue){
        links.shouldHave(size(expectedValue));
    }

    public void linksTextsAreCorrect(){
        links.shouldHave(texts("Admin", "PIM", "Leave",
                "Time", "Recruitment", "My Info", "Performance", "Dashboard", "Directory", "Maintenance",
                "Claim", "Buzz"));
    }

    public void clickMaintenance (){
        maintenanceLink.click();
    }
}
