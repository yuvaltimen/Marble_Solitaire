package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.BoardSpot;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents a game of Triangular Marble Solitaire as defined by (@code MarbleSolitaireModel).
 */
public class TriangleSolitaireModelImpl implements MarbleSolitaireModel {

  private int sideLength;
  private BoardSpot[][] board;

  /**
   * No-argument constructor that initializes the board with a side length of 5.
   */
  public TriangleSolitaireModelImpl() {
    this(5, 0, 0);
  }


  /**
   * Constructor that takes in the side length of the board and places the empty slot at (0,0).
   *
   * @param sideLength Represents the length of the bottom row.
   */
  public TriangleSolitaireModelImpl(int sideLength) {
    this(sideLength, 0, 0);
  }

  /**
   * Constructor that creates a board of side length 5 and initializes the empty slot at
   * the specified position.
   *
   * @param row Represents the row of the empty position.
   * @param col Represents the column of the empty position.
   */
  public TriangleSolitaireModelImpl(int row, int col) {
    this(5, row, col);
  }

  /**
   * Constructor that takes in the side length and position of the empty slot and
   * initializes the board.
   *
   * @param sideLength Represents the length of the bottom row of the board.
   * @param row        Represents the row of the empty slot.
   * @param col        Represents the column of the empty slot.
   */
  public TriangleSolitaireModelImpl(int sideLength, int row, int col) {
    if (!isValidSideLength(sideLength)) {
      String errLen = "Invalid side length.";
      throw new IllegalArgumentException(errLen);
    } else if (!isValidPosition(sideLength, row, col)) {
      String errPos = String.format("Invalid position: (%d,%d).", row, col);
      throw new IllegalArgumentException(errPos);
    }
    this.sideLength = sideLength;
    this.board = this.initializeBoard(sideLength, row, col);
  }

  /**
   * Determines whether the side length of the board is valid.
   *
   * @param sideLength Represents the potential length of the bottom row of the board.
   * @return true if the side length is valid, false otherwise.
   */
  private boolean isValidSideLength(int sideLength) {
    return sideLength > 1;
  }

  /**
   * Determines whether the position given by (row, col) is valid for a board of
   * the given side length.
   *
   * @param sideLength Represents the size of the bottom row of the board.
   * @param row        Represents the row of the given position.
   * @param col        Represents the column of the given position.
   * @return true if the position is valid, false otherwise.
   */
  private boolean isValidPosition(int sideLength, int row, int col) {
    boolean rowIsBounded = (row < sideLength);
    boolean nonNegativePosition = (row >= 0 && col >= 0);
    boolean colIsValid = (col <= row);

    return rowIsBounded && nonNegativePosition && colIsValid;
  }

  /**
   * Creates the board with the given side length, and the given empty slot.
   *
   * @param sideLength Represents the length of the bottom row of the board.
   * @param row        Represents the row of the empty slot.
   * @param col        Represents the column of the empty slot.
   * @return A 2-dimensional board of enumerated values.
   */
  private BoardSpot[][] initializeBoard(int sideLength, int row, int col) {
    BoardSpot[][] ans = new BoardSpot[sideLength][];

    for (int r = 0; r < sideLength; r++) {
      ans[r] = new BoardSpot[r + 1];
      for (int c = 0; c <= r; c++) {
        ans[r][c] = BoardSpot.MARBLE;
      }
    }
    ans[row][col] = BoardSpot.EMPTY;
    return ans;
  }

