import java.util.*;
public class NorthWest {
  public static void main(String[] args) {
    solve(1, 2);
  }
  public static void solve(int x, int y) {
    // all of the things that only need to happen once
    System.out.println("All the paths:");
    solve(x, y, 0, 0, new Stack<String>());
  }
  //we can add all of the extra parameters we want.
  //                          target        me
  private static void solve(int x, int y, int m, int n, Stack<String> path) {
    System.out.println("  Hey -- I have taken the path" + path + " so far");
    if(x == m && y == n) {
      System.out.println(path);
      return;
    } else if(m > x || n > y) {
      return;
    } else {
      //N, NE, E
      path.push("か");
      solve(x, y, m, n + 1, path);
      path.pop();

      path.push("NE");
      solve(x, y, m + 1, n + 1, path);
      path.pop();

      path.push("E");
      solve(x, y, m + 1, n, path);
      path.pop();
    }
  }
}
