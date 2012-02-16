# Some notes for the midterm

I ended up writing like 3 times that of what I thought would write.
Hopefully, this means that we can pull a section average of at least 1%
more or something... that would probably make this worth it.

If there's some bugs in my code or something, then tell me. I'm totally
not going to proofread this or anything of the sort.

Good luck!


## Tips for every problem

- Make example inputs to the problem with a Before and After picture for
  how the data structure should look.

- Figure out how you would go about solving the problem if somebody gave
  you a really large example input. You can turn this strategy into
code.

- Diagram and walk through all of your math on paper.

- Don't forget the edge cases. Your code might not work in the empty or
  one element case.. or you might be asked to throw an exception.

## ArrayList Coding

Pay attention to index math. You need to try out your numbers on paper
in order to know if your code will actually work or not.

You'll either be the ArrayList client or the class.

If you are the client, then you must worry about shifting. For example.

    #!java
    for(int i = 0; i < list.size(); i++)
      list.remove(i);

If you had an ArrayList called list, then this **would not remove all of
the elements**. Thats because when you remove the 0th element,
everything shifts over. **You need to be able to handle this situation
whenever you use the add/remove methods or else you'll lose mad points
on the problem**.

If you are the class, then you need to accurately update the state of
the object. That means that **Both elementData and size need to be fixed
by the time you are done with the problem**. The strategies for handling
the array inside of the ArrayIntList is similar to being the client
except without any shifting.

Get used to this pattern, where you fill in the __ for various numbers

    #!java
    for(int i = ___; i < ___; i += ___) {
      // Move stuff in an array somehow
    }


### filterRange

- Accepts an ArrayList of Integers
- Two Integers min and max
- removes all integers within min and max inclusive
- if no elements are contained within min and max, then nothing changes

First notice that we are a client. Then try an example input.

    #!ruby
    before:
    list => [39, 42, 51, 9001, 9042],
    min  => 2
    max  => 5

    after:
    list => [39, 42]

Let's try removing elements **one at a time** and see what happens

    #!ruby
    .
     0    1   2    3      4     5
    [39, 42, 51, 9001, 9042] // Removing 51.. it happens to be at index 2
    [39, 42, 9001, 9042] // 9001.. happens to be at index 2
    [39, 42, 9042] // 9042.. happens to be at index 2
    [39, 42] // We're done because we chopped up the whole list

So we'll always be removing the element at index 2.. or min

    #!java
    public static void filterRange(ArrayList<Integer> list, int min, int max) {
      for(int i = min; i <= max; i++) {
        if(i < list.size())
          list.remove(min);
        else
          return;
      }
    }

Then you try out the numbers on paper with your example. This would
make.
    #!java
    for(int i = 2; i < 5; i++) {
      if(i < 5)
        list.remove(2)
      else
        return;
    }

## Stacks and Queues

Diagrams. Stacks are vertical. Queues are horizontal.

Write every step of transformation in between the before picture and the
after picture.

Don't even start writing code until you have all of the steps ready

Putting elements into a stack and then pulling them out tends to reverse
the order. Use this to your advantage.

If you have a queue and want to add elements back to it as you loop
through it, then **store the original size to a variable or you'll screw
everything up**.

If you are given a Stack or Queue as a parameter and asked to find some
information about it **You must return the data structure to its
original state**. If somebody asked you to use their car to buy
groceries, it'd be douche to return them a busted car.


# removeMin

- Takes a Stack of Integers
- Removes and returns the smallest integer in the stack
- You can make one auxiliary Queue


Let's try this example

    Before       After
    //39  //     //    //
    //9001// ==> //    //
    //42  //     //9001//
    //39  //     //42  //
    =======       =====

The initial state:

    //39  //
    //9001// ________________
    //42  //
    //39  // ________________
     ====

One thing that you need to notice is that we need to know the smallest
number in the stack in order to remove it. **With stacks, it is
impossible to find out what the last item is without removing everything
else first**. This means that we'll definitely have to move everything
to the queue.

We'll also want to find the smallest number in the stack as we remove
everything.


      stack to queue
      also find smallest number(39)
    //  //
    //  // ________________
    //  // 39, 42, 9001, 39
    //  // ________________
     ====

