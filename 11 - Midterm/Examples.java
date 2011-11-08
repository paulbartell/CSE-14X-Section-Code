public static boolean isPalindrome(String s) {
  if(s.length() < 2)
    return true;
  if(s.charAt(0) == s.charAt(s.length() - 1)) {
    return isPalindrome(s.substring(1, s.length() - 1));
  }
  return false;

}


//We look at every element
// Was it the same as what I just saw?
//   Yes -- no one cares
//   No  -- Add 1


// front
public int numUnique() {
  if(front == null) {
    return 0;
  }
  if(front.next == null) {
    return 1;
  }
  ListNode current = front;
  int total = 1
  //traversing looks like this
  while(current.next != null) {
    if(current.data != current.next.data) {
      total++;
    }
    current = current.next
  }

  return total;
}


//moving gives you the chance to look at every element
public static int removeMax(Stack<Integer> s) {
  Queue<Integer> q = new LinkedList<Integer>();
  int max = s.pop();
  q.add(max);
  // s => q and find max
  while(!s.isEmpty()) {
    int val = s.pop();
    if(max < val)
      max = val;
    q.add(val);
  }

  // q => s and murder max
  while(!q.isEmpty()) {
    int val = q.remove();
    if(max != val)
      s.push(val);
  }
}







