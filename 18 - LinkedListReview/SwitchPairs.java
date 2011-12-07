public void switchPairs() {
  front = switchPairs(front);
}

public ListNode switchPairs(ListNode node) {
  if(node == null || node.next == null)
    return node;
  ListNode first  = node;
  ListNode second = node.next;
  ListNode rest   = second.next;

  // Fix the rest of the list, and attach it where it needs to go
  first.next = switchPairs(rest);
  // Fix the nodes in my perspective here
  second.next = first;
  return second;
}
