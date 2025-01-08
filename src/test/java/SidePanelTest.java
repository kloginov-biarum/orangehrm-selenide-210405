import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v85.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SidePanelTest extends BaseTest{

    private static final Logger log = LoggerFactory.getLogger(SidePanelTest.class);

    @Test
    public void allLinksAreDisplayed(){
        //auth with valid data
        loginPage.successLogin("Admin", "admin123");
        //check that 12 links are displayed on the side panel
        sidePanel.amountOfLinksEquals(11);
        sidePanel.linksTextsAreCorrect();
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
        //Click on the "Maintenance" link on the side panel
        //Enter password "admin123"
        //Click on the "Confirm" button
        //Check that we are on the page "Maintenance"
    }



}
