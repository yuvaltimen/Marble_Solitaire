package cs3500.marblesolitaire.model.hw02;

/**
 * Represents a regular game of Marble Solitaire as defined by (@code MarbleSolitaireModel).
 */
public class MarbleSolitaireModelImpl extends SquareSolitaireModelImpl {

  /**
   * No-argument constructor.
   *
   * <p>Initializes the board to armLength of 3, with the empty spot in the middle.</p>
   */
  public MarbleSolitaireModelImpl() {
    this(3, 3, 3);
  }

  /**
   * Constructor that takes in armLength.
   *
   * @param armLength represents the length of one edge side of the board.
   */
  public MarbleSolitaireModelImpl(int armLength) {
    this(armLength, ((3 * armLength - 2) / 2), ((3 * armLength - 2) / 2));
  }

  /**
   * Constructor that takes in the position of the empty spot.
   * Defaults the armLength to 3.
   *
   * @param sRow the row of the empty spot.
   * @param sCol the column of the empty spot.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * Constructor that takes in armLength, sRow, and sCol.
   *
   * @param armLength represents the length of one edge side of the board.
   * @param sRow      represents the row of the initial empty spot.
   * @param sCol      represents the column of the initial empty spot.
   */
  public MarbleSolitaireModelImpl(int armLength, int sRow, int sCol) {
    super(armLength, sRow, sCol);
  }
}
