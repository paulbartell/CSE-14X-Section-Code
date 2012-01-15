# Tests
Test our code for us

We write code to make sure that every situation we can think of works

Tests let us feel comfortable with changing our code because if we mess up changing the code... the tests break
and we know that we messed up.

Black Box Testing -- from the perspective of the client
White Box Testing -- from the perspective of the coder

Writing a test:
- Take one or two methods together
- Write code that does something using our class
- create an expectation for what we think it will do
- Write code that checks if what the methods did is what we expected

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

