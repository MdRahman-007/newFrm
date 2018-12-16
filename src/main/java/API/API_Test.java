package API;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by mdrahman on 12/9/18.
 * Spring 2018
 */
public class API_Test {


    @BeforeClass
    public void setupAPI(){
        String port = System.getProperty("server.port");
        if (port == null){
            RestAssured.port = Integer.valueOf(8080);
        }else
        {
            RestAssured.port = Integer.valueOf(port);
        }
        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/rest-garage-sample/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;
    }


    public class GarageRestTest {

        @Test
        public void basicPingTest() {
            given().when().get("/garage").then().statusCode(200);
        }
    }

    @Test
    public void invalidParkingSpace() {
        given().when().get("/garage/slots/999")
                .then().statusCode(404);
    }











    @Test
    public void runAPI() {


//        RestAssured.baseURI = "https://maps.googleapis.com";

        given().
                get("https://www.google.com").

        then().statusCode(200);
        System.out.println("verified");

    }

}
