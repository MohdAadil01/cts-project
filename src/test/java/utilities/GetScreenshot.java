package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testBase.BaseClass;

public class GetScreenshot extends BaseClass {
	public static String captureScreenshot(String testName) throws IOException {
		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(filePath);
		
		FileUtils.copyFile(src, target);
		return filePath;
	}
}
