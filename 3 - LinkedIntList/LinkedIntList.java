public class LinkedIntList {
  private ListNode front;

  public String toString() {
    String result = "[";
    ListNode current = front;
    while(current != null) {
      result += current.data + ", ";
      current = current.next;
    }
    result = result.substring(0, result.length() - 2) + "]";
    return result;
  }

  public void add(int value) {
    if (front == null) {
       front = new ListNode(value);
    } else {
      ListNode current = front;
      while (current.next != null) {
        current = current.next;
      }
      current.next = new ListNode(value);
    }
  }

  public int get(int index) {
    return -1;
  }

  public int size() {
    return -1;
  }
  public void add(int index, int value) {
    return;
  }

  public void remove(int index) {
    return;
  }
}
