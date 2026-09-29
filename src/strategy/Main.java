package strategy;

import java.util.Random;

public class Main {

    // creates a random number generator for the test data
    private static final Random random = new Random();

    // starts sorting performance comparison
    public static void main(String[] args) {

        // creates a small random array containing 30 integers
        int[] smallDataSet = generateRandomArray(30);

        // creates a large random array containing 100000 integers
        int[] largeDataSet = generateRandomArray(100000);

        // creates the context used to switch between sorting strategies
        SortingContext context = new SortingContext();

        // tests Bubble Sort with both data sets
        testStrategy(
                context,
                new BubbleSortStrategy(),
                smallDataSet,
                largeDataSet
        );

        // tests Merge Sort with both data sets
        testStrategy(
                context,
                new MergeSortStrategy(),
                smallDataSet,
                largeDataSet
        );

        // tests quick Sort with both data sets
        testStrategy(
                context,
                new QuickSortStrategy(),
                smallDataSet,
                largeDataSet
        );
    }

    // generates an array containing random integer values
    private static int[] generateRandomArray(int size) {

        // Creates an array with the requested size
        int[] array = new int[size];

        // Generates a random value for every array position
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }

        // Returns the generated random array
        return array;
    }

    // Tests one strategy using both the small and large data sets
    private static void testStrategy(
            SortingContext context,
            SortingStrategy strategy,
            int[] smallDataSet,
            int[] largeDataSet) {

        // Changes the sorting algorithm using the Strategy Pattern
        context.setStrategy(strategy);

        // Prints the name of the selected sorting algorithm

        System.out.println("\n========== " + context.getStrategyName() + " ==========");

        // Tests the algorithm with the small data set
        runTest(
                context,
                copyArray(smallDataSet),
                "Small data set"
        );

        // Tests the algorithm with the large data set
        runTest(
                context,
                copyArray(largeDataSet),
                "Large data set"
        );
    }

    // Measures the execution time of the selected sorting strategy
    private static void runTest(
            SortingContext context,
            int[] data,
            String dataSetName) {

        // Records the starting time before sorting
        long startTime = System.nanoTime();

        // Sorts the array using the currently selected strategy
        context.sort(data);

        // Records the ending time after sorting.
        long endTime = System.nanoTime();

        // Calculates the total sorting time in nanoseconds
        long duration = endTime - startTime;

        // Converts nanoseconds into milliseconds
        double milliseconds = duration / 1_000_000.0;

        // Prints the name and size of the tested data set
        System.out.println(dataSetName + " (" + data.length + " elements)");

        // Prints the measured execution time.
        System.out.printf("Execution time: %.3f ms%n", milliseconds);

        // Checks and prints whether the array was sorted correctly
        System.out.println("Sorted correctly: " + isSorted(data));
    }

    // creates a separate copy every algorithm receives the same original data
    private static int[] copyArray(int[] original) {

        // creates a new array with the same size
        int[] copy = new int[original.length];

        // copies each value manually into the new array
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }

        return copy;
    }

    // checks all numbers are ordered from smallest to largest
    private static boolean isSorted(int[] array) {

        for (int i = 1; i < array.length; i++) {


            if (array[i - 1] > array[i]) {
                return false;
            }
        }

        // returns true when the complete array is correctly sorted
        return true;
    }
}