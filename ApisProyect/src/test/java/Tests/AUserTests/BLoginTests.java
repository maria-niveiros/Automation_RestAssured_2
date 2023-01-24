package Tests.AUserTests;

import Data.Model.User.LoginUserRequest;
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

import java.util.Base64;

import static Data.Builder.User.LoginUserRequestBuilder.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class BLoginTests extends BaseTest {

    Response response;

    String accessToken ="";

    BaseTest baseTest = new BaseTest();
    public static final String REGISTERED_USERNAME = "maria";
    public static final String REGISTERED_PASSWORD= "maria86";
    private static final String UNREGISTERED_USER = "pentacampeon";
    private static final String UNREGISTERED_PASSWORD= "brasil10";

    @BeforeClass
    public void setUp() { requestSpecification = userLoginSpecification();}




    @Test(priority=1)
    @Epic("Sprint 1")
    @Tag("Regression")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Login process returns an access token ")
    public void loginOkGetToken() {

        accessToken = given()
                .when()
                .queryParam("username", REGISTERED_USERNAME)
                .queryParam("password", REGISTERED_PASSWORD)
                .get()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .asString();

       BaseTest.setAccessToken(accessToken);

    }

    @Test(priority=4)
    @Severity(SeverityLevel.NORMAL)
    @Description("When login an user, response has headers")
    public void loginHeaders() {
        response = (Response) given()
                .queryParam("username", REGISTERED_USERNAME)
                .queryParam("password", REGISTERED_PASSWORD)
                .get()
                .then()
                .extract()
                .body();
        Headers headers = response.getHeaders();
        Assert.assertTrue(headers.exist());
    }

    @Test(priority=5)
    @Tag("Regression")
    @Epic("Sprint 1")
    @Severity(SeverityLevel.BLOCKER)
    @Description("When login an user, Status Code is 200")
    public void loginOkStatusCode() {
        response = (Response) given()
                .queryParam("username", REGISTERED_USERNAME)
                .queryParam("password", REGISTERED_PASSWORD)
                .get()
                .then()
                .extract()
                .body();
        int httpStatus = response.getStatusCode();
        Assert.assertEquals(HttpStatus.SC_OK, httpStatus);
    }

    @Test(priority=6)
    @Epic("Sprint 1")
    @Tag("Regression")
    @Severity(SeverityLevel.NORMAL)
    @Description("When login an user, response has content-type: application/json")
    public void loginOkContentType() {
        response = (Response) given()
                .queryParam("username", REGISTERED_USERNAME)
                .queryParam("password", REGISTERED_PASSWORD)
                .get()
                .then()
                .extract()
                .body();
        String contentType = response.getContentType();
        Assert.assertEquals("application/json", contentType);
    }

    @Test(priority=7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Attempt to login with an unregistered email")
    public void failLoginUnregisteredEmail() {
        given()
                .queryParam("username", UNREGISTERED_USER)
                .queryParam("password", UNREGISTERED_PASSWORD)
                .get()
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test(priority=8)
    @Epic("Sprint 1")
    @Tag("Regression")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Attempt to login with an unregistered password")
    public void failLoginUnregisteredPassword() {
       given()
                .queryParam("username", UNREGISTERED_USER)
                .queryParam("password", UNREGISTERED_PASSWORD)
                .get()
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }





}
