public int evenSum() {
  ListNode current = front;
  int index = 0;
  int sum = 0;
  while(current != null) {
    if(index % 2 == 0) {
      sum += current.data;
    }
    index++;
    current = current.next;
  }
  return sum;
}

// Steps
// Before and After diagram
// Choose a perspective -- how many nodes are relevant?
// Make a perspective diagram with before/after arrows
//
// Choose temporary variables for nodes in the perspective
// Document the reassignments for nodes in the perspective
// Be confident in these
//
// Find out where you would need to place a current pointer in order to set up your temp variables
// Find out how to assign the variables for the perspective case
// Find out how to assign the variables for the front case
//
// Find a condition where you either cannot set up current or you cannot set up your temp variables
// This will be the condition of your traversal loop
//
// Then code


public void switchPairs() {
  // What situations should I not do anything at all
  if(front == null || front.next == null)
    return;
  // Handle the front case
  ListNode f = front;
  ListNode s = front.next;
  ListNode r = front.next.next;
  // P is analogous to front for the first case
  front  = s;
  f.next = r;
  s.next = f;

  // The rest
  // Place current in its necessary spot for the first perspective
  ListNode current = front.next;

  // In what situations can we guarantee that the variables can get set up?
  while(current.next != null && current.next.next != null) {
    // Assign temps
    ListNode p = current;
    f = p.next;
    s = f.next;
    r = s.next;

    // Rearrange
    p.next = s;
    f.next = r;
    s.next = f;

    // How can we get current from it's position for this perspective
    // to the new perspective for the next perspective
    current = current.next.next;
  }
}
