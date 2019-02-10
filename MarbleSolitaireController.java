package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This interface represents the controller used to "run" a game of Marble Solitaire.
 * Uses an instance of (@code MarbleSolitaireModel).
 */
public interface MarbleSolitaireController {

  /**
   * Plays a new game of Marble Solitaire using the given model.
   *
   * <p>Plays the game in the following order:
   * (a) Transmit game state to the Appendable object exactly as the model provides it.
   * (b) Transmit the game score as: "Score: N", replacing N with the score.
   * (c) If the game is ongoing, obtain the next user input from the  Readable object.</p>
   *
   *    <p>The user input consists of the following 4 items separated by spaces or newlines:
   *   (i) The row number of the position from where a marble is to be moved.
   *   (ii) The column number of the position from where a marble is to be moved.
   *   (iii) The row number of the position to where a marble is to be moved.
   *   (iv) The column number of the position to where a marble is to be moved.</p>
   *
   *   <p>[NOTE: All row and columns numbers in the input begin from 1.]</p>
   *
   * <p>(d) If the game is over, the method should transmit each of the following in order:
   *   - The message "Game over!".
   *   - The final state of the game.
   *   - The message "Score: N", with N replaced by the final score.</p>
   *
   *
   * <p>@param model An instance of (@code MarbleSolitaireModel), represents the model of the game.
   * @throws IllegalArgumentException if the given model is (@code null).
   * @throws IllegalStateException if this controller is unable to receive or transmit output.</p>
   */
  void playGame(MarbleSolitaireModel model) throws IllegalArgumentException, IllegalStateException;
}
