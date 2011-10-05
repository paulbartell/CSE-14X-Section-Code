public class RemoveTest {
  public static void main(String[] args) {
    runExpectation(1, testOne(),   "[]");
    runExpectation(2, testTwo(),   "[39]");
    runExpectation(3, testThree(), "[42]");
    runExpectation(4, testFour(),  "[42, 39]");
  }
  public static String testOne() {
    LinkedIntList a = new LinkedIntList();
    a.add(42);
    a.remove(42);
    return a.toString();
  }

  public static String testTwo() {
    LinkedIntList a = new LinkedIntList();
    a.add(42);
    a.add(39);
    a.remove(0);
    return a.toString();
  }

  public static String testThree() {
    LinkedIntList a = new LinkedIntList();
    a.add(42);
    a.add(39);
    a.remove(1);
    return a.toString();
  }

  public static String testFour() {
    LinkedIntList a = new LinkedIntList();
    a.add(42);
    a.add(39);
    a.add(9001);
    a.remove(2);
    return a.toString();
  }

  public static void runExpectation(int testNumber, String output, String expected) {
    if(expected.equals(output)) {
      System.out.println("Success Test " + testNumber);
    } else {
      System.out.println("Fail Test " + testNumber + ". Got " + output + "    Expected " + expected);
    }
  }
}
