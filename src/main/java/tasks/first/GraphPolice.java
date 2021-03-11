package tasks.first;

import java.util.Scanner;

public class GraphPolice {
    public static boolean[][] inputAdjacencyMatrix(Scanner in) {
        System.out.println("Количество вершин: ");
        int vertexCount = in.nextInt();
        boolean[][] matrix = new boolean[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                int digit = in.nextInt();
                if (digit == 1) {
                    matrix[i][j] = true;
                }
            }
        }
        return matrix;
    }
}