Then we'll put the elements back.. all except for the smallest number

      queue to stack
      except for the elements equal to the smallest number
    //    //
    //    // ________________
    //42  //
    //9001// ________________
     =====

So we're done right!? **No. Everything is in the wrong order. You would
notice this if you used the diagrams like you should**. We can put it to
the way that it should look if we move everything to a queue again and
then back to the stack

        stack to queue
    //    //
    //    // ________________
    //    // 9001, 42
    //    // ________________
     =====

And back to the stack

        queue to stack
    //    //
    //    // ________________
    //9001//
    //42  // ________________
     =====

And the stack looks just like how we wanted it.

Now that we have all of the steps, write them out

- Stack to Queue, also find min
- Queue to Stack, except don't push the min
- Stack to Queue
- Queue to Stack

And code these out! Stuff like edge cases figure out on the spot as you
code.

    #!java
    public static int removeMin(Stack<Integer> derp) {
      if(derp.isEmpty())
        return;
      Queue<Integer> meep = new LinkedList<Integer>();
      // Need to retrieve the first element
      // in order to find the minimum
      int min = derp.pop();
      meep.add(min);

      while(!derp.isEmpty()){
        int value = derp.pop();
        if(value < min)
          min = value;
        meep.add(value);
      }

      while(!meep.isEmpty())
        int value = meep.remove();
        if(value != min)
          derp.add(value);

      while(!derp.isEmpty())
        meep.add(derp.pop());

      while(!meep.isEmpty())
        derp.add(meep.remove());

      return min;
    }

You can also make use of the given s2q and q2s methods.

## Collections

Sets have no Duplicates
Maps store the most recent value stored for any particular key

Loop through Sets using for each Loops or Iterators

    #!java
    // Imagine that you already have a Set<String> called set
    for(String item: set) {
      // Use item however you want
    }

    Iterator<String> it = set.iterator();
    while(it.hasNext()) {
      String item = it.next();
      // Use item however you want
      it.remove(); // You can also remove item from the set
    }

Loop through key/value pairs in maps through keyset

    #!java
    // Imagine that you already have a Map<String, Integer> called map
    for(String key: map.keySet()) {
      Integer value = map.get(key);
      // Use key or value however you want
    }

## whoPassed

- Takes a Map<String, Integer> of student names to their grade percents
    called students
- Takes a Map<Integer, Double> of grade percents to 4.0 scale grades
    called grades
- Takes a minGrade double
- Return a Set<String> of students names who passed

As always, try an example

    #!ruby
    {
       "Garpley" -> 100,
       "Alice"   -> 42,
       "Bob"     -> 39
    }
    {
       100 -> 4.0,
       42  -> 3.9,
       39  -> 2.1
    }

    minGrade -> 3.9

How would you handle this as a human?

- Garpley got an 100, which is a 4.0 so he passes
- Alice got a 42, which is a 3.9 so she passes
- Bob got a 39, which is a 2.1 so he does not pass

Notice some things. I just looped through all of the students. And
looped through their grades too.

return {Garpley, Alice}

    #!java
    public static void whoPassed(Map<String, Integer> students, Map<Integer, Double> grades, double minGrade) {
      Set<String> passers = new TreeSet<String>();

      for(String name: students.keySet()) {
        int percentGrade = students.get(name);
        double numGrade  = grades.get(percentGrade);

        if(numGrade > minGrade)
          passers.add(name);
      }

      return name;
    }


## Linked Lists

### How to rearrange nodes in a perspective

Say we had some nodes and wanted to rearrange them or run some operation
on them

    .p..-->[39]-->[42]-->[9001]-->...
    .p..-->[39]-->[9001]-->[42]-->...

Note that I don't care if this chunk of nodes appears at the beginning,
middle, or end of the list. That's why I used the ...

Write a beginning, middle, and after picture:

    ...-->[39]-->[42]-->[9001]-->...
    .
                    _____________
                   / ,-------.   -,
    ...-->[39]   [42]   [9001]     ...
           \_____________.^

    ...-->[39]-->[9001]-->[42]-->...


