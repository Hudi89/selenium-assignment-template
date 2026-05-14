package tests;

import org.junit.jupiter.api.Test;
import pages.FileUploadPage;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUploadTest extends BaseTest {

    @Test
    public void shouldUploadFile() {
        driver.get(baseUrl + "upload");
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        Path uploadFile = Path.of("src", "test", "resources", "upload-sample.txt").toAbsolutePath();

        fileUploadPage.uploadFile(uploadFile.toString());

        assertEquals("upload-sample.txt", fileUploadPage.uploadedFileName());
    }
}
