<markdown>

## Arrays

An array is a way to hold and package multiple pieces of data(data..
like numbers or birthdays or turtle names)

    #!java
    //            0  1   2   3
    int[] list = {1, 2, 39, 42};

This array has four elements, and they can each be retrieved with their individual index number

    #!java
    list[0] // Evaluates to 1
    list[1] // Evaluates to 2
    list[2] // Evaluates to 39
    list[3] // Evaluates to 42
    list[4] // Breaks -- Throws an ArrayIndexOutOfBounds Exception because 4 is not within the size of the array

You should note that the array's size is 4, but the greatest index is 3.
This is because of the zero based indexing, which is just something you'll 
have to get used to. The original reason for this would be explained in CSE351,
and it has to do with the low level details of computer memory.

If we wanted to access everything in the array to say.. print everything out,
we could access everything in the list one at a time and print them.

    #!java
    System.out.println(list[0]);
    System.out.println(list[1]);
    System.out.println(list[2]);
    System.out.println(list[3]);

But here is a better way

    #!java
    for(int i = 0; i < list.length; i++) {
      System.out.println(list[i]);
    }

The greatest reason why this is a better way is because it scales.
This construct will print out all of the elements in the list regardless
of the list's size. But in the end, it is important to realize that you are
just trying every number between zero and size.

Some things to note about this:

**i = 0** -- We start i at zero because the first number that we want to try out is the 0th element. We can shift this to 1 or 2 if we want to skip elements

**i < list.size** -- list.size in the first example is 4.
This means that the condition for continuing is **i < 4**. If **i = 4**...which is **4 < 4**..
It will be false, and we won't go into the loop when i is 4.
This is what we want because we would otherwise get the exception for out of bounds.

If **i = 3**... **3 < 4**, we will go into the loop, which is what we want.
A good way to think around it is to think that **3 will be the final number that satisfies the condition**.

**System.out.println(list[i])** -- we access list[i] and then print out what is in it.
Realize that **i is just a number**. You could use **list[i + 1]** or **list[i - 1]** if you wanted, and in many situations you will need to.

## Objects

https://github.com/DavidMah/CSE-14X-Section-Code/blob/master/12wi143/01-ArrayList/Human.java

https://github.com/DavidMah/CSE-14X-Section-Code/blob/master/12wi143/01-ArrayList/TryHuman.java

Classes let us bundle information together. We make them as utilities that help
us organize code.

What if we were writing a program that organized information about all
Humans in the country or world? **We would want to bundle together
information like name and age**

Classes make this process organized.

We are all of class human, and every instance of human has a few fields like (String name), (int age), (String guiltyPleasure).

    #!java
    public class Human {
      private String name;
      private String age;
      private String guiltyPleasure;
    }

I am David -- I am one **instance** of Human -- my name is David, I'm 19, I watch My Little Pony.
BimboBob is another Human, he also has a name, and an age, and he enjoys mud wrestling.
He has the same types of fields as I do (As the class Human describes),
but **because he is a different instance of human, he has different values for his fields**.

### Instance Methods

Every human knows how to do a few things, like eating and sleeping. These methods are described in the class

    #!java
    // Pretend this code is written inside of the public class Human
      public void eat() {
        // BITE IT
        // I SATISFIED NOW
      }
      public void sleep() {
        // I SURE FEEL RESTED
      }


Note that when you are writing methods for instances of classes,
you **do not include the keyword `static`**. A rule of thumb is that
for your objects in this course you will never write static.
But if you are writing something with a `main` method.. you will need to.

### A Real explanation that you don't actually need for a good grade in the course but will make you a better programmer:

So you can write static fields and static methods in your class(see
population and getPopulation).

A static field/method exists **once** throughout all of your class.
Every one of your instances will be able to access a static
field/method. It's like one big shared variable. A client might reach
your static stuff through Human.getPopulation.

When you write static in your client programs, it's because you aren't
instantiating any individual of that client program. You're running
those methods from the perspective of the whole class, as opposed to an
individual.

Play with the code in the example and try writing another static
field or method and see what you can do.

### Constructor

All humans know how to be born.
The events that occur right when a new Human is instantiated are described in the Human's **constructor**

    #!java
    // Pretend this code is written just underneath the fields
      public Human() {
        // BABIES
        age = 0;
      }
      public Human(String newName) {
        name = newName;
        this();
      }

I've described two constructors here. A client(Someone who is writing other
code to make use of the human class) can choose which way the Human will come
into existence. The first is a zero-arguments constructor. It just sets the age to be 0.
You should consider the constructor as just another method, just like `eat()` and `sleep()`.
The difference is that constructors are methods for an instantiation of a class coming into existence.

The second constructor takes a String -- the Human's name and sets the
field. With our human class, you can't give a name to the human at any
time other than when it is born.

### Client versus Class

Check out the example code for the Human. Human.java is the class.
TryHuman.java is the client.

The class describes what a Human is like and what it can do, and it
publishes a bunch of public methods that a client can tell a human to
do(like eat and sleep)

The client makes a bunch of Humans and makes use of these public
methods. The client doesn't actually have to worry how eat and sleep's
tiny code details work. All the client has to do is say a.sleep and a
will go to sleep. In fact, often I'd say is that **the client doesn't
even want to know the implementation details of a class**. Remember
that. It will come up later.

## ArrayList

The ArrayIntList is a class that describes an object to wrap around arrays.
Ordinarily, you cannot change the size of an array. If you spawn one of size 4,
it will forever remain size four.
**The purpose of ArrayIntList is to allow you to have an array that can change size.**

Because of the client/class idea, we don't care how the ArrayList works.
**We can make use of an ArrayList without actually knowing how it works
on the inside**.

### How it works which doesn't matter to you right now, but good to know

The way it works is that each instance of the ArrayIntList object holds an array of some size.
The client can add or remove or do whatever he wants with elements in the ArrayIntList.
If the array inside of the ArrayIntList has 100 slots, but the client only added four,
then the ArrayIntList will pretend there are four things.. if the client tries to access the 50th element,
then even though the actual array is that big, the ArrayIntList will say that this is out of bounds.

If the client adds 100 elements to the ArrayIntList with 100 slots, then
the ArrayIntList will do a sneaky thing -- It will make a **new array
with maybe double the slots and move all of the elements over**. And the
client won't even need to know that this happened **nor does the client
care**.

</markdown>
