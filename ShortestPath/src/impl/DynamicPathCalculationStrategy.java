package impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import strategy.IStrategy;

public class DynamicPathCalculationStrategy implements IStrategy {

	public int calculateShortestPath(Node startNode) {

		computePaths(startNode);
		return 0;

	}
	
	public List<Node> getShortestPathTo(Node target)
    {
        List<Node> path = new ArrayList<Node>();
        for (Node vertex = target; vertex != null; vertex = vertex.getPrevious())
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }

	public void computePaths(Node source) {

		source.setDistance(0);
		PriorityQueue<Node> nodeQueue = new PriorityQueue<Node>();
		nodeQueue.add(source);

		while (!nodeQueue.isEmpty()) {
			Node node = nodeQueue.poll();

			Edge[] successor = node.getSuccessor();
			if (successor == null) { continue; }
			for (Edge edge : successor) {
				Node targetNode = edge.target;
				double weight = edge.getWeight();
				double distanceThroughU = node.getDistance() + weight;
				if (distanceThroughU < targetNode.getDistance()) {
					nodeQueue.remove(targetNode);
					targetNode.setDistance(distanceThroughU);
					targetNode.setPrevious(node);
					nodeQueue.add(targetNode);
				}
			}
		}

	}
}