package strategy;

public class QuickSortStrategy implements SortingStrategy {

    // starts quick Sort for the complete array
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    //sorts smaller parts of the array
    private void quickSort(int[] array, int low, int high) {

        // continues sorting while the section has more than one element
        if (low < high) {

            // Partitions the array and gets the pivot position
            int pivotIndex = partition(array, low, high);

            // sorts the elements before the pivot
            quickSort(array, low, pivotIndex - 1);

            // sorts the elements after the pivot
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // places the pivot into its correct sorted position
    private int partition(int[] array, int low, int high) {

        // uses the last element as the pivot
        int pivot = array[high];

        // tracks the position for smaller elements
        int i = low - 1;

        // checks every element before the pivot
        for (int j = low; j < high; j++) {

            // checks whether the current value belongs before the pivot
            if (array[j] <= pivot) {

                // moves smaller-element position forward
                i++;


                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // returns the final position of the pivot
        return i + 1;
    }

    // returns the name of this sorting strategy
    @Override
    public String getName() {
        return "Quick Sort";
    }
}
