package strategy;

public interface SortingStrategy {

    // defines the sorting operation that every sorting strategy must implement
    void sort(int[] array);

    // Returns the name of the sorting strategy
    String getName();
}
