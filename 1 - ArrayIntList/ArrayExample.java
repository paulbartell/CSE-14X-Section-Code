public class ArrayExample {
  public static void main(String[] args) {
    int[] list = {10, 11, 12, 13};
    System.out.println(list[0]);
    System.out.println(list[1]);
    System.out.println(list[2]);
    System.out.println(list[3]);
    // System.out.println(list[4]); // Try running this line.. you'll see what happens during compile

    System.out.println("-------------------");

    // Print everything in an array by looking at the indexes one at a time
    for(int i = 0; i < list.length; i++) {
      System.out.println(list[i]);
    }

    System.out.println("-------------------");

    // Sum up everything in an array by adding the elements to a sum one at a time
    int sum = 0;
    for(int i = 0; i < list.length; i++) {
      sum += list[i];
    }
    System.out.println(sum);
  }
}
