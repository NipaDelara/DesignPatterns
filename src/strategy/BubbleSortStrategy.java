package strategy;

public class BubbleSortStrategy implements SortingStrategy {

    //sorts the array using the bubble sort algorithm

    @Override
    public void sort(int[] array) {

        // stores the number of elements in the array
        int n = array.length;

        // Repeats passes
        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                // Checks whether the elements are in the wrong order
                if (array[j] > array[j + 1]) {

                    // Stores one value temporarily.
                    int temp = array[j];

                    // Moves the smaller value to the lef
                    array[j] = array[j + 1];

                    // Moves the larger value to the right
                    array[j + 1] = temp;

                    // Records that a swap happened
                    swapped = true;
                }
            }
            // Stops early when the array is already sorted.
            if (!swapped) {
                break;
            }
        }
    }
    // Returns the strategy name
    @Override
    public String getName() {
        return "Bubble Sort";
    }
}
