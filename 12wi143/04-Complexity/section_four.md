## Complexity

Complexity is all about analyzing how the time to solve problems gets
larger as you increase the input size to those problems. Don't worry
about what that actually means.. let's consider this made up example

## This square bathroom:

Say we had a bathroom..

![Alt text](http://davidpmah.com/cse/14312wi/Bathroom.jpg)

Some things to notice:

 - A door
 - The length and width of the room is 3. 3 whats? meters? No. just 3
 - There are 3 showers... we fit as many showers as there is space. All
   shower sizes are the same, I'm just bad at drawing.

Consider how long(arbitrary numbers) it might take to do some certain
operations

 - Open the Door **(2 seconds)**
 - Close the Door **(1 second)**
 - Clean the entire room **(900 seconds)**
 - Clean the showers **(90 seconds)**

These numbers are useful... but we don't actually want to pay much
attention to them. I might be slow at cleaning the entire room, but
Derpaherpa Joe might be really fast with a mop. He can do some things at
a different pace:

 - Open the Door **(2 seconds)**
 - Close the Door **(1 second)**
 - Clean the entire room **(90 seconds)**
 - Clean the showers **(9 seconds)**

We want to analyze how long it takes to clean, **but we need a way to
talk about how long cleaning takes regardless of who is doing the
cleaning**. So we will talk about everything in terms of steps. We need
to choose what a step is for some of these problems.

 - Turning a doorknob **(1 step)**
 - Pushing a door **(1 step)**
 - Closing a door **(1 step)**
 - Cleaning a 1x1 square of the room **(1 step)**

Now we can talk about how long these operations take in terms of
steps(which anybody can use to understand how difficult the problems
are, rather than time which isn't that helpful).

 - Open the Door **(2 steps)**
 - Close the Door **(1 step)**
 - Clean the entire room **(9 steps)**
 - Clean the showers **(3 steps)**

## Growth

What if the room was bigger? The length/width is now 4x4.

![Alt text](http://davidpmah.com/cse/14312wi/Bathroom2.jpg)

The amount of steps for each of those operations is now different

 - Open the Door **(2 steps)**
 - Close the Door **(1 step)**
 - Clean the entire room **(16 steps)**
 - Clean the showers **(4 steps)**

In Complexity and Growth, **we ask how much longer it takes to solve a
problem when the input size grows**. The size of the room... our input,
has grown by 1. How did each of these operations change?

 - Opening the Door and Closing the Door

These didn't really change at all. Because the door is the same even if
we changed the size of the room. **This is constant time with respect to
the size of the room, or O(1)**. Even though Opening the door takes
longer than Closing the door, **the amount of steps of both did not
change when the room got bigger. That is what it means to be O(1).**.

 - Cleaning the showers

when the length was 3, there were 3 different showers. Now that the
length is 4, we can fit one more shower. Because of this, cleaning showers
 ow takes one more step than it used to. **When we increased the input
size by 1, the amount of steps it took to clean the showers went up by a
constant amount. That is what it means to take linear time or O(n).**

In other words, the time it takes to clean the room is linear with the
growth of the input, but it's easier to just think that the amount of
steps that goes up is constant. **This doesn't mean an increase of 1
step, this means an increase of a constant amount of steps. If the 1
length caused the cleaning to take 3 more steps, then it would still be
linear time as long as every increase of 1 was 3 steps(as opposed to.. n
steps)**

 - Cleaning the entire room.

When the lengthxwidth was 3, there were 9 different squares that had to
be cleaned, which is why cleaning took 9 total steps. Increase the input
size to 4(increase it by 1), and there is now 16 total steps. **When we
increase the input size by 1, the amount of steps it took to clean the
showers when up by an amount related to 4)**. The next next increase
causes the room to take 25 total steps. **The difference between 9 and
16 was only 7. But the difference 16 and 25 is 9. The difference is
getting larger!**.

**This is n squared time or O(n^2)** The difference between each
increase in input was a linear function, but if the difference was a
quadratic function then the time would be cubed.

Analyzing how many extra steps based on the input size is Growth and
Complexity.

## Binary Search

Consider a dictionary.. It's crappy, and you want to find the word **derp**
because you couldn't quite tell if it was a word or not based on all of
the ridiculous sections.

So you flip to the front of the D section, and you find out that there are 1000 words
in the D section. There are two common ways to find the word you want.

- Check every word.

You look at the first word. **daaaathenpaywithyourblood!**. That isn't your word,
so you look at the next word. **dababawhattheglob**. That isn't your word
either. Eventually, after looking at 202 different words, you find out
that **derp** really does exist. But that took really long. **I hope
that this isn't how you actually look up words in the dictionary**.

- Use Binary Search.

You flip **halfway into the D section to index 500**, and find that **dmurlocs**
isn't your word. **You know that derp comes before dmurlocs based on the
alphabet, so you know that derp has to be before index 500**.

You flip **halfway into the other half to index 250**, and find that **diglet**
isn't your word. **You know that derp comes before diiglet based on the
alphabet, so you know that derp has to be before index 250**.

You flip **halfway into the rest to index 125**, and find that
**ddtwilightsparkle** isn't your word. **You know that derp comes before ddtwilightsparkle 
based on the alphabet, so you know that derp has to be after index 125**.

- check index (125 + 250) / 2 = 187, find out that the word is after this
- check index (187 + 250) / 2 = 218, find out that the word is before
  this
- check index (187 + 218) / 2 = 202, **happen to land on derp.. just
  what we were looking for!!!**

That only took 6 steps, how fortunate.

**Either you will accidentally land on your word like we did just now,
or you will get to a point where there is only one possible word.. and
you will land on top of it**.

Binary search works only on sorted things.. An unsorted Dictionary would
suck. **Any list that has some type that is sorted can have binary
search applied to it** Yes **Integers**. Yes **Doubles**. No
**TileManagers**, for you cannot sort TileManagers.

Binary search runs in O(log(n)) time. A way to think about log time..
**If you double the amount of words in the dictionary, the binary search
will only take one more step**. Log time doesn't depend on the doubling
actually.. it's more like... **if multiply the amount of words in the
dictionary, the operation will take some amount of steps related to the
number that you used to multiplty**.
