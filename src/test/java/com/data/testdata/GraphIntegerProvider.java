package com.data.testdata;

import com.data.model.Graph;
import com.data.model.Node;

public class GraphIntegerProvider {
  
  private final Graph<Integer> graph = new Graph<>();
  private final Node<Integer> one = graph.addNode(1);
  private final Node<Integer> two = graph.addNode(2);
  private final Node<Integer> three = graph.addNode(3);
  private final Node<Integer> four = graph.addNode(4);
  private final Node<Integer> five = graph.addNode(5);
  
  /**
   * <pre>
   *   1
   *  /|\
   * 2 3 4
   *  \|/
   *   5
   * </pre>
   **/
  public Graph<Integer> graphDiamond () {
    graph.addEdge(one, two);
    graph.addEdge(one, three);
    graph.addEdge(one, four);
    graph.addEdge(two, five);
    graph.addEdge(three, five);
    graph.addEdge(four, five);
    return graph;
  }
  
  /**
   * <pre>
   *   1
   *  /|
   * 2 3
   * | |
   * 5 4
   * </pre>
   **/
  public Graph<Integer> graphTree () {
    graph.addEdge(one, three);
    graph.addEdge(three, four);
   
    graph.addEdge(one, two);
    graph.addEdge(two, five);
    return graph;
  }
  
  
  public Node<Integer> one () {
    return one;
  }
  
  public Node<Integer> two () {
    return two;
  }
  
  public Node<Integer> three () {
    return three;
  }
  
  public Node<Integer> four () {
    return four;
  }
  
  public Node<Integer> five () {
    return five;
  }
}
