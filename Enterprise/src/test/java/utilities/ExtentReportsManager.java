package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManager {
    private static ExtentReports extent;

    // Method to initialize ExtentReports
    public static ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Appium Test Report");
            sparkReporter.config().setReportName("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // Adding system information to the report
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester", "Abdur Rahman");
            extent.setSystemInfo("Platform", "Android");
            extent.setSystemInfo("Framework", "TestNG");
        }
        return extent;
    }
}
