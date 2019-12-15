package com.data.bfs;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class BreadthFirstSearchTest {
  
  private final BreadthFirstSearch<Integer> breadthFirstSearch = new BreadthFirstSearch<>();
  
  /*
              1
             /|\
            2 3 4
             \|/
              5
  */
  private static final Graph<Integer> graph = new Graph<>();
  private static final Node<Integer> one = graph.addNode(1);
  private static final Node<Integer> two = graph.addNode(2);
  private static final Node<Integer> three = graph.addNode(3);
  private static final Node<Integer> four = graph.addNode(4);
  private static final Node<Integer> five = graph.addNode(5);
  
  @BeforeClass
  public static void setUp () {
    graph.addEdge(one, two);
    graph.addEdge(one, three);
    graph.addEdge(one, four);
    graph.addEdge(two, five);
    graph.addEdge(three, five);
    graph.addEdge(four, five);
  }
  
  @Test
  public void searchWhenStartsInOne () {
    List<Integer> visitedOrder = breadthFirstSearch.search(graph, one);
    assertThat(visitedOrder).containsExactly(1, 2, 3, 4, 5);
  }
  
  @Test
  public void searchWhenStartsInTwo () {
    List<Integer> visitedOrder = breadthFirstSearch.search(graph, two);
    assertThat(visitedOrder).containsExactly(2, 1, 5, 3, 4);
  }
  
  @Test
  public void searchWhenStartsInThree () {
    List<Integer> visitedOrder = breadthFirstSearch.search(graph, three);
    assertThat(visitedOrder).containsExactly(3, 1, 5, 2, 4);
  }
  
  @Test
  public void searchWhenStartsInFour () {
    List<Integer> visitedOrder = breadthFirstSearch.search(graph, four);
    assertThat(visitedOrder).containsExactly(4, 1, 5, 2, 3);
  }
  
  @Test
  public void searchWhenStartsInFive () {
    List<Integer> visitedOrder = breadthFirstSearch.search(graph, five);
    assertThat(visitedOrder).containsExactly(5, 2, 3, 4, 1);
  }
  
}