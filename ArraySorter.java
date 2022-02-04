/**
 * 
 */
package edu.ics211.h03;

import java.util.Comparator;
/**
 * @author isaac
 *
 */
public class ArraySorter<E> implements SortsArray<E> {

  private int numSwaps;
  private int numComparisons;
  private double sortTime;
  /**
   * 
   */
  public ArraySorter() {
    // TODO Auto-generated constructor stub
  }
  
  public void insertionSort(Comparator<E> compare, E[] data) {
    //get the start time using System.nanoTime
    //setnumSwaps and numComps to 0
    //set up nextPos int
    double start = System.nanoTime();
    numSwaps = 0;
    numComparisons = 0;
    int nextPos;
    //loop data.length times
    for (int i = 1; i < data.length; i++) {
      //set nextPos to i
      nextPos = i;
      //while nexPos is positive and compare data[nextPos] and data[nextPos - 1]
      while (nextPos > 0 && compare.compare(data[nextPos], data[nextPos - 1]) < 0) {
        //count compare
        numComparisons++;
        //swap data[nextPos] and data[nextPos - 1]
        E nextVal = data[nextPos];
        data[nextPos] = data[nextPos - 1];
        data[nextPos - 1] = nextVal;
        //decrement nextPos for next smallest
        nextPos--;
        //count swap
        numSwaps++;
      }
      //if nextPos is pos
      if (nextPos > 0) {
        //count compare
        numComparisons++;
      }
    }
    //get end time and get sortTime
    double end = System.nanoTime();
    this.sortTime = end - start;
  }
  
  @Override
  public void bubbleSort(Comparator<E> compare, E[] data) {
    //get the start time using System.nanoTime
    //setnumSwaps and numComps to 0
    //boolean didSwap
    double start = System.nanoTime();
    numSwaps = 0;
    numComparisons = 0;
    boolean didSwap;
    do {
      //set didSwap to false
      didSwap = false;
      //loop data.length - 1 times
      for (int j = 0; j < data.length - 1; j++) {
        //count compare
        numComparisons++;
        //compare data[j] to data[j + 1]
        if (compare.compare(data[j], data[j + 1]) > 0) {
          //swap data[j] and data[j + 1]
          E key = data[j];
          data[j] = data[j + 1];
          data[j + 1] = key;
          //count swap
          numSwaps++;
          //set didSwap to true
          didSwap = true;
        }
      }
      //condition
    } while (didSwap);
    //get end time and get sortTime
    double end = System.nanoTime();
    this.sortTime = end - start;
  }
  
  @Override
  public void selectionSort(Comparator<E> compare, E[] data) {
    //get the start time using System.nanoTime
    //setnumSwaps and numComps to 0
    double start = System.nanoTime();
    numSwaps = 0;
    numComparisons = 0;
    
    int n = data.length;
    //loop data.length - 1 times
    for (int i = 0; i < n - 1; i++) {
      //set minimum index to i each interval
      int minIndex = i;
      //loop data.length times
      for (int j = i + 1; j < n; j++) {
        //compare data[j] to data[minIndex]
        if (compare.compare(data[j], data[minIndex]) < 0) {
          //swap data[j] and data[minIndex]
          data[minIndex] = data[j];
          //count compare
          numComparisons++;
        }
        //set data[i] to previous value
        E key = data[minIndex];
        data[minIndex] = data[i];
        data[i] = key;
        //count compare
        numComparisons++;
      }
    }
    //get end time and get sortTime
    double end = System.nanoTime();
    this.sortTime = end - start;
  }
  
  @Override
  public int getNumberOfSwaps() {
    //return numSwaps
    return this.numSwaps;
  }
  
  @Override
  public int getNumberOfComparisons() {
    return this.numComparisons;
  }
  
  @Override
  public double getSortTime() {
    return this.sortTime;
  }

}
