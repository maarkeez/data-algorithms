package com.data.bfs;

import static java.util.stream.Collectors.toList;

import com.data.model.Graph;
import com.data.model.Node;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class BreadthFirstSearch<I> {
  
  
  
  List<I> search ( Graph<I> graph, Node<I> rootNode ) {
    final Set<Node<I>> visitedNodes = new LinkedHashSet<>();
    
    final Queue<Node<I>> toBeExploredNodes = new LinkedList<>();
    
    toBeExploredNodes.add(rootNode);
    visitedNodes.add(rootNode);
    
    while (!toBeExploredNodes.isEmpty()) {
      Node<I> visited = toBeExploredNodes.poll();
      
      graph.getAdjNodes(visited)
           .stream()
           .filter(node -> !visitedNodes.contains(node))
           .forEach(node -> {
             toBeExploredNodes.add(node);
             visitedNodes.add(node);
           });
      
    }
    
    return visitedNodes.stream()
                       .map(Node::getValue)
                       .collect(toList());
  }
  
}

