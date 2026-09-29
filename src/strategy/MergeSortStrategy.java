package strategy;

public class MergeSortStrategy implements SortingStrategy {

    // Start merge sort for the complete array
    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    // divides array into smaller parts
    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {

            // finds the middle position
            int middle = left + (right - left) / 2;

            // sort left half
            mergeSort(array, left, middle);

            // sort right half
            mergeSort(array, middle + 1, right);

            // combines the two sorted halves
            merge(array, left, middle, right);
        }
    }

    // merges two sorted parts of the array
    private void merge(int[] array, int left, int middle, int right) {
        int size1 = middle - left + 1;
        int size2 = right - middle;

        // creates temporary arrays for both halves
        int[] leftArray = new int[size1];
        int[] rightArray = new int[size2];

        // copies values into the left temporary array
        for (int i = 0; i < size1; i++) {
            leftArray[i] = array[left + i];
        }

        // copies values into the right temporary array
        for (int i = 0; i < size2; i++) {
            rightArray[i] = array[middle + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        // places the smaller values back into the original array
        while (i < size1 && j < size2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // copies any remaining values from the left array
        while (i < size1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // copies any remaining values from the right array
        while (j < size2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // returns the strategy name
    @Override
    public String getName() {
        return "Merge Sort";
    }
}