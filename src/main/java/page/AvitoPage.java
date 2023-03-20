package page;

import config.AvitoTestConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static utils.AshotScreenShot.makeScreenShot;
import static utils.Waiters.waitUntilVisible;

/**
 * Класс в котором происходит взаимодействие со страницей Google
 */
public class AvitoPage {

    /**
     * Экземпляр драйвера для управления браузером
     */
    private final WebDriver driver;

    /**
     * Экземпляр конфигурации с параметрами для Avito тестов
     */
    private final AvitoTestConfig config = ConfigFactory.create(AvitoTestConfig.class, System.getenv());

    /**
     * Конструктор создания AvitoPage
     *
     * @param driver драйвер для управления браузером
     */
    public AvitoPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Элемент выбора категорий Всех
     */
    @FindBy(css = "span[class='tooltip-tooltip-box-RsJbq']")
    private WebElement category;

    /**
     * Нажимаем на категорию
     *
     * @return
     */
    public AvitoPage clickToCategory() {
        category.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Элемент выбора категорий “Оргтехника и расходники”
     */
    @FindBy(css = "a[href='/penza/orgtehnika_i_rashodniki?cd=1']")
    private WebElement orgtehnica;

    /**
     * Нажимаем на Ортехнику
     *
     * @return
     */
    public AvitoPage clickToCategoryOrgtehnika() {
        orgtehnica.click();
        makeScreenShot(driver);
        return this;
    }

    @FindBy(css = "a[href='/penza/tovary_dlya_kompyutera?cd=1']")
    private WebElement forCompucter;

    /**
     * Нажимаем на любую указанную категорию
     *
     * @param category передаваемая категория
     * @return текущая страница
     */
    public AvitoPage clickOnThisCategory(String category) {
        if (category.equals("ОргтехникаИРасходники")) {
            orgtehnica.click();
        }
        if (category.equals("ТоварыДляКомпьютера")) {
            forCompucter.click();
        }
        return this;
    }

    /**
     * Элемент с полем поиска товара
     */
    @FindBy(css = "input[class='input-input-Zpzc1']")
    private WebElement searchFieldForItem;

    /**
     * Нажимаем на поисковую строку для ввода товара
     *
     * @return
     */
    public AvitoPage clickToFieldForSearchItem() {
        searchFieldForItem.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод ввода текста в поле поиска по товару
     *
     * @param str текст ввода
     * @return текущая страница
     */
    @Step("Вводим товар и нажимаем enter")
    public AvitoPage inputStringInSearchFieldItem(String str) {
        waitUntilVisible(driver, searchFieldForItem);
        searchFieldForItem.sendKeys(str);
        searchFieldForItem.sendKeys(Keys.ENTER);
        makeScreenShot(driver);
        return this;
    }

    /**
     * Элемент с полем поиска по регионам,городам,районам
     */
    @FindBy(css = "div[class='main-select-JJyaZ main-location-XUs1_']")
    private WebElement searchFieldForArea;

    /**
     * Нажимаем на поле поиска по регионам,городам,районам
     *
     * @return
     */
    public AvitoPage clickToAreaSearch() {
        searchFieldForArea.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * В открывшемся окне Элемент с полем поиска по регионам,городам,районам
     */
    @FindBy(css = "input[class='suggest-input-rORJM']")
    private WebElement searchDeepFieldForArea;


    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div/div[2]/div/div[6]/div/div/span/div/div[1]/div[2]/div/ul/li[1]")
    private WebElement searchFieldCityChoiseFirstOnList;

    public AvitoPage clickToSearchFieldCityChoiseFirstOnList() {
        searchFieldCityChoiseFirstOnList.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Нажимаем на Элемент с полем поиска по регионам,городам,районам
     *
     * @return
     */
    public AvitoPage clickToDeepFieldAreaSearch() {
        searchDeepFieldForArea.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод ввода текста в поле поиска по регионам,городам,районам
     *
     * @param str текст ввода Владивосток
     * @return текущая страница
     */
    @Step("Поисковая строка для городов,вводим город")
    public AvitoPage inputStringInSearchFieldCity(String str) {
        waitUntilVisible(driver, searchDeepFieldForArea);
        searchDeepFieldForArea.sendKeys(str);
//        searchDeepFieldForArea.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        makeScreenShot(driver);
        return this;
    }

    /**
     * Элемент кнопки по найденонму количеству товара в регионам,городам,районам
     */
    @FindBy(css = "button[class='button-button-CmK9a button-size-m-LzYrF button-primary-x_x8w']")
    private WebElement bigButtonForFoundedItems;

    /**
     * Нажимаем на кнопку начала поиска по найденному количеству
     *
     * @return
     */
    public AvitoPage clickBigButtonForFoundedItems() {
        bigButtonForFoundedItems.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Элемент чек-бокс с фото
     */
    @FindBy(xpath = "//div[@id='app']/div[2]/div/div[2]/div/div[4]/div/label[2]/span")
    private WebElement checkbox;

    /**
     * Нажимаем на чек-бокс только с фото
     *
     * @return
     */
    public AvitoPage clickCheckBox() {
        checkbox.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Элемент сортировки (выпадающий список)
     */
    @FindBy(xpath = "//div[@id='app']/div[3]/div[3]/div[3]/div/div[2]/select")
    private WebElement selectorByPrice;

    /**
     * Нажимаем на выпадающий список
     *
     * @return
     */
    public AvitoPage clickSelectorByAllPrices() {
        selectorByPrice.click();
        makeScreenShot(driver);
        return this;
    }

    /**
     * Элемент выпадающего списка Дороже
     */
    @FindBy(xpath = "//*[text()='Дороже']")
    private WebElement selectorExpensive;

    @FindBy(xpath = "//*[text()='Дешевле']")
    private WebElement selectorChip;

    /**
     * Нажимаем на элемент выпадающего списка Дороже
     *
     * @return
     */
    public AvitoPage clickExpensive() {
        selectorExpensive.click();
        makeScreenShot(driver);
        return this;
    }

    public AvitoPage clickSelectorByPrices(String sort) {
        if (sort.equals("Дороже")) {
            selectorExpensive.click();
        }
        if (sort.equals("Дешевле")) {
            selectorChip.click();
        }
        return this;
    }

    /**
     * Метод получения требуемого количества цен элемента по введенному номеру
     *
     * @param elementNumber номер элемента
     * @return цена элемента результата поиска по списку
     */
    private WebElement getSearchResultElementByNumber(int elementNumber) {
        return driver.findElement(By.xpath("//div[@id]//div[1]//div[" + elementNumber
                + "]//div[1]//div[3]/span[1]//meta[2]"));
    }

    /**
     * Метод печати первых n цен элементов
     *
     * @param number количество цен товаров требуемых выводу
     */
    @Step("Печать в консоль цен элементов запроса")
    public void printFirstPriceByNumber(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.println(getSearchResultElementByNumber(i).getAttribute(config.linkAttribute()));
        }
    }
}