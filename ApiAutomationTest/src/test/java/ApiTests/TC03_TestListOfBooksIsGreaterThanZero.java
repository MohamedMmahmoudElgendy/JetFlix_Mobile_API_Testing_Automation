package ApiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Test.BaseTestReport;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TC03_TestListOfBooksIsGreaterThanZero extends BaseTestReport {

@BeforeMethod
public void intializer() {
    extentTest = createTest("TTest List Of Books");

}


    @Test
    public void TestlistOfBooks(){

        Response listofbooks = given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking");

        extentTest.info("Response Status Code: " + listofbooks.statusCode());
        extentTest.info("Response Body: " + listofbooks.getBody().asString());

       // listofbooks.prettyPrint();

        List<Integer> bookingIds = listofbooks.jsonPath().getList("bookingid");
        extentTest.info("Booking IDs: " + bookingIds);
        System.out.println("Booking IDs: " + bookingIds);
        Assert.assertTrue(bookingIds.size() > 0, "The list of booking IDs is not greater than zero!");
        extentTest.pass("Booking list of IDs size is greater than zero.");

    }

    @AfterMethod
    public void ResultStatus(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.pass("Test passed");
        }

    }
}
