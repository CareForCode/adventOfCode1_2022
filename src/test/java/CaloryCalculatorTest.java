import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CaloryCalculatorTest {

    private static Stream<Arguments> getCaloriesValues() {
        return Stream.of(
                Arguments.of(Collections.emptyList(), 0),
                Arguments.of(Collections.singletonList(1), 1),
                Arguments.of(List.of(1,2), 3),
                Arguments.of(List.of(1000,2000,3000), 6000),
                Arguments.of(List.of(5000,6000), 11000)
        );
    }

    @ParameterizedTest
    @MethodSource("getCaloriesValues")
    void getCalories(List<Integer> integerList, int expectedCalories) {
        Inventory inventory = new Inventory(integerList);

        int calories = inventory.getCalories();

        assertThat(calories).isEqualTo(expectedCalories);
    }

    @Test
    void result1() {
        BufferedReader reader;
        int totalSum = 0;

        List<Integer> caloryList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("src/test/resources/adventOfCode1Input.txt"));
            String line = reader.readLine();
            List<Integer> inventory = new ArrayList<>();
            while (line != null) {
                if (line.equals("")) {
                    caloryList.add(new Inventory(inventory).getCalories());
                    inventory.clear();
                } else {
                    inventory.add(Integer.valueOf(line));
                }
                // read next line
                line = reader.readLine();
            }
            caloryList.add(new Inventory(inventory).getCalories());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int highestCalories = caloryList.stream().mapToInt(value -> value).max().orElse(0);

        assertThat(highestCalories).isEqualTo(68802);
    }
}
