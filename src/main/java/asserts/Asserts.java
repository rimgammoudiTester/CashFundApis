package asserts;

import io.restassured.response.Response;
import org.testng.Assert;


public class Asserts {

    /**
     * @Author Rim Gammoudi
     **/


    //Method useful For veriyfing for the param is eaqual to expected one
    public static void isParamEqualToExpectedResult(Object ExpectedParam, Response res, String path) {
        Assert.assertEquals(res.path(path), ExpectedParam);
    }


    //Method useful For verifying for The param is not null
    public static void isParamNotNull(Response res, String path) {
        Assert.assertNotNull(res.path(path));
    }

    //Method useful For the verifying for the param is null
    public static void isParamNull(Response res, String path) {
        Assert.assertNull(res.path(path));
    }

    //Method useful for verifying The code status of the response
    public static  void isResponseStatusCorrect(Response res, int statusCode) {
        Assert.assertEquals(res.getStatusCode(), statusCode);
    }


}
