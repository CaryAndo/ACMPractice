package graphs;

import java.util.List;


public class GraphNode<T> {
    private T data;
    private List<GraphNode<T>> connections;

    public GraphNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GraphNode<T>> getConnections() {
        return connections;
    }

    public void addConnection(GraphNode<T> connection) {
        if (!connections.contains(connection)) {
            connections.add(connection);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphNode<?> graphNode = (GraphNode<?>) o;

        if (data != null ? !data.equals(graphNode.data) : graphNode.data != null) return false;
        return connections != null ? connections.equals(graphNode.connections) : graphNode.connections == null;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (connections != null ? connections.hashCode() : 0);
        return result;
    }
}
