import java.util.*;
public class Examples {
  public static void stutter(Stack<Integer> s) {
    Queue<Integer> q = new LinkedList<Integer>();

    while(!s.isEmpty()) {
      int temp = s.pop();
      q.add(temp);
      q.add(temp);
    }
    queueToStack(q, s);

    stackToQueue(s, q);
    queueToStack(q, s);
  }
  public static boolean equals(Stack<Integer> s1, Stack<Integer> s2) {
    Stack<Integer> s3 = new Stack<Integer>();
    // check size and return maybe immediately
    if(s1.size() != s2.size()) {
      return false;
    }
    while(!s1.isEmpty()) {
      int a1 = s1.pop();
      int a2 = s2.pop();
      s3.push(a1);
      s3.push(a2);

      if(a1 != a2) {
      // if no match, move everything back and then return
        while(!s3.isEmpty()) {
          int b2 = s3.pop();
          int b1 = s3.pop();
          s1.push(b1);
          s2.push(b2);
        }
      return false;
      }
    }
    while(!s3.isEmpty()) {
      int b2 = s3.pop();
      int b1 = s3.pop();
      s1.push(b1);
      s2.push(b2);
    }
    return true;

  }

  public static void queueToStack(Queue<Integer> q, Stack<Integer> s) {
    while(!q.isEmpty()) {
      s.push(q.remove());
    }
  }

  public static void stackToQueue(Stack<Integer> s, Queue<Integer> q) {
    while(!s.isEmpty()) {
      q.add(s.pop());
    }
  }
}
