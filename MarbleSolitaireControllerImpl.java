package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a controller as defined by (@code MarbleSolitaireController).
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private Appendable ap;
  private Scanner sc;
  private boolean quittedGame;

  /**
   * Constructor for this class.
   *
   * <p>@param rd represents a readable piece of data.
   * @param ap represents the output to which the data is written.
   * @throws IllegalArgumentException if rd or ap are (@code null).</p>
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Parameters may not be null.");
    } else {
      this.ap = ap;
      this.sc = new Scanner(rd);
      this.quittedGame = false;
    }
  }

  /**
   * Handles the appending operation given the thing to be appended.
   * This was newly added in Assignment 4.
   */
  private void appendToAp(CharSequence cs) throws IllegalStateException {
    try {
      this.ap.append(cs);
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }


  /**
   * Transmits the current state of the game, along with the current score to the Appendable.
   *
   * <p>@param model Represents the current model of the game being played.</p>
   */
  private void transmitGameState(MarbleSolitaireModel model) {
    this.appendToAp(model.getGameState());
    this.appendToAp("\n");
    this.appendToAp(String.format("Score: %d", model.getScore()));
    this.appendToAp("\n");
  }

  /**
   * Waits for user input and creates an ArrayList of length 4 representing the move.
   *
   * <p>@return (@ code ArrayList < Integer >)</p>
   */
  private ArrayList<Integer> getUserInput() {
    ArrayList<Integer> ans = new ArrayList<>();

    while (ans.size() < 4) {
      if (this.sc.hasNext()) {
        String current = this.sc.next();
        this.checkQuitted(current);
        if (this.quittedGame) {
          break;
        }
        try {
          int nextInp = Integer.parseInt(current);
          ans.add(nextInp - 1);
        } catch (NumberFormatException e) {
          this.appendToAp("Please input a number...");
          this.appendToAp("\n");
        }
      } else {
        throw new IllegalStateException();
      }
    }
    return ans;
  }


  /**
   * Checks if the user has quit the game.
   */
  private void checkQuitted(String inp) {
    if (inp.equalsIgnoreCase("q")) {
      this.quittedGame = true;
    }
  }

  /**
   * Plays a new game of Marble Solitaire using the given model.
   *
   * <p>Plays the game in the following order: (a) Transmit game state to the Appendable object
   * exactly as the model provides it. (b) Transmit the game score as: "Score: N", replacing N
   * with the score. (c) If the game is ongoing, obtain the next user input
   * from the Readable object.</p>
   *
   * <p>The user input consists of the following 4 items separated by spaces or newlines: (i) The
   * row number of the position from where a marble is to be moved. (ii) The column number of the
   * position from where a marble is to be moved. (iii) The row number of the position to where a
   * marble is to be moved. (iv) The column number of the position to where a marble is to be
   * moved.</p>
   *
   * <p>NOTE: All row and columns numbers in the input begin from 1.</p>
   *
   * <p>(d) If the game is over, the method should transmit each of the following in order: - The
   * message "Game over!". - The final state of the game. - The message "Score: N", with N replaced
   * by the final score.</p>
   *
   * <p>@param model An instance of (@code MarbleSolitaireModel), represents the model of the game.
   * @throws IllegalArgumentException if the given model is (@code null).
   * @throws IllegalStateException    if this controller is unable to receive input or transmit
   *                                  output.</p>
   */
  @Override
  public void playGame(MarbleSolitaireModel model) throws IllegalArgumentException,
          IllegalStateException {


    //(1) check for nulls
    if (model == null) {
      throw new IllegalArgumentException("The model cannot be null.");
    }

    this.transmitGameState(model);
    while (!model.isGameOver()) {

      ArrayList<Integer> userInput = this.getUserInput();
      if (this.quittedGame) {
        //transmit the end-of-game stats
        this.appendToAp("Game quit!");
        this.appendToAp("\n");
        this.appendToAp("State of game when quit:");
        this.appendToAp("\n");
        this.transmitGameState(model);
        this.sc.close();
        break;
      } else {
        int fromRow = userInput.get(0);
        int fromCol = userInput.get(1);
        int toRow = userInput.get(2);
        int toCol = userInput.get(3);
        try {
          model.move(fromRow, fromCol, toRow, toCol);
        } catch (IllegalArgumentException e) {
          String invMove = "Invalid move. Play again. (%d,%d) -> (%d,%d)";
          this.appendToAp(String.format(invMove, fromRow + 1, fromCol + 1, toRow + 1, toCol + 1));
          this.appendToAp("\n");
        }
        this.transmitGameState(model);
      }
    }
    if (model.isGameOver()) {
      this.appendToAp("Game over!");
      this.appendToAp("\n");
      this.transmitGameState(model);
      this.sc.close();
    }
  }
}
