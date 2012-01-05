public class IndexOfTest {
  public static void main(String[] args) {
    testOne();
    testTwo();
    testThree();
  }
  public static void testOne()   {
    ArrayIntList list = new ArrayIntList();
    list.add(0);
    list.add(1);
    list.add(2);
    list.add(3);
    int output   = list.indexOf(0);
    int expected = 0;
    if(output == expected) {
      System.out.println("Success on test one");
    } else {
      System.out.println("Failure on test one");
    }
  }
  public static void testTwo()   {
    ArrayIntList list = new ArrayIntList();
    list.add(0);
    list.add(1);
    list.add(2);
    list.add(3);
    int output   = list.indexOf(42);
    int expected = -1;
    if(output == expected) {
      System.out.println("Success on test two");
    } else {
      System.out.println("Failure on test two");
    }
  }
  public static void testThree() {
    ArrayIntList list = new ArrayIntList();
    list.add(0);
    list.add(1);
    list.add(2);
    list.add(3);
    int output   = list.indexOf(3);
    int expected = 3;
    if(output == expected) {
      System.out.println("Success on test three");
    } else {
      System.out.println("Failure on test three");
    }
  }
}
