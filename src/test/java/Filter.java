import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class Filter {

    private WebDriver driver;

    private final static By ALL_COMPANIES = By.xpath(".//*/div[2]/*/div/*/button"); //плохо
    private final static By FROM_INPUT = By.xpath(".//*[@id='glf-pricefrom-var']");
    private final static By TO_INPUT = By.xpath(".//*[@id='glf-priceto-var']");
    private final static By COMPANY_INPUT = By.xpath(".//*/div[2]/div[2]/*/span/span/input"); //плохо

    Filter(WebDriver driver) {
        this.driver = driver;
    }

    void fromSetPrice(String price) {
        WebElement element = driver.findElement(FROM_INPUT);
        setPrice(price, element);
    }

    void toSetPrice(String price) {
        WebElement element = driver.findElement(TO_INPUT);
        setPrice(price, element);
    }

    private void setPrice(String price, WebElement element) {
        element.sendKeys(price);
        String fromText = element.getAttribute("value");
        assertThat("ошибка в веденном значении:  "+fromText, price, equalTo(fromText));
    }

    void findCompanies() {
        driver.findElement(ALL_COMPANIES).click();
    }

    void setCompany(List<String> list) {

        for (String aList : list) {
            driver.findElement(COMPANY_INPUT).sendKeys(aList);
            driver.findElement(By.xpath(String.format(".//div[1]/span/label[text()='%s']/..", aList))).click();
            driver.findElement(COMPANY_INPUT).clear();
        }

    }

}
