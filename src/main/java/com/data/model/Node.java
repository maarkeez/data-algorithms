package com.data.model;

public class Node<I> {
  
  private I value;
  
  Node ( I value ) {
    if (value==null) {
      throw new IllegalArgumentException("Node value can not be empty");
    }
    this.value = value;
  }
  
  public boolean valueEquals ( Object o ) {
    return value.equals(o);
  }
  
  public I getValue () {
    return value;
  }
  
  @Override
  public String toString () {
    return value.toString();
  }
  
}