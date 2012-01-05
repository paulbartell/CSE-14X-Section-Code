public class AddTest {
  public static void main(String[] args) {
    testOne();
    testTwo();
    testThree();
  }
  public static void testOne() {
    ArrayIntList list = new ArrayIntList();
    list.add(0, 42);
    String output = list.toString();
    String expected = "[42]";
    if(output.equals(expected)) {
      System.out.println("Success on test one");
    } else {
      System.out.println("Failure on test one");
    }
  }
  public static void testTwo() {
    ArrayIntList list = new ArrayIntList();
    list.add(39);
    list.add(0, 42);
    String output = list.toString();
    String expected = "[42, 39]";
    if(output.equals(expected)) {
      System.out.println("Success on test two");
    } else {
      System.out.println("Failure on test two");
    }
  }
  public static void testThree() {
    ArrayIntList list = new ArrayIntList();
    list.add(39);
    list.add(39);
    list.add(39);
    list.add(2, 42);
    String output = list.toString();
    String expected = "[39, 39, 42, 39]";
    if(output.equals(expected)) {
      System.out.println("Success on test three");
    } else {
      System.out.println("Failure on test three");
    }
  }
}
