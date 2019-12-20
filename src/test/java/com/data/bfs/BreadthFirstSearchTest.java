package com.data.bfs;


import static org.assertj.core.api.Assertions.assertThat;

import com.data.model.Graph;
import com.data.testdata.GraphIntegerProvider;
import java.util.List;
import org.junit.Test;

public class BreadthFirstSearchTest {
  
  private final BreadthFirstSearch<Integer> breadthFirstSearch = new BreadthFirstSearch<>();
  private static final GraphIntegerProvider testData = new GraphIntegerProvider();
  private static final Graph<Integer> graph = testData.graphDiamond();
  
  @Test
  public void searchWhenStartsInOne () {
    List<Integer> visitedOrder = breadthFirstSearch.search(graph, testData.one());
    assertThat(visitedOrder).containsExactly(1, 2, 3, 4, 5);
  }
  
  @Test
  public void searchWhenStartsInTwo () {
    List<Integer> visitedOrder = breadthFirstSearch.search(graph, testData.two());
    assertThat(visitedOrder).containsExactly(2, 1, 5, 3, 4);
  }
  
  @Test
  public void searchWhenStartsInThree () {
    List<Integer> visitedOrder = breadthFirstSearch.search(graph, testData.three());
    assertThat(visitedOrder).containsExactly(3, 1, 5, 2, 4);
  }
  
  @Test
  public void searchWhenStartsInFour () {
    List<Integer> visitedOrder = breadthFirstSearch.search(graph, testData.four());
    assertThat(visitedOrder).containsExactly(4, 1, 5, 2, 3);
  }
  
  @Test
  public void searchWhenStartsInFive () {
    List<Integer> visitedOrder = breadthFirstSearch.search(graph, testData.five());
    assertThat(visitedOrder).containsExactly(5, 2, 3, 4, 1);
  }
  
}