import java.util.*;
public class ListRemoveDuplicatesTest {
  public static void main(String[] args) {
    String[] inputOne = {};
    runExpectation(1, "It should leave the empty list alone",                                       test(inputOne),   "[]");
    String[] inputTwo = {"39"};
    runExpectation(2, "It should leave this one element alone",                                     test(inputTwo),   "[39]");
    String[] inputThree = {"42", "42", "39"};
    runExpectation(3, "It should destroy this first duplicate",                                     test(inputThree), "[39]");
    String[] inputFour = {"39", "39", "39", "39", "39", "42"};
    runExpectation(4, "It should destroy these wide amounts of duplicate but leave the rest alone", test(inputFour),  "[39, 42]");
    String[] inputFive = {"39", "39", "39", "39", "42", "42", "42", "9001", "9001"};
    runExpectation(5, "It shouldn't skip anything",                                                 test(inputFive),  "[39, 42, 9001]");
  }

  public static String test(String[] inputs) {
    List<String> original = new ArrayList<String>();
    String[] arr = {};

    for(String s: inputs) {
      original.add(s);
    }

    Examples.removeDuplicates(original);
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
