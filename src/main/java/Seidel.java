public class Seidel {

    public static int[][] seidelAlgorithm(int[][] graph, int n) {
        // If given graph is an all one matrix,
        //  then all distances are equal 1
        boolean isGraphAllOne = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && graph[i][j] != 1) {
                    isGraphAllOne = false;
                    break;
                }
            }
        }

        boolean isGraphAllZeros = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && graph[i][j] != 0) {
                    isGraphAllZeros = false;
                    break;
                }
            }
        }
        if (isGraphAllZeros || isGraphAllOne) {
            return graph;
        }

        // Boolean matrix multiplication -> graph ** 2
        int[][] squaredGraph = boolMatrixMultiplication(graph, graph, n);

        int[][] matrixA = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && (graph[i][j] == 1 || squaredGraph[i][j] > 0)) {
                    matrixA[i][j] = 1;
                } else {
                    matrixA[i][j] = 0;
                }
            }
        }

        int[][] distances = seidelAlgorithm(matrixA, n);
        int[][] matrixB = boolMatrixMultiplication(distances, graph, n);

        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                degree[i] += graph[i][j];
            }
        }

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrixB[i][j] >= distances[i][j] * degree[j]) {
                    result[i][j] = 2 * distances[i][j];
                } else {
                    result[i][j] = 2 * distances[i][j] - 1;
                }
            }
        }

        return result;
    }

    private static int[][] boolMatrixMultiplication(int[][] a, int[][] b, int n) {
        int[][] multipliedGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int m = 0; m < n; m++) {
                    sum += a[i][m] * b[m][j];
                }
                multipliedGraph[i][j] = sum;
            }
        }

        return multipliedGraph;
    }

    public static void printGraph(int[][] graph, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + ", ");
            }
        }
    }
}
