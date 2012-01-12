  // ArrayIntList Problems
  //
  // For every problem, these are the general things that you must consider
  //     state
  //  -- size         <before> => <after>
  //  -- elementData  <before> => <after>

  //  -- return values
  //
  //  Solve the problem in general
  //  then examine possible edge cases(empty list, 1 element list, etc)
public class ArrayIntList {
  private int[] elementData;
  private int   size;

  //At every index in the array as we go across
  //We will keep track of the current most frequent frequency
  public int maxCount() {
    int max   = 0;
    int count = 1;
    int previous = elementData[0];

    for(int i = 1; i < size; i++) {

      if(elementData[i] == previous)
        count++
      else {
        if(count > max) {
          max = count;
        }
        count = 1;
      }

      previous = elementData[i];
    }

    // [1, 2, 2, 2, 2, 2]
    if(count > max && size != 0) {
      max = count;
    }

    return max;
  }

  public void mirror() {
    // We have to change the state of the ArrayIntList
    // Fix Size
    // Fix the elementData
    // loop from back to front
    mirrorItems();
    doubleSize();

    for(int i = size - 1; i >= 0; i--) {
      elementData[2 * size - i - 1] = elementData[i]
    }
    size *= 2;
  }
}
