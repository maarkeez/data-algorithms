package com.data.dfs;

import static org.assertj.core.api.Assertions.assertThat;

import com.data.model.Graph;
import com.data.testdata.GraphIntegerProvider;
import java.util.List;
import org.junit.Test;

public class DepthFirstSearchTest {
  
  private final DepthFirstSearch<Integer> depthFirstSearch = new DepthFirstSearch<>();
  private static final GraphIntegerProvider testData = new GraphIntegerProvider();
  private static final Graph<Integer> graph = testData.graphTree();
  
  @Test
  public void searchWhenStartsInOne () {
    List<Integer> visitedOrder = depthFirstSearch.search(graph, testData.one());
    assertThat(visitedOrder).containsExactly(1, 2, 5, 3, 4);
  }
  
  @Test
  public void searchWhenStartsInTwo () {
    List<Integer> visitedOrder = depthFirstSearch.search(graph, testData.two());
    assertThat(visitedOrder).containsExactly(2, 5, 1, 3, 4);
  }
  
  @Test
  public void searchWhenStartsInThree () {
    List<Integer> visitedOrder = depthFirstSearch.search(graph, testData.three());
    assertThat(visitedOrder).containsExactly(3, 4, 1, 2, 5);
  }
  
  @Test
  public void searchWhenStartsInFour () {
    List<Integer> visitedOrder = depthFirstSearch.search(graph, testData.four());
    assertThat(visitedOrder).containsExactly(4, 3, 1, 2, 5);
  }
  
  @Test
  public void searchWhenStartsInFive () {
    List<Integer> visitedOrder = depthFirstSearch.search(graph, testData.five());
    assertThat(visitedOrder).containsExactly(5, 2, 1, 3, 4);
  }
  
}