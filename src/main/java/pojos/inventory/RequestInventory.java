package pojos.inventory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import enums.inventory.typeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class RequestInventory {
    private String name;
    //private int inventoryId;
    private String date;
     private typeEnum type;




}
