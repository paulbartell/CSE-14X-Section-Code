import java.util.*;
public class Examples {

  public static void main(String[] args) {
    System.out.println("derp don't get distracted looking at this");
  }

  public static int maxLength(ArrayList<String> list) {
    // Use the same strategy as for the regular array
    // In CSE142, we would sort of call this a _cumulative sum_ method

    int currentLongestLength = 0;

    // list.size() is analagous to the array's .length
    for(int i = 0; i < list.size(); i++) {
      if(list.get(i).length() > currentLongestLength) {
        currentLongestLength = list.get(i).length();
      }
    }
    return currentLongestLength;
  }

  public static void stutter(ArrayList<Integer> list) {
    // We looked at the example...
    //  0   1    2
    // [39, 42, 9001]
    // Which had to turn into
    //  0   1   2   3   4     5
    // [39, 39, 42, 42, 9001, 9001]
    // We noticed that 39 had to be added at 1
    // 42 at 3
    // 9001 at 5.
    //
    // Phrased otherwise
    // item 0 => 1
    // item 1 => 3
    // item 2 => 5
    // Of course, there's many different ways to solve this
    // as long as you realize that this problem exists

    // Since the loop is 0 to less than originalSize, this loop is ensured
    // to be entered the same amount of times as there exist original elements
    int originalSize = list.size();
    for(int i = 0; i < originalSize; i++) {
      list.add(2 * i + 1, list.get(i - 1));
    }

    // Other solution:
    // This adds right before every element and then shifts over by two
    // for(int i = 0; i < list.size(); i += 2) {
    //   list.add(i, list.get(i));
    // }
  }

}
