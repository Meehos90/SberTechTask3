import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class MySteps {

    private WebDriver driver;
    private String firstNoteText;

    private final static By FIRST_PRODUCT = By.xpath(".//div[1]/div[1]/div[3]//h3//span");
    private final static By PRODUCTS_LIST = By.className("n-snippet-card");
    private final static By INPUT_SEARCH = By.xpath("//*[@id=\"header-search\"]");
    private final static By RESULT_PRODUCT = By.xpath(".//h1");
    private Filter filter;
    private OpenPage openPage;


    @Before
    public void start() throws Throwable {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        filter = new Filter(driver);
        openPage = new OpenPage(driver);
    }

    @After
    public void exit() throws Throwable {
        driver.quit();
    }

    @Дано("^открываем сайт yandex\\.ru$")
    public void открываемСайт() throws Throwable {
        driver.get("https://www.yandex.ru");
    }

    @Тогда("^выбираем пункт меню$")
    public void выбираемПунктМеню(List<String> list) throws Throwable {

        for (String aList : list) {
            openPage.checkLink(aList);
        }

    }

    @Тогда("^в поле с ценой от вводим значение \"([^\"]*)\"$")
    public void вБлокеЦенаОт(String price) throws Throwable {
        filter.fromSetPrice(price);

    }

    @Тогда("^в поле с ценой до вводим значение \"([^\"]*)\"$")
    public void вБлокеЦенаДо(String price) throws Throwable {
        filter.toSetPrice(price);
    }

    @И("^в блоке Производитель выбираем чекбоксы$")
    public void вБлокеВыбираемЧекбоксы(List<String> list) throws Throwable  {
        filter.findCompanies();
        filter.setCompany(list);
    }

    @И("^нажимаем кнопку \"([^\"]*)\"$")
    public void нажимаемКнопку(String s) throws Throwable {
        openPage.checkLink(s);
    }

    @Тогда("^проверяем что количество товаров равно \"([^\"]*)\"$")
    public void проверяемЧтоКоличествоРавно(int count) throws Throwable {
        List<WebElement> list = driver.findElements(PRODUCTS_LIST);
        assertThat("Неверное количество товаров", count, equalTo(list.size()));
    }

    @И("^вводим название первого товара в поле поиска$")
    public void сохраняемПервогоТовара() throws Throwable {
        WebElement firstNote = driver.findElement(FIRST_PRODUCT);
        firstNoteText = firstNote.getText();
        driver.findElement(INPUT_SEARCH).sendKeys(firstNoteText);
    }

    @И("^нажимаем кнопку \"([^\"]*)\" для поиска$")
    public void нажимаемКнопкуНайти(String s) throws Throwable {
        driver.findElement(By.xpath(String.format(".//span[text()='%s']/..", s))).click();
    }


    @Тогда("^в результатах поиска сравниваем названия товаров$")
    public void сравниваемСВведеннымВПоискеПервогоВСпискеТовара() throws Throwable {
        WebElement sameNote = driver.findElement(RESULT_PRODUCT);
        String sameNoteText = sameNote.getText();
        assertThat(firstNoteText, equalTo(sameNoteText));
    }
}

