package Course_project;

import java.util.Arrays;

/**
 * Created by Игорь on 07.11.2016.
 */
public class Operations {
    public static int[][] multiplyMatrix(final double[][] firstMatrix,
                                          final double[][] secondMatrix) {
        final int rowCount = firstMatrix.length;             // Число строк результирующей матрицы.
        final int colCount = secondMatrix[0].length;         // Число столбцов результирующей матрицы.
        final int sumLength = secondMatrix.length;           // Число членов суммы при вычислении значения ячейки.
        final int[][] result = new int[rowCount][colCount];  // Результирующая матрица.
        if(firstMatrix[0].length == secondMatrix.length) {
            for (int row = 0; row < rowCount; ++row) {  // Цикл по строкам матрицы.
                for (int col = 0; col < colCount; ++col) {  // Цикл по столбцам матрицы.
                    int sum = 0;
                    for (int i = 0; i < sumLength; ++i)
                        sum += firstMatrix[row][i] * secondMatrix[i][col];
                    result[row][col] = sum;
                }
            }

            return result;
        }
        return null;
    }
}


