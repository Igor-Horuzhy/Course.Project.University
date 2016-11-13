package Course_project;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Игорь on 06.11.2016.
 */
public class ReadMatrix {
    Scanner sc;
    int rows,cols;
    int arr[][];
    public void open(File file) {
        try {
            sc = new Scanner(file);
            System.out.println("Успешно открыт");
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось открыть");
        }
    }
    public double[][] readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        while (reader.readLine() != null) rows++;
        reader.close();
        String s = sc.nextLine();
        Scanner fors = new Scanner(s);
        while (fors.hasNext()) {
            if (fors.hasNextInt()) {
                fors.nextInt();
                cols++;
            }
        }
        sc = new Scanner(file);
        double arr[][] = new double[rows][cols];
        int n = 0;
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        arr[i][j] = sc.nextInt();
                    }
                }
            }
        }
        return arr;
    }
    public void close(){
        sc.close();
    }
}
