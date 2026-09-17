public class SortBenchmark {
    public static void runBenchmark(SortingAlgorithm sorter, double[] originalArr, int runs) {
        long totalOrigTime = 0, totalOrigSwaps = 0, totalOrigCps = 0;
        long totalShufTime = 0, totalShufSwaps = 0, totalShufCps = 0;

        // JVM warm up
        for (int i = 0; i < 200; i++) {
            sorter.algorithm(originalArr.clone());
        }

        for (int i = 0; i < runs; i++) {
            double[] origArr = originalArr.clone();
            double[] shufArr = originalArr.clone();
            FisherYatesShuffle.shuffle(shufArr);

            // Timing original
            long startO = System.nanoTime();
            sorter.algorithm(origArr);
            totalOrigTime += (System.nanoTime() - startO);
            totalOrigSwaps += sorter.getNrOfOperations();
            totalOrigCps += sorter.getComparisons();

            // Timing shuffled
            long startS = System.nanoTime();
            sorter.algorithm(shufArr);
            totalShufTime += (System.nanoTime() - startS);
            totalShufSwaps += sorter.getNrOfOperations();
            totalShufCps += sorter.getComparisons();
        }

        double[] sorted = originalArr.clone();
        sorter.algorithm(sorted);

        PrintResults.print(sorter.getName(), sorted,
                totalOrigTime / runs, totalShufTime / runs,
                totalOrigSwaps / runs, totalShufSwaps / runs,
                totalOrigCps / runs, totalShufCps / runs);
    }
}
