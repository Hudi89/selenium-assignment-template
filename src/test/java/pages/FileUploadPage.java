package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage {

    private final By fileInput = By.id("file-upload");
    private final By uploadButton = By.id("file-submit");
    private final By uploadedFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile(String absolutePath) {
        findPresent(fileInput).sendKeys(absolutePath);
        click(uploadButton);
    }

    public String uploadedFileName() {
        return textOf(uploadedFiles);
    }
}
