// Returns true if any single string appears in the list three times
// [apple, apple, apple, banana, banana, tree, tree]
public static boolean contains3(List<String> list) {
  for(int i = 0; i < list.size(); i++) {
    Map<String, Integer> counts = new TreeMap<String, Integer>();
    String wordIAmLookingUp = list.get(i);

    if(counts.contains(wordIAmLookingUp)) {
      int amountIHaveCountedYou = counts.get(wordIAmLookingUp);
      counts.put(wordIAmLookingUp, amountIHaveCountedYou + 1)

      if(counts.get(wordIamLookingUp) == 3) {
        return true;
      }
    } else { // guess i have not seen you before
      counts.put(wordIAmLookingUp, 1)
    }
  }
  return false;
}

public static Map<String, Set<String>> convert(Set<String> numbers) {
  Map<String, Set<String>> result = new TreeMap<String, Set<String>>();
  //we must traverse this set using an iterator!!
  Iterator<String> it = numbers.iterator();
  while(it.hasNext()) {
    String numberSingular     = it.next();
    String firstHalfOfNumber  = numberSingular.substring(0, 3) // key
    String secondHalfOfNumber = numberSingular.substring(4)    // value
    //The magic happens you write this part
    if(result.contains(firstHalfOfNumber)) {
      //oh hey i've seen you before, let's use your bucket
    } else {
      // you seem new around here let's get you a bucket
      Set<String> numberBucket = new TreeSet<String>();
      result.put(firstHalfOfNumber, numberBucket);
      numberBucket.add(secondHalfOfNumber);
    }
  }
  return result
}







