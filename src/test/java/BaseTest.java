import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {


    @BeforeEach
    public void setUp(){
        //Configuration.browser = "ie";
        //Configuration.browserSize = "3000x3000";
        //Configuration.headless = true;
        Configuration.timeout = 10000;
        Configuration.fastSetValue = true;
        Configuration.clickViaJs = true;
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    LoginPage loginPage =  new LoginPage();
    SidePanel sidePanel = new SidePanel();
    LeavePage leavePage = new LeavePage();
    MaintenancePage maintenancePage = new MaintenancePage();
    DashboardPage dashboardPage = new DashboardPage();

}
