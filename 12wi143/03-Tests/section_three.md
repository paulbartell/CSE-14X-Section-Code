# Tests

Tests automate the task of making sure that our code works.

We write code to make sure that every situation we can think of works.

If you have tests, then in only a few clicks you can check for any major
flaws in your code.

Tests let us feel comfortable with changing our code because if we mess
up changing the code... the tests fail and we know that we messed up.

You will never have tests that perfectly make sure your code works. Just
mostly working.

## Black Box Testing

Black box testing is from the perspective of the client. The client doesn't
know what the implementation of the code is(the code is the 'Black
Box'). Write client code that run methods within the class, and hope
that they do what we expect them to do.

## White Box Testing

White Box testing is from the perspective of the coder(coder.. not the
class). **The tests you write will still be client code and will look
just like black box tests**. The difference is that you have greater
knowledge because you know what the code looks like.

For instance, say you are testing indexOf... **As a white box tester,
you can see the code. You know that indexOf uses a loop. Because you
know there is a loop, you know that you need to test the boundaries of
the loop**. The black box tester wouldn't know about the loop.

Writing a test:

 -  Take one or two methods together

 -  Write code that does something using our class

 -  Create an expectation for what we think it will do

 -  Write code that checks if what the methods did is what we expected


        #!java
        public class Test {
          public static void main(String[] args) {
            // we are the client
            // public methods


            // Testing toString, the constructor, and add
            // toString works on the brand new ArrayIntList
            ArrayIntList derp = new ArrayIntList();
            expect(derp.toString(), "[]");

            // toString works on the ArrayIntList after an add
            derp = new ArrayIntList();
            derp.add(39);
            expect(derp.toString(), "[39]");

            // After two adds
            derp = new ArrayIntList();
            derp.add(39);
            derp.add(42);
            expect(derp.toString(), "[39, 42]");


            // Testing add
            // []... add(0, 5) => [5]     adding to an empty
            //....... add(0, 3) => [3, 5] adding and shifting one element
            //....... add(2, 7) => [3, 5, 7]
            // throw IllegalArgumentException if index < 0
            derp = new ArrayIntList();

            // How to test an exception
            try {
              // code that might make an exception happen
              derp.add(9001, 39);
              System.out.println("got past the add, no exception");
            } catch(IllegalArgumentException e) {
              System.out.println("Got the exception, so this is all good");
            }


            // Ideas for what to consider for tests

            // contains:
            // empty always false
            // begin, middle, end, existence
            // false
            // several isntances of the same number

            // isEmpty:
            // empty and not derp

            // indexOf:
            // without value
            // it does have
            // has multiple of
            // the beginning, and the end

            // remove:
            // three elements... remove the end
            // two elements... remove the beginning
            // one element.. remove the beginning
            // remove when nothingi s there
            // trying to remove beyond our bounds

            // size:
            // add method many times
            // empty list
          }

          public static void expect(String output, String expected) {
            if(output.equals(expected))
              System.out.println("Success");
            else
              System.out.println("Failure. Got <" + output +">. Expected <" + expected + ">");
          }
        }

