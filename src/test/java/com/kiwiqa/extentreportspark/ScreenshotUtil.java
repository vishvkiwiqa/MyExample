package com.kiwiqa.extentreportspark;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil
{
    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        // Take screenshot and store it as a file format
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        // Define the destination file path
        String destFile = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
        
        // Copy the screenshot to the destination file
        try {
            FileUtils.copyFile(srcFile, new File(destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Return the path of the screenshot
        return destFile;
    }
}
