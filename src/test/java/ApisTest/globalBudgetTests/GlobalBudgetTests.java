package ApisTest.globalBudgetTests;


import configManager.ConfigurationReader;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import pojos.globalBudget.globalBudgetRequestPojo;

import java.util.HashMap;

import static ApisTest.inventoryTests.InventoryTests.pathOfFolderProperty;
import static asserts.Asserts.isResponseStatusCorrect;
import static clientApisCall.GlobalBudgetApis.GlobalBudgetApis.createAglobalBudget;
import static clientApisCall.GlobalBudgetApis.GlobalBudgetApis.extractAlistOfBudget;

@Slf4j
public class GlobalBudgetTests {
    private final String globalBudgetProperty = "globalBudget";
    private final String globalBudgetPeriodProperty = "globalBudgetPeriod";

    //Method useful to  create a globalBudgetTest
    @SneakyThrows
    @Test()
    public void createGlobalBudgetTestShouldBeSuccessful() {
        globalBudgetRequestPojo globalBudget = globalBudgetRequestPojo.builder()
                .month(2)
                .year(2026)
                .value(15).build();
        Response res = createAglobalBudget(globalBudget, ConfigurationReader.getProperty(pathOfFolderProperty) + ConfigurationReader.getProperty(globalBudgetProperty));
        System.out.println(res.body().asPrettyString());
        isResponseStatusCorrect(res, 200);
    }

    //Method useful to  create a globalBudgetTest
    @SneakyThrows
    @Test()
    public void GlobalBudgetTestShouldReturnTheCorrectList() {
        HashMap<String, Object> globalBudget = new HashMap<>();
        globalBudget.put("from", "14-01-2026");
        globalBudget.put("to", "16-02-2026");
        Response res = extractAlistOfBudget(globalBudget, ConfigurationReader.getProperty(pathOfFolderProperty) + ConfigurationReader.getProperty(globalBudgetProperty) + ConfigurationReader.getProperty(globalBudgetPeriodProperty));
        System.out.println(res.body().asPrettyString());
        isResponseStatusCorrect(res, 200);
    }


}
