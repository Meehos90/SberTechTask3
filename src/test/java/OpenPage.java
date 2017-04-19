import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class OpenPage {

    private WebDriver driver;

    OpenPage(WebDriver driver) { this.driver = driver; }

    void checkLink(String s) {
        WebElement link = driver.findElement(By.linkText(s));
        Assert.assertEquals("Ошибка открытия станицы: " + s, s, link.getText());
        link.click();
    }
}
