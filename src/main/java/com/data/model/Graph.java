package com.data.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<I> {
  
  private Map<Node<I>, List<Node<I>>> adjNodes = new HashMap<>();
  
  public Node<I> addNode ( I nodeValue ) {
    Node<I> node = new Node<>(nodeValue);
    adjNodes.putIfAbsent(node, new ArrayList<>());
    return node;
  }
  
  public void removeNode ( Node<I> v ) {
    adjNodes.values()
            .forEach(list -> list.remove(v));
    adjNodes.remove(v);
  }
  
  public void addEdge ( Node<I> v1, Node<I> v2 ) {
    
    adjNodes.get(v1)
            .add(v2);
    
    adjNodes.get(v2)
            .add(v1);
  }
  
  public void removeEdge ( Node<I> v1, Node<I> v2 ) {
    List<Node<I>> listOfFirstNodes = adjNodes.get(v1);
    List<Node<I>> listOfSecondNodes = adjNodes.get(v2);
    if (listOfFirstNodes!=null) {
      listOfFirstNodes.remove(v2);
    }
    if (listOfSecondNodes!=null) {
      listOfSecondNodes.remove(v1);
    }
  }
  
  public List<Node<I>> getAdjNodes ( Node<I> node ) {
    return adjNodes.get(node);
  }
  
}
