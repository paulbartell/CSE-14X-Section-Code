// Linked list problems today involve changing stuff in a linked list...:O
//
//
//
//
//3 min - find the minimum value in a list of integers
//
// we get access to fields
// --> front
// You can only traverse a linked list using a bunch of pointers
// and by pointers I maen temporary variables
//
// 1. Think of an overall strategy that doesn't have to do with linkedlists
// 2. Make an example list
// 3. Pick a mini perspective... how many nodes at one time matter?
// 4. Solve for that one mini perspective
// 5. What preconditions matter for that mini perspective?
// 6. Set them up with a loop
// 7. at the bottom of the loop, satisfy preconditions for next perspective
// 8. EDGE CASES
public int min() {
  // edge cases
  if(front == null)
    throw new NoSuchElementException();

  // initialize stuff for the first node
  int currentMin   = front.data;
  ListNode current = front;

  // ensure that current is NOT null...
  // because the lines of code down there won't work
  // if current is indeed null
  while(current != null) {
    // preconditions:
    // currentMin needs to be set correctly
    // current needs to point to that node
    // current shouldn't be null
    int currentData = current.data;
    if(currentMin > currentData)
      currentMin = currentData;

    // satisfying preconditions for the next perspective
    current = current.next;
  }

  return currentMin;

}

public int indexOf(int data) {
  // edge cases for front.. none for this problem

  // satisfy preconditions for this first node
  int index = 0;
  ListNode current = front;
  while(current != null) { // the condition here is part of precondition satisfying!

    // preconditions:
    // current needs to point to the next node
    // current isn't null!
    // index needs to be the correct value
    //
    //
    // current set!
    // not null... current?
    // index!
    if(current.data == data)
      return index;

    // changes from one perspective to satisfy the next perspective
    index += 1;
    current = current.next;
  }

  // edge case
  return -1;

}
