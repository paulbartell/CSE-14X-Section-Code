// sum -- sums all of the elements
//
// //list
// Iterators let us loop through stuff in a collection
// They are nice because it is guaranteed that all collections
// can offer iterators to use.
//  -->You aren't guaranteed for the iterator to give you
//  elements in any particular order. For a list.. it
//  just happens to give them in correct order usually. You can't
//  expect the set to give you stuff any particular order at all.

public static int sum(List<Integer> list) {
  int sum = 0;
  // Create an iterator -- this is a tool that
  // lets us loop through stuff in a collection.
  Iterator<Integer> it = list.iterator();
  // We can ask it if there are any elements left
  while(it.hasNext()) {
    // We can take an element out of the iterator
    int item = it.next();
    sum += item;
    // A Note that isn't useful for this problem
    // You can remove the most recently given element from the collection
    // through `it.remove();`
    it.remove();
  }
  return sum;
}
// Returns a set that has the even valued elements of the original set
// Removes those elements from the original set.
public Set<Integer> removeEvens(Set<Integer> setOne) {
  Set<Integer> setTwo = new TreeSet<Integer>(); // final result set

  Iterator<Integer> it = list.iterator();
  while(it.hasNext()) {
    int item = it.next();
    if(item % 2 == 0) { // if item is even...
      it.remove(); // identical me erasing
      setTwo.add(item); // identical to me drawing the number in again
    }
  }
  return setTwo;
}

public static int evenSum(List<Integer> list) {
  int sum = 0;
  Iterator<Integer> it = list.iterator();
  boolean even = true;
  while(it.hasNext()) {
    int item = it.next();
    if(even) {
      sum += item;
    }
    even = !even;
  }
  return sum;
}

public static int evenSum(List<Integer> list) {
  int sum = 0;
  boolean even = true;
  for(Integer item: list)
    if(even) {
      sum += item;
    }
    even = !even;
  }
  return sum;
}


public static int sum(Set<Integer> set) {
  int sum = 0;
  Iterator<Integer> it = set.iterator();
  while(it.hasNext()) {
    int item = it.next();
    sum += item;
  }
  return sum;
}
