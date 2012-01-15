<markdown>
## Client

Clients don't know about implementation details. They actually don't
want to know. 


**For all I care, ArrayList could be implemented with 9001 different
variables. As long as it does what I think it should do**

    #!java
    public class DerpyArrayList {
      private int zeroth;
      private int oneth;
      private int twoth
    }

## Class

We've now become the class. We're not the client anymore. **We are
writing the ArrayList ourselves.** At least.. a cheaper version that we
are calling the **ArrayIntList**.

So we care about the implementation. But when writing our code, we
should pay attention to what the client does and doesn't need to know.
It'd be bad to murder the client through tons of unnecessary information

## Comments

Here's a link to the API for ArrayList(http://docs.oracle.com/javase/1.5.0/docs/api/java/util/ArrayList.html)

Look down at the List of Methods. All the things that the client sees
are

- The Method Name
- The Parameters
- The Comment

**The client should be able to guess the return value and effects of
your methods based on only this information** That is the point of
documenting your methods.

## Private Methods

There's this thing that we call the client contract. Theres a bunch of
expectations that the client has of you.

The client understands that you've fulfilled the contracts through your
public methods. **The only reason you have public methods is for the
clients to make use of them**. Another way to word this is.. **If you
have a method not meant for the client to use, then it shouldn't be
public** You can make them private

    #!java
    // Helper returns the element at the greatest index in the list
    private int helper() {
      return elementData[size - 1];
    }

Making public methods that the client doesn't want breaks the contract
by introducing extra functionality, so don't do it. Make your extra
methods private.
</markdown>
