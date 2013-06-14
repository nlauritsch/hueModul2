package shortestPath;

import impl.Edge;
import impl.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import strategy.IStrategy;
import strategy.StrategyFactory;

public class Calculator {

	private static Map<String, Node> nodeList = new HashMap<String, Node>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 0, 2, 3, 6 }, { 0, 8, 5, 7 },
				{ 1, 2, 0, 8 }, { 8, 8, 8, 8 }, { 1, 2, 3, 4 }, { 9, 0, 9, 9 },
				{ 1, 2, 1, 1 } };

		String strategyName = "Dynamic";
		StrategyFactory strategyFactory = new StrategyFactory();

		IStrategy strategy = strategyFactory.generateStrategy(strategyName);

		Map<String, Node> allNodes = createNodes(matrix);
		strategy.computePaths(allNodes.get(getKey(0, 0)));

		for (Node v : allNodes.values()) {
			System.out.println("Distance to " + v + ": " + v.getDistance());
			List<Node> path = strategy.getShortestPathTo(v);
			System.out.println("Path: " + path);
		}
		List<Node> shortestPathTo = strategy.getShortestPathTo(allNodes
				.get(getKey(6, 3)));

	}

	private static Map<String, Node> createNodes(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				String key = getKey(i, j);
				nodeList.put(key, new Node(key));

			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				List<Edge> edges = new ArrayList<Edge>();
				if ((i == 0) || (i < matrix.length - 1)) {
					String key2 = getKey(i + 1, j);
					int weight = matrix[i + 1][j];
					Edge edge = new Edge(nodeList.get(key2), weight);
					edges.add(edge);
				}
				if ((i > 0) && (j > 0) && (j < matrix[i].length - 1)) {
					String key2 = getKey(i - 1, j);
					int weight = matrix[i - 1][j];
					Edge edge = new Edge(nodeList.get(key2), weight);
					edges.add(edge);
				}
				if (j < matrix[i].length - 1) {
					String key2 = getKey(i, j + 1);
					int weight = matrix[i][j + 1];
					Edge edge = new Edge(nodeList.get(key2), weight);
					edges.add(edge);
				}
				if ((j > 0)
						&& ((i != 0) && (j != 1))
						&& ((i != matrix.length - 1) && (j != matrix[i].length - 1))) {
					String key2 = getKey(i, j - 1);
					int weight = matrix[i][j - 1];
					Edge edge = new Edge(nodeList.get(key2), weight);
					edges.add(edge);
				}
				String key = getKey(i, j);
				Node node = nodeList.get(key);
				if (!edges.isEmpty()) {
					Edge[] edgesArray = new Edge[edges.size()];
					int e = 0;
					String log = "";
					for (Edge edge : edges) {
						edgesArray[e] = edge;
						e++;
						log += edge + ", ";
					}
					node.setSuccessor(edgesArray);
				}
			}
		}
		return nodeList;

	}

	private static String getKey(int i, int j) {
		StringBuffer key = new StringBuffer(String.valueOf(i));
		key.append(",");
		key.append(String.valueOf(j));
		return key.toString();
	}
}
