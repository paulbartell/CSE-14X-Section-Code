import java.util.*;
public class StutterTest {
  public static void main(String[] args) {
    runExpectation(1, "It should leave the empty stack alone",  testOne(),   "[]");
    runExpectation(2, "It should duplicate the single element", testTwo(),   "[39, 39]");
    runExpectation(3, "It should stutter the two elements",     testThree(), "[39, 39, 42, 42]");
    runExpectation(4, "It should stutter the three elements",   testFour(),  "[39, 39, 42, 42, 9001, 9001]");
  }

  public static void pushMultiple(Stack<Integer> s, int[] inputs) {
    for(int i: inputs) {
      s.push(i);
    }
  }

  public static String testOne() {
    Stack<Integer> original = new Stack<Integer>();
    int[] arr = {};
    pushMultiple(original, arr);
    Examples.stutter(original);
    return original.toString();
  }

  public static String testTwo() {
    Stack<Integer> original = new Stack<Integer>();
    int[] arr = {39};
    pushMultiple(original, arr);
    Examples.stutter(original);
    return original.toString();
  }

  public static String testThree() {
    Stack<Integer> original = new Stack<Integer>();
    int[] arr = {39, 42};
    pushMultiple(original, arr);
    Examples.stutter(original);
    return original.toString();
  }

  public static String testFour() {
    Stack<Integer> original = new Stack<Integer>();
    int[] arr = {39, 42, 9001};
    pushMultiple(original, arr);
    Examples.stutter(original);
    return original.toString();
  }

  public static void runExpectation(int testNumber, String description, String output, String expected) {
    if(expected.equals(output)) {
      System.out.println("Success Test " + testNumber);
    } else {
      System.out.println("Fail Test " + testNumber + ", where " + description + ". Got " + output + "    Expected " + expected);
    }
  }
}
