package ApiTests;


import AuthDeSerialization.AuthResponse;
import AuthSerialization.AuthActivity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Test.BaseTestReport;
import static io.restassured.RestAssured.given;


public class TC01_TestResponseNotEmptyAndTokenGeneration extends BaseTestReport {

    @BeforeMethod
    public void intializer() {
    extentTest = createTest("Test Auth Token Generation");

    }


    @Test
    public void  TestAuthTokenGeneration() throws JsonProcessingException {

    AuthActivity auth= new AuthActivity();
    auth.setUsername("admin");
    auth.setPassword("password123");


    ObjectMapper mapper=new ObjectMapper();
    String bodydata=mapper.writeValueAsString(auth);


    Response res=given().contentType(ContentType.JSON)
                        .body(bodydata)
                        .when().post("https://restful-booker.herokuapp.com/auth");

    String responseBody = res.getBody().asString();
    extentTest.info("Response Body: " + responseBody);

    Assert.assertFalse(res.getBody().asString().isEmpty(),"Response is empty");
    AuthResponse AuthResponse=res.body().as(AuthResponse.class);

    Assert.assertNotNull(AuthResponse.getToken(),"token is not generated");
    System.out.println("token generated:"+AuthResponse.getToken());

    extentTest.pass("Token generated successfully: " + AuthResponse.getToken());

    }

    @AfterMethod
    public void ResultStatus(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Test passed");
        }



    }

}
