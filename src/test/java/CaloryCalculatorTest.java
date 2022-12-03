import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CaloryCalculatorTest {

    private static Stream<Arguments> getCaloriesValues() {
        return Stream.of(
                Arguments.of(Collections.emptyList(), 0),
                Arguments.of(Collections.singletonList(1), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("getCaloriesValues")
    void getCalories(List<Integer> integerList, int expectedCalories) {
        Inventory inventory = new Inventory(integerList);

        int calories = inventory.getCalories();

        assertThat(calories).isEqualTo(expectedCalories);
    }
}
