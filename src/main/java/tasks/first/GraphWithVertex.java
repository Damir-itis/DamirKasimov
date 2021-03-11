package tasks.first;

import java.util.ArrayDeque;
import java.util.HashSet;

public class GraphWithVertex {
    HashSet<Integer> metOfVertexes = new HashSet<>();
    ArrayDeque<Integer> metOfDeque = new ArrayDeque<>();
    boolean[][] adjacencyMatrix;


    public String breadthFirst(boolean[][] adjacencyMatrix, int startIndex) {
        String bypassingOfWide = " " + startIndex;
        this.adjacencyMatrix = adjacencyMatrix;
        addAllChildrenToDeque(startIndex);
        metOfVertexes.add(startIndex);
        boolean flag = false;
        while (!flag) {
            if (metOfDeque.peekFirst() != null) {
                startIndex = metOfDeque.pollFirst();
                bypassingOfWide = checkVertex(startIndex, bypassingOfWide);
            } else {
                flag = true;
            }
        }
        return bypassingOfWide;
    }


    public String checkVertex(int vertex, String bypassingOfWide) {
        if (!metOfVertexes.contains(vertex)) {
            metOfVertexes.add(vertex);
            addAllChildrenToDeque(vertex);
            bypassingOfWide = bypassingOfWide.concat(", " + vertex);
        }
        return bypassingOfWide;
    }


    private void addAllChildrenToDeque(int vertex) {
        for (int i = 0; i < adjacencyMatrix[vertex - 1].length; i++) {
            if (adjacencyMatrix[i - 1][i]) metOfDeque.add(i + 1);
        }
    }
}
