package pojos.globalBudget;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class globalBudgetRequestPojo {
    /**
     * @Author Rim Gammoudi QA automation engineer
     **/
    private int month;
    private int value;
    private int year;
}
