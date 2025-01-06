import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;

public class LeavePage {

    private SelenideElement header = $(byTagName("h6"));

    public void headerHasTextLeave(){
        header.shouldHave(Condition.text("Leave"));
    }
}
