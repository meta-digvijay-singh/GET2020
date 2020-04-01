package graph;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import pojo.Edge;

public class GraphImplTest {
    Graph graph;

    @Test
    public void testGraphConnected() {
        graph = new GraphImpl(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 5, 2);
        boolean isConnected = graph.isConnected();
        assertEquals(true, isConnected);
    }

    @Test
    public void testGraphNotConnected() {
        graph = new GraphImpl(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        boolean isConnected = graph.isConnected();
        assertEquals(false, isConnected);
    }

    @Test
    public void testAllNodesAreReachable() {
        graph = new GraphImpl(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 5, 2);
        List<Integer> actualOutput = graph.reachableNodes(1);
        Collections.sort(actualOutput);
        int[] expectedOutput = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < expectedOutput.length; i++) {
            assertEquals(expectedOutput[i], (int) actualOutput.get(i));
        }
    }

    @Test
    public void testSomeNodesAreReachable() {
        graph = new GraphImpl(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        List<Integer> actualOutput = graph.reachableNodes(1);
        Collections.sort(actualOutput);
        int[] expectedOutput = { 1, 2, 4, 5 };
        for (int i = 0; i < expectedOutput.length; i++) {
            assertEquals(expectedOutput[i], (int) actualOutput.get(i));
        }
    }

    @Test(expected = AssertionError.class)
    public void testReachableNodeDoesNotExist() {
        graph = new GraphImpl(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        graph.reachableNodes(6);

    }

    @Test
    public void testGetMST() {
        graph = new GraphImpl(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 5, 2);
        List<Edge> actualOutput = graph.getMinimumSpanningTree();
        for (Edge edge : actualOutput) {
            System.out.println(edge.getSource() + " " + edge.getDestination()
                    + " " + edge.getWeight());
        }
    }

    @Test
    public void testgetShortestPath() {
        graph = new GraphImpl(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 5, 2);
        List<Integer> actualOutput = graph.shortestPath(1, 4);
        int[] expectedOutput = { 1, 2, 4 };
        for (int i = 0; i < expectedOutput.length; i++) {
            assertEquals(expectedOutput[i], (int) actualOutput.get(i));
        }
    }

    @Test(expected = AssertionError.class)
    public void testgetShortestPathNodeDoesNotExist() {
        graph = new GraphImpl(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        graph.reachableNodes(6);

    }
}
