public class ArrayIntList {
  private int[] elementData; // list of integers
  private int   size;        // current number of elements in a list

  // constructs a list with a capacity of 100
  public ArrayIntList() {
    elementData = new int[100];
    size = 0;
  }

  // returns a comma-separated, bracketed version of the list
  public String toString() {
    if(size == 0) {
      return "[]";
    } else {
      String result = "[" + elementData[0];
      for(int i = 1; i < size; i++) {
        result += ", " + elementData[i];
      }
      result += "]";
      return result;
    }
  }

  // appends the given value to the end of the list
  public void add(int value) {
    elementData[size] = value;
    size++;
  }

  // Given an int
  public int indexOf(int n) {
    for(int i = 0; i < size; i++) {
      if(elementData[i] == n) {
        return i;
      }
    }
    return -1;
  }

  public void add(int index, int n) {
    for(int i = size; i > index; i--) {
      elementData[i] = elementData[i - 1];
    }
    size += 1;
    elementData[index] = n;
  }
}
