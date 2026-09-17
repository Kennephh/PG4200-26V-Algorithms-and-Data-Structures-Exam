public class MergeSort implements SortingAlgorithm {
    private long nrOfMergeOperations;
    private long nrOfComparisons;

    @Override
    public void algorithm(double[] arr){
        nrOfMergeOperations = 0;
        nrOfComparisons = 0;
        mergeSortRecursive(arr);
    }

    private void mergeSortRecursive(double[] arr) { // Divide
        int n = arr.length;

        if (n > 1) {
            int midIndex = n / 2;
            double[] left = new double[midIndex];
            double[] right = new double[n - midIndex];

            System.arraycopy(arr, 0, left, 0, midIndex);
            System.arraycopy(arr, midIndex, right, 0, n - midIndex);

            mergeSortRecursive(left); // Recursively sort each half
            mergeSortRecursive(right);
            merge(arr, left, right); // Merge the two sorted arrays back together
            nrOfMergeOperations++;
        }
    }

    private void merge(double[] arr, double[] left, double[] right){ // Conquer

        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize){ // Compare elements from both halves
            nrOfComparisons++;
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements
        while (i < leftSize){
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < rightSize){
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    @Override
    public long getNrOfOperations(){
        return nrOfMergeOperations;
    }

    @Override
    public long getComparisons(){
        return nrOfComparisons;
    }

    @Override
    public String getName(){
        return "MergeSort";
    }
}

/*********************************************************************
 * Problem 3: MergeSort
 * Code     : Based on the pseudocode for merge sort found on pseudoeditor
            : https://pseudoeditor.com/guides/merge-sort
 * Notes    : Code is refactored to work with the Wine Quality dataset
 *********************************************************************/