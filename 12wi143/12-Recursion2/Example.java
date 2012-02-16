import java.util.*;
public class Example {
  public static void main(String[] derpyderpderp) {
    tryEverythingStartingFromCoordinates(2, 2);
    // String[] toppings = {"Lettuce", "Cheese", "Turkham"};
    // trySandwiches(toppings);
  }

  public static void tryEverythingStartingFromCoordinates(int x, int y) {
    tryEverythingStartingFromCoordinates(0, 0, x, y, "");
  }

  private static void tryEverythingStartingFromCoordinates(int xHere, int yHere, int x, int y, String path) {
    if(xHere > x) {
      return;
    }
    if(yHere > y) {
      return;
    }
    if(xHere == x && yHere == y) {
      System.out.println(path);
    }

    //Up, Right or Diagonal
    // We're actually going up
    // We are finding all of the possible routes
    // starting from the coordinate one above
    // path is slightly different and the coordinates are slightly different

    //choose -- sets up everything we need for that recursion to work out
    yHere = yHere + 1;
    path = path + "N ";
    // explore.. is the recursive call where you pass parameters and stuff
    tryEverythingStartingFromCoordinates(xHere, yHere, x, y, path);
    //unchoose -- revert exactly everything from that choosing
    yHere = yHere - 1;
    path = path.substring(0, path.length() - 2);

    // tryEverythingStartingFromCoordinates(xHere, yHere + 1, x, y, path + "N ");

    tryEverythingStartingFromCoordinates(xHere + 1, yHere + 1, x, y, path + "NE ");
    tryEverythingStartingFromCoordinates(xHere + 1, yHere, x, y, path + "E ");

    // choose
    // explore
    // unchoose
  }

  public static void trySandwiches(String[] toppings) {
    //The public method does everything that needs to
    //only happen once
    trySandwiches(toppings, 0, "");
  }

  private static void trySandwiches(String[] toppings, int index, String top) {
    // Base Case
    if(index >= toppings.length) {
      System.out.println(top);
      return;
    } else {
      // try everything with yes
      trySandwiches(toppings, index + 1, top + " " + toppings[index]);
      // try everything with no
      trySandwiches(toppings, index + 1, top);
    }
  }
}
