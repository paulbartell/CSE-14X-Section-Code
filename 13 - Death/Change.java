import java.util.*;
public class Change {                       // 0  1  2   3   4   5
    public static final int[] DENOMINATIONS = {1, 5, 10, 25, 50, 100};
    public static final int FIELD_WIDTH = 8;  // for printing numbers

    public static void main(String[] args) {
        System.out.println("This program shows you all ways to make change");
        System.out.println("for various amounts.");
        System.out.println();
        Scanner console = new Scanner(System.in);
        for (;;) {
            System.out.print("Amount (0 to quit)? ");
            int amount = console.nextInt();
            if (amount == 0)
                break;
            showChange(amount);
        }
    }

    // prints the array of ints in fixed width columns
    public static void printInts(int[] numbers) {
        for (int n : numbers)
            System.out.printf("%" + FIELD_WIDTH + "d", n);
        System.out.println();
    }

    // Shows all ways to make change for the given amount
    public static void showChange(int amount) {
        printInts(DENOMINATIONS);
        for (int i = 0; i < DENOMINATIONS.length * FIELD_WIDTH; i++)
            System.out.print("-");
        System.out.println();
        // then print all solutions
        // to be filled in
        int firstPreviousCoin = DENOMINATIONS.length - 1;
        int[] coins = new int[DENOMINATIONS.length];
        showChange(amount, coins, firstPreviousCoin);
    }
    private static void showChange(int amount, int[] coins, int previousCoin) {
      if(amount < 0)
        return;
      if(amount == 0) {
        printInts(coins);
      } else {
        //take all of the coin types <= amount
        for(int i = previousCoin; i >= 0; i--) {
          int coin = DENOMINATIONS[i];
          //decision making
          amount = amount - coin;
          coins[i]++;
          //recursing
          showChange(amount, coins, i);
          //unchoosing -- annihilate the side effects
          coins[i]--;
          amount = amount + coin;
        }
      }
    }

}
