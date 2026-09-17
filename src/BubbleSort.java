public class BubbleSort implements SortingAlgorithm {
    public long nrOfSwaps;
    public long nrOfComparisons;

    @Override
    public void algorithm(double[] arr) {
        int n = arr.length;
        nrOfSwaps = 0;
        nrOfComparisons = 0;
        for (int i = 0; i < n - 1; i++) {//Outer for-loop for traversing each element
            for (int j = 0; j < n - 1 - i; j++) {//Inner for-loop for comparing every element
                nrOfComparisons++;
                if (arr[j] > arr[j + 1]) {//Code lines for swapping elements
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    nrOfSwaps++;
                }
            }
        }
    }
    @Override
    public long getNrOfOperations(){
        return nrOfSwaps;
    }

    @Override
    public long getComparisons(){
        return nrOfComparisons;
    }

    @Override
    public String getName() {
        return "BubbleSort";
    }
}

/*********************************************************************
 * Problem 1: BubbleSort (Non-optimized
 * Code     : Based on the BubbleSort implementation found on
            : https://www.w3schools.com/dsa/dsa_algo_bubblesort.php
 * Notes    : Code is refactored to work with the Wine Quality dataset
 *********************************************************************/