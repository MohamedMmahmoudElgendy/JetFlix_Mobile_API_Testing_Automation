package ApiTests;

import BookDeSerialization.BookResponse;
import BookSerialization.BookActivity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Test.BaseTestReport;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TC02_TestBookAddedSuccessfully extends BaseTestReport {

    @BeforeMethod
    public void intializer() {
    extentTest = createTest("Test Book Added");

    }
    @Test
    public void TestBookAdded() throws IOException {


        ObjectMapper mapper = new ObjectMapper();
        List<BookActivity> bookingDataList = mapper.readValue(new File("src/test/resources/testdata.json"),
                new TypeReference<List<BookActivity>>() {
                });

        for (BookActivity bookingData : bookingDataList) {

            String bodydata = mapper.writeValueAsString(bookingData);


            Response res = given().contentType(ContentType.JSON)
                    .body(bodydata)
                    .when().post("https://restful-booker.herokuapp.com/booking");


            Assert.assertEquals(res.statusCode(), 200);
            res.prettyPrint();

            extentTest.info("Request Body: " + bodydata);
            extentTest.info("Response Status Code: " + res.statusCode());
            extentTest.info("Response Body: " + res.getBody().asString());

            BookResponse resData=res.body().as(BookResponse.class);
            Assert.assertNotNull(resData.getBookingid(),"id is Null");
            Assert.assertEquals(resData.getBooking().getFirstname(),bookingData.getFirstname());
            Assert.assertEquals(resData.getBooking().getLastname(),bookingData.getLastname());
            Assert.assertEquals(resData.getBooking().getTotalprice(),bookingData.getTotalprice());
            Assert.assertEquals(resData.getBooking().isDepositpaid(), bookingData.getDepositpaid().booleanValue());
            Assert.assertEquals(resData.getBooking().getBookingdates().getCheckin(), bookingData.getBookingdates().getCheckin());
            Assert.assertEquals(resData.getBooking().getBookingdates().getCheckout(),bookingData.getBookingdates().getCheckout());
            Assert.assertEquals(resData.getBooking().getAdditionalneeds(),bookingData.getAdditionalneeds());


            extentTest.pass("Booking added and validated successfully.");
        }

    }
    @AfterMethod
    public void ResultStatus(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Test passed");
        }

    }

}
