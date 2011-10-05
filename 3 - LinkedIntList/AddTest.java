public class AddTest {
  public static void main(String[] args) {
    runExpectation(1, testOne(),   "[39, 42]");
    runExpectation(2, testTwo(),   "[42, 9001, 39]");
    runExpectation(3, testThree(), "[42, 39, 9001]");
  }
  public static String testOne() {
    LinkedIntList a = new LinkedIntList();
    a.add(42);
    a.add(0, 39);
    return a.toString();
  }

  public static String testTwo() {
    LinkedIntList a = new LinkedIntList();
    a.add(42);
    a.add(39);
    a.add(1, 9001);
    return a.toString();
  }

  public static String testThree() {
    LinkedIntList a = new LinkedIntList();
    a.add(42);
    a.add(39);
    a.add(2, 9001);
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
