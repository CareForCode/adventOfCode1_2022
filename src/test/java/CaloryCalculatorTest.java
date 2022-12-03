import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class CaloryCalculatorTest {

    @Test
    void getCalories() {
        Inventory inventory = new Inventory(Collections.emptyList());

        int calories = inventory.getCalories();

        assertThat(calories).isZero();
    }
}
