import java.util.*;
public class Examples {
  public static void main(String[] derp) {
    printSquares(5);
  }

  // Express an integer as a sum of squares of unique positive integers
  // In a public method of a public/private pair, you do all of
  // the things that only need to happen once
  public static void printSquares(int n) {
    // this solution is clearly wrong
    // Initialize depth
    // Initialize the List
    // Initialize the current total sum
    printSquares(n, 1, new ArrayList<Integer>(), 0);
  }

  // When we need more parameters in order to solve the problem
  private static void printSquares(int n, int depth, List<Integer> list, int currentTotalSum) {
    if(currentTotalSum == n) // A way to stop and indeed report answer
      System.out.println(list);
    else if(depth * depth < n) { //A way to continue

      // Everything that you need in order to set up a recursive call
      // We are setting up the recursive call incorrectly
      list.add(depth); // Choose
      currentTotalSum += depth * depth;
      depth += 1;
      // printSquares(n, depth, list, currentTotalSum); // Explore
      voodoo(n, depth, list, currentTotalSum);
      depth -= 1;
      currentTotalSum -= depth * depth;
      list.remove(list.size() - 1); // Unchoose
      // Unchoose -- You want to revert EVERYTHING that you did in
      // order to set up the first recursive call
      //
      // Your Problems when you do the homework...
      // Your unchoose will not actually exactly revert the choose

      depth += 1; // Choose
      // printSquares(n, depth, list, currentTotalSum); // Explore
      voodoo(n, depth, list, currentTotalSum);
      depth -= 1; // Unchoose
    }
    //none of the above
  }

  public static void voodoo(int n, int depth, List<Integer> list, int currentTotalSum) {
    System.out.println("n  " + n);
    System.out.println("depth:  " + depth);
    System.out.println("list:  " + list);
    System.out.println("sum:  " + currentTotalSum);
  }


  private static int sumOfSquares(List<Integer> list) {
    int sum  = 0;
    for(Integer i: list) {
      sum += i*i;
    }
    return sum;
  }
}
