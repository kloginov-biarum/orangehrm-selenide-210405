import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;


import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SidePanel {

    private ElementsCollection links = $$(".oxd-main-menu-item-wrapper");

    private SelenideElement leaveLink = $("[href=\"/web/index.php/leave/viewLeaveModule\"]");

    private SelenideElement maintenanceLink = $("[href=\"/web/index.php/maintenance/viewMaintenanceModule\"]");

    private SelenideElement searchField = $(".oxd-input--active");

    private SelenideElement arrow = $(".oxd-main-menu-search i");

    private SelenideElement wholeSidePanel = $(byClassName("oxd-sidepanel"));

    private ElementsCollection linksIcons = $$(".oxd-main-menu li");

    private ElementsCollection linksNames  = $$(".oxd-main-menu li span");

    public void clickOnTheLeaveLink(){
        leaveLink.click();
    }
    public void amountOfLinksEquals(int expectedValue){
        links.shouldHave(size(expectedValue));
    }

    public void amountOfLinksIconsEquals(int expectedValue){
        linksIcons.shouldHave(size(expectedValue));
    }

    public void allLinksIconsAreDisplayed(){
        for (SelenideElement icon: linksIcons){
            icon.shouldBe(Condition.visible);
        }
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

    public void eachLinkHasText(String substring){
        for (SelenideElement link: links){
            link.shouldHave(Condition.partialText(substring));
        }
    }

    @Test
    public void clickOnTheArrow(){
        arrow.click();
    }

    public void panelIsRolledOut(){
        wholeSidePanel.shouldHave(Condition.attributeMatching("class",".*toggled.*"));
    }

    public void panelIsRolledIn(){
        wholeSidePanel.shouldNotHave(Condition.attributeMatching("class",".*toggled.*"));
    }

    public void linksNamesAreNotDisplayed(){
        for (SelenideElement name: linksNames){
            name.shouldNotBe(Condition.visible);
        }

    }
}
