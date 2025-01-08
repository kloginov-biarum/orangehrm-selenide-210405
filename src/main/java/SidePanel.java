import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SidePanel {

    private ElementsCollection links = $$(".oxd-main-menu-item-wrapper");

    private SelenideElement leaveLink = $("[href=\"/web/index.php/leave/viewLeaveModule\"]");

    private SelenideElement maintenanceLink = $("[href=\"/web/index.php/maintenance/viewMaintenanceModule\"]");

    private SelenideElement searchField = $(".oxd-input--active");

    public void clickOnTheLeaveLink(){
        leaveLink.click();
    }
    public void amountOfLinksEquals(int expectedValue){
        links.shouldHave(size(expectedValue));
    }

        public void linksTextsAreCorrect(List<String> expectedValues){
            links.shouldHave(texts(expectedValues));
        }

    public void clickMaintenance (){
        maintenanceLink.click();
    }
    public void enterSearchValue(String value){
        searchField.setValue(value);
    }


}
