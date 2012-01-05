public class GetTest {
  public static void main(String[] args) {
    runExpectation(1, testOne(), 42);
    runExpectation(2, testTwo(), 39);
  }
  public static int testOne(){
    LinkedIntList a = new LinkedIntList();
    a.add(42);
    a.add(39);
    return a.get(0);
  }
  public static int testTwo(){
    LinkedIntList a = new LinkedIntList();
    a.add(42);
    a.add(39);
    return a.get(1);
  }

  public static void runExpectation(int testNumber, int output, int expected) {
    if(expected == output) {
      System.out.println("Success Test " + testNumber);
    } else {
      System.out.println("Fail Test " + testNumber + ". Got " + output + "    Expected " + expected);
    }
  }
}
