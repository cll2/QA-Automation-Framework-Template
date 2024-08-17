package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class InfoPanelPage extends BasePage {

    public InfoPanelPage (WebDriver givenDriver) {
        super (givenDriver);
    }

    @FindBy(css = ".album-info .name")
    WebElement albumName;
    @FindBy(css = "main >.cover")
    WebElement albumCover;

    @FindBy (css = "button#extraTabAlbum")
    WebElement albumsTab;
    //@FindBy (css = "#extraPanelAlbum>article> h1>span")
    //WebElement albumNameSpan;
    //@FindBy (css = "p.none.text-secondary>span")
    //WebElement lyrics;


    public void clickAlbumTab() {
        albumsTab.click();
    }

    public void albumNameIsDisplayed() {
        WebElement albumNameSpan = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#extraPanelAlbum>article> h1>span")));
        String albumNameSpanText = albumNameSpan.getText();
        Assert.assertFalse(albumNameSpanText.trim().isEmpty());
    }

    public void albumCoverIsDisplayed() {
        Assert.assertTrue(albumCover.isDisplayed());
    }

    public void lyricsAreDisplayed() {
        WebElement lyrics = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.none.text-secondary>span")));
        String lyricsSpanText = lyrics.getText();
        Assert.assertFalse(lyricsSpanText.trim().isEmpty());
    }


}
