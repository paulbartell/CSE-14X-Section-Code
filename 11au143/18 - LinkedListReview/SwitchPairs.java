// Steps
// Before/After Diagram
// Choose perspective
// Don't separate the front case, front/rest are handled with the same code
// Assign Temporary Variables
// Figure out rearranging. Attaching to the parent is through return
//
// When is the linked list not large enough for our perspective? That will be the Base Case

public void switchPairs() {
  front = switchPairs(front);
}

public ListNode switchPairs(ListNode node) {
  // When the linked list is not large enough for our perspective
  if(node == null || node.next == null)
    return node;
  // Assign temporary variables to the perspective
  ListNode first  = node;
  ListNode second = node.next;
  ListNode rest   = second.next;

  // Fix the rest of the list, and attach it where it needs to go
  first.next = switchPairs(rest); // f.next = r AND handles the rest of the list

  // Fix the nodes in my perspective here
  second.next = first; // Equivalent in other example to: s.next = f

  // To attach to the parent, we return
  return second; // Equivalent to in other example to: p.next = s
}

// When do we NOT use recursion
//
// You have to return a brand new linked list
//   the problem will read something like --
//   extract every even node or so into a second linked list and return that ). 
//   You won't be able to solve such a problem without being able to return multiple items.
//
// Rearrangements are difficult
//   Assuming that the rest of the list beyond the perspective is in solved order
//   What extra details do we have to handle to combine the perspective with the rest?
//   This can be really hard if.. you have to inject a perspective node into the middle of the rest
