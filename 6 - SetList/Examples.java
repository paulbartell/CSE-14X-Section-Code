import java.util.*;
public class Examples {

  public static void main(String[] args) {
    
  }

  public static int sum(List<Integer> list) {
    int sum = 0;
    Iterator<Integer> it = list.iterator();

    while(it.hasNext()) {
      int value = it.next();
      sum += value;
    }

    return sum;
  }


  public static void removeDuplicates(List<String> list) {
    if(list.size() == 0) {
      return;
    }
    Iterator<String> it = list.iterator();

    String value = it.next();
    while(it.hasNext()) {
      String now = it.next();
      if(value.equals(now)){
        it.remove();
      } else {
        value = now;
      }
    }

  }
  public static void removeEvens(List<Integer> list) {
    Iterator<Integer> it = list.iterator();

    while(it.hasNext()) {

      int value = it.next();
      if(value % 2 == 0) {
        it.remove();
      }

    }
  }

    // Just like the List one, but whenever we remove something, we should
    // drop it into the new set!
  public static Set<Integer> removeEvens(Set<Integer> s1) {
    Set<Integer> s2 = new TreeSet<Integer>();

    Iterator<Integer> it = s1.iterator();
    while(it.hasNext()) {
      int value = it.next();
      if(value % 2 == 0) {
        it.remove();
        s2.add(value);
      }
    }
    return s2; // dummy return for before we start the real problem
  }

  public static void retainAll(Set<Integer> s1, Set<Integer> s2) {
    //Look at everything in s1 one at a time
    Iterator<Integer> it = s1.iterator();
    whileit.hasNext()) {
      int value = it.next();
      if(!s2.contains(value)) {
        it.remove();
      }
    }
    // If it is not in s2 this is bad, we should destroy it
    // If it is in s2 this is good
  }
}















