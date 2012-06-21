/**
 * 
 */
package org.coode.oppl.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * @author Luigi Iannone
 * 
 */
public abstract class SearchTree<N> {
	
	private HashSet<N> r_set = new HashSet<N>();
	private HashSet<N> p_set = new HashSet<N>();
	
	protected boolean depthFirstSearch(N start, Stack<N> result) {
		if (r_set.contains(start)) {
			return false;
		}
		result.push(start);
		r_set.add(start);
		boolean goalReached = this.goalReached(start);
		if (goalReached) {
			return true;
		}
		List<N> children = this.getChildren(start);
		for (int i = 0; i < children.size(); i++) {
			N child = children.get(i);
			if (this.depthFirstSearch(child, result)) {
				return true;
			}
		}
		// No path was found
		result.pop();
		r_set.remove(start);
		return false;
	}

	protected boolean exhaustiveDepthFirstSearch(N start,
			Stack<N> currrentPath, List<List<N>> solutions) {
		if (p_set.contains(start)) {
			return false;
		}
		currrentPath.push(start);
		p_set.add(start);
		boolean goalReached = this.goalReached(start);
		if (goalReached) {
			solutions.add(new ArrayList<N>(currrentPath));
			currrentPath.pop();
			p_set.remove(start);
			return true;
		}
		List<N> children = this.getChildren(start);
		boolean found = false;
		for (int i = 0; i < children.size(); i++) {
			N child = children.get(i);
			boolean searchSubTree = this.exhaustiveDepthFirstSearch(child,
					currrentPath, solutions);
			found = found || searchSubTree;
		}
		currrentPath.pop();
		p_set.remove(start);
		return found;
	}

	public boolean exhaustiveSearchTree(N start, List<List<N>> solutions) {
		solutions.clear();
		return this
				.exhaustiveDepthFirstSearch(start, new Stack<N>(), solutions);
	}

	protected abstract List<N> getChildren(N node);

	protected abstract boolean goalReached(N node);
}
