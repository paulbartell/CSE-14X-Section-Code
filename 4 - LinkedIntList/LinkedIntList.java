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

    public boolean isSorted() {
      return false;
    }

    public void reverse3() {
      return;
    }
}