  /**
   * Moves the marble from the position specified by (fromRow, fromCol) to (toRow, toCol).
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move cannot be made for some reason.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {

    //check that from and to positions are valid
    boolean fromValid = this.isValidPosition(this.sideLength, fromRow, fromCol);
    boolean toValid = this.isValidPosition(this.sideLength, toRow, toCol);

    boolean marbleAtFrom = false;
    boolean emptyAtTo = false;
    boolean fromTwoAwayFromTo;

    //check that from has a marble
    //check that to is empty
    if (fromValid && toValid) {
      marbleAtFrom = (this.board[fromRow][fromCol] == BoardSpot.MARBLE);
      emptyAtTo = (this.board[toRow][toCol] == BoardSpot.EMPTY);
    } else {
      String err = String.format("Invalid origin or destination:(%d,%d)~(%d,%d)",
              fromRow, fromCol, toRow, toCol);
      throw new IllegalArgumentException(err);
    }

    //check that from is 2 away from to
    boolean upLeft = (fromRow == toRow + 2) && (fromCol == toCol + 2);
    boolean upRight = (fromRow == toRow + 2) && (fromCol == toCol);
    boolean botLeft = (fromRow + 2 == toRow) && (fromCol + 2 == toCol);
    boolean botRight = (fromRow + 2 == toRow) && (fromCol == toCol);
    boolean horizontal = (fromRow == toRow) && (Math.abs(fromCol - toCol) == 2);
    fromTwoAwayFromTo = (upLeft || upRight || botLeft || botRight || horizontal);


    //check that there's a marble between from and to
    if (fromTwoAwayFromTo) {
      int midRow;
      int midCol;

      //get midRow
      if (fromRow > toRow) {
        midRow = fromRow - 1;
      } else if (toRow > fromRow) {
        midRow = fromRow + 1;
      } else {
        midRow = fromRow;
      }

      //get midCol
      if (fromCol > toCol) {
        midCol = fromCol - 1;
      } else if (toCol > fromCol) {
        midCol = fromCol + 1;
      } else {
        midCol = fromCol;
      }

      boolean checkMarbleBetween = (this.board[midRow][midCol] == BoardSpot.MARBLE);


      //if all else is true, make the move
      if (marbleAtFrom && emptyAtTo && checkMarbleBetween) {
        this.board[fromRow][fromCol] = BoardSpot.EMPTY;
        this.board[midRow][midCol] = BoardSpot.EMPTY;
        this.board[toRow][toCol] = BoardSpot.MARBLE;

      } else {
        throw new IllegalArgumentException("Cannot make move.");
      }
    } else {
      String err = "The distance between the marbles is not equal to 2.";
      throw new IllegalArgumentException(err);
    }
  }

  /**
   * Determines when this game of TriangleMarbleSolitaire is over.
   *
   * @return true when the game is over, false otherwise.
   */
  @Override
  public boolean isGameOver() {

    boolean gameIsOver = true;

    for (int r = 0; r < this.board.length; r++) {
      for (int c = 0; c < this.board[r].length; c++) {
        if (this.board[r][c] == BoardSpot.EMPTY) {


          //check top-left
          if (this.isValidPosition(this.sideLength, r - 2, c)) {
            boolean b1 = (this.board[r - 2][c] != BoardSpot.MARBLE);
            boolean b2 = (this.board[r - 1][c] != BoardSpot.MARBLE);
            gameIsOver &= (b1 || b2);
          }

          //check top-right
          if (this.isValidPosition(this.sideLength, r - 2, c - 2)) {
            boolean b1 = (this.board[r - 2][c - 2] != BoardSpot.MARBLE);
            boolean b2 = (this.board[r - 1][c - 1] != BoardSpot.MARBLE);
            gameIsOver &= (b1 || b2);
          }


          //check bottom-left
          if (this.isValidPosition(this.sideLength, r + 2, c)) {
            boolean b1 = (this.board[r + 2][c] != BoardSpot.MARBLE);
            boolean b2 = (this.board[r + 1][c] != BoardSpot.MARBLE);
            gameIsOver &= (b1 || b2);
          }

          //check bottom-right
          if (this.isValidPosition(this.sideLength, r + 2, c + 2)) {
            boolean b1 = (this.board[r + 2][c + 2] != BoardSpot.MARBLE);
            boolean b2 = (this.board[r + 1][c + 1] != BoardSpot.MARBLE);
            gameIsOver &= (b1 || b2);
          }


          //check left
          if (this.isValidPosition(this.sideLength, r, c - 2)) {
            boolean b1 = (this.board[r][c - 2] != BoardSpot.MARBLE);
            boolean b2 = (this.board[r][c - 1] != BoardSpot.MARBLE);
            gameIsOver &= (b1 || b2);
          }

          //check right
          if (this.isValidPosition(this.sideLength, r, c + 2)) {
            boolean b1 = (this.board[r][c + 2] != BoardSpot.MARBLE);
            boolean b2 = (this.board[r][c + 1] != BoardSpot.MARBLE);
            gameIsOver &= (b1 || b2);
          }
        }
      }
    }
    return gameIsOver;
  }

  /**
   * Fetches the current state of this game of TriangleMarbleSolitaire.
   *
   * @return the current state of the game as a String.
   */
  @Override
  public String getGameState() {

    int dim = this.board.length;
    String[] spaces = new String[dim];
    String[] marbles = new String[dim];

    for (int r = 0; r < dim; r++) {
      //determine the number of spaces
      StringBuilder s1 = new StringBuilder();
      for (int t = 0; t < dim - r - 1; t++) { // maybe not "-1"
        s1.append(' ');
      }
      spaces[r] = s1.toString();

      //print out the marbles
      StringBuilder s2 = new StringBuilder();
      for (int c = 0; c < this.board[r].length; c++) {
        switch (this.board[r][c]) {
          case MARBLE:
            s2.append('O');
            break;
          case EMPTY:
            s2.append('_');
            break;
          case INVALID:
            //THIS CASE NEVER HAPPENS
            s2.append('X');
            break;
          default:
            //THIS CASE NEVER HAPPENS
            break;
        }
      }
      marbles[r] = s2.toString();
    }

    for (int i = 0; i < dim; i++) {
      String marbs = marbles[i].replace("", " ").trim();
      spaces[i] = spaces[i] + marbs;
    }

    return String.join("\n", spaces);
  }

  /**
   * Gets the current score of the game.
   *
   * @return the score as an int.
   */
  @Override
  public int getScore() {
    int score = 0;
    for (int r = 0; r < this.board.length; r++) {
      for (int c = 0; c < this.board[r].length; c++) {
        if (board[r][c] == BoardSpot.MARBLE) {
          score++;
        }
      }
    }
    return score;
  }
}
