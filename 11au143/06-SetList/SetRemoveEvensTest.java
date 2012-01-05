import java.util.*;
public class SetRemoveEvensTest {
  public static void main(String[] args) {
    int[] inputOne = {};
    runExpectation(1, "It should leave the empty list alone",              test(inputOne),   "[][]");
    int[] inputTwo = {39};
    runExpectation(2, "It should leave this non even element alone",       test(inputTwo),   "[39][]");
    int[] inputThree = {42};
    runExpectation(3, "It should move this single even number",            test(inputThree), "[][42]");
    int[] inputFour = {39, 42, 9001};
    runExpectation(4, "It should move this even and leave the odds alone", test(inputFour),  "[39, 9001][42]");
  }

  public static String test(int[] inputs) {
    Set<Integer> original = new TreeSet<Integer>();
    int[] arr = {};
    for(int i: inputs) {
      original.add(i);
    }
    Set<Integer> result = Examples.removeEvens(original);
    return original.toString() + result.toString();
  }

  public static void runExpectation(int testNumber, String description, String output, String expected) {
    if(expected.equals(output)) {
      System.out.println("Success Test " + testNumber);
    } else {
      System.out.println("Fail Test " + testNumber + ", where " + description + ". Got " + output + "    Expected " + expected);
    }
  }
}
