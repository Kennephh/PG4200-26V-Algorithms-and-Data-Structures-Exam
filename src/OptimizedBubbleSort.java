public class OptimizedBubbleSort implements SortingAlgorithm {
    long nrOfSwaps;
    long nrOfComparisons;

    @Override
    public void algorithm(double[] arr){
        int n = arr.length;
        nrOfSwaps = 0;
        nrOfComparisons = 0;
        boolean isSwapped;
        for (int i = 0; i < n - 1; i++){
            isSwapped = false;//Set to false by default
            for (int j = 0; j < n - 1 - i; j++){
                nrOfComparisons++;
                if (arr[j] > arr[j + 1]){
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    nrOfSwaps ++;
                    isSwapped = true;
                }
            }
            if (!isSwapped){
                break;//True = break out of loop
            }
        }
    }

    @Override
    public long getNrOfOperations() {
        return nrOfSwaps;
    }

    @Override
    public long getComparisons(){
        return nrOfComparisons;
    }

    @Override
    public String getName(){
        return "Optimized BubbleSort";
    }
}
/*********************************************************************
 * Problem 1: BubbleSort (Optimized)
 * Code     : Based on the BubbleSort implementation found on
            : https://www.geeksforgeeks.org/dsa/bubble-sort-algorithm/
 * Notes    : Code is refactored to work with the Wine Quality dataset
 *********************************************************************/