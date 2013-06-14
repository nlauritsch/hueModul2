package strategy;

import java.util.List;

import impl.Node;

public interface IStrategy {

	public List<Node> getShortestPathTo(Node startNode);
	
	public void computePaths(Node source);

}
