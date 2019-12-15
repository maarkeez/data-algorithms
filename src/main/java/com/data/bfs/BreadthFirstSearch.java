package com.data.bfs;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch<I> {
  
  
  
  public List<I> search ( Graph<I> graph, Node<I> rootNode ) {
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

class Node<I> {
  
  I value;
  
  Node ( I value ) {
    if (value==null) {
      throw new IllegalArgumentException("Node value can not be empty");
    }
    this.value = value;
  }
  
  boolean valueEquals ( Object o ) {
    return value.equals(o);
  }
  
  I getValue () {
    return value;
  }
  
  @Override
  public String toString () {
    return value.toString();
  }
  
}

class Graph<I> {
  
  private Map<Node<I>, List<Node<I>>> adjNodes = new HashMap<>();
  
  Node<I> addNode ( I nodeValue ) {
    Node<I> node = new Node<>(nodeValue);
    adjNodes.putIfAbsent(node, new ArrayList<>());
    return node;
  }
  
  void removeNode ( Node<I> v ) {
    adjNodes.values()
            .forEach(list -> list.remove(v));
    adjNodes.remove(v);
  }
  
  void addEdge ( Node<I> v1, Node<I> v2 ) {
    
    adjNodes.get(v1)
            .add(v2);
    
    adjNodes.get(v2)
            .add(v1);
  }
  
  void removeEdge ( Node<I> v1, Node<I> v2 ) {
    List<Node<I>> listOfFirstNodes = adjNodes.get(v1);
    List<Node<I>> listOfSecondNodes = adjNodes.get(v2);
    if (listOfFirstNodes!=null) {
      listOfFirstNodes.remove(v2);
    }
    if (listOfSecondNodes!=null) {
      listOfSecondNodes.remove(v1);
    }
  }
  
  List<Node<I>> getAdjNodes ( Node<I> node ) {
    return adjNodes.get(node);
  }
  
}