The middle diagram visually has the nodes from before. But the arrows
are pointing teh same way as the after picture. This will help us know
what needs to change.

Assign some temporary variables:

    .
                    _____________
                   / ,-------.   -,
    ...-->[39]   [42]   [9001]     ...
            \_____________.^
     p      a      b       c        d

And follow the lines to see what order things need to change

        a.next = c;
        b.next = d;
        c.next = b;

And it's changed. Huzzah. This is important for linked list programming.

### The tips

- Make the before/middle/after picture(if you need to rearrange nodes)
- Choose a perspective -- **How many nodes matter at any one given
  time?**
- Figure out what operation we must perform on the nodes in the perspective
  (depends on problem)
- Figure out the preconditions for that operation
- Figure out how to set up the preconditions for transitions


### hasAlternatingParity

- Written for the LinkedIntList class
- Returns whether or not the list of integers has alternating
  parity(even/odd)

We don't need to rearrange anything, so I won't make a big
before/middle/after picture. You can use the given example, **and it
remains important for you to figure out how you would solve the problem
as a human**.

#### Choose the perspective

I need to ask myself how many nodes matter at a time. This depends on
what you did in the step prior. I've decided that we will look at two
nodes at a time, because we can compare their parity.

This means that the perspective is two nodes

    ->[39]->[42]->
        a     b

The operation that we will run is to compare if these are of the
differing parity.

    #!java
    if(a % 2 == b % 2)
      return false;

#### Choose the preconditions

What are some preconditions for this code to work?

- We need to be able to set a and b. So we need some pointer to already
  point here. I'm thinking some sort of current that we will use in a
loop.

    ->[39]->[42]->
       /\
      current

- We need at least two nodes. You can't compare two if there aren't two.

#### Setup the preconditions

There will always be two cases. The front case and anything else. Lets
set up the perspective for the first case by satisfying our two
preconditions

    #!java
    // Yes.. I haven't set up a new button for the pipe symbol,
    // so this is the best I can do for the or operator!

    // Satisfy the second precondition
    if(front != null)
      return true;
    if(front.next != null)
      return true;

    // Satisfy the first precondition
    ListNode current = front;

This stuff goes at the top of your method.

Next we can satisfy the preconditions for transitioning between
perspectives

    //Satisfy the second precondition
    while(current.next != null) {
      // The code for our operation

      //Satisfy the first precondition
      current = current.next;
    }

Combine everything

    #!java
    public boolean hasAlternatingParity() {
      if(front != null)
        return true;
      if(front.next != null)
        return true;

      ListNode current = front;

      while(current.next != null) {
        ListNode a = current;
        ListNode b = current.next;

        if(a % 2 == b % 2)
          return false;

        current = current.next;
      }
      return true;
    }

Victory.

## Recursion

- Example inputs/outputs
- Be really really confident that a method call with a given input will
  return that output
- Where do smaller versions of the problem fit into larger versions of
  the problem?
- When does the problem become really really easy to solve?
- How can we ensure that we correctly put together the pieces from our
  recursive call


### indexOf

Try some example inputs and outputs

    indexOf "apple",  "app" => 0
    indexOf "papple", "app" => 1

Decide when we can quit and how we respond in these base cases

      if(original.length < piece.length)
        return -1;
      if(original.substring(0, piece.length).equals(piece))
        return 0;

Otherwise, how do we chop up the problem? See an answer cause I'm tired
of typing by now hole crap I'm still here writing this I am totally not
proofreading.

    #!java
    public static int indexOf(String original, String piece) {
      // Base Cases -- really easy to solve situations
      if(original.length < piece.length)
        return -1;
      if(original.substring(0, piece.length).equals(piece))
        return 0;

      int result = indexOf(original.substring(1), piece);
      // We assume that the indexOf call returns the correct value..
      // But the correct value might have more than one situation.
      // Based on that return, we put together the pieces differently

      if(result == -1)
        // If it wasn't found.. it's still -1
        return -1;
      else
        // If it was found, then there actually is one more
        // letter to account for
        return result + 1;
    }
