public class TestExample {
  public static void main(String[] args) {
    int[] a = {};
    expect("it should leave the empty list alone",                                   a, "[]");
    int[] b = {39};
    expect("it should leave the single element list alone",                          b, "[39]");
    int[] c = {39, 42};
    expect("it should leave the two element list alone",                             c, "[39, 42]");
    int[] d = {39, 42, 9001};
    expect("it should reverse this one chunk of three",                              d, "[9001, 42, 39]");
    int[] e = {39, 42, 9001, 123};
    expect("it should reverse this one chunk of three but leave the next one alone", e, "[9001, 42, 39, 123]");
    int[] f = {39, 42, 9001, 1, 2, 3, 4, 5, 6, 77, 88};
    expect("it should reverse all of these chunks and leave the last two alone",     f, "[9001, 42, 39, 3, 2, 1, 6, 5, 4, 77, 88]");
  }

  public static void expect(String description, int[] input, String expected) {
    String output = test(input);
    if(expected.equals(output)) {
      System.out.println("Success!");
    } else {
      System.out.println("Failed!" + description + ".\n    Got " + output + "    Expected " + expected);
    }
  }

  public static String test(int[] input) {
    LinkedIntList list = new LinkedIntList();
    list.add(input);
    try {
      list.testFunction();
    } catch (Exception e) {
      return e.toString();
    }
    return list.toString();
  }
}
