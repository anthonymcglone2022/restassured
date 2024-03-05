package tests;

import java.util.Map;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import util.Config;
import data.TestData;

public class RestAssuredTest {
	
    @Test
    void createPostcode() {
        given()
            .contentType(Config.contentTypeJson)
            .body(TestData.createPostCode)
        .when()
            .post(Config.baseURL + Config.createPostCode)
        .then()
            .statusCode(Config.twoHundred)
            .body(TestData.code, equalTo(TestData.createPostCode.get(TestData.code)))
            .body(TestData.inuse, equalTo(TestData.createPostCode.get(TestData.inuse)))
            .body(TestData.district, equalTo(TestData.createPostCode.get(TestData.district)));			
    }
	
    @Test
    void formatPostCode() {
        Map.Entry<String,String> entry = TestData.formatPostCode.entrySet().iterator().next();
        String unformattedPostCode = entry.getKey();
        String formattedPostCode = entry.getValue();		
	
        given()
        .when()
            .get(Config.baseURL + Config.formatPostCode + unformattedPostCode)
        .then()
            .statusCode(Config.twoHundred)
            .body(containsString(formattedPostCode));
    }

}
