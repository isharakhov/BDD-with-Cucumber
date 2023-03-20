package cucumber.steps;

import config.BaseConfig;
import enums.Category;
import enums.City;
import enums.Sort;
import enums.StringForSearch;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.AvitoPage;

import java.time.Duration;

public class MyStepdefs {

    /**
     * Переменная с экземпляром драйвера
     */
    protected WebDriver driver;

    /**
     * Экземпляр страницы с которой происходит взаимодействие
     */
    private AvitoPage avitoPage;

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Метод для input элементов enum category в поле поиска
     *
     * @param stringCategory элемент строки которую можно ввести
     * @return проверяет принадлежит ли элемент enum category
     */
    @ParameterType(".*")
    public Category stringCategory(String stringCategory) {
        return Category.valueOf(stringCategory);
    }

    /**
     * Метод для input элементов enum StringForSearch в поле поиска
     *
     * @param stringForSearch элемент строки которую можно ввести
     * @return проверяет принадлежит ли элемент enum StringForSearch
     */
    @ParameterType(".*")
    public StringForSearch stringForSearch(String stringForSearch) {
        return StringForSearch.valueOf(stringForSearch);
    }

    /**
     * Метод для input элементов enum City в поле поиска
     *
     * @param city элемент строки которую можно ввести
     * @return проверяет принадлежит ли элемент enum City
     */
    @ParameterType(".*")
    public City city(String city) {
        return City.valueOf(city);
    }

    /**
     * Метод для элементов enum Sort в поле поиска
     *
     * @param sortBy элемент enum
     * @return проверяет принадлежит ли элемент enum Sort
     */
    @ParameterType(".*")
    public Sort sortBy(String sortBy) {
        return Sort.valueOf(sortBy);
    }

    @When("Follow the link Avito page")
    public void followTheLinkAvitoPage() {

        //Установка пути до драйвера Chrome
        System.setProperty(config.driverProperty(), config.driverPath());

        //создание экземпляра драйвера
        driver = new ChromeDriver();

        //разворот страницы на полное окно
        driver.manage().window().maximize();

        //лимит неявного ожидания устанавливаем 20 сек
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //тайм аут для загрузки страницы и элементов
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        //открытие url авито
        driver.get(config.url());

        //Создание объекта страницы
        avitoPage = new AvitoPage(driver);
    }

    @Then("Select category {stringCategory}")
    public void selectCategoryCategory(Category stringCategory) {
        avitoPage
                .clickToCategory()  //нажимаем на выпадающий окно с категориями
                .clickOnThisCategory(String.valueOf(stringCategory))  //выбор категории
                .clickToFieldForSearchItem();
    }

    @Then("In the search field write {stringForSearch}")
    public void inTheSearchFieldWriteStringForSearch(StringForSearch stringForSearch) {
        avitoPage
                .inputStringInSearchFieldItem(stringForSearch.getValue());    //вводим Принтер и Монитор
    }

    @Then("Click on the dropdown list of regions")
    public void clickOnTheDropdownListOfRegions() {
        avitoPage
                .clickToAreaSearch()      //открытие поля поиска по городу
                .clickToDeepFieldAreaSearch(); //поле поиска по городам
    }

    @Then("Enter region {city}")
    public void enterRegionCity(City city) {
        avitoPage
                .inputStringInSearchFieldCity(city.getValue());
    }

    @Then("Click on the button “Show n ads”")
    public void clickOnTheButtonShowNAds() {
        avitoPage
                .clickBigButtonForFoundedItems();    //нажимаем на кнопку поиска
    }

    @Then("Activate the checkbox “with photo only”")
    public void activateTheCheckboxWithPhotoOnly() {
        avitoPage
                .clickCheckBox();     //чек-бокс только с фото
    }

    @Then("Select {} in the sort drop down list")
    public void selectSortInTheSortDropDownList(Sort sort) {
        avitoPage
                .clickSelectorByAllPrices()
                .clickSelectorByPrices(sort.getValue());
    }

    @Then("Output to the console Price value of the first {int} items")
    public void outputToTheConsolePriceValueOfTheFirstQuantityItems(int quantity) {
        avitoPage
                .printFirstPriceByNumber(quantity);   //выводит количество первых цен (количество quantity)
    }

    @Then("Close browser")
    public void closeBrowser() {
        // остановка работы драйвера
        driver.close();
    }
}