package impl;

public class Edge {

	public final Node target;
	public final double weight;

	public Edge(Node argTarget, int argWeight) {
		target = argTarget;
		weight = argWeight;
	}

	public Node getTarget() {
		return target;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Edge [target=" + target + ", weight=" + weight + "]";
	}

}
