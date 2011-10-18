import java.util.*;
public class SetRetainAllTest {
  public static void main(String[] args) {
    int[] inputOneOne = {};
    int[] inputOneTwo = {};
    runExpectation(1, "It should leave the empty sets alone",              test(inputOneOne, inputOneTwo),   "[][]");
    int[] inputTwoOne = {39};
    int[] inputTwoTwo = {39};
    runExpectation(2, "It should remove that one duplicate element",       test(inputTwoOne, inputTwoTwo),   "[][39]");
    int[] inputThreeOne = {39, 42};
    int[] inputThreeTwo = {42, 9001};
    runExpectation(3, "It should remove the only duplicate element",            test(inputThreeOne, inputThreeTwo), "[39][42, 9001]");
    int[] inputFourOne = {0, 19, 8, 9, 12, 13, 14, 15};
    int[] inputFourTwo = {0, 19, 2, 4, 5, 9, 10, 11};
    runExpectation(4, "It remove those dupes", test(inputFourOne, inputFourTwo),  "[0, 19, 9][0, 19, 2, 4, 5, 9, 10, 11]");
  }

  public static String test(int[] inputsOne, int[] inputsTwo) {
    Set<Integer> originalOne = new TreeSet<Integer>();
    Set<Integer> originalTwo = new TreeSet<Integer>();
    for(int i: inputsOne) {
      originalOne.add(i);
    }
    for(int i: inputsTwo) {
      originalTwo.add(i);
    }
    Examples.retainAll(originalOne, originalTwo);
    return originalOne.toString() + originalTwo.toString();
  }

  public static void runExpectation(int testNumber, String description, String output, String expected) {
    if(expected.equals(output)) {
      System.out.println("Success Test " + testNumber);
    } else {
      System.out.println("Fail Test " + testNumber + ", where " + description + ". Got " + output + "    Expected " + expected);
    }
  }
}
