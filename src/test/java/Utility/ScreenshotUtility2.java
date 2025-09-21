package Utility;

import Pages.DriverInit;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility2 {

    @Attachment(value = "Page Screenshot", type = "image/png")
    public static byte[] captureScreenshot() {
        try {
            if (DriverInit.driver != null) {
                return ((TakesScreenshot) DriverInit.driver).getScreenshotAs(OutputType.BYTES);
            }
        } catch (Exception e) {
            // Optionally log the error
        }
        return new byte[0];
    }
}
