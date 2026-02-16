package clientApisCall.GlobalBudgetApis;

import io.restassured.response.Response;

import java.util.HashMap;

import static genericApi.GenericApiCall.createAnObject;
import static genericApi.GenericApiCall.getTheObject;

public class GlobalBudgetApis {
    /**
     * @Author Rim Gammoudi
     */


    //Method useful to create an global Budget
    public static Response createAglobalBudget(Object payload, String endPoint) {
        return createAnObject(payload, endPoint);
    }

    //Method useful to eextract a list of global budget with criteria

    public static Response extractAlistOfBudget(HashMap<String, Object> queryParam, String endPoint) {

        return getTheObject(queryParam, endPoint);
    }



}
