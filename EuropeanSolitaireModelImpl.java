package cs3500.marblesolitaire.model.hw04;

/**
 * Represents a game of European Marble Solitaire as defined by (@code MarbleSolitaireModel).
 */
public class EuropeanSolitaireModelImpl extends SquareSolitaireModelImpl {


  /**
   * The default constructor for this class - creates a board of side length 3 with the empty
   * spot in the center.
   */

  public EuropeanSolitaireModelImpl() {
    this(3, 3, 3);
  }

  /**
   * Constructor that takes in the side length and creates a board with the empty spot
   * in the center.
   */

  public EuropeanSolitaireModelImpl(int sideLength) {
    this(sideLength, ((3 * sideLength - 2) / 2), ((3 * sideLength - 2) / 2));
  }

  /**
   * Constructor that takes in the row and column of the empty spot and initializes the
   * board of side length 3.
   */

  public EuropeanSolitaireModelImpl(int row, int col) {
    this(3, row, col);
  }

  /**
   * Constructor that takes in side length of the board and the row and column of the empty spot.
   */

  public EuropeanSolitaireModelImpl(int sideLength, int row, int col) {
    super(sideLength, row, col);
  }

  /**
   * Checks that the position given by (sRow, sCol) is valid for the given armLength on
   * an octagonal board.
   *
   * <p>@param armLength the length of the arm (must be odd and positive)
   *
   * @param sRow the row number (starts at 0)
   * @param sCol the column number (starts at 0)</p>
   */
  @Override
  protected boolean isValidPosition(int armLength, int sRow, int sCol) {

    boolean isValidPlus = super.isValidPosition(armLength, sRow, sCol);
    boolean octCorners;
    //top-left quadrant
    int bound = armLength - 1;
    if (sRow < bound && sCol < bound) {
      octCorners = (sCol + sRow >= bound);
    }
    //top right quadrant
    else if (sRow < bound && sCol > 2 * bound) {
      octCorners = (Math.abs(sCol - sRow) <= 2 * bound);
    }
    //bottom-left quadrant
    else if (sRow > 2 * bound && sCol < bound) {
      octCorners = (Math.abs(sCol - sRow) <= 2 * bound);
    }
    //bottom-right quadrant
    else if (sRow > 2 * bound && sCol > 2 * bound) {
      octCorners = (sCol + sRow <= 5 * bound);
    } else {
      octCorners = false;
    }

    return isValidPlus || octCorners;
  }
}
