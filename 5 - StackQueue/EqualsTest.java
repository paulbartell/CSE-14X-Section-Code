import java.util.*;
public class EqualsTest {
  public static void main(String[] args) {
    runExpectation(1, "It should consider the empty stacks equal",                 testOne(),   "[][]true");
    runExpectation(2, "It should consider these equal stacks equal",               testTwo(),   "[39, 42][39, 42]true");
    runExpectation(3, "It should consider these different size stacks not equal",  testThree(), "[39, 42][39, 42, 9001]false");
    runExpectation(4, "It should consider these different value stacks not equal", testFour(),  "[39, 42][39, 9001]false");
  }

  public static void pushMultiple(Stack<Integer> s, int[] inputs) {
    for(int i: inputs) {
      s.push(i);
    }
  }

  public static String testOne() {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    int[] arr1 = {};
    int[] arr2 = {};
    pushMultiple(s1, arr1);
    pushMultiple(s2, arr2);
    boolean result = Examples.equals(s1, s2);
    return s1.toString() + s2.toString() + result;
  }

  public static String testTwo() {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    int[] arr1 = {39, 42};
    int[] arr2 = {39, 42};
    pushMultiple(s1, arr1);
    pushMultiple(s2, arr2);
    boolean result = Examples.equals(s1, s2);
    return s1.toString() + s2.toString() + result;
  }

  public static String testThree() {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    int[] arr1 = {39, 42};
    int[] arr2 = {39, 42, 9001};
    pushMultiple(s1, arr1);
    pushMultiple(s2, arr2);
    boolean result = Examples.equals(s1, s2);
    return s1.toString() + s2.toString() + result;
  }

  public static String testFour() {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    int[] arr1 = {39, 42};
    int[] arr2 = {39, 9001};
    pushMultiple(s1, arr1);
    pushMultiple(s2, arr2);
    boolean result = Examples.equals(s1, s2);
    return s1.toString() + s2.toString() + result;
  }
  public static void runExpectation(int testNumber, String description, String output, String expected) {
    if(expected.equals(output)) {
      System.out.println("Success Test " + testNumber);
    } else {
      System.out.println("Fail Test " + testNumber + ", where " + description + ". Got " + output + "    Expected " + expected);
    }
  }
}
