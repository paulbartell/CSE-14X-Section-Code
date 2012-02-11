// contains3
//
public static boolean contains3(List<Strings> list) {
  Map<String, Integer> counts = new HashMap<String, Integer>();

  // go through the strings one at a time //check
  // counting as I go //check
  // oh hey.. one of them showed up 3 times.. TRUE
  for(String s: list) {
    if(!counts.containsKey(s)) {
      counts.put(s, 1);
    } else {
      // int newCount = counts.get(s) + 1;
      // counts.put(s, newCount);
      counts.put(s, counts.get(s) + 1);
      if(counts.get(s)  == 3)
        return true;
    }
  }
  // oh hey... none of them showed up 3 times.. NO
  return false;
}

if you have a Set<Integer> t..
for(Integer i: t) {
  //this is one way.. use it if you don't want to change what is in the set
}

Iterator<Integer> it = t.iterator();
while(it.hasNext()) {
  int i = it.next();
  //the iterator way lets you remove stuff as you go
  it.remove();// remove the most recent thing that was retrieved
}

public static Map<Integer, Integer> counts(List<Integer> list, Set<Integer> set) {
  Map<Integer, Integer> result = new TreeMap<Integer, Integer>();

  for(Integer item: set) {
    result.put(item, 0);
  }

  for(Integer listItem: list) {
    result.put(listItem, result.get(listItem) + 1);
  }

  return result;
}

//Strings in the list..
//SEA=>LAX,SFO,JFK
//LAX=>SFO
public static Map<String, Set<String>> makeDestinations(List<String> inputs) {
  Map<String, Set<String>> travel = new HashMap<String, Set<String>>();
  for(String item: inputs) {
    String[] parts = item.split("=>")
    //  0            1
    //["SEA", "LAX,SFO,JFK"]
    String from = parts[0]
    String destination = parts[1]
    String[] destinations = destination.split(",")
    //[LAX, SFO, JFK]
    for(String dest: destinations) {
      if(!travel.containsKey(from)) {
      //  We didn't have the set... so make it
        travel.put(from, new TreeSet<String>());
        travel.get(from).add(dest);
      } else {
        //Add to the set that we didn't have
        travel.get(from).add(dest);
      }
    }
  }
}

public static Map<String, Set<String>> makeDestinations(List<String> inputs) {
  Map<String, Set<String>> travel = new HashMap<String, Set<String>>();
  for(String item: inputs) {
    String[] parts = item.split("=>")
    //  0            1
    //["SEA", "LAX,SFO,JFK"]
    String from = parts[0]
    String destination = parts[1]
    String[] destinations = destination.split(",")
    //[LAX, SFO, JFK]
    for(String dest: destinations) {
      if(!travel.containsKey(from))
        //  We didn't have the set... so make it
        travel.put(from, new TreeSet<String>());
      travel.get(from).add(dest);
    }
  }
}
