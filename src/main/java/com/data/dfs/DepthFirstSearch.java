package com.data.dfs;

import static java.util.stream.Collectors.toList;

import com.data.model.Graph;
import com.data.model.Node;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class DepthFirstSearch<I> {
  
  List<I> search ( Graph<I> graph, Node<I> rootNode ) {
    
    final List<Node<I>> popNodesInOrder = new ArrayList<>();
    
    final Set<Node<I>> visitedNodes = new LinkedHashSet<>();
    final Stack<Node<I>> toBeExploredNodes = new Stack<>();
    
    toBeExploredNodes.push(rootNode);
    visitedNodes.add(rootNode);
    
    while (!toBeExploredNodes.isEmpty()) {
      Node<I> visited = toBeExploredNodes.pop();
      popNodesInOrder.add(visited);
      
      graph.getAdjNodes(visited)
           .stream()
           .filter(node -> !visitedNodes.contains(node))
           .forEach(node -> {
             toBeExploredNodes.push(node);
             visitedNodes.add(node);
           });
      
    }
    
    return popNodesInOrder.stream()
                       .map(Node::getValue)
                       .collect(toList());
  }
}
