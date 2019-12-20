package com.data.testdata;

import com.data.model.Graph;
import com.data.model.Node;

public class GraphProvider {
  
  
  
  /**
   * <pre>
   *   1
   *  /|\
   * 2 3 4
   *  \|/
   *   5
   * </pre>
   **/
  public static Graph<Integer> graphWithFiveNodes () {
    Graph<Integer> graph = new Graph<>();
    Node<Integer> one = graph.addNode(1);
    Node<Integer> two = graph.addNode(2);
    Node<Integer> three = graph.addNode(3);
    Node<Integer> four = graph.addNode(4);
    Node<Integer> five = graph.addNode(5);
    graph.addEdge(one, two);
    graph.addEdge(one, three);
    graph.addEdge(one, four);
    graph.addEdge(two, five);
    graph.addEdge(three, five);
    graph.addEdge(four, five);
    return graph;
  }
}
