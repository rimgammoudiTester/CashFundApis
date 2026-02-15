package clientApisCall.inventoryApis;

import io.restassured.response.Response;

import java.util.HashMap;

import static genericApi.GenericApiCall.*;

public class InventoryApis {

    /**
     * @Author Rim Gammoudi
     */

    //method useful to create an inventory
    public static Response createAnInventory(Object payload, String endPoint) {
        return createAnObject(payload, endPoint);
    }

    //method useful to return  an inventory or list of inventories

    public static Response returnListOfInventory(HashMap<String, Object> queryToSend, String endPoint) {
        return getTheObject(queryToSend, endPoint);
    }


    //method useful to return  an inventory or list of inventories
    public static Response returnListOfInventory(Object pathParameter, String parameterName, String endPoint) {
        return getTheObjectWithPathParameter(pathParameter, parameterName, endPoint);
    }


    //method useful to update an inventory depending on criterias

    public static Response updateInventory(HashMap<String, Object> queryToSend, String endPoint) {

        return updateTheObject(queryToSend, endPoint);
    }

    //method useful to update an inventory depending on criterias

    public static Response deleteInventory(Object pathParameter, String parameterName, String endPoint) {

        return deleteTheObject(pathParameter, parameterName, endPoint);
    }


}
