public class SortedTest {
  public static void main(String[] args) {
    runExpectation(1, "it should consider an empty list sorted"                     ,testOne(), true);
    runExpectation(2, "it should consider the single item list sorted"              ,testTwo(), true);
    runExpectation(3, "it should consider this two item sorted list sorted"         ,testThree(), true);
    runExpectation(4, "it should consider this three item sorted list sorted"       ,testFour(), true);
    runExpectation(5, "it should consider this out of order 2 item list not sorted" ,testFive(), false);
    runExpectation(6, "it should consider this out of order 3 item list not sorted" ,testSix(), false);
  }

  public static boolean testOne() {
    LinkedIntList list = new LinkedIntList();
    return list.isSorted();
  }

  public static boolean testTwo() {
    LinkedIntList list = new LinkedIntList();
    list.add(42);
    return list.isSorted();
  }

  public static boolean testThree() {
    LinkedIntList list = new LinkedIntList();
    int[] arr = {39, 42};
    list.add(arr);
    return list.isSorted();
  }

   public static boolean testFour() {
    LinkedIntList list = new LinkedIntList();
    int[] arr = {39, 42, 9001};
    list.add(arr);
    return list.isSorted();
  }

  public static boolean testFive() {
    LinkedIntList list = new LinkedIntList();
    int[] arr = {42, 39};
    list.add(arr);
    return list.isSorted();
  }

  public static boolean testSix() {
    LinkedIntList list = new LinkedIntList();
    int[] arr = {39, 9001, 42};
    list.add(arr);
    return list.isSorted();
  }

  public static void runExpectation(int testNumber, String description, boolean output, boolean expected) {
    if(expected == output) {
      System.out.println("Success Test " + testNumber);
    } else {
      System.out.println("Fail Test " + testNumber + ", where " + description + ". Got " + output + "    Expected " + expected);
    }
  }
}
