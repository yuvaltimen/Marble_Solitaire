package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

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
   * Transmits the current state of the game, along with the current score to the Appendable.
   *
   * <p>@param model Represents the current model of the game being played.</p>
   */
  private void transmitGameState(MarbleSolitaireModel model) {
    try {
      this.ap.append(model.getGameState());
      this.ap.append("\n");
      this.ap.append(String.format("Score: %d", model.getScore()));
      this.ap.append("\n");
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }

  /**
   * Waits for user input and creates an ArrayList of length 4 representing the move.
   *
   * <p>@return (@ code ArrayList < Integer >)</p>
   */
  private void getUserInput(ArrayList<Integer> userInput) {

    while (userInput.size() < 4) {
      if (this.sc.hasNext()) {
        String current = this.sc.next();
        this.checkQuitted(current);
        if (this.quittedGame) {
          return;
        }
        try {
          int nextInp = Integer.parseInt(current);
          userInput.add(nextInp - 1);
        } catch (NumberFormatException e) {
          try {
            this.ap.append("Please input a number...");
            this.ap.append("\n");
          } catch (IOException p) {
            throw new IllegalStateException();
          }
        }
      } else {
        throw new IllegalStateException();
      }
    }
  }


  /**
   * Checks if the user has quit the game.
   */
  private void checkQuitted(String inp) {
    if (inp.equalsIgnoreCase("q")) {
      this.quittedGame = true;
    }
    return;
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
    while (true) {

      //(2) check for game over
      if (model.isGameOver()) {
        try {
          this.ap.append("Game over!");
          this.ap.append("\n");
          this.transmitGameState(model);
          return;
        } catch (IOException e) {
          throw new IllegalStateException();
        }
      }

      ArrayList<Integer> userInput = new ArrayList<>();
      this.getUserInput(userInput);
      if (this.quittedGame) {
        //transmit the end-of-game stats
        try {
          this.ap.append("Game quit!");
          this.ap.append("\n");
          this.ap.append("State of game when quit:");
          this.ap.append("\n");
          this.transmitGameState(model);
          this.sc.close();
        } catch (IOException e) {
          throw new IllegalStateException();
        }
        break;
      } else {
        int fromRow = userInput.get(0);
        int fromCol = userInput.get(1);
        int toRow = userInput.get(2);
        int toCol = userInput.get(3);
        try {
          model.move(fromRow, fromCol, toRow, toCol);
        } catch (IllegalArgumentException e) {
          try {
            String invMove = "Invalid move. Play again. (%d,%d) -> (%d,%d)";
            this.ap.append(String.format(invMove, fromRow, fromCol, toRow, toCol));
            this.ap.append("\n");
          } catch (IOException v) {
            throw new IllegalStateException();
          }
        }
        this.transmitGameState(model);
      }
    }
    this.sc.close();
  }
}
