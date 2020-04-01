package graph;

import java.util.List;

import pojo.Edge;

public interface Graph {
    
    /**
     * Checks whether graph is connected graph or not.
     * @return true if graph is connected else false.
     */
    boolean isConnected();

    /**
     * Gives the reachable nodes from the given node.
     * @param node : node of the graph.
     * @return list of reachable nodes.
     */
    List<Integer> reachableNodes(int node);

    /**
     * Gives the minimum spanning tree.
     * @return list of edges in the minimum spanning tree.
     */
    List<Edge> getMinimumSpanningTree();

    /**
     * Finds the shortest path for the given vertices.
     * @param vertex1 : starting vertex.
     * @param vertex2 : end vertex.
     * @return list of nodes.
     */
    List<Integer> shortestPath(int vertex1, int vertex2);
    
    /**
     * Adds edge to the graph.
     * @param source : source vertex.
     * @param destination : destination vertex.
     * @param weight : weight of the edge.
     * @return true if edge has successfully been created else false.
     */
    boolean addEdge(int source, int destination, int weight);
}
