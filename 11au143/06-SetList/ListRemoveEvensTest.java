import java.util.*;
public class ListRemoveEvensTest {
  public static void main(String[] args) {
    int[] inputOne = {};
    runExpectation(1, "It should leave the empty list alone",                       test(inputOne),   "[]");
    int[] inputTwo = {39};
    runExpectation(2, "It should leave this non even element alone",                test(inputTwo),   "[39]");
    int[] inputThree = {42};
    runExpectation(3, "It should destroy this single even number",                  test(inputThree), "[]");
    int[] inputFour = {42, 42, 39, 42, 42};
    runExpectation(4, "It should destroy these four evens and leave the odd alone", test(inputFour),  "[39]");
  }

  public static String test(int[] inputs) {
    List<Integer> original = new ArrayList<Integer>();
    int[] arr = {};
    for(int i: inputs) {
      original.add(i);
    }
    Examples.removeEvens(original);
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
