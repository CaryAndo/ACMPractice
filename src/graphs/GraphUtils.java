package graphs;

import com.sun.tools.javac.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public final class GraphUtils {
    private GraphUtils() {

    }

    public static GraphNode<?> findCheapestLeaf(GraphNode<?> root) {
        return findCheapestLeaf(root, null, 0).fst;
    }

    private static Pair<GraphNode<?>, Integer> findCheapestLeaf(GraphNode<?> node,
                                                                Pair<GraphNode<?>, Integer> minimum,
                                                                int cost) {

        if (node.getConnections().size() == 0) {
            if (minimum == null) {
                return new Pair<>(node, cost);
            } else if (cost < minimum.snd) {
                return new Pair<>(node, cost);
            } else {
                return minimum;
            }
        } else {
            Pair<GraphNode<?>, Integer> tempMin = minimum;
            for (Edge connection : node.getConnections()) {
                Pair<GraphNode<?>, Integer> minimumChild
                        = findCheapestLeaf(connection.getTarget(), minimum, cost + connection.getWeight());
                if (tempMin == null || minimumChild.snd < tempMin.snd) {
                    tempMin = minimumChild;
                }
            }

            return tempMin;
        }
    }

    public static GraphNode<Integer> findCheapestLeafBFS(GraphNode<Integer> root) {
        Queue<GraphNode<Integer>> queue = new LinkedList<>();
        return null;
    }
}
