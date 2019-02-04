package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents a controller as defined by (@code MarbleSolitaireController).
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  /**
   * Constructor for this class.
   * @param rd represents a readable piece of data.
   * @param ap represents the output to which the data is written.
   * @throws IllegalArgumentException if rd or ap are (@code null).
   */
  MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {

  }



  /**
   * Plays a new game of Marble Solitaire using the given model.
   *
   * @param model An instance of (@code MarbleSolitaireModel), represents the model of the game.
   * @throws IllegalArgumentException if the given model is (@code null).
   * @throws IllegalStateException    if this controller is unable to receive input or transmit
   *                                  output.
   */
  @Override
  public void playGame(MarbleSolitaireModel model) {

  }
}
