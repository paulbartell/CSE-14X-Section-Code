public class TryHuman {

  public static void main(String[] args) {
    // Don't mistake a or b for the Human's name!
    // That's a variable name, while the 'Bob' refers to the _field_ name
    Human a = new Human();
    Human b = new Human("Bob");

    System.out.println(a);
    System.out.println(b);
    System.out.println("--------------------------");

    a.getOlder();

    // a got older while b did not
    System.out.println(a);
    System.out.println(b);
    System.out.println("--------------------------");

    // Play around with this. You'll notice that the variables c and a
    // Both point to the same human
    Human c = a;

    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println("--------------------------");

    // Try running b.getGuiltyPleasure()
    // It won't work from outside of the class because it's declared private
    System.out.println(b.getName());
    System.out.println(b.getAge());
    System.out.println("--------------------------");

    // Static stuff -- only look at it if you've got your mind wrapped
    // around the rest
    System.out.println(Human.population);
    new Human();
    new Human();
    new Human();
    System.out.println(Human.population);
  }
}
