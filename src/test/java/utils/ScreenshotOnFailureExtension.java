package utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotOnFailureExtension implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        WebDriver driver = DriverFactory.getExistingDriver();

        if (driver instanceof TakesScreenshot screenshotDriver) {
            saveScreenshot(context, screenshotDriver);
        }

        throw throwable;
    }

    private void saveScreenshot(ExtensionContext context, TakesScreenshot screenshotDriver) throws IOException {
        Path screenshotsDir = Path.of("build", "screenshots");
        Files.createDirectories(screenshotsDir);

        String fileName = context.getRequiredTestMethod().getName() + ".png";
        byte[] screenshot = screenshotDriver.getScreenshotAs(OutputType.BYTES);
        Files.write(screenshotsDir.resolve(fileName), screenshot);
    }
}
