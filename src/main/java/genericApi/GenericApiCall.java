package genericApi;
import configManager.ConfigurationReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import java.util.HashMap;
import static bases.BaseTest.setApiHeaders;
import static io.restassured.RestAssured.given;
public class GenericApiCall {

    private static RequestSpecification req = getSpec();
    private static final String baseUrlProperty = "baseUrl";

    @SneakyThrows
    private static RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigurationReader.getProperty(baseUrlProperty))
                .setContentType(ContentType.JSON)
                .build();


    }

    //Method useful to return The object with query param
    public static Response getTheObject(HashMap<String, Object> queryToSend, String endPoint) {

        return given()
                .spec(req)
                .headers(setApiHeaders())
                .queryParams(queryToSend)
                .when()
                .get(endPoint)
                .then().extract().response();

    }

    //Method useful to return The object without query param
    public static Response getTheObjectWithoutQueryParam(String endPoint) {

        return given()
                .spec(req)
                .headers(setApiHeaders())
                .when()
                .get(endPoint)
                .then().extract().response();
    }


    //Method useful to return The object without query param
    public static Response getTheObjectWithPathParameter(Object pathParameter, String parameterName, String endPoint) {

        return given()
                .spec(req)
                .headers(setApiHeaders())
                .pathParam(parameterName, pathParameter)
                .when()
                .get(endPoint)
                .then().extract().response();
    }


    //Method useful to create an  object
    public static Response createAnObject(Object body, String endPoint) {

        return given()
                .spec(req)
                .headers(setApiHeaders())
                .body(body)
                .when()
                .post(endPoint)
                .then().extract().response();


    }

    //Method useful to create or update an object (based on requirements)
    public static Response createOrUpdateAnObject(Object body, String endPoint) {

        return given()
                .spec(req)
                .headers(setApiHeaders())
                .body(body)
                .when()
                .put(endPoint)
                .then().extract().response();
    }


    //Method useful to update The object with query param
    public static Response updateTheObject(HashMap<String, Object> queryToSend, String endPoint) {

        return given()
                .spec(req)
                .headers(setApiHeaders())
                .queryParams(queryToSend)
                .when()
                .put(endPoint)
                .then().extract().response();

    }


    //Method useful to delete The object with query param
    public static Response deleteTheObject(Object pathParameter, String parameterName, String endPoint) {

        {

            return given()
                    .spec(req)
                    .headers(setApiHeaders())
                    .pathParam(parameterName, pathParameter)
                    .when()
                    .delete(endPoint)
                    .then().extract().response();
        }


    }}
