package graphs;

/**
 * Created by cary on 6/8/17.
 */
public class Edge<T> {
    public int weight;
    public GraphNode<T> target;

    public Edge(int weight, GraphNode<T> target) {
        this.weight = weight;
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public GraphNode<T> getTarget() {
        return target;
    }

    public void setTarget(GraphNode<T> target) {
        this.target = target;
    }
}
