package Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestReport {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentTest;

    @BeforeSuite
    public void setupReport() {
        if (extentReports == null) {
            htmlReporter = new ExtentHtmlReporter("extent-report.html");
            htmlReporter.config().setDocumentTitle("Test Report");
            htmlReporter.config().setTheme(Theme.STANDARD);

            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);
        }
    }

    @AfterSuite
    public void ReportCloseOneTime() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

    public ExtentTest createTest(String testName) {
        extentTest = extentReports.createTest(testName);
        return extentTest;
    }
}

