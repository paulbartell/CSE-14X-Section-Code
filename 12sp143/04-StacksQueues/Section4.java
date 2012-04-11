public static void splitStack(Stack<Integer> s) {
  Queue<Integer> q = new LinkedList<Integer>();
  // Stack to Queue
  while(!s.isEmpty) {
    q.add(s.pop());
  }

  // Move only negatives to the stack
  for(int i = 0; i < q.size(); i++) {
    int n = q.remove();
    if(n < 0) {
      s.push(n);
    } else {
      q.add(n);
    }
  }

  // Queue to Stack
  while(!q.isEmpty) {
    s.push(q.remove());
  }

}
