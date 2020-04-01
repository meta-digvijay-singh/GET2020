package pojo;

/**
 * Represents edge of a graph.
 * @author Digvijay
 *
 */
public class Edge {
    int source, destination, weight;

    /**
     * Creates and edge with the given source, destination and weight.
     * @param source : source vertex.
     * @param destination : destination vertex.
     * @param weight : weight of the vertex.
     */
    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // Getters and setters.
    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
