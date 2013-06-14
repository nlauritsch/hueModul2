package impl;

public class Node implements Comparable<Node> {

	private String nodeId;
	private Edge [] successor;
	private Node previous;
	private double distance = Double.POSITIVE_INFINITY;

	public Node(String string) {
		nodeId = string;
	}

	public String getName() {
		return nodeId;
	}

	public void setName(String id) {
		nodeId = id;
	}

	public Edge[] getSuccessor() {
		return successor;
	}

	public void setSuccessor(Edge[] successor) {
		this.successor = successor;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distanceThroughU) {
		this.distance = distanceThroughU;
	}

	public String toString() {
		return nodeId + "";
	}

	@Override
	public int compareTo(Node otherNode) {

		int compareResult;

		if (distance < otherNode.getDistance()) {
			compareResult = -1;

		}
		if (distance < otherNode.getDistance()) {
			compareResult = 0;
		} else
			compareResult = 1;

		return compareResult;
	}

}
