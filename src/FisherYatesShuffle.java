import java.util.Random;

public class FisherYatesShuffle {
    private static final Random random = new Random();
    // Fisher-Yates shuffle
    public static void shuffle(double[] arr){
        for (int i = arr.length - 1; i > 0; i--){
            int j = random.nextInt(i + 1);
            double temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

/*********************************************************************
 * Fisher-Yates shuffle
 * Code: Based on the Fisher-Yates shuffle from GeeksForGeeks
 https://www.geeksforgeeks.org/dsa/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/
 *********************************************************************/