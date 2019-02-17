package cs3500.marblesolitaire.model.hw02;

/**
 * Represents a game of European Marble Solitaire as defined by (@code MarbleSolitaireModel).
 */
public class EuropeanSolitaireModelImpl extends SquareSolitaireModelImpl {


    /**
     * The default constructor for this class - creates a board of side length 3 with the empty spot in the center.
     */

    public EuropeanSolitaireModelImpl() {
        this(3, 3, 3);
    }

    /**
     * Constructor that takes in the side length and creates a board with the empty spot in the center.
     */

    public EuropeanSolitaireModelImpl(int sideLength) {
        this(sideLength, ((3 * sideLength - 2) / 2), ((3 * sideLength - 2) / 2));
    }

    /**
     * Constructor that takes in the row and column of the empty spot and initializes the board of side length 3.
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
     * Checks that the position given by (sRow, sCol) is valid for the given armLength on an octagonal board.
     *
     * @param armLength the length of the arm (must be odd and positive)
     * @param sRow      the row number (starts at 0)
     * @param sCol      the column number (starts at 0)
     */
    @Override
    protected boolean isValidPosition(int armLength, int sRow, int sCol) {

        //TODO : Put in the clause that creates the octagonal shape for each row


//        //Checks that the position is within the dimensions of the board.
//        boolean checkPositionOnBoard = ((sRow >= 0 && sRow <= 3 * armLength - 3)
//                && (sCol >= 0 && sCol <= 3 * armLength - 3));
//
//        //Checks that the position is not an invalid spot.
//        boolean checkPositionNotInvalid;
//        if (sRow < armLength - 1 || sRow > 2 * armLength - 2) {
//            checkPositionNotInvalid = (sCol >= armLength - 1 && sCol <= 2 * armLength - 2);
//        } else {
//            checkPositionNotInvalid = true;
//        }
//
//        //Return the final boolean
//        return checkPositionOnBoard && checkPositionNotInvalid;

        boolean isValidPlus = super.isValidPosition(armLength, sRow, sCol);
        boolean octCorners = (false);

        return isValidPlus || octCorners;
    }
}
