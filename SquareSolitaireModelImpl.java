package cs3500.marblesolitaire.model.hw02;

/**
 * Represents a square board implementation of the (@code MarbleSolitaireModel).
 */
public abstract class SquareSolitaireModelImpl implements MarbleSolitaireModel {

    protected int armLength;
    protected BoardSpot[][] board;

    /**
     * Constructor that takes in armLength, sRow, and sCol.
     *
     * @param armLength represents the length of one edge side of the board.
     * @param sRow      represents the row of the initial empty spot.
     * @param sCol      represents the column of the initial empty spot.
     */
    public SquareSolitaireModelImpl(int armLength, int sRow, int sCol) {
        if (!isValidPosition(armLength, sRow, sCol)) {
            String errMsg = String.format("Invalid empty cell position (%d,%d)", sRow, sCol);
            throw new IllegalArgumentException(errMsg);
        } else if (!isValidArmLength(armLength)) {
            throw new IllegalArgumentException("Arm length is invalid.");
        } else {
            this.armLength = armLength;
            this.board = createBoard(armLength);
            this.initializeBoard(sRow, sCol);
        }
    }

    /**
     * Fills in the null board with the correct BoardSpot in each position.
     *
     * @param row Represents the row of the empty spot on the board.
     * @param col Represents the column of the empty spot on the board.
     */
    private void initializeBoard(int row, int col) {
        int dimension = 3 * this.armLength - 2;
        for (int r = 0; r < dimension; r++) {
            for (int c = 0; c < dimension; c++) {
                //set the invalid spots
                if (!(this.isValidPosition(armLength, r, c))) {
                    this.board[r][c] = BoardSpot.INVALID;
                } else {
                    this.board[r][c] = BoardSpot.MARBLE;
                }
            }
        }
        this.board[row][col] = BoardSpot.EMPTY;
    }

    /**
     * Determines whether the given position is valid for a board of the given arm length.
     *
     * @param armLength Represents the length of the arm of the board.
     * @param row       Represents the row in the position.
     * @param col       Represents the column in the position.
     * @return True if the position is valid, false otherwise.
     */
    protected boolean isValidPosition(int armLength, int row, int col) {
        //Checks that the position is within the dimensions of the board.
        boolean checkPositionOnBoard = ((row >= 0 && row <= 3 * armLength - 3)
                && (col >= 0 && col <= 3 * armLength - 3));

        //Checks that the position is not an invalid spot.
        boolean checkPositionNotInvalid;
        if (row < armLength - 1 || row > 2 * armLength - 2) {
            checkPositionNotInvalid = (col >= armLength - 1 && col <= 2 * armLength - 2);
        } else {
            checkPositionNotInvalid = true;
        }

        //Return the final boolean
        return checkPositionOnBoard && checkPositionNotInvalid;
    }

    /**
     * Initializes a square board.
     *
     * @param armLength the length of the arm (must be odd and positive).
     */
    private static BoardSpot[][] createBoard(int armLength) {
        int dimension = 3 * armLength - 2;
        BoardSpot[][] ans = new BoardSpot[dimension][dimension];
        return ans;
    }

    /**
     * Checks that the armLength is a positive odd number (must be greater than 1 since a game
     * with armLength of 1 has no valid moves.)
     *
     * @param armLength the length of the arm (must be odd and positive)
     */
    private static boolean isValidArmLength(int armLength) {
        return (armLength > 1 && armLength % 2 == 1);
    }

    /**
     * Move a single marble from a given position to another given position. A move is valid only if
     * the from and to positions are valid. Specific implementations may place additional constraints
     * on the validity of a move.
     *
     * @param fromRow the row number of the position to be moved from (starts at 0)
     * @param fromCol the column number of the position to be moved from (starts at 0)
     * @param toRow   the row number of the position to be moved to (starts at 0)
     * @param toCol   the column number of the position to be moved to (starts at 0)
     * @throws IllegalArgumentException if the move is not possible
     */

