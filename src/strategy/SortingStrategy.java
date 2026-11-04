package strategy; //Interface that defines sorting. / Sorting-এর নিয়ম তৈরি করে।

public interface SortingStrategy {

    // defines the sorting operation that every sorting strategy must implement
    void sort(int[] array);

    // Returns the name of the sorting strategy
    String getName();
}
