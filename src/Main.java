import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Reading CSV values
        ArrayList<Double> values = ReadAlcoholValues.readFromFile(
                "files/winequality-red.csv",
                "files/winequality-white.csv"
        );
        // Removing duplicates and setting the number of times the algorithm runs to get an accurate average time.
        double[] uniqueValues = ReadAlcoholValues.removeDuplicates(values);
        int runs = 1000;


        /**************************************************************
        * Choose sorting algorithm by removing "//" from one or multiple lines.
         ***************************************************************/

        SortBenchmark.runBenchmark(new BubbleSort(), uniqueValues, runs);
        //SortBenchmark.runBenchmark(new OptimizedBubbleSort(), uniqueValues, runs);
        //SortBenchmark.runBenchmark(new InsertionSort(), uniqueValues, runs);
        //SortBenchmark.runBenchmark(new MergeSort(), uniqueValues, runs);
        //SortBenchmark.runBenchmark(new LomutoQuickSort(1), uniqueValues, runs);
        /*
        * Send in a number between 1-4 on line 24 for the different pivot strategies for QuickSort:
        * 1: The first element as pivot
        * 2: The last element as pivot
        * 3: Random element as pivot
        * 4: Median-of-three element as pivot
        * */


    }
}
