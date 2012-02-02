import static org.junit.Assert.*;
import org.junit.*;
import junit.framework.TestCase;

import java.lang.reflect.*;
import java.util.*;

public class Recursion {
  public static void main(String[] derps) {
    org.junit.runner.JUnitCore.main(Recursion.class.getName());
  }
  

  // getTimeToCleanRoom returns the amount of time to clean
  // a room of X by Y size
  // precondition: the room isn't negative lengthed
  // have you ever seen such a thing?
  public static int getTimeToCleanRoom(int x, int y) {
    //Base Case -- When do we quit?
    if(y == 0 && x == 0)
      return 0;

    // Recursive Case
    int topRowTime = (5 * x);
    // While writing code... assume that all calls
    // to methods will return what you expect
    int rest       = getTimeToCleanRoom(x, y - 1);
    int totalTime = topRowTime + rest;
    return totalTime;
  }

  public static int getTimeToCleanRoom2(int x, int y) {
    //Base Case -- When do we quit?
    if(y <= 0)
      return 0;
    if(x <= 0)
      return 0;

    int total = 5;
    total += getTimeToCleanRoom2(x - 1, 1);
    total += getTimeToCleanRoom2(1, y - 1);
    total += getTimeToCleanRoom2(x - 1, y - 1);
    return total;
  }

  @Test public void testCleanRoomTime1() {
    assertEquals(0, getTimeToCleanRoom2(9001, 0));
  }

  @Test public void testCleanRoomTime2() {
    assertEquals(40 * 5, getTimeToCleanRoom2(5, 8));
  }

  //returns the product of the first n even numbers!
  public static int multiplyEvens(int n) {
    // What is the easiest problem?
    // exception code goes here I don't feel like writin it
    if(n == 1)
      return 2;
    // How can I split this problem into two(<--hint)
    // pieces?
    // One of these pieces I should be able to evaluate right now.
    // The other... if only we had a method to solve that smaller problem
    return (2 * n) * multiplyEvens(n - 1);
  }

// hiht hint wink wink
  @Test public void testMEvensBaseCase() {
    assertEquals(2, multiplyEvens(1));
  }

  @Test public void testMEvens() {
    //2 * 4 * 6 * 8 * 10
    assertEquals(3840, multiplyEvens(5));
  }
  // trololol these two examples next to each other
  // hint at how to make the problem smaller
  @Test public void testMEvens2() {
    //2 * 4 * 6 * 8
    assertEquals(384, multiplyEvens(4));
  }

  public static void printTwos(int n) {
    //lol when can i do little work
    if(n % 2 == 1) {
      System.out.print(n);
      return;
    }
    //split the problem into pieces
    // at this point, i know that the answer must be even
    int smaller = (n / 2);
    System.out.print("2 * ")

    if(smaller % 2 == 0)
      smaller = (smaller / 2);
    printTwos(smaller);

    System.out.print(" * 2");
  }


}
