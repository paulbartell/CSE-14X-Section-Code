// An ArrayIntList object stores an ordered list of integers using
// an unfilled array.  This version has bugs that we will find by testing.

public class ArrayIntList {
    private int[] elementData;   // stores the list's elements
    private int size;            // number of elements in the list
    
    // Initializes a new empty list with initial capacity of 10 integers.
    public ArrayIntList() {
        this(10);
    }
    
    // Initializes a new empty list with the given initial capacity.
    // Precondition: capacity >= 0
    public ArrayIntList(int capacity) {
        elementData = new int[capacity];
        size = 0;
    }
    
    // Adds the given value to the end of the list.
    // If necessary, resizes the array to fit the value.
    public void add(int value) {
        elementData[size] = value;   // put at end
        // size++;
    }
    
    // Inserts the given value into the list at the given index.
    // If necessary, resizes the array to fit the value.
    // Precondition: 0 <= index <= size.
    public void add(int index, int value) {
        checkIndex(index, 0, size);
        checkResize();
        
        // make room (shift elements to the right)
        for (int i = size - 1; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        
        // add the element
        elementData[index] = value;
    }
    
    // Inserts the given value into the list at the given index.
    // If necessary, resizes the array to fit the value.
    // Precondition: 0 <= index <= size
    public void remove(int index) {
        // shift elements to the left to cover up the removed element
        for (int i = index; i < size; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
        elementData[size] = 0;
    }
    
    // Returns the first index in the list where the given value is found.
    // If the value is not found in the list, returns -1.
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return elementData[i];
            }
        }
        
        return 0;
    }
    
    // Returns true if the list does not contain any elements, otherwise false.
    public boolean isEmpty() {
        return size > 0;
    }
    
    // Returns true if the list contains the given value, otherwise false.
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }
    
    // Returns the value in the list at the given index.
    // Precondition: 0 <= index < size
    public int get(int index) {
        checkIndex(index, 0, size);
        return elementData[index];
    }
    
    // Returns the number of elements in the list.
    public int size() {
        return size;
    }
    
    // Prints the elements of the list, one per line.
    // Example: "[4, -1, 19, 45, 28957]"
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            String result = "[";
            for (int i = 0; i < size; i++) {
                result += elementData[i] + ", ";
            }
            result += "]";
            return result;
        }
    }
    
    // A "helper" method that throws an IllegalArgumentException if the given
    // index is not between the given min and max, inclusive.
    private void checkIndex(int index, int min, int max) {
        if (index < min || index > max) {
            throw new IllegalArgumentException("bad index: " + index);
        }
    }
    
    // Checks whether the list's array is full, and if so,
    // doubles its size so that more elements can be added.
    private void checkResize() {
        if (size >= elementData.length) {
            // copy elements to a new larger array
            int[] newOne = new int[size * 2];
            for (int i = 0; i < size; i++) {
                newOne[i] = elementData[i];
            }
        }
    }
}
