import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeidelTests {

    @Test
    public void allOnesGraph() {
        int[][] graph = {
                {0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0},
        };

        assertArrayEquals(graph, Seidel.seidelAlgorithm(graph, 5));
    }

    @Test
    public void allZerosGraph() {
        int[][] graph = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };

        assertArrayEquals(graph, Seidel.seidelAlgorithm(graph, 6));
    }

    @Test
    public void testOne() {
        int[][] graph = {
                {0, 1, 1, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 1, 0}
        };
        int[][] expected = {
                {0, 1, 1, 2},
                {1, 0, 2, 3},
                {1, 2, 0, 1},
                {2, 3, 1, 0}
        };

        assertArrayEquals(expected, Seidel.seidelAlgorithm(graph, 4));
    }

    @Test
    public void testTwo() {
        int[][] graph = {
                {0, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 0, 0, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1, 0}
        };
        int[][] expected = {
                {0, 1, 1, 2, 1, 1},
                {1, 0, 2, 3, 2, 1},
                {1, 2, 0, 1, 1, 2},
                {2, 3, 1, 0, 2, 3},
                {1, 2, 1, 2, 0, 1},
                {1, 1, 2, 3, 1, 0}
        };

        assertArrayEquals(expected, Seidel.seidelAlgorithm(graph, 6));
    }

    @Test
    public void testThree() {
        int[][] graph = {
                {0, 1, 1,},
                {1, 0, 0},
                {1, 0, 0}
        };
        int[][] expected = {
                {0, 1, 1},
                {1, 0, 2},
                {1, 2, 0}
        };

        assertArrayEquals(expected, Seidel.seidelAlgorithm(graph, 3));
    }
}