import java.util.Arrays;

public class PrintResults {

    public static void print(String algName, double[] sorted, long avgTimeOrig, long avgTimeShuf,
                             long nrOfOriginalSwaps, long nrOfShuffledSwaps, long nrOfOriginalCps, long nrOfShuffledCps){
        System.out.println("--- " + algName + " ---");
        System.out.println("Average Time (Original): " + avgTimeOrig + " ns");
        System.out.println("Average Time (Shuffled): " + avgTimeShuf + " ns");

        System.out.println("============================================");

        System.out.println("Number of Swaps/Shifts/Merge-operations (Original): " + nrOfOriginalSwaps);
        System.out.println("Number of Swaps/Shifts/Merge-operations (Shuffled): " + nrOfShuffledSwaps);

        System.out.println("============================================");

        System.out.println("Number of Comparisons (Original): " + nrOfOriginalCps);
        System.out.println("Number of Comparisons (Shuffled): " + nrOfShuffledCps);
        System.out.println("Sorted: " + Arrays.toString(sorted));
        System.out.println("============================================");
    }
}
