public class Grid {
  public static final int SIZE = 9;
  private int[][] grid;

  // Stub Constructor
  public Grid(int[][] newGrid) {
    grid = newGrid;
  }

  public void print() {
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[i].length; j++) {
        if(grid[i][j] == 0)
          System.out.print("-" + " ");
        else
          System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
  }

  public void place(int cell, value v) {
    grid[cellToRow(cell)][cellToCol(cell)] = v;
  }

  public void remove(int cell) {
    grid[cellToRow(cell)][cellToCol(cell)] = 0;
  }

  private cellToRow(int n) {
    return n / SIZE;
  }

  private cellToCol(int n) {
    return n % SIZE;
  }

  public boolean noConflicts(int cell, value v) {
    for(int i = 0; i < 9; i++) {
      if(grid[cellToRow(cell)][i] == v || grid[i][cellToCol(cell)] == v)
        return false;
    }

    int row = cellToRow(cell);
    int col = cellToCol(cell);

    int rowShift = shift(row);
    int colShift = shift(col);
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        if(grid[i + rowShift][j + colShift] == v) 
          return false;
      }
    }
    private int shift(int i) {
      return i / 3 * 3;
    }
  }
  public boolean noConflicts2(int cell, value v) {
    int row = cellToRow(cell);
    int col = cellToCol(cell);

    int rowShift = shift(row);
    int colShift = shift(col);
    for(int i = 0; i < 9; i++) {
      if(grid[cellToRow(cell)][i] == v || grid[i][cellToCol(cell)] == v)
        return false;
      if(grid[rowShift + i / 3][colShift + i % 3] == v)
        return false;
    }
    }
    private int shift(int i) {
      return i / 3 * 3;
    }
  }
}
