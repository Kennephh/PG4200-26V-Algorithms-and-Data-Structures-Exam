import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadAlcoholValues {
    public static ArrayList<Double> readFromFile(String... filePaths) throws FileNotFoundException {

        ArrayList<Double> values = new ArrayList<>();

        for (String filePath : filePaths){
            File file = new File(filePath);
            try (Scanner scanner = new Scanner(file)) {
                scanner.nextLine();
                while (scanner.hasNextLine()) {
                    String[] columns = scanner.nextLine().split(";");
                    double alcoholValue = Double.parseDouble(columns[10]);
                    values.add(alcoholValue);
                }
            }
        }
        return values;
    }

    public static double[] removeDuplicates(ArrayList<Double> values){
        return values.stream()
                .distinct()
                .mapToDouble(Double::doubleValue)
                .toArray();
    }
}
