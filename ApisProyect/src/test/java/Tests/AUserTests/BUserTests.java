package Tests.AUserTests;

import Data.Factory.User;
import Data.Model.User.RegisterUserRequest;
import Tests.AABase.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static Data.Builder.User.LoginUserRequestBuilder.loginUser;
import static Data.Builder.User.RegisterUserRequestBuilder.newUser;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.path.json.JsonPath.from;


public class BUserTests extends BaseTest {

   Response response;
    public static final String REGISTERED_USERNAME = "maria";
    private static final String UNREGISTERED_USER = "pentacampeon";



    @BeforeClass
    public void setUp() {
        requestSpecification = userRequestSpecification();

    }


    @Test(priority=1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("When get a user by username, Status Code is 200")
    public void httpStatus200OnGetUserByUsername() {
        response = given().get("{username}", REGISTERED_USERNAME);
        int httpStatus = response.getStatusCode();
        Assert.assertEquals(HttpStatus.SC_OK, httpStatus);
    }

    @Test(priority=2)
    @Severity(SeverityLevel.BLOCKER)
    @Description("When get a user by invalid username, Status Code is 404")
    public void OnGetUserByIdWithWrongUsername() {
        String responses = given()
                .get("{username}", "usuario2")
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .extract()
                .body()
                .asString();

    }


    @Test(priority=3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Edit successfully  user by username")
    public void putUserByUsername(){
        given()
                .body("{\n"+
                                "  \"firstName\": \"maria nuevo\",\n"+
                        "  \"firstName\": \"maria nuevo\",\n" +
                        "  \"lastName\": \"maria nuevo\",\n" +
                        "  \"email\": \"marianuevo@mail.com\",\n" +
                        "  \"password\": \"marianuevo\",\n" +
                        "  \"phone\": \"marianuevo\",\n" +
                        "  \"userStatus\": 1"+"}")
                .put("{username}", REGISTERED_USERNAME)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test(priority=4)
    @Severity(SeverityLevel.NORMAL)
    @Description("delete user")
    public void deleteUser(){
        given()
                .delete("{username}", REGISTERED_USERNAME)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}