package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage {
    public LandingPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "i.fa.fa-plus-circle.create")
    WebElement playListPlusBtn;

    /*public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }*/

    public void clickAddPlaylistPlusButton() {
        playListPlusBtn.click();
    }

    /*
    public BasePage clickAddPlayListPlusButton() {

        playListPlusBtn.click();
        return this;
    }
    */
}
