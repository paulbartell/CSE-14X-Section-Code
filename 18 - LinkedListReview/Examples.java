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


public void switchPairs() {
  // Should I not do anything at all
  if(front == null || front.next == null)
    return;
  ListNode f = front;
  ListNode s = front.next;
  ListNode r = front.next.next;
  //p is actually front
  front  = s;
  f.next = r;
  s.next = f;

  //the rest
  ListNode current = front.next;
  while(current.next != null && current.next.next != null) {
    ListNode p = current;
    f = p.next;
    s = f.next;
    r = s.next;

    p.next = s;
    f.next = r;
    s.next = f;

    current = current.next.next;
  }
}
