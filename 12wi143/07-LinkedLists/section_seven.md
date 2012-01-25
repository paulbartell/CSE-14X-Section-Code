<markdown>

I wrote this last quarter for the Linked List section -- there might
exist some inconsistencies if I reference Stuarts teaching in some way
or something. Too busy to reread to make sure it all matches, but the
overall concepts are the same.

## Data Structures

We've been using the phrase **Data Structure** for while. A data
structure is a way to organize information, where information can be a
whole bunch of integers, or a whole lot of people's names and social
security numbers.

An array or an ArrayList would qualify as a data structure. They hold
various quantities of this data, and offer features for helping us
organize and work with that information. For instance **indexOf** is a
feature that makes it easy for clients to search from an ArrayList.

## Linked Lists

https://github.com/DavidMah/CSE-143-Section-AE-Code/blob/master/3%20-%20LinkedIntList/LinkedIntList.java

The Linked List is another data structure. In short, the power it offers
is **the ability to easily change size**.

    #!java
    public class ListNode {
      public int data;
      public ListNode next;
    }

This is the basic construct of a Linked List. One Linked List is a chain
of many List Nodes. Every List Node contains **one piece of data** and an
**address** to another List Node.

![Alt text](http://davidpmah.com/cse/14311fa/linkedlists/2.png)

![Alt text](http://davidpmah.com/cse/14311fa/linkedlists/3.png)

Problems in CSE143 will involve manipulating these pointers

## Pointers

This is about References in programming -- which is really
important for handling Linked Lists. If you went to Stuart's Lecture,
then this is his example of the fact that you do not have actual humans
hiding in your cellphones, you just have all of their phone numbers.

With **Primitives** like int, double, char, a variable stored will
actually have this value in it

    #!java
    int a = 5;

If you pass that variable into a parameter, it will make a copy of it
for you

    #!java
    public static void addALittleBit(int a) {
      a = 9001;
    }

If in any other method I ran this code below..

    #!java
    int a = 5;
    addALittleBit(a);
    System.out.println(a);

Would it print 9001? **No**.

But this is slightly different with objects

    #!java
    ListNode a = new ListNode();

Consider this method that takes a ListNode

    #!java
    public static void setNextToNull(ListNode node) {
      node.next = null;
    }

If I run

    #!java
    ListNode a = new ListNode();
    ListNode b = new ListNode();
    a.next     = b;
    setNextToNull(a);
    System.out.println(a.next);

Then it will report null(will explain what null is in a sec...)

Why does this happen? I want you to think that **a variable that says it
is an Object really just is an arrow to an object**. While ints and
doubles and stuff actually hold the number. **Object variables just hold
arrows**.  **arrows**. **ARROWS**

But seriously. Now consider this method

    #!java
    public static void setToNull(ListNode node) {
      node = null;
    }

If I run `setToNull(a);`, then it **will not change a at all**. This
part is just like usual with variables. When you make that function
call, **the parameters of the method all get copies/clones, just like
they always do with ints**. What is different here is that **the clone
that is made is an arrow to an object**.

So step back to the first method, the `setNextToNull(ListNode node)`
method. This made a copy of that parameter, it sure did. It was an arrow
though. So **what we changed is a field on the ListNode that the arrows
both pointed to**. Read that bold part again.

![Alt text](http://davidpmah.com/cse/14311fa/linkedlists/1.png)

Heres one more related feature.

    #!java
    ListNode a = new ListNode();
    ListNode b = new ListNode();
    System.out.println(a == b);

It'll say false. **Even though all of the fields in a and b are
identical, when we say a == b, we are asking if the pointers point to
the same spot on your computer. They don't**.

### null

Null is a pointer to nowhere. It can act as a placeholder if you have an
Object variable but don't want to have it point to a real object. You
can't truly understand null if you don't understand pointers.

    #!java
    ListNode a = null;

It can act as a placeholder for a pointer for any object(**not primitives**)
Sometimes a problem will ask you to return null in some cases. You can
just write:

    #!java
    return null;

In LinkedLists, we use it as a wall at the end of the list.

A problem we will encounter with null is that even though a ListNode
variable can be null, **You cannot try to access ListNode fields or use
ListNode methods if the variable is null**

    #!java
    ListNode node = new ListNode(5);
    System.out.println(node.data); // this works
    node = null;
    System.out.println(node.data); // NullPointerException

So null is dangerous. We'll just have to ensure that it isn't null
before we try accessing any fields

    #!java
    if(node != null) {
      System.out.println(node.data);
    }

This is safe. Future problems will be frustrating because we may have to
access node.next.next but node.next might be null.


## How does memory of an Array work versus a linked list?

![Alt text](http://davidpmah.com/cse/14311fa/linkedlists/4.png)

With an array, it is really easy to jump to a specific spot along the
array. For example, if you want to get to index 5, you can **start at
zero and just troll 5 spots to the right**. On the other hand, you can only
reserve all of this space at once, so you must know how much space you
are going to need, or you will have to make new arrays and move
everything over when you run out of space.

![Alt text](http://davidpmah.com/cse/14311fa/linkedlists/5.png)

With a Linked List, you can't jump to any element in one step. You must
follow the path along the nodes until you get to what you want. **If you
have 16 million nodes and want the 8 millionth node, you will have to make 8
million steps to get there**. However, it is really easy to extend the
size of the Linked List -- you just need to create another node and have
something point to it.

## Dealing with Linked List problems

### A Rearrangement problem with a fixed original Linked List

![Alt text](http://davidpmah.com/cse/14311fa/linkedlists/6.png)

![Alt text](http://davidpmah.com/cse/14311fa/linkedlists/7.png)

Before anything, **Look at which .nexts need to be changed**. Before

* front => 1
* 1     => 2
* 2     => 3
* 3     => (it could be anything -- null OR another ListNode)

After:

* front => 2
* 1     => (Whatever 3 used to point to)
* 2     => 3
* 3     => 1

The usual problem about LinkedLists are that if you write code that
changes pointers, then you may end up with a node that has **nothing
pointing to it**. In this case, that node... **lost forever, and you got
the problem wrong**. Do not lose your nodes forever. They will fly away
if you give them the chance. 

Here is the easy way -- You should make temporary pointers to nodes
whenever you can. Making more pointers never hurt anybody. They're just
more strings to hold onto your balloons with.

    #!java
    ListNode first  = list;                // 1
    ListNode second = list.next;           // 2
    ListNode third  = list.next.next;      // 3
    ListNode fourth = list.next.next.next; // Whatever 3 points to

Then we must rearrange their nexts

    #!java
    front       = b;      // remember list isn't a Node. It itself is a pointer/arrow
    first.next  = fourth; // 1 => null
    second.next = c;      // 2 => 3 (We actually don't need this line because 2 already points to 3)
    third.next  = a;      // 3 => 1

What is good about these temporary variables is that we can write these
statements in any order and still be fine.

    #!java
    third.next = a;      // 3 => 1
    first.next = fourth; // 1 => null
    front      = b;      // remember list isn't a Node. It itself is a pointer/arrow
    second.next = c;     // 2 => 3 (We actually don't need this line because 2 already points to 3)

### A Coding Problem

https://github.com/DavidMah/CSE-143-Section-AE-Code/blob/master/3%20-%20LinkedIntList/AddTest.java

> Write a method for the LinkedIntList class called add(index, value)
> that inserts the given value at the given index(0-based indexing)

If the List looked like this

![Alt text](http://davidpmah.com/cse/14311fa/linkedlists/8.png)

and we called `list.add(50, 2)`, then it should look like this

![Alt text](http://davidpmah.com/cse/14311fa/linkedlists/9.png)

We must rearrange the pointers of the ListNodes to handle this problem.
**You cannot take the 2'th node and set the .data = 50**. This is called
mutation, and it takes tons longer for your computer to deal with it
than it does for rearranging pointers. Recall that **data structures
are meant to organize information**. That is -- what if each ListNode's
data contained the entire contents of a book? This would take crazy long
to mutate when we could just change some of the pointers.

We can separate this problem into two parts:

* Move into the perspective of ListNodes that need to be changed
* Rearrange ListNodes

The second half of this is just like one of the problems spoken about
before that has a fixed quantity of nodes. So the new part is setting
ourselves up to be able to solve this problem.

Remember, we are writing a method for the LinkedIntList class. Since we
are writing code in the class, we have access to its fields and
everything.

    #!java
    public void add(int index, int element) {
      // Handle the case where we are inserting at zero
      if(index == 0) {
        ListNode newNode = new ListNode(element);
        newNode.next     = front;
        front            = newNode;
        return; // You can return in a void method.. It just stops.
      }

      // Get our pointers to where we want them to be
      int currentIndex = 1;
      ListNode current = front;
      while(currentIndex < index) {
        currentIndex += 1;
        current = current.next;
      }

      // Rearrange our pointers that we now have set up
      ListNode firstNode = current;
      ListNode farNode   = firstNode.next;
      ListNode newNode   = new ListNode(element);

      firstNode.next   = newNode;
      newNode.next     = farNode;
    }

#### Moving into position

This is the part that is new as compared to the first section on Linked
Lists. We create a pointer **current** to point to the front node. And
we move it **one spot prior** to where we are trying to insert the new
node.

Consider that example with [39, 42, 9001]. If we are trying to call
`add(2, 50)`, then we need to set up our perspective to look like

![Alt text](http://davidpmah.com/cse/14311fa/linkedlists/8.png)

![Alt text](http://davidpmah.com/cse/14311fa/linkedlists/10.png)

We will have to use a LinkedList traversal to set this up.

    #!java
    ListNode current = front;
    int currentIndex = 1;
    while(currentIndex < index) {
      currentIndex += 1;
      current = current.next;
    }

This is a common pattern. We have a pointer: current. And **we move
current down the list one node at a time until it gets to where we need
it to**. For another pattern with a while loop on traversing lists, see
the solution to size.

We should ensure that current moves the correct amount of times.

[39, 42, 9001] with add(2, 50);

current starts at [39], currentIndex is 1

1 < 2(currentIndex < index) -- true. We move current to [42] and
currentIndex becomes 2

2 < 2(currentIndex > index) -- false. We are done moving current.
And this is exactly where we want current to be. So huzzah, we shall
move on. (Depending on the problem, you may have to check for crazy edge
cases. This seems relatively calm of a problem, so I won't do it here).

#### Rearranging the Nodes

You need to label all that has changed

* There is a new node with 50 as the data
* The block of data 42 is pointing to that new node
* That new node is pointing to the block of 9001

![Alt text](http://davidpmah.com/cse/14311fa/linkedlists/11.png)

First go ahead and set up your temporary variables. One for every node
in the perspective of the problem.

    #!java
    // Rearrange our pointers that we now have set up
    ListNode firstNode = current;
    ListNode farNode   = firstNode.next;

I even made a temporary variable to to replace what current is. In
future problems, current may have to be changing as we are reassigning
pointers. This way I can be sure about what nodes my pointers are
pointing to.

Now we can start applying each of those three changes:

    #!java
    ListNode newNode   = new ListNode(element);

New Node created -- I like making any new nodes before changing
pointers, because it is easier to organize.

Then change the pointers -- the other two changes to the LinkedList that
needed to be applied. That's all 3 things done, so this solves the
problem!

    #!java
    firstNode.next   = newNode;
    newNode.next     = farNode;

**Because we have temporary variables, nobody cares about the order that you 
change the .nexts.**

    newNode.next     = farNode;
    firstNode.next   = newNode;

### Edge Cases

We're not actually done yet. We need to thrash our solution by trying a
bunch of different edge cases against it.

Here's a few.

* What if we are trying to add to the end of the list

Sometimes the idea that null is behind the new block is a little
confusing. We should walk through our code as if farNode is null

    #!java
    ListNode firstNode = current;
    ListNode farNode   = firstNode.next; // This will be null
    ListNode newNode   = new ListNode(element);

    firstNode.next   = newNode;
    newNode.next     = farNode; //newNode.next will point to null

So it's fine. Because we want newNode to point to null.

* What if we are trying to add to the front of the list

front is just a variable. It's different from some sort of node.next. So
we should pay attention to it.

    #!java
    ListNode firstNode = current;

With this, we already know that we're screwed. How can we be putting
something in the beginning of the list, if our current code forces the
newNode to be on the .next of a current node. **We should handle this
edge case separately**.

    #!java
    // Handle the case where we are inserting at zero
    if(index == 0) {
      ListNode newNode = new ListNode(element);
      newNode.next     = front;
      front            = newNode;
    }

* What if we are trying to add to the front of an empty list

This edge case is a combination of the other two. Read the solution to
the front case, and use the same logic that was applied to the other
situation.

Common edge cases for problems to worry about:

* Applying some function to node at index 0
* Applying some function to node at last index
* Applying some function to the empty LinkedList
* Applying some function to the LinkedList of size 1
</markdown>

