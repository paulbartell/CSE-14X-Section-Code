public static int multiplyEvens(int n) {
  if(n == 1) //BASE CASE
    return 2;
  return multiplyEvens(n - 1) * (n * 2);//RECURSION
}

public static String starString(int n) {
  //Base Case
  if(n == 0) {
    return "*";
  }
  //Recursive Case
  return starString(n - 1) + starString(n - 1);
}
// Recursive Case --
// read the problem
// MAKE EXAMPLES OF INPUTS/OUTPUTS
// outputs as open as you can
// Look for where smaller versions fit in bigger versions
// What more than the smaller verion do we need? That's the recursive step
//
// Base case --
// when do we quit because the problem has become so easy
//
// Things that happen once can go in the public
public static void parenthesize(String s, int n) {
  parenthesizeHelper(s, n);
  System.out.println();
}
// Recursion can happen in the private helper
private static void parenthesizeHelper(String s, int n) {
  // Base Case
  if(n == 0) {
    System.out.print(s)
  } else {
    // Recursive Case
    System.out.print("(");
    parenthesize(s, n - 1);
    System.out.print(")");
  }
}

public static void writeSequence(int n) {
  // Base Case -- May be easier to figure this out first
  if(n == 1) {
    System.out.print("1");
  } else if (n == 2) {
    System.out.print("1 1");
  }else {
  // Recursive Case
    int val = (n - 1) / 2 + 1
    System.out.print(val + " ")
    writeSequence(n - 2) // assume this works completely perfectly
    System.out.print(" " + val) // did we apply the little step correctly
  }
}





