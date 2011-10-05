public class SizeTest {
  public static void main(String[] args) {
    runExpectation(1, testOne(),   0);
    runExpectation(2, testTwo(),   1);
    runExpectation(3, testThree(), 2);
  }
  public static int testOne() {
    LinkedIntList a = new LinkedIntList();
    return a.size();
  }

  public static int testTwo() {
    LinkedIntList a = new LinkedIntList();
    a.add(42);
    return a.size();
  }

  public static int testThree() {
    LinkedIntList a = new LinkedIntList();
    a.add(42);
    a.add(39);
    return a.size();
  }

  public static void runExpectation(int testNumber, int output, int expected) {
    if(expected == output) {
      System.out.println("Success Test " + testNumber);
    } else {
      System.out.println("Fail Test " + testNumber + ". Got " + output + "    Expected " + expected);
    }
  }
}