    /*
     * (a) the “from” and “to” positions are valid
     * (b) there is a marble at the specified “from” position
     * (c) the “to” position is empty
     * (d) the “to” and “from” positions are exactly two positions away (horizontally or vertically)
     * (e) there is a marble in the slot between the “to” and “from” positions.
     *
     * */
    @Override
    public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {

        //First check that the To and From positions are valid.
        boolean fromIsValid = isValidPosition(this.armLength, fromRow, fromCol);
        boolean toIsValid = isValidPosition(this.armLength, toRow, toCol);

        //If To and From are valid, check that the move can be made.
        if (!(fromIsValid && toIsValid)) {
            throw new IllegalArgumentException("To or From position is invalid.");
        } else {
            boolean marbleAtFrom = (this.board[fromRow][fromCol] == BoardSpot.MARBLE);
            boolean emptyAtTo = (this.board[toRow][toCol] == BoardSpot.EMPTY);
            boolean distanceIsTwo = ((Math.abs(fromCol - toCol) == 2 && fromRow == toRow)
                    || (Math.abs(fromRow - toRow) == 2 && fromCol == toCol));

            //If move can be made, check that a marble is in between.
            if (!(marbleAtFrom && emptyAtTo && distanceIsTwo)) {
                throw new IllegalArgumentException("Move could not be made.");
            } else {
                int midRow;
                int midCol;
                if (toRow != fromRow) {
                    if (toRow > fromRow) {
                        midRow = fromRow + 1;
                        midCol = toCol;
                    } else {
                        midRow = fromRow - 1;
                        midCol = toCol;
                    }
                } else {
                    if (toCol > fromCol) {
                        midRow = toRow;
                        midCol = fromCol + 1;
                    } else {
                        midRow = toRow;
                        midCol = fromCol - 1;
                    }
                }

                //Check that marble is actually in between
                if (this.board[midRow][midCol] != BoardSpot.MARBLE) {
                    throw new IllegalArgumentException("No marble in between.");
                } else {
                    this.board[fromRow][fromCol] = BoardSpot.EMPTY;
                    this.board[midRow][midCol] = BoardSpot.EMPTY;
                    this.board[toRow][toCol] = BoardSpot.MARBLE;
                }
            }
        }
    }

    /**
     * Determine and return if the game is over or not. A game is over if no more moves can be made.
     *
     * @return true if the game is over, false otherwise
     */
    @Override
    public boolean isGameOver() {
        //Check that all empty spots have no two adjacent marbles in any direction.
        int dimension = this.board.length;
        boolean gameIsOver = true;
        for (int r = 0; r < dimension; r++) {
            for (int c = 0; c < dimension; c++) {
                if (this.board[r][c] == BoardSpot.EMPTY) {
                    if (r >= 2) {
                        //Checks above it
                        gameIsOver &= (this.board[r - 1][c] != BoardSpot.MARBLE
                                || this.board[r - 2][c] != BoardSpot.MARBLE);
                    }
                    if (r <= dimension - 3) {
                        //Checks below it
                        gameIsOver &= (this.board[r + 1][c] != BoardSpot.MARBLE
                                || this.board[r + 2][c] != BoardSpot.MARBLE);
                    }
                    if (c >= 2) {
                        //Checks to the left
                        gameIsOver &= (this.board[r][c - 1] != BoardSpot.MARBLE
                                || this.board[r][c - 2] != BoardSpot.MARBLE);
                    }
                    if (c <= dimension - 3) {
                        //Checks to the right
                        gameIsOver &= (this.board[r][c + 1] != BoardSpot.MARBLE
                                || this.board[r][c + 2] != BoardSpot.MARBLE);
                    }
                }
            }
        }
        return gameIsOver;
    }

    /**
     * Return a string that represents the current state of the board. The string should have one line
     * per row of the game board. Each slot on the game board is a single character (O, _ or space for
     * a marble, empty and invalid position respectively). Slots in a row should be separated by a
     * space. Each row has no space before the first slot and after the last slot.
     *
     * @return the game state as a string
     */
    @Override
    public String getGameState() {
        int dimension = 3 * armLength - 2;
        String[] rows = new String[dimension];

        //Creates an array of Strings where each element represents the row in the board
        for (int r = 0; r < dimension; r++) {
            rows[r] = "";
            boolean readyForNewline = false; //resetting the row resets this value
            for (BoardSpot c : this.board[r]) {
                //if we're at the last row
                if ((r == dimension - 1) && (c == BoardSpot.INVALID) && readyForNewline) {
                    break; // end the full loop
                }
                switch (c) {
                    case EMPTY:
                        //add the empty spot
                        readyForNewline = true;
                        rows[r] += "_";
                        break;
                    case MARBLE:
                        //add the marble, now ready for newline
                        readyForNewline = true;
                        rows[r] += "O";
                        break;
                    case INVALID:
                        //add an invalid if not yet ready for newline, else add a newline and reset r and c
                        if (!readyForNewline) {
                            rows[r] += " ";
                        } else {
                            continue;
                        }
                        break;
                    default:
                        throw new RuntimeException(String.format("Invalid BoardSpot: %s.", c));
                }
            }
        }

        //formats the array of Strings as a single String
        String ans = "";
        for (int s = 0; s < rows.length; s++) {
            String tmp = "";
            for (int i = 0; i < rows[s].length(); i++) {
                if (i < rows[s].length() - 1) {
                    tmp += rows[s].charAt(i) + " ";
                } else {
                    tmp += rows[s].charAt(i);
                }
            }
            rows[s] = tmp;
        }
        ans += String.join("\n", rows);

        return ans;
    }

    /**
     * Return the number of marbles currently on the board.
     *
     * @return the number of marbles currently on the board
     */
    @Override
    public int getScore() {
        int score = 0;
        for (BoardSpot[] bArr : this.board) {
            for (BoardSpot b : bArr) {
                if (b == BoardSpot.MARBLE) {
                    score += 1;
                }
            }
        }
        return score;
    }

}
