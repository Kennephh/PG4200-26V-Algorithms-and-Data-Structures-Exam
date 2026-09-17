public class InsertionSort implements SortingAlgorithm {
    public long nrOfShifts;
    public long nrOfComparisons;

    @Override
    public void algorithm(double[] arr) {
        int n = arr.length;
        nrOfShifts = 0;
        nrOfComparisons = 0;

        for (int i = 1; i < n; i++) {
            double key = arr[i];
            int j = i - 1;

            while(j >= 0){ // Comparing / checking if the current element needs to be shifted
                nrOfComparisons++;
                if (arr[j] > key){
                    arr[j + 1] = arr[j]; // Shift one position to the right
                    nrOfShifts++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j+1] = key; // Insert key into its sorted position
        }
    }

    @Override
    public long getNrOfOperations() {
        return nrOfShifts;
    }

    @Override
    public long getComparisons() {
        return nrOfComparisons;
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }
}

/*********************************************************************
 * Problem 2: InsertionSort
 * Code     : Based on the InsertionSort implementation found on GeeksforGeeks
            : https://www.geeksforgeeks.org/dsa/insertion-sort-algorithm/
 * Notes    : Code is refactored to work with the Wine Quality dataset
 *********************************************************************/