import java.util.List;

public class Inventory {

    private final List<Integer> caloryList;

    public Inventory(List<Integer> caloryList) {
        this.caloryList = caloryList;
    }

    public int getCalories() {
        if (caloryList.isEmpty()) {
            return 0;
        }
        return 1;
    }
}
