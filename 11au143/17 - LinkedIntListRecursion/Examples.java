public void reorder3() {
  front = reorder(front);
}
public IntNode reorder(IntNode node) {
  if(node == null || node.next == null || node.next.next == null)
    return node;
  IntNode first  = node;
  IntNode second = node.next;
  IntNode third  = node.next.next;
  IntNode rest = node.next.next.next;

  third.next = reorder(rest);
  first.next = third;
  second.next = first;
  return second;
}
