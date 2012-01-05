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

  public static void stutter(ArrayList<Integer> arr) {
    for(int i = 1; i < arr.size(); i++) {
      arr.add(i + (2 * (i - 1)), arr.get(i - 1));
    }
  }

}
