public interface SortingAlgorithm {
    void algorithm(double[] arr);
    long getNrOfOperations();
    long getComparisons();
    String getName();
}
