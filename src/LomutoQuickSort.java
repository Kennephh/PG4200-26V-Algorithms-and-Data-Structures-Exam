import java.util.Random;

/*********************************************************************
* Problem 4: QuickSort
* Code     : Based on the QuickSort implementation found on GeeksforGeeks
           : https://www.geeksforgeeks.org/dsa/quick-sort-algorithm/
* Notes    : Code is refactored to work with the Wine Quality dataset
           : This class handles all four pivot strategies

*********************************************************************/

public class LomutoQuickSort implements SortingAlgorithm {

    public long nrOfSwaps;
    public long nrOfComparisons;
    private int pivotStrategy;
    private Random random;

    public LomutoQuickSort(int pivotStrategy){
        this.random = new Random();
        if(pivotStrategy < 1 || pivotStrategy > 4){
            System.out.println("Invalid pivot strategy chosen. Defaulting to strategy 1.");
            this.pivotStrategy = 1;
        } else{
            this.pivotStrategy = pivotStrategy;
        }
    }

    @Override
    public void algorithm(double[] arr) {
        nrOfSwaps = 0;
        nrOfComparisons = 0;
        if (arr == null || arr.length <= 1) return;
        quickSortRecursive(arr, 0, arr.length - 1);
    }

    public void quickSortRecursive(double[] arr, int low, int high){
        if (low < high) {
            int pivotIndex = partition(arr, low, high, pivotStrategy);
            quickSortRecursive(arr, low, pivotIndex - 1);
            quickSortRecursive(arr, pivotIndex + 1, high);
        }
    }

    private int partition(double[] arr, int low, int high, int pivotStrategy) {
        switch (pivotStrategy) {
            case 1:
                //Case 1 declares the pivot as the first element in the list
                break;
            case 2:
                //Swaps the first and last element in the list, so that the pivot is the last element
                swap(arr, low, high);
                break;
            case 3:
                //Choosing a random pivot point
                int randomPivotIndex = low + random.nextInt((high - low) + 1);
                swap(arr, low, randomPivotIndex);
                break;
            case 4:
                int mid = low + (high - low) / 2;//Finding the value at middle index
                int medianIndex = getMedianIndex(arr, low, mid, high);//Method finds the median value
                swap(arr, low, medianIndex);//Swaps the medianIndex with low so that pivot is the median
                break;
            default:
                System.out.println("Invalid pivot strategy. Reverting to first element as pivot");
                break;
        }
        double pivot = arr[low];
        int i = low;

        for (int j = low + 1; j <= high; j++) {
            nrOfComparisons++;
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, low, i);
        return i;
    }

    private int getMedianIndex(double[] medianIndexList, int low, int mid, int high) {
        double a = medianIndexList[low];
        double b = medianIndexList[mid];
        double c = medianIndexList[high];
        nrOfComparisons++;
        if(a > b){
            nrOfComparisons++;
            if(b > c) return mid;

            nrOfComparisons++;
            if(a > c) return high;
            return low;
        } else{
            nrOfComparisons++;
            if(a > c) return low;

            nrOfComparisons++;
            if(b > c) return high;
            return mid;
        }
    }

    private void swap(double[] arr, int index1, int index2) {
        if (index1 != index2) {
            double temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
            nrOfSwaps++;
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
    public String getName(){
        return "QuickSort, (Pivot strategy: " + pivotStrategy + ")";
    }
}
