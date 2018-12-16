package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sun.media.jfxmediaimpl.MediaUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by mdrahman on 12/15/18.
 * Spring 2018
 */
public class Reporter {

    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;


    @Test
    public void runTest() throws IOException {
        reportTest("RunTest","Dummy","Dummy");
    }



    @Test
    public void reportTest(String testName, String testInfo, String passMessage) throws IOException {

        try {
            System.out.println("Extent Report Test");

            //start reporters
            htmlReporter =
                    new ExtentHtmlReporter("./Reports/myReport.html");

            //create ExtentReports and attach Reporter(s)
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);

            //create a toggle for the given test, adds all log events under it
            ExtentTest logger = extent.createTest(testName);

            logger.log(Status.INFO, "Test Info");

            logger.log(Status.PASS, passMessage);

            extent.flush();

        } catch (Exception e) {
            ExtentTest logger2 = extent.createTest("Fail test");

            logger2.log(Status.FAIL, "Test Failed");

            logger2.addScreenCaptureFromPath("/Users/mdrahman/Desktop/screenShot.jpeg");

            extent.flush();

            extent.close();

        }
    }

}
