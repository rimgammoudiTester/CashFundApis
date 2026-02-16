package ApisTest.inventoryTests;

import asserts.Asserts;
import configManager.ConfigurationReader;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import pojos.inventory.RequestInventory;

import java.awt.*;

import static asserts.Asserts.isResponseStatusCorrect;
import static clientApisCall.inventoryApis.InventoryApis.createAnInventory;
import static enums.inventory.typeEnum.PARTIEL;



@Slf4j
public class InventoryTests {

    private final String pathOfInventoryCreationProperty="pathCreateInventory";
    private final String pathOfFolderProperty="folder";




    /**@Author Rim Gammoudi **/


    //Veryfing the creating of the inventory is sucessfully done


    @Test()
    @SneakyThrows
    public void createAnInventoryShouldBeSuccessfull()
    {
        //Serliazation

        RequestInventory requestInventory= RequestInventory.builder()
                .name("inventoryTest")
                .date("2026-02-15")
                .type(PARTIEL)
                //.inventoryId(12)
                .build();
        String endPoint=ConfigurationReader.getProperty(pathOfFolderProperty)+ConfigurationReader.getProperty(pathOfInventoryCreationProperty);
         Response res =createAnInventory(requestInventory,endPoint);
        isResponseStatusCorrect(res,200);
        log.info("The responce is succesfully passing");
         System.out.println("The response json : "+res.body().asPrettyString());

    }

}
