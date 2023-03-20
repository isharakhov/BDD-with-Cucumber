import config.BaseConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

/**
 * Общий класс с настройками для тестов
 */
public class ParentTest {
    /**
     * Переменная с экземпляра драйвера
     */
    protected WebDriver driver;

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    /**
     * Общие настройки для всех тестов,перед выполнением каждого
     */
    @BeforeMethod
    public void setDriver() {
        //Установка пути до драйвера Chrome
        System.setProperty(config.driverProperty(), config.driverPath());

        //создание экземпляра драйвера
        driver = new ChromeDriver();

        //разворот страницы на полное окно
        driver.manage().window().maximize();

        //лимит неявного ожидания устанавливаем 20 сек
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //тайм аут для загрузки страницы и элементов
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        //открытие url авито
        driver.get(config.url());
    }

    /**
     * Общие настройки для всех тестов,после выполнения каждого
     */
    @AfterMethod
    public void turnOffChrome() {
        //остановка работы драйвера
        driver.quit();
    }
}