import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {


    @BeforeEach
    public void setUp(){
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    LoginPage loginPage =  new LoginPage();
    SidePanel sidePanel = new SidePanel();
    LeavePage leavePage = new LeavePage();
    MaintenancePage maintenancePage = new MaintenancePage();
}
