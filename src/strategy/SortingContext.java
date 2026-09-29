package strategy;

public class SortingContext {

    // Stores the currently selected sorting strategy
    private SortingStrategy strategy;

    // Changes the sorting strategy while the program is running
    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    // Uses the selected strategy to sort an array
    public void sort(int[] array) {

        // Checks that a sorting strategy has been selected
        if (strategy == null) {
            throw new IllegalStateException("Sorting strategy is not set.");
        }

        // Delegates the sorting work to the selected strategy
        strategy.sort(array);
    }

    // Returns the name of the selected strategy
    public String getStrategyName() {

        // Handles the case where no strategy has been selected
        if (strategy == null) {
            return "No strategy";
        }

        // Gets the name from the selected strategy
        return strategy.getName();
    }
}