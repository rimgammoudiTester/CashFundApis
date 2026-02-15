package bases;

import configManager.ConfigurationReader;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;

import static io.restassured.RestAssured.given;
@Slf4j
public class BaseTest {

    private static final String licenceCodeProperty = "licenceCode";
    private static final String loginProperty = "userTest";

    private static final String passwordProperty = "password";
    private static final String baseUrlProperty = "baseUrl";
    private static String token;


    public static HashMap<String, String> intializeHeaders() {
        HashMap<String, String> tokenHeaders = new HashMap<>();
        tokenHeaders.put("authorization", "Basic "+"T0F1dGgyV2ViVXNlcjpzZWNyZXQ=");
        tokenHeaders.put("Content-Type","application/json");

        return tokenHeaders;

    }


    @SneakyThrows
    public static void generateToken() {


        if(token==null)
        {
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("login", ConfigurationReader.getProperty(loginProperty));
        payload.put("password", ConfigurationReader.getProperty(passwordProperty));
        payload.put("licenceCode", "");
        payload.put("grantType", "password");
        token = given().baseUri(ConfigurationReader.getProperty(baseUrlProperty)).headers(intializeHeaders()).body(payload).when().post("/uaa/oauth/token").then().extract().response().path("access_token");
        log.info(token);


    }}


    @SneakyThrows
    public static HashMap<String, String> setApiHeaders() {
        generateToken();
        HashMap<String, String> apiHeaders = new HashMap<>();
        apiHeaders.put("accept", "application/json");
        apiHeaders.put("authorization", "Bearer " + token);
        apiHeaders.put("x-licence-code", ConfigurationReader.getProperty(licenceCodeProperty));
        return apiHeaders;


    }


}
