package utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Класс с методами работы со скриншотами
 */
public class AshotScreenShot {

    /**
     * Делает скриншот для allure отчета
     *
     * @param driver экземпляр драйвера
     */
    @Attachment
    @Step("Ашот делает скриншот")
    public static byte[] makeScreenShot(WebDriver driver) {
        Screenshot screenshot = new AShot().takeScreenshot(driver);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            ImageIO.write(screenshot.getImage(), "PNG", buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toByteArray();
    }
}