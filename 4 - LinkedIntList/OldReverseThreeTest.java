public class OldReverseThreeTest {
  public static void main(String[] args) {
    runExpectation(1, "it should leave the empty list alone", testOne(), "[]");
    runExpectation(2, "it should leave the single element list alone", testTwo(), "[39]");
    runExpectation(3, "it should leave the two element list alone", testThree(), "[39, 42]");
    runExpectation(4, "it should reverse this one chunk of three", testFour(), "[9001, 42, 39]");
    runExpectation(5, "it should reverse this one chunk of three but leave the next one alone", testFive(), "[9001, 42, 39, 123]");
    runExpectation(6, "it should reverse all of these chunks and leave the last two alone", testSix(), "[9001, 42, 39, 3, 2, 1, 6, 5, 4, 77, 88]");
  }

  public static String testOne() {
    LinkedIntList list = new LinkedIntList();
    try {
      list.oldReverse3();
    } catch (Exception e) {
      return e.toString();
    }
    return list.toString();
  }

  public static String testTwo() {
    LinkedIntList list = new LinkedIntList();
    int[] arr = {39};
    list.add(arr);
    try {
      list.oldReverse3();
    } catch (Exception e) {
      return e.toString();
    }
    return list.toString();
  }

  public static String testThree() {
    LinkedIntList list = new LinkedIntList();
    int[] arr = {39, 42};
    list.add(arr);
    try {
      list.oldReverse3();
    } catch (Exception e) {
      return e.toString();
    }
    return list.toString();
  }

  public static String testFour() {
    LinkedIntList list = new LinkedIntList();
    int[] arr = {39, 42, 9001};
    list.add(arr);
    try {
      list.oldReverse3();
    } catch (Exception e) {
      return e.toString();
    }
    return list.toString();
  }

  public static String testFive() {
    LinkedIntList list = new LinkedIntList();
    int[] arr = {39, 42, 9001, 123};
    list.add(arr);
    try {
      list.oldReverse3();
    } catch (Exception e) {
      return e.toString();
    }
    return list.toString();
  }

  public static String testSix() {
    LinkedIntList list = new LinkedIntList();
    int[] arr = {39, 42, 9001, 1, 2, 3, 4, 5, 6, 77, 88};
    list.add(arr);
    try {
      list.oldReverse3();
    } catch (Exception e) {
      return e.toString();
    }
    return list.toString();
  }

  public static void runExpectation(int testNumber, String description, String output, String expected) {
    if(expected.equals(output)) {
      System.out.println("Success Test " + testNumber);
    } else {
      System.out.println("Failure Test " + testNumber + ", where " + description + ". Got " + output + "    Expected " + expected);
    }
  }
}
