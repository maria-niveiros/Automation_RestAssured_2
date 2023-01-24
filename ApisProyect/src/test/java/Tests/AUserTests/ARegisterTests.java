package Tests.AUserTests;

import Data.Builder.User.RegisterUserRequestBuilder;

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

import static Data.Builder.User.RegisterUserRequestBuilder.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;



public class ARegisterTests extends BaseTest {
    Response response;

    @BeforeClass
    public void setUp() { requestSpecification = userRegisterSpecification();
    }



    @Test(priority=1)
    @Epic("Sprint 1")
    @Tag("Regression")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Register process returns an user")
    public void registerOk() {

        given()
                .when()
                .body(newUsers())
                .post()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(priority=2)
    @Severity(SeverityLevel.NORMAL)
    @Description("When register an user, response has headers")
    public void registerHeaders() {
        response = (Response) given()
                .body(newUsers())
                .post()
                .then()
                .extract()
                .body();
        Headers headers = response.getHeaders();
        Assert.assertTrue(headers.exist());
    }

    @Test(priority=3)
    @Severity(SeverityLevel.NORMAL)
    @Description("When register an user, response has content-type: application/json")
    public void registerOkContentType() {
        response = (Response) given()
                .body(newUsers())
                .post()
                .then()
                .extract()
                .body();
        String contentType = response.getContentType();
        Assert.assertEquals("application/json", contentType);
    }


    @Test(priority=4)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Can´t register with empty user")
    public void registerWithEmptyUser() {
        response = (Response) given()
                .when()
                .body(emptyUser())
                .post()
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
    ;
    }


    @Test(priority=5)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Can´t register with null user")
    public void registerWithNullUser() {
        response = (Response) given()
                .when()
                .body(nullUser())
                .post()
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
        ;
    }

}