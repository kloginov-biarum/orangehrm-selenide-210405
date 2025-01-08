import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v85.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SidePanelTest extends BaseTest{

    private static final Logger log = LoggerFactory.getLogger(SidePanelTest.class);

    @Test
    public void allLinksAreDisplayed(){
        //auth with valid data
        loginPage.successLogin("Admin", "admin123");
        //check that 12 links are displayed on the side panel
        sidePanel.amountOfLinksEquals(12);
        List<String> expectedLinks = Arrays.asList(
                "Admin", "PIM", "Leave", "Time", "Recruitment", "My Info",
                "Performance", "Dashboard", "Directory", "Maintenance",
                "Claim", "Buzz"
        );
        sidePanel.linksTextsAreCorrect(expectedLinks);
    }


    @Test
    public void leaveLinkIsCorrect(){
        //login
        loginPage.successLogin("Admin", "admin123");
        //follow the link "Leave"
        sidePanel.clickOnTheLeaveLink();
        //check that we are on the page "Leave"
        leavePage.headerHasTextLeave();
    }

    @Test
    public void maintenanceLinkTestValidCred(){
        //Login
        loginPage.successLogin("Admin", "admin123");
        //Click on the "Maintenance" link on the side panel
        sidePanel.clickMaintenance();
        //Enter password "admin123"
        maintenancePage.inputAdminPassword("admin123");
        //Click on the "Confirm" button
        maintenancePage.clickConfirmButton();
        //Check that we are on the page "Maintenance"
        maintenancePage.headerMaintanceText("Maintenance\n" +
                "Purge Records");
    }

    @Test
    public void maintenanceLinkTestInvalidCred() {
        loginPage.successLogin("Admin", "admin123");
        //Click on the "Maintenance" link on the side panel
        sidePanel.clickMaintenance();
        //Enter password "admin123"
        maintenancePage.inputAdminPassword("dfsdfsf");
        //Check that error message with text "Invalid credentials" is displayed
        maintenancePage.clickConfirmButton();
        maintenancePage.errorTextAreCorrect("Invalid credentials");
    }

    @Test
    public void maintenanceLinkTestEmptyPassword(){
        loginPage.successLogin("Admin", "admin123");
        sidePanel.clickMaintenance();
        //Leave password empty
        maintenancePage.inputAdminPassword("");
        maintenancePage.clickConfirmButton();
        //Check that "Required" error message is displayed
        maintenancePage.errorTextAreCorrect("Invalid credentials");
        maintenancePage.errorTextPasswordEmpty("Required");
    }

    @Test
    public void searchExactValue(){
        loginPage.successLogin("Admin", "admin123");
        //Enter "Leave" to searchbar
        sidePanel.enterSearchValue("Leave");
        //Check that list of links has 1 item
        sidePanel.amountOfLinksEquals(1);
        //Check that item is "Leave"
        List<String> expectedLinks = Arrays.asList("Leave");
        sidePanel.linksTextsAreCorrect(expectedLinks);
    }



}
