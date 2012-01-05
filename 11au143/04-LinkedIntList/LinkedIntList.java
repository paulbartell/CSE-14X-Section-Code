// Class LinkedIntList can be used to store a list of integers.

public class LinkedIntList {
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (front == null)
            return "[]";
        else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null)
            front = new ListNode(value);
        else {
            ListNode current = front;
            while (current.next != null)
                current = current.next;
            current.next = new ListNode(value);
        }
    }

    // post: appends given values to the end of the list
    public void add(int[] values) {
      for(int i: values) {
        add(i);
      }
    }

    // post: returns true if the data of the LinkedIntList is in sorted(nondecreasing) order
    public boolean isSorted() {
      if(front == null || front.next == null){
        return true;
      }
      ListNode current = front.next;
      ListNode previous = front;

      while(current != null) {
        if(current.data < previous.data) {
          return false;
        }
        current  = current.next;
        previous = previous.next;
      }

      return true;
    }

    // The really texty version
    public void oldReverse3() {
      //first, second, or third don't exist
      if(front == null || front.next == null || front.next.next == null) {
        return;
      }

      //1. Handle the front of the list
      ListNode first  = front;
      ListNode second = first.next;
      ListNode third  = second.next;
      ListNode fourth = third.next;

      front       = third;
      first.next  = fourth;
      third.next  = second;
      second.next = first;

      ListNode foo = first;
      //2. Handle the rest of the list
      //over and over and over using a loop

      while(foo.next != null && foo.next.next != null && foo.next.next.next != null) {
        first  = foo.next;
        second = first.next;
        third  = second.next;
        fourth = third.next;

        foo.next    = third;
        first.next  = fourth;
        third.next  = second;
        second.next = first;

        // Set ourselves up for the next time around
        foo         = first;
      }
    }

    public void reverse3() {
      //first, second, or third don't exist
      if(front == null || front.next == null || front.next.next == null) {
        return;
      }
      //1. Handle the front of the list
      front = reverseFront(front);
      ListNode foo = front.next.next;

      //2. Handle the rest of the list
      //over and over and over using a loop
      while(foo.next != null && foo.next.next != null && foo.next.next.next != null) {

        foo.next = reverseFront(foo.next);

        // Set ourselves up for the next time around
        foo = foo.next.next.next;
      }
    }

    // pre: a ListNode chain of at least size 3
    // post: Returns a ListNode chain where the order of the first three Nodes are reversed
    private ListNode reverseFront(ListNode first) {
      // front(or foo.next) was passed as a parameter,
      // This is the same as either
      // first = front;
      // first = foo.next;

        ListNode second = first.next;
        ListNode third  = second.next;
        ListNode fourth = third.next;

        first.next  = fourth;
        third.next  = second;
        second.next = first;
        return third;
    }

}